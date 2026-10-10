/* Every tile has an immutable home index. Groups are connected tiles with
   the same translation from home. Translation swaps follow chains through
   overlapping footprints, keeping the board a permutation. */
(function(root){
  function groups(board,cols){
    const seen=new Set(),out=[];
    for(let i=0;i<board.length;i++){
      if(seen.has(i))continue;
      const group=[],stack=[i];seen.add(i);
      while(stack.length){
        const p=stack.pop();group.push(p);
        const r=Math.floor(p/cols),c=p%cols;
        for(const q of [c>0?p-1:-1,c<cols-1?p+1:-1,p-cols,p+cols]){
          if(q<0||q>=board.length||seen.has(q))continue;
          const h=board[p],k=board[q];
          if(Math.floor(k/cols)-Math.floor(h/cols)===Math.floor(q/cols)-r && k%cols-h%cols===q%cols-c){seen.add(q);stack.push(q);}
        }
      }out.push(group);
    }return out;
  }
  function move(board,cols,group,dx,dy){
    const rows=board.length/cols;
    dx=Math.max(-Math.min(...group.map(p=>p%cols)),Math.min(cols-1-Math.max(...group.map(p=>p%cols)),dx));
    dy=Math.max(-Math.min(...group.map(p=>Math.floor(p/cols))),Math.min(rows-1-Math.max(...group.map(p=>Math.floor(p/cols))),dy));
    if(!dx&&!dy)return board.slice();
    const delta=dy*cols+dx,src=new Set(group),dst=new Set(group.map(p=>p+delta)),next=board.slice();
    for(const p of dst){
      if(src.has(p))continue;
      let vacancy=p-delta;
      while(dst.has(vacancy))vacancy-=delta;
      next[vacancy]=board[p];
    }
    for(const p of group)next[p+delta]=board[p];
    return next;
  }
  const api={groups,move};
  if(typeof module!=='undefined'&&module.exports)module.exports=api;else root.PuzzleEngine=api;
})(typeof window==='undefined'?globalThis:window);
