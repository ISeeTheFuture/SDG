/* Pure course generation and swept collision rules. */
(function(root){
'use strict';
const clamp=(v,a,b)=>Math.max(a,Math.min(b,v)),mix=(a,b,t)=>a+(b-a)*t,smooth=t=>t*t*(3-2*t);
function create(seed){
function noise(n){const v=Math.sin(n*127.1+seed*.007+311.7)*43758.5453;return v-Math.floor(v);}
function corridor(course){const c=Math.max(0,course),km=c*.004,ramp=smooth(clamp(c/130,0,1)),cell=c/240,i=Math.floor(cell),t=smooth(cell-i),squeeze=mix(noise(i+130),noise(i+131),t);const base=14-Math.min(km*.45,5.2),halfWidth=mix(14,base*(.69+squeeze*.31),ramp);const phase=seed%1000*.01;const bend=(Math.sin(c*.012+phase)*5+Math.sin(c*.027+phase*.7)*2.2)*ramp;return {center:bend,halfWidth:Math.max(6.1,halfWidth),floor:2.3};}
function speed(km){return Math.min(112,42+km*7);}
function spacing(km,n){return Math.max(82,130-km*4)*( .86+noise(n+800)*.28);}
function plan(index,course){const km=course*.004,p=corridor(course),r=noise(index*31+4),types=km<1.2?['bridge','rocks','pillars','gate']:['bridge','rocks','pillars','gate','lowpass','moving'];const kind=index===0?'bridge':types[Math.floor(r*types.length)];const gapW=Math.max(6.8,10.5-km*.25),gapH=Math.max(6.2,11-km*.28);const localX=index===0?0:(noise(index*13+11)-.5)*Math.max(0,p.halfWidth*2-gapW-3);const y=index===0?11:7.5+noise(index*7+18)*12;return {kind,course,center:p.center,width:p.halfWidth,localX,y,gapW:Math.min(gapW,p.halfWidth*2-2),gapH,phase:noise(index+93)*Math.PI*2,amplitude:Math.min(2.7,Math.max(0,p.halfWidth-gapW/2-Math.abs(localX)-1.2))};}
return {seed,noise,corridor,speed,spacing,plan};
}
function segmentHitsBox(start,end,half){let lo=0,hi=1;for(let i=0;i<3;i++){const delta=end[i]-start[i];if(Math.abs(delta)<1e-8){if(Math.abs(start[i])>half[i])return false;}else{let a=(-half[i]-start[i])/delta,b=(half[i]-start[i])/delta;if(a>b)[a,b]=[b,a];lo=Math.max(lo,a);hi=Math.min(hi,b);if(lo>hi)return false;}}return true;}
const api={create,segmentHitsBox};if(typeof module!=='undefined'&&module.exports)module.exports=api;else root.AlpineCourse=api;
})(typeof window!=='undefined'?window:globalThis);
