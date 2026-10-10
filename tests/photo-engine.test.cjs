const assert=require('node:assert/strict');
const {groups,move}=require('../photo-puzzle/engine.js');
const sorted=a=>a.slice().sort((a,b)=>a-b);
for(const [cols,rows] of [[3,4],[4,6],[6,8]]){
  const home=Array.from({length:cols*rows},(_,i)=>i);
  assert.equal(groups(home,cols).length,1);
  for(let trial=0;trial<160;trial++){
    let b=home.slice();for(let i=b.length-1;i>0;i--){const j=Math.floor(Math.random()*(i+1));[b[i],b[j]]=[b[j],b[i]];}
    for(let step=0;step<60;step++){
      const gs=groups(b,cols);assert.deepEqual(sorted(gs.flat()),home);
      const g=gs[Math.floor(Math.random()*gs.length)];
      const n=move(b,cols,g,Math.floor(Math.random()*cols*2)-cols,Math.floor(Math.random()*rows*2)-rows);
      assert.deepEqual(sorted(n),home,'group moves must not lose or duplicate tiles');
      const positions=g.map(p=>n.indexOf(b[p])),dx=positions[0]%cols-g[0]%cols,dy=Math.floor(positions[0]/cols)-Math.floor(g[0]/cols);
      for(let k=0;k<g.length;k++){assert.equal(positions[k]%cols-g[k]%cols,dx);assert.equal(Math.floor(positions[k]/cols)-Math.floor(g[k]/cols),dy);}
      b=n;
    }
    for(let step=0;step<home.length;step++){
      const p=b.findIndex((h,i)=>h!==i);if(p<0)break;
      const h=b[p];b=move(b,cols,groups(b,cols).find(g=>g.includes(p)),h%cols-p%cols,Math.floor(h/cols)-Math.floor(p/cols));
      assert.deepEqual(sorted(b),home);
    }
    assert.deepEqual(b,home,'hints must always be able to finish the puzzle');
  }
}
// Overlapping group footprints must displace the far-end tile into the vacancy.
assert.deepEqual(move([0,1,5,3,4,2,6,7,8],3,[0,1],1,0),[5,0,1,3,4,2,6,7,8]);
console.log('Passed: 28,800 randomized group moves, all difficulty levels, overlapping swaps, and 480 hint-to-completion checks.');
