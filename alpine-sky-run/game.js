/* Alpine Sky Run — original procedural art; Three.js under MIT. */
'use strict';
(() => {
const $=id=>document.getElementById(id), T=window.THREE;
if(!T){showError('The game could not load. Please refresh the page.');return;}
// A CPU projection fallback also supports browsers without a WebGL context.
class CanvasRenderer {
constructor(canvas){this.canvas=canvas;this.ctx=canvas.getContext('2d',{alpha:false});if(!this.ctx)throw new Error('No graphics context');this.ratio=1;this.view=new T.Matrix4();this.mvp=new T.Matrix4();this.modelView=new T.Matrix4();this.normal=new T.Matrix3();this.color=new T.Color();this.light=new T.Vector3(-.5,.8,.25).normalize();this.n=new T.Vector3();this.cache=new WeakMap();}
setPixelRatio(r){this.ratio=Math.min(r,1.25);}
setSize(w,h){this.canvas.width=Math.round(w*this.ratio);this.canvas.height=Math.round(h*this.ratio);this.w=this.canvas.width;this.h=this.canvas.height;}
render(scene,camera){const ctx=this.ctx,w=this.w,h=this.h;if(!w)return;const gradient=ctx.createLinearGradient(0,0,0,h);gradient.addColorStop(0,'#4dc9ee');gradient.addColorStop(.68,'#b7e9de');gradient.addColorStop(1,'#c7ead7');ctx.fillStyle=gradient;ctx.fillRect(0,0,w,h);scene.updateMatrixWorld();camera.updateMatrixWorld();this.view.copy(camera.matrixWorldInverse);const draw=[];
scene.traverseVisible(o=>{if(!o.isMesh)return;const g=o.geometry,pos=g.attributes.position,idx=g.index,vc=g.attributes.color,normal=g.attributes.normal,m=o.material;if(!pos||Array.isArray(m))return;this.modelView.multiplyMatrices(this.view,o.matrixWorld);this.mvp.multiplyMatrices(camera.projectionMatrix,this.modelView);this.normal.getNormalMatrix(o.matrixWorld);const e=this.mvp.elements,ve=this.modelView.elements,p=pos.array;let data=this.cache.get(g);if(!data){data={screen:new Float32Array(pos.count*3)};this.cache.set(g,data);}const s=data.screen;
for(let i=0;i<pos.count;i++){const k=i*3,x=p[k],y=p[k+1],z=p[k+2],cw=e[3]*x+e[7]*y+e[11]*z+e[15];s[k]=(e[0]*x+e[4]*y+e[8]*z+e[12])/cw*w*.5+w*.5;s[k+1]=-(e[1]*x+e[5]*y+e[9]*z+e[13])/cw*h*.5+h*.5;s[k+2]=-(ve[2]*x+ve[6]*y+ve[10]*z+ve[14]);}
const count=idx?idx.count:pos.count;for(let j=0;j<count;j+=3){const ia=idx?idx.array[j]:j,ib=idx?idx.array[j+1]:j+1,ic=idx?idx.array[j+2]:j+2,a=ia*3,b=ib*3,c=ic*3;if(s[a+2]<.4||s[b+2]<.4||s[c+2]<.4)continue;const ax=s[a],ay=s[a+1],bx=s[b],by=s[b+1],cx=s[c],cy=s[c+1];if((bx-ax)*(cy-ay)-(by-ay)*(cx-ax)>=0)continue;if(Math.max(ax,bx,cx)<0||Math.min(ax,bx,cx)>w||Math.max(ay,by,cy)<0||Math.min(ay,by,cy)>h)continue;const depth=(s[a+2]+s[b+2]+s[c+2])/3;if(depth>650)continue;this.color.copy(m.color);if(vc)this.color.setRGB(vc.getX(ia),vc.getY(ia),vc.getZ(ia));let lit=1;if(normal){this.n.fromBufferAttribute(normal,ia).applyMatrix3(this.normal).normalize();lit=.7+Math.max(0,this.n.dot(this.light))*.45;}this.color.multiplyScalar(lit);if(m.emissive)this.color.addScaledColor?this.color.addScaledColor(m.emissive,.2):this.color.add(m.emissive.clone().multiplyScalar(.2));const fog=T.MathUtils.smoothstep(depth,90,540);this.color.lerp(scene.fog.color,fog);draw.push({ax,ay,bx,by,cx,cy,depth,color:this.color.getStyle(T.SRGBColorSpace),alpha:m.transparent?m.opacity:1});}});
draw.sort((a,b)=>b.depth-a.depth);for(const f of draw){ctx.globalAlpha=f.alpha;ctx.fillStyle=f.color;ctx.beginPath();ctx.moveTo(f.ax,f.ay);ctx.lineTo(f.bx,f.by);ctx.lineTo(f.cx,f.cy);ctx.closePath();ctx.fill();}ctx.globalAlpha=1;}
}
let renderer;
try{renderer=new T.WebGLRenderer({canvas:$('world'),antialias:true,alpha:false,powerPreference:'high-performance'});}catch(e){try{renderer=new CanvasRenderer($('world'));}catch(err){showError('This browser could not start graphics. Please open the game in Chrome or Safari.');return;}}
renderer.setPixelRatio(Math.min(devicePixelRatio,1.65));renderer.outputColorSpace=T.SRGBColorSpace;
const scene=new T.Scene();scene.background=new T.Color('#73d7ed');scene.fog=new T.Fog('#b7e9de',90,540);
const camera=new T.PerspectiveCamera(60,1,.1,700);
scene.add(new T.HemisphereLight('#eafaff','#5a8240',2.0));
const sun=new T.DirectionalLight('#fff8d8',2.15);sun.position.set(-80,110,30);scene.add(sun);
const materialCache=new Map();function mat(color,emissive){const key=color+':'+emissive;if(!materialCache.has(key))materialCache.set(key,new T.MeshStandardMaterial({color,flatShading:true,roughness:.82,metalness:0,emissive:emissive||0,emissiveIntensity:emissive?.7:0}));return materialCache.get(key);}
const boxgeo=new T.BoxGeometry(1,1,1), spheregeo=new T.IcosahedronGeometry(1,0), conegeo=new T.ConeGeometry(1,1,5);
function mesh(geo,color,x=0,y=0,z=0,sx=1,sy=1,sz=1,parent=scene){const m=new T.Mesh(geo,typeof color==='string'?mat(color):color);m.position.set(x,y,z);m.scale.set(sx,sy,sz);parent.add(m);return m;}
const plane=new T.Group();scene.add(plane);plane.position.set(0,11,0);
mesh(spheregeo,'#147bd1',0,0,0,.85,.75,2.1,plane);
mesh(boxgeo,'#1b91eb',0,-.05,-.15,6.4,.15,1.12,plane);
mesh(boxgeo,'#ffc94e',-3,-.04,-.18,.55,.17,1.16,plane);mesh(boxgeo,'#ffc94e',3,-.04,-.18,.55,.17,1.16,plane);
mesh(spheregeo,'#7fe9ff',0,.57,-.55,.5,.35,.8,plane);
mesh(boxgeo,'#ffcc4d',0,.68,1.47,.17,1.35,.83,plane);mesh(boxgeo,'#ffce49',0,.22,1.55,2.4,.12,.65,plane);
const engines=[],flames=[];
for(const x of [-1.95,1.95]){mesh(spheregeo,'#197ac2',x,-.25,-.2,.38,.4,.88,plane);mesh(spheregeo,'#f06a32',x,-.25,-.95,.34,.36,.27,plane);const prop=new T.Group();prop.position.set(x,-.25,-1.25);plane.add(prop);mesh(boxgeo,'#f5dd94',0,0,0,1.13,.08,.06,prop);mesh(boxgeo,'#f5dd94',0,0,0,.08,1.13,.06,prop);engines.push(prop);const f=mesh(conegeo,mat('#ffc54e','#ff601d'),x,-.25,1,.24,2,.24,plane);f.rotation.x=Math.PI/2;flames.push(f);}
// Deterministic noise keeps the terrain continuous across recycled segments.
const hash=(n)=>{const v=Math.sin(n*127.1+311.7)*43758.5453;return v-Math.floor(v);};
const xs=[-100,-70,-48,-32,-22,-15,-8,0,8,15,22,32,48,70,100];
function altitude(x,z){const ax=Math.abs(x);if(ax<=15)return -2.5+Math.sin(z*.025)*.4;const ridge=Math.sin(z*.035+x*.18)*9+Math.sin(z*.08)*4;return ax<=22?5+(ax-15)*1.4:13+(ax-22)*.75+ridge+hash(Math.round(z/16)+x)*8;}
const terrain=[],terrainMat=new T.MeshStandardMaterial({vertexColors:true,flatShading:true,roughness:1});
function terrainGeometry(start){const verts=[],cols=[];const greens=['#4a9d2c','#59ab31','#65b438','#448f2c','#389236','#77ba43'];for(let j=0;j<2;j++){const za=start+j*16,zb=za+16;for(let k=0;k<xs.length-1;k++){const a=[xs[k],altitude(xs[k],za),j*16],b=[xs[k+1],altitude(xs[k+1],za),j*16],c=[xs[k],altitude(xs[k],zb),(j+1)*16],d=[xs[k+1],altitude(xs[k+1],zb),(j+1)*16];for(const tri of [[a,c,b],[b,c,d]]){const color=new T.Color(greens[Math.floor(hash(start+k*19+j*83)*greens.length)]);for(const v of tri){verts.push(...v);cols.push(color.r,color.g,color.b);}}}}const g=new T.BufferGeometry();g.setAttribute('position',new T.Float32BufferAttribute(verts,3));g.setAttribute('color',new T.Float32BufferAttribute(cols,3));g.computeVertexNormals();return g;}
let trackTravel=0;
for(let i=0;i<22;i++){const m=new T.Mesh(terrainGeometry(i*32),terrainMat);m.position.z=48-i*32;scene.add(m);terrain.push(m);}
const clouds=[];for(let i=0;i<22;i++){const group=new T.Group();for(let k=0;k<4;k++)mesh(spheregeo,'#f4ffff',(k-1.5)*5,hash(i+k)*3,0,5+hash(i*9+k)*3,2.5,3.7,group);group.position.set((hash(i+4)-.5)*160,48+hash(i+44)*45,30-i*30);scene.add(group);clouds.push(group);}
const distant=new T.Group();scene.add(distant);for(let i=0;i<16;i++){const peak=mesh(conegeo,'#8acbbb',(i-7.5)*42,35,-535,42,95,44,distant);peak.rotation.y=hash(i)*3;mesh(conegeo,'#e7f0df',peak.position.x,70,-535,16,28,17,distant);}
const trees=[];for(let i=0;i<36;i++){const g=new T.Group();mesh(boxgeo,'#715c31',0,0,0,.7,5,.7,g);mesh(conegeo,'#327735',0,4,0,3,10,3,g);g.position.set((i%2?1:-1)*(24+hash(i)*24),12+hash(i)*12,-i*19);scene.add(g);trees.push(g);}
const starShape=new T.Shape();for(let i=0;i<10;i++){const a=i*Math.PI/5+Math.PI/2,r=i%2?.42:1;const x=Math.cos(a)*r,y=Math.sin(a)*r;i?starShape.lineTo(x,y):starShape.moveTo(x,y);}starShape.closePath();
const starGeo=new T.ExtrudeGeometry(starShape,{depth:.22,bevelEnabled:true,bevelSegments:1,steps:1,bevelSize:.09,bevelThickness:.08});starGeo.center();const starMat=mat('#ffdb53','#e8a923');
const obstacles=[],stars=[],particles=[];const tornado=new T.Group();scene.add(tornado);const stormMat=new T.MeshStandardMaterial({color:'#697d89',transparent:true,opacity:.45,roughness:1});for(let i=0;i<9;i++){const ring=new T.Mesh(new T.TorusGeometry(1,.18,4,16),stormMat);ring.rotation.x=Math.PI/2;ring.position.y=i*2;ring.scale.setScalar(2+i*.8);tornado.add(ring);}tornado.position.set(0,0,45);
let state='menu',distance=0,collected=0,lives=3,energy=100,storm=800,invulnerable=0,spawnIndex=0,nextRow=100,best=0,last=performance.now(),elapsed=0,boosting=false,toastTimer=0,flashTimer=0;
try{best=Number(localStorage.getItem('alpine-sky-best-v1'))||0;}catch(e){}
const keys=new Set(),input={x:0,y:0,boost:false},clamp=T.MathUtils.clamp;
let audio=null,soundOn=false;
function sound(freq,duration=.12,type='sine'){if(!soundOn||!audio)return;try{const o=audio.createOscillator(),g=audio.createGain();o.type=type;o.frequency.value=freq;g.gain.setValueAtTime(.055,audio.currentTime);g.gain.exponentialRampToValueAtTime(.001,audio.currentTime+duration);o.connect(g);g.connect(audio.destination);o.start();o.stop(audio.currentTime+duration);}catch(e){}}
function record(){ $('record').textContent='PERSONAL BEST · '+best.toFixed(2)+' KM';}record();
function toast(text){$('toast').textContent=text;$('toast').style.opacity=1;toastTimer=2.2;}
function clearWorld(){for(const o of obstacles)scene.remove(o.group);obstacles.length=0;for(const s of stars)scene.remove(s.mesh);stars.length=0;for(const p of particles)scene.remove(p.mesh);particles.length=0;}
function spawnRow(index,z){const gx=index===0?0:(hash(index*3)-.5)*14,gy=index===0?11:8+hash(index*7)*11;const g=new T.Group();scene.add(g);g.position.z=z;const colliders=[];const gapW=10.5,gapH=11;
function bar(x,y,w,h){mesh(boxgeo,'#997344',x,y,0,w,h,1.6,g);mesh(boxgeo,'#c39a62',x,y+h/2+.04,0,w,.13,1.7,g);colliders.push({x,y,w,h});}
if(index%3===2){bar(-10,11,3.3,26);bar(7,5,4,11);bar(0,25,34,3);for(let i=0;i<3;i++)mesh(conegeo,'#6c7468',-11+i*10,1,0,3,6,3,g);}else{const left=-17,right=17,lo=gx-gapW/2,hi=gx+gapW/2;bar((left+lo)/2,15,lo-left,32);bar((hi+right)/2,15,right-hi,32);const bottom=gy-gapH/2,top=gy+gapH/2;if(bottom>0)bar(gx,bottom/2,gapW,bottom);bar(gx,(32+top)/2,gapW,32-top);}
obstacles.push({group:g,colliders,checked:false,passed:false});
for(let i=0;i<6;i++){const m=new T.Mesh(starGeo,starMat);m.position.set(index%3===2?0:gx,index%3===2?15:gy,z+30+i*5);scene.add(m);stars.push({mesh:m});}
}
function reset(){clearWorld();distance=0;collected=0;lives=3;energy=100;storm=800;invulnerable=0;spawnIndex=0;nextRow=100;trackTravel=0;elapsed=0;keys.clear();input.x=input.y=0;input.boost=false;plane.position.set(0,11,0);plane.rotation.set(0,0,0);camera.position.set(0,17,24);state='playing';$('menu').classList.add('hidden');$('touch').classList.remove('hidden');$('hint').classList.remove('hidden');$('pause').textContent='Ⅱ';$('pause').setAttribute('aria-label','Pause game');$('flash').style.opacity=0;for(let i=0;i<22;i++)terrain[i].position.z=48-i*32;for(let i=0;i<5;i++)spawnRow(spawnIndex++,-110-i*100);nextRow=610;toast('Find the opening. Follow the stars!');if(audio)audio.resume();updateHUD();}
function showMenu(kind){$('menu').classList.remove('hidden');$('touch').classList.add('hidden');$('hint').classList.add('hidden');$('results').classList.toggle('hidden',kind==='paused');$('help').classList.toggle('hidden',kind!=='paused');if(kind==='paused'){$('tag').textContent='TAKE A BREATHER';$('title').innerHTML='Sky on<br><span>standby.</span>';$('description').textContent='Your adventure is right where you left it.';$('start').innerHTML='RESUME FLIGHT <span>↗</span>';}else{$('tag').textContent=kind==='won'?'100 KM. YOU MADE IT!':'EVERY FLIGHT IS A FRESH START';$('title').innerHTML=kind==='won'?'Above &<br><span>beyond.</span>':'One more<br><span>flight?</span>';$('description').textContent=kind==='won'?'You crossed the mountains and outran the storm.':'The sky is waiting. Try a new route and beat your best.';$('start').innerHTML='FLY AGAIN <span>↗</span>';$('finaldistance').textContent=distance.toFixed(2)+' km';$('finalstars').textContent=collected;record();}}
function finish(won=false){state=won?'won':'over';if(distance>best){best=distance;try{localStorage.setItem('alpine-sky-best-v1',best.toFixed(2));}catch(e){}}showMenu(state);sound(won?880:150,.4);}
function pause(){if(state==='playing'){state='paused';keys.clear();input.x=input.y=0;input.boost=false;showMenu('paused');$('pause').textContent='▶';$('pause').setAttribute('aria-label','Resume game');}else if(state==='paused'){state='playing';$('menu').classList.add('hidden');$('touch').classList.remove('hidden');$('hint').classList.remove('hidden');$('pause').textContent='Ⅱ';$('pause').setAttribute('aria-label','Pause game');}}
function burst(pos,color,count=10){for(let i=0;i<count;i++){const m=mesh(spheregeo,color,pos.x,pos.y,pos.z,.1,.1,.1);particles.push({mesh:m,v:new T.Vector3((Math.random()-.5)*9,(Math.random()-.3)*8,(Math.random()-.5)*7),life:.7});}}
function hit(){if(invulnerable>0||state!=='playing')return;lives--;storm-=120;invulnerable=1.7;flashTimer=.32;burst(plane.position,'#ffbe70',16);sound(120,.2,'sawtooth');toast(lives>0?'Watch your wings!':'Flight ended');if(lives<=0)finish();}
function updateHUD(){$('distance').textContent=distance.toFixed(2);$('stars').textContent=collected;$('health').innerHTML=Array.from({length:3},(_,i)=>'<span class="'+(i>=lives?'empty':'')+'">♥</span>').join('');$('energytext').textContent=Math.round(energy)+'%';$('energyfill').style.width=energy+'%';$('stormtext').textContent=Math.max(0,Math.round(storm))+' m';$('stormfill').style.width=clamp(storm/10,0,100)+'%';$('stormfill').style.background=storm<220?'#ff7970':'#e9f9ff';$('progress').style.width=clamp(distance,0,100)+'%';$('level').textContent='VALLEY '+String(1+Math.floor(distance/10)).padStart(2,'0');}
function step(dt){elapsed+=dt;toastTimer-=dt;if(toastTimer<=0)$('toast').style.opacity=0;flashTimer=Math.max(0,flashTimer-dt);$('flash').style.opacity=flashTimer*.7;for(const prop of engines)prop.rotation.z+=dt*55;
if(state==='playing'){
const ix=clamp((keys.has('ArrowRight')||keys.has('d')?1:0)-(keys.has('ArrowLeft')||keys.has('a')?1:0)+input.x,-1,1),iy=clamp((keys.has('ArrowUp')||keys.has('w')?1:0)-(keys.has('ArrowDown')||keys.has('s')?1:0)+input.y,-1,1);
boosting=(keys.has(' ')||input.boost)&&energy>1;
energy=clamp(energy+(boosting?-27:13)*dt,0,100);const speed=(38+Math.min(distance*.3,22))*(boosting?1.7:1);const advance=speed*dt;trackTravel+=advance;distance=Math.min(100,distance+advance*.004);
storm=clamp(storm+(boosting?85:-22-Math.min(distance*.4,18))*dt,0,1000);if(storm<=0){toast('The storm caught up!');finish();}
plane.position.x=clamp(plane.position.x+ix*17*dt,-16,16);plane.position.y=clamp(plane.position.y+iy*14*dt,2,28);
plane.rotation.z=T.MathUtils.damp(plane.rotation.z,-ix*.52,8,dt);plane.rotation.x=T.MathUtils.damp(plane.rotation.x,iy*.22,7,dt);plane.rotation.y=T.MathUtils.damp(plane.rotation.y,-ix*.12,7,dt);
invulnerable=Math.max(0,invulnerable-dt);plane.visible=invulnerable<=0||Math.floor(invulnerable*12)%2===0;
if((Math.abs(plane.position.x)>15.8||plane.position.y<=2.05)&&invulnerable<=0){hit();plane.position.x*=.85;plane.position.y=Math.max(plane.position.y,4);}
for(const m of terrain){m.position.z+=advance;if(m.position.z>80){m.position.z-=704;m.geometry.dispose();m.geometry=terrainGeometry(Math.floor(trackTravel/32)*32);}}
for(const c of clouds){c.position.z+=advance*.75;if(c.position.z>80)c.position.z-=690;}
for(const t of trees){t.position.z+=advance;if(t.position.z>70)t.position.z-=684;}
for(let i=obstacles.length-1;i>=0;i--){const o=obstacles[i];const before=o.group.position.z;o.group.position.z+=advance;if(!o.checked&&before<1.8&&o.group.position.z>=-1.8){o.checked=true;for(const b of o.colliders){if(Math.abs(plane.position.x-b.x)<b.w/2+1&&Math.abs(plane.position.y-b.y)<b.h/2+.65){hit();break;}}}if(!o.passed&&o.group.position.z>4){o.passed=true;storm=clamp(storm+18,0,1000);}if(o.group.position.z>65){scene.remove(o.group);obstacles.splice(i,1);}}
while(trackTravel+500>=nextRow){spawnRow(spawnIndex++,-(nextRow-trackTravel));nextRow+=100;}
for(let i=stars.length-1;i>=0;i--){const s=stars[i],z0=s.mesh.position.z;s.mesh.position.z+=advance;s.mesh.rotation.y+=dt*2;s.mesh.rotation.z=Math.sin(elapsed*3+i)*.15;if(z0<2&&s.mesh.position.z>=-2&&Math.hypot(s.mesh.position.x-plane.position.x,s.mesh.position.y-plane.position.y)<2.2){collected++;energy=clamp(energy+2,0,100);storm=clamp(storm+8,0,1000);burst(s.mesh.position,'#ffed7f',5);sound(660+collected%4*100,.08);scene.remove(s.mesh);stars.splice(i,1);}else if(s.mesh.position.z>45){scene.remove(s.mesh);stars.splice(i,1);}}
if(distance>=100)finish(true);updateHUD();
}else if(state==='menu'){plane.position.y=11+Math.sin(elapsed*1.4)*.35;plane.rotation.z=Math.sin(elapsed*.7)*.12;boosting=false;}
for(const f of flames){f.visible=boosting;f.scale.y=2.5+Math.sin(elapsed*40)*.6;}
for(let i=particles.length-1;i>=0;i--){const p=particles[i];p.life-=dt;p.mesh.position.addScaledVector(p.v,dt);p.mesh.scale.setScalar(Math.max(0,p.life)*.2);if(p.life<=0){scene.remove(p.mesh);particles.splice(i,1);}}
tornado.visible=state==='playing'&&storm<360;tornado.position.set(plane.position.x*.3,0,12+storm*.035);tornado.rotation.y+=dt*2;for(let i=0;i<tornado.children.length;i++)tornado.children[i].position.x=Math.sin(elapsed*3+i)*.7;
const isMenu=state==='menu',targetX=isMenu?10:plane.position.x*.4,targetY=isMenu?17:plane.position.y+5;
camera.position.x=T.MathUtils.damp(camera.position.x,targetX,3,dt);camera.position.y=T.MathUtils.damp(camera.position.y,targetY,3,dt);camera.position.z=isMenu?25:23;camera.fov=T.MathUtils.damp(camera.fov,boosting?71:60,4,dt);camera.updateProjectionMatrix();camera.lookAt(isMenu?-2:plane.position.x*.6,isMenu?10:plane.position.y+1,-34);
renderer.render(scene,camera);
}
function frame(now){const dt=Math.min((now-last)/1000,.04);last=now;step(dt);requestAnimationFrame(frame);}camera.position.set(10,17,25);
function resize(){const w=innerWidth,h=innerHeight;renderer.setSize(w,h,false);camera.aspect=w/h;camera.updateProjectionMatrix();}addEventListener('resize',resize);resize();
$('start').onclick=()=>state==='paused'?pause():reset();$('pause').onclick=pause;
$('sound').onclick=()=>{soundOn=!soundOn;if(soundOn&&!audio){try{audio=new(window.AudioContext||window.webkitAudioContext)();}catch(e){soundOn=false;}}if(audio)audio.resume();$('sound').style.background=soundOn?'#fff5':'#102f3a50';$('sound').setAttribute('aria-label',soundOn?'Turn sound off':'Turn sound on');sound(700);};
addEventListener('keydown',e=>{const key=e.key.length===1?e.key.toLowerCase():e.key;if(['ArrowUp','ArrowDown','ArrowLeft','ArrowRight',' ','w','a','s','d'].includes(key)){e.preventDefault();keys.add(key);}if(e.key==='Escape'&&!e.repeat)pause();});addEventListener('keyup',e=>keys.delete(e.key.length===1?e.key.toLowerCase():e.key));
addEventListener('blur',()=>{keys.clear();input.x=input.y=0;input.boost=false;if(state==='playing')pause();});document.addEventListener('visibilitychange',()=>{if(document.hidden&&state==='playing')pause();});
let stickPointer=null;const stick=$('stick'),knob=$('knob');function moveStick(e){if(e.pointerId!==stickPointer)return;const r=stick.getBoundingClientRect(),lim=r.width*.34;const x=clamp(e.clientX-r.left-r.width/2,-lim,lim),y=clamp(e.clientY-r.top-r.height/2,-lim,lim);const len=Math.hypot(x,y),factor=len>lim?lim/len:1;input.x=x*factor/lim;input.y=-y*factor/lim;knob.style.transform=`translate(${x*factor}px,${y*factor}px)`;}
stick.addEventListener('pointerdown',e=>{e.preventDefault();stickPointer=e.pointerId;stick.setPointerCapture(e.pointerId);moveStick(e);});stick.addEventListener('pointermove',moveStick);function releaseStick(e){if(e.pointerId===stickPointer){stickPointer=null;input.x=input.y=0;knob.style.transform='';}}stick.addEventListener('pointerup',releaseStick);stick.addEventListener('pointercancel',releaseStick);stick.addEventListener('lostpointercapture',releaseStick);
const boost=$('boost');boost.addEventListener('pointerdown',e=>{e.preventDefault();boost.setPointerCapture(e.pointerId);input.boost=true;});for(const ev of ['pointerup','pointercancel','lostpointercapture'])boost.addEventListener(ev,()=>input.boost=false);
if(matchMedia('(pointer:coarse)').matches)$('touchhelp').textContent='Joystick to steer. Hold ϟ to boost.';
$('world').addEventListener('webglcontextlost',e=>{e.preventDefault();if(state==='playing')pause();toast('Graphics interrupted. Refresh to continue.');});
updateHUD();requestAnimationFrame(frame);
function showError(message){const el=document.createElement('div');el.className='error';el.textContent=message;document.body.append(el);}
})();
