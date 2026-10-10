'use strict';
const $=id=>document.getElementById(id),engine=PuzzleEngine,storageKey='vocab-photo-puzzle-'+new URLSearchParams(location.search).get('user');
let cols=3,rows=4,board=[],moves=0,elapsed=0,runningSince=null,history=[],selected=null,drag=null,pendingReset=null,won=false,saveAvailable=true;
const tiles=new Map();
const surface=document.createElement('canvas');
surface.className='puzzle-surface';surface.setAttribute('aria-hidden','true');
const context=surface.getContext('2d'),photo=new Image();
photo.onload=()=>paint();
photo.onerror=()=>{$('caption').textContent='Could not load the picture. Please reload.';};

function seconds(){return elapsed+(runningSince===null?0:Math.floor((Date.now()-runningSince)/1000));}
function clock(n){return String(Math.floor(n/60)).padStart(2,'0')+':'+String(n%60).padStart(2,'0');}
function startClock(){if(!won&&runningSince===null)runningSince=Date.now();}
function save(){if(!roundId||!board.length)return;try{localStorage.setItem(storageKey,JSON.stringify({cols,rows,board,moves,elapsed:seconds(),history:history.slice(-80),roundId,photoUrl}));}catch(e){saveAvailable=false;document.querySelector('.bottom-note').textContent='New pictures, new puzzles';}}
function isPermutation(a,n){return Array.isArray(a)&&a.length===n&&new Set(a).size===n&&a.every(x=>Number.isInteger(x)&&x>=0&&x<n);}
function groupAt(p){return engine.groups(board,cols).find(g=>g.includes(p));}
function shuffle(c=cols,r=rows){
  cols=c;rows=r;board=Array.from({length:c*r},(_,i)=>i);
  for(let i=board.length-1;i>0;i--){const j=Math.floor(Math.random()*(i+1));[board[i],board[j]]=[board[j],board[i]];}
  if(board.every((x,i)=>x===i))[board[0],board[1]]=[board[1],board[0]];
  moves=0;elapsed=0;runningSince=null;history=[];selected=null;won=false;drag=null;
  $('difficulty').value=cols+','+rows;tiles.clear();$('board').replaceChildren(surface);render();save();
  $('caption').textContent='Drag pieces to move them. Matching neighbors connect.';
}
function render(){
  if(surface.parentNode!==$('board'))$('board').prepend(surface);
  const gs=engine.groups(board,cols),groupIds=new Map();gs.forEach((g,i)=>g.forEach(p=>groupIds.set(p,i)));
  let edges=0;
  for(let p=0;p<board.length;p++){
    const home=board[p],r=Math.floor(p/cols),c=p%cols;let tile=tiles.get(home);
    if(!tile){tile=document.createElement('button');tile.className='tile';tile.dataset.home=home;tile.type='button';tiles.set(home,tile);$('board').append(tile);}
    tile.dataset.cell=p;tile.style.width=100/cols+'%';tile.style.height=100/rows+'%';tile.style.left=c*100/cols+'%';tile.style.top=r*100/rows+'%';tile.style.transform='';
    const g=gs[groupIds.get(p)];tile.classList.toggle('merged',g.length>1);tile.classList.toggle('selected',selected!==null&&g.includes(selected));tile.classList.remove('dragging');
    tile.setAttribute('aria-label',`Row ${r+1}, column ${c+1}, piece ${home+1}${g.length>1?", "+g.length+" connected":""}`);
    for(const [side,q] of [['t',r>0?p-cols:-1],['b',r<rows-1?p+cols:-1],['l',c>0?p-1:-1],['r',c<cols-1?p+1:-1]]){
      const connected=q>=0&&groupIds.get(q)===groupIds.get(p);
      if(connected&&(side==='b'||side==='r'))edges++;
    }
  }
  const percent=Math.round(edges/(rows*(cols-1)+cols*(rows-1))*100);
  $('moves').textContent=moves;$('time').textContent=clock(seconds());$('percent').textContent=percent+'%';$('bar').style.width=percent+'%';
  $('undo').disabled=!history.length;$('board').setAttribute('aria-label',`${cols} columns, ${rows} rows. Drag pieces or tap two positions.`);
  paint();
}
function paint(){
  if(!photo.complete||!photo.naturalWidth||!board.length)return;
  const rect=$('board').getBoundingClientRect();if(!rect.width||!rect.height)return;
  const dpr=window.devicePixelRatio||1;
  // One canvas for the entire board, and one photo draw per connected group.
  // Integer cell boundaries eliminate separately composited subpixel seams.
  const width=Math.max(cols,Math.round(rect.width*dpr/cols)*cols);
  const height=Math.max(rows,Math.round(rect.height*dpr/rows)*rows);
  if(surface.width!==width)surface.width=width;
  if(surface.height!==height)surface.height=height;
  const w=width/cols,h=height/rows,gapX=Math.max(1,Math.round(width/rect.width)),gapY=Math.max(1,Math.round(height/rect.height));
  context.clearRect(0,0,width,height);
  const gs=engine.groups(board,cols),ids=new Map();gs.forEach((g,i)=>g.forEach(p=>ids.set(p,i)));
  function drawGroup(g,dx=0,dy=0,lifted=false){
    context.save();context.translate(dx,dy);context.beginPath();
    for(const p of g){
      const c=p%cols,r=Math.floor(p/cols),same=q=>q>=0&&q<board.length&&ids.get(p)===ids.get(q);
      const l=c>0&&!same(p-1)?gapX:0,rr=c<cols-1&&!same(p+1)?gapX:0;
      const t=r>0&&!same(p-cols)?gapY:0,b=r<rows-1&&!same(p+cols)?gapY:0;
      context.rect(c*w+l,r*h+t,w-l-rr,h-t-b);
    }
    // Union all cells before clipping; no internal edge is ever painted alone.
    context.clip();
    if(lifted||(selected!==null&&g.includes(selected)))context.filter='brightness(1.13)';
    const p=g[0],home=board[p];
    context.drawImage(photo,(p%cols-home%cols)*w,(Math.floor(p/cols)-Math.floor(home/cols))*h,width,height);
    context.restore();
  }
  const moving=drag&&drag.moving?gs.find(g=>g.includes(drag.p)):null;
  for(const g of gs)if(g!==moving)drawGroup(g);
  if(moving)drawGroup(moving,Math.round((drag.dx||0)*width/rect.width),Math.round((drag.dy||0)*height/rect.height),true);
}
function applyMove(group,dx,dy){
  const next=engine.move(board,cols,group,dx,dy);
  if(next.every((x,i)=>x===board[i])){selected=null;render();return false;}
  startClock();history.push({board:board.slice(),moves});if(history.length>80)history.shift();
  board=next;moves++;selected=null;won=board.every((x,i)=>x===i);
  if(won){elapsed=seconds();runningSince=null;}
  render();save();
  const max=Math.max(...engine.groups(board,cols).map(g=>g.length));
  $('caption').textContent=won?'All pieces are connected!':max>1?`${max} pieces connected. Move them as one group.`:'Drag pieces to move them. Matching neighbors connect.';
  if(won){updateReward();$('winStats').textContent=`${moves} moves · ${clock(elapsed)}${saveAvailable?' · Saved on this device':''}`;setTimeout(()=>{$('winDialog').showModal();celebrate();},230);}
  return true;
}
function tap(p){
  if(won||rewardBusy||!roundId)return;
  if(selected===null){selected=p;render();$('caption').textContent='Tap a destination or drag the selected group.';}
  else if(groupAt(selected).includes(p)){selected=null;render();$('caption').textContent='Drag pieces to move them. Matching neighbors connect.';}
  else{const g=groupAt(selected);applyMove(g,p%cols-selected%cols,Math.floor(p/cols)-Math.floor(selected/cols));}
}
$('board').addEventListener('pointerdown',e=>{
  const tile=e.target.closest('.tile');if(!tile||won||rewardBusy||!roundId||drag||e.button!==0)return;
  e.preventDefault();const p=Number(tile.dataset.cell),rect=$('board').getBoundingClientRect();
  drag={id:e.pointerId,p,group:groupAt(p),x:e.clientX,y:e.clientY,w:rect.width/cols,h:rect.height/rows,moving:false};
  $('board').setPointerCapture(e.pointerId);
});
$('board').addEventListener('pointermove',e=>{
  if(!drag||drag.id!==e.pointerId)return;
  let x=e.clientX-drag.x,y=e.clientY-drag.y;
  if(Math.hypot(x,y)>6)drag.moving=true;
  if(!drag.moving)return;
  const minC=Math.min(...drag.group.map(p=>p%cols)),maxC=Math.max(...drag.group.map(p=>p%cols)),minR=Math.min(...drag.group.map(p=>Math.floor(p/cols))),maxR=Math.max(...drag.group.map(p=>Math.floor(p/cols)));
  x=Math.max(-minC*drag.w,Math.min((cols-1-maxC)*drag.w,x));y=Math.max(-minR*drag.h,Math.min((rows-1-maxR)*drag.h,y));
  drag.dx=x;drag.dy=y;paint();
});
$('board').addEventListener('pointerup',e=>{
  if(!drag||drag.id!==e.pointerId)return;
  const d=drag;drag=null;
  if(d.moving)applyMove(d.group,Math.round((e.clientX-d.x)/d.w),Math.round((e.clientY-d.y)/d.h));else tap(d.p);
});
function cancelDrag(){if(drag){drag=null;render();}}
$('board').addEventListener('pointercancel',cancelDrag);$('board').addEventListener('lostpointercapture',cancelDrag);
$('board').addEventListener('keydown',e=>{
  const tile=e.target.closest('.tile');if(!tile||won||rewardBusy||!roundId)return;
  const p=Number(tile.dataset.cell),home=Number(tile.dataset.home);
  if(e.key==='Enter'||e.key===' '){e.preventDefault();tap(p);}
  else if(e.key==='Escape'){selected=null;render();}
  else if(['ArrowLeft','ArrowRight','ArrowUp','ArrowDown'].includes(e.key)){
    e.preventDefault();applyMove(groupAt(p),e.key==='ArrowLeft'?-1:e.key==='ArrowRight'?1:0,e.key==='ArrowUp'?-1:e.key==='ArrowDown'?1:0);tiles.get(home).focus();
  }
});
$('undo').onclick=()=>{if(!history.length)return;const prev=history.pop();board=prev.board;moves=prev.moves;selected=null;won=false;startClock();render();save();$('caption').textContent='Last move undone.';};
$('reference').onclick=()=>{$('photoDialog').showModal();};$('closePhoto').onclick=()=>{$('photoDialog').close();};
function requestReset(c,r){if(rewardBusy)return;pendingReset=[c,r];$('confirmDialog').showModal();}
$('difficulty').onchange=()=>{const [c,r]=$('difficulty').value.split(',').map(Number);$('difficulty').value=cols+','+rows;requestReset(c,r);};
$('shuffle').onclick=()=>requestReset(cols,rows);$('cancelReset').onclick=()=>{$('confirmDialog').close();pendingReset=null;};
$('confirmReset').onclick=()=>{const [c,r]=pendingReset;pendingReset=null;$('confirmDialog').close();beginRound(c,r);};
$('playAgain').onclick=()=>{$('winDialog').close();beginRound(cols,rows);};$('viewComplete').onclick=()=>{$('winDialog').close();$('photoDialog').showModal();};
function celebrate(){if(matchMedia('(prefers-reduced-motion: reduce)').matches)return;for(let i=0;i<36;i++){const e=document.createElement('i');e.className='confetti';e.style.left=Math.random()*100+'vw';e.style.background=['#afe3b9','#f4ce80','#edeee4'][i%3];e.style.setProperty('--drift',(Math.random()-.5)*180+'px');e.style.animationDelay=Math.random()*.6+'s';document.body.append(e);setTimeout(()=>e.remove(),3200);}}
setInterval(()=>{$('time').textContent=clock(seconds());},1000);
setInterval(()=>{if(runningSince!==null)save();},5000);
document.addEventListener('visibilitychange',()=>{if(document.hidden){elapsed=seconds();runningSince=null;save();}else if(roundId&&moves&&!won)startClock();});
window.addEventListener('pagehide',save);
new ResizeObserver(()=>{cancelDrag();paint();}).observe($('board'));

const Q=Quest,params=new URLSearchParams(location.search),user=params.get('user'),token=params.get('token');
let roundId=null,photoUrl='assets/forest.jpg',rewardBusy=false,photoList=[],pendingId=null;
const SERVICE='https://vocab-puzzle-photos.twilight-heart-e320.workers.dev';
$('backHome').href=Q.HOME;document.querySelectorAll('.home-link').forEach(a=>a.href=Q.HOME);
function loadPhoto(url){return new Promise((resolve,reject)=>{photo.onload=()=>{paint();resolve();};photo.onerror=()=>reject(Error('Could not load this picture. Please try again.'));photo.src=url;});}
function showPhoto(){$('board').style.aspectRatio=photo.naturalWidth+'/'+photo.naturalHeight;$('board').style.width='min(100%, calc((100svh - 330px) * '+(photo.naturalWidth/photo.naturalHeight)+'))';document.querySelectorAll('#photoDialog img,#winDialog img').forEach(img=>img.src=photo.src);}
async function updateReward(){try{const r=await Q.status(user,token);$('rewardStatus').textContent=r.available+(r.available===1?' play left · ':' plays left · ')+r.used+(r.unlimitedDaily?' played today · No daily limit':'/6 played today');$('startPlay').hidden=!r.canPlay;$('playAgain').hidden=!r.canPlay;$('rewardMessage').textContent=r.canPlay?'One new puzzle uses one play.':'Earn more plays in Vocabulary, or come back tomorrow if you reached today’s limit.';$('winReward').textContent=r.canPlay?r.available+' plays left. Try another picture!':'No plays left for now. Earn more plays in Vocabulary, or return tomorrow after the daily limit resets.';return r;}catch(e){$('rewardMessage').textContent=e.message;$('startPlay').hidden=$('playAgain').hidden=true;throw e;}}
async function beginRound(c=cols,r=rows){if(rewardBusy)return;rewardBusy=true;$('rewardMessage').textContent='Loading your puzzle…';$('startPlay').disabled=true;$('board').style.pointerEvents='none';try{
await Q.auth(user,token);const listing=await fetch(SERVICE+'/photos');if(!listing.ok)throw Error('Could not load pictures. Please try again.');photoList=(await listing.json()).photos;const choice=photoList.length?photoList[Math.floor(Math.random()*photoList.length)].url:'assets/forest.jpg';await loadPhoto(choice);pendingId=pendingId||Q.uid();await Q.start(user,token,pendingId,'puzzle');roundId=pendingId;pendingId=null;photoUrl=choice;showPhoto();shuffle(c,r);$('startDialog').close();await updateReward();
}catch(e){if(roundId&&photo.src!==new URL(photoUrl,location.href).href){try{await loadPhoto(photoUrl);}catch{}}$('rewardMessage').textContent=e.message;if(!roundId)$('startDialog').showModal();else $('caption').textContent=e.message;}finally{rewardBusy=false;$('startPlay').disabled=false;$('board').style.pointerEvents='';}}
$('startPlay').onclick=()=>beginRound(...$('difficulty').value.split(',').map(Number));
async function boot(){try{await Q.auth(user,token);const response=await fetch(SERVICE+'/photos');if(!response.ok)throw Error('Could not load pictures. Please try again.');photoList=(await response.json()).photos;await updateReward();let saved;try{saved=JSON.parse(localStorage.getItem(storageKey));}catch{}
if(saved&&saved.roundId&&['3,4','4,6','6,8'].includes(saved.cols+','+saved.rows)&&isPermutation(saved.board,saved.cols*saved.rows)&&!saved.board.every((x,i)=>x===i)&&Number.isFinite(saved.elapsed)&&saved.elapsed>=0&&Number.isInteger(saved.moves)&&saved.moves>=0){roundId=saved.roundId;photoUrl=saved.photoUrl||'assets/forest.jpg';try{await loadPhoto(photoUrl);}catch{photoUrl='assets/forest.jpg';await loadPhoto(photoUrl);}cols=saved.cols;rows=saved.rows;board=saved.board;moves=saved.moves;elapsed=saved.elapsed;history=(saved.history||[]).filter(h=>isPermutation(h.board,board.length));$('difficulty').value=cols+','+rows;showPhoto();render();$('caption').textContent='Continue your puzzle. No extra play is used.';}else $('startDialog').showModal();
}catch(e){$('rewardMessage').textContent=e.message;$('startPlay').hidden=true;$('startDialog').showModal();}}
boot();
