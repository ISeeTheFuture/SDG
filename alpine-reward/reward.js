'use strict';
window.FlightReward=(()=>{
const Q=window.Quest,$=id=>document.getElementById(id),query=new URLSearchParams(location.search);
let session=null,quota=null,ready=false,starting=false,pendingStart=null,kind='menu',checkId=0;
try{session=query.has('token')?{user:query.get('user'),token:query.get('token')}:JSON.parse(sessionStorage.getItem('questFlightSession')||'null');if(session)sessionStorage.setItem('questFlightSession',JSON.stringify(session));history.replaceState(null,'',location.pathname);}catch{}
const back=()=>location.href=Q.HOME;
$('returnLearning').onclick=back;$('learnMore').onclick=back;
$('rewardPlayer').textContent=(Q.USERS.includes(session?.user)?session.user+' · ':'')+'REWARD PLAY';
$('start').disabled=true;
$('start').before($('rewardState')); // Status comes before the action, as in the approved concept.
function ui(){
 const paused=kind==='paused',recovered=pendingStart&&quota?.lastStart===pendingStart,allowed=ready&&(quota?.canPlay||recovered);
 document.querySelector('.reward-header').classList.toggle('hidden',window.AlpineFlight?.state()==='playing');
 document.querySelector('.hud').style.visibility=window.AlpineFlight?.state()==='playing'?'visible':'hidden';
 $('rewardState').classList.toggle('hidden',paused);$('quotaRule').classList.toggle('hidden',paused);
 $('learnMore').classList.toggle('hidden',paused||allowed);
 $('start').classList.toggle('hidden',!paused&&!allowed);$('start').disabled=starting||(!paused&&!allowed);
 if(paused)return;
 $('start').innerHTML=starting?'Starting flight…':kind==='menu'?"LET'S FLY <span>1 play ↗</span>":'Try again <span>1 play ↗</span>';
 if(!ready){$('quotaTitle').textContent='Sign in from the learning app';$('quotaMessage').textContent='Open Vocab to choose your profile and earn plays.';return;}
 if(quota.used>=6&&!recovered){$('quotaTitle').textContent='All 6 plays used today';$('quotaMessage').textContent='Come back tomorrow. Your '+quota.remaining+' remaining plays are saved.';$('quotaRule').textContent='Daily plays are shared with Poop Dodge.';}
 else if(!quota.remaining&&!recovered){$('quotaTitle').textContent='No plays left';$('quotaMessage').textContent='Learn more words and earn more plays. Then come back for another flight!';$('quotaRule').textContent='Earn 100 XP to unlock 3 more plays.';}
 else{$('quotaTitle').textContent=quota.available+' plays left';$('quotaMessage').textContent=kind==='menu'?'Both games share your earned plays.':'You can fly again!';$('quotaRule').textContent='One play is used when your next flight starts.';}
}
async function check(){const id=++checkId;try{if(!session)throw Error('Please sign in from the learning app.');const result=await Q.status(session.user,session.token);if(id!==checkId)return;quota=result;ready=true;$('rewardError').textContent='';}catch(e){if(id!==checkId)return;ready=false;$('rewardError').textContent=e.message;}ui();}
function menu(next){kind=next;if(next!=='paused'){$('tag').textContent='ALPINE SKY RUN';$('title').innerHTML=next==='won'?'Flight complete':'Game over';const n=session?.user==='PARENT'?'Parent':session?.user==='YURA'?'Yura':'Dennis';$('description').textContent='Nice flight, '+n+'!';}ui();if(next!=='paused')void check();}
async function start(){if(starting||!ready)return;starting=true;checkId++;$('rewardError').textContent='';ui();try{pendingStart=pendingStart||Q.uid();quota=await Q.start(session.user,session.token,pendingStart,'flight');pendingStart=null;kind='playing';window.AlpineFlight.start();document.querySelector('.reward-header').classList.add('hidden');}catch(e){$('rewardError').textContent=e.message;try{quota=await Q.status(session.user,session.token);ready=true;}catch{ready=false;}}finally{starting=false;ui();}}
let date=Q.day();setInterval(()=>{if(Q.day()!==date){date=Q.day();if(kind!=='playing')void check();}},30000);
window.addEventListener('pageshow',()=>{if(kind!=='playing')void check();});
void check();return {start,menu,playing:()=>{kind='playing';ui();}};
})();
