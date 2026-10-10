const MAX=3*1024*1024;
const KEY=/^photos\/[0-9a-f-]{36}\.jpg$/;
const cors={'Access-Control-Allow-Origin':'*','Access-Control-Allow-Methods':'GET, HEAD, OPTIONS','X-Content-Type-Options':'nosniff'};
const json=(status,data)=>new Response(JSON.stringify(data),{status,headers:{...cors,'Content-Type':'application/json','Cache-Control':'no-store'}});
export default {async fetch(request,env){
 try{
 const url=new URL(request.url),route=url.pathname;
 if(request.method==='OPTIONS')return new Response(null,{status:204,headers:cors});
 if(route==='/health')return json(200,{ok:true});
 if(env.REQUEST_LIMIT){const r=await env.REQUEST_LIMIT.limit({key:request.headers.get('CF-Connecting-IP')||'unknown'});if(!r.success)return json(429,{error:'잠시 후 다시 시도해 주세요.'});}
 if(!env.PHOTOS)return json(503,{error:'사진 저장소가 아직 연결되지 않았습니다.'});
 if(request.method==='GET'&&route==='/photos'){
  const cacheKey=new Request(url.origin+'/photos');const cached=await caches.default.match(cacheKey);if(cached)return cached;
  let cursor,photos=[];do{const page=await env.PHOTOS.list({prefix:'photos/',include:['customMetadata'],limit:1000,...(cursor?{cursor}:{})});photos.push(...page.objects.filter(o=>KEY.test(o.key)).map(o=>({id:o.key,title:o.customMetadata?.title||'사진 퍼즐',width:Number(o.customMetadata?.width)||900,height:Number(o.customMetadata?.height)||1200,uploadedAt:o.uploaded.toISOString(),size:o.size,url:url.origin+'/image/'+encodeURIComponent(o.key)})));cursor=page.truncated?page.cursor:null;}while(cursor);
  const response=json(200,{photos:photos.sort((a,b)=>b.uploadedAt.localeCompare(a.uploadedAt))});response.headers.set('Cache-Control','public, max-age=300');await caches.default.put(cacheKey,response.clone());return response;
 }
 if(['GET','HEAD'].includes(request.method)&&route.startsWith('/image/')){
  const key=decodeURIComponent(route.slice(7));if(!KEY.test(key))return json(404,{error:'사진이 없습니다.'});
  const file=await env.PHOTOS.get(key);if(!file)return json(404,{error:'사진이 없습니다.'});
  return new Response(request.method==='HEAD'?null:file.body,{headers:{...cors,'Content-Type':'image/jpeg','Cache-Control':'public, max-age=86400',ETag:file.httpEtag,'Content-Length':String(file.size)}});
 }
 if(!['POST','DELETE'].includes(request.method)||!(route==='/photos'||route.startsWith('/photos/')))return json(404,{error:'없는 기능입니다.'});
 if(!env.ADMIN_TOKEN||request.headers.get('Authorization')!=='Bearer '+env.ADMIN_TOKEN)return json(401,{error:'사진 관리 권한이 필요합니다.'});
 if(request.method==='POST'&&route==='/photos'){
  const existing=await env.PHOTOS.list({prefix:'photos/',limit:201});if(existing.objects.length>=200||existing.truncated)return json(409,{error:'사진은 최대 200장입니다. 기존 사진을 삭제한 후 올려 주세요.'});
  if(request.headers.get('Content-Type')?.split(';')[0]!=='image/jpeg')return json(415,{error:'JPEG 사진만 저장할 수 있습니다.'});
  if(Number(request.headers.get('Content-Length'))>MAX)return json(413,{error:'사진 크기를 줄여 주세요.'});
  const reader=request.body?.getReader();if(!reader)return json(400,{error:'사진을 선택해 주세요.'});let bytes=0,chunks=[];
  while(true){const {done,value}=await reader.read();if(done)break;bytes+=value.byteLength;if(bytes>MAX){await reader.cancel();return json(413,{error:'사진 크기를 줄여 주세요.'});}chunks.push(value);}
  const body=new Uint8Array(bytes);let offset=0;for(const chunk of chunks){body.set(chunk,offset);offset+=chunk.length;}
  if(bytes<4||body[0]!==255||body[1]!==216||body[2]!==255)return json(415,{error:'올바른 사진 파일이 아닙니다.'});
  const key='photos/'+crypto.randomUUID()+'.jpg',title=(url.searchParams.get('title')||'사진 퍼즐').slice(0,80),width=Math.min(2000,Math.max(1,Number(url.searchParams.get('width'))||900)),height=Math.min(2000,Math.max(1,Number(url.searchParams.get('height'))||1200));
  await env.PHOTOS.put(key,body,{httpMetadata:{contentType:'image/jpeg'},customMetadata:{title,width:String(width),height:String(height)}});
  await caches.default.delete(new Request(url.origin+'/photos'));
  return json(201,{id:key});
 }
 if(request.method==='DELETE'&&route.startsWith('/photos/')){const key=decodeURIComponent(route.slice(8));if(!KEY.test(key))return json(400,{error:'잘못된 사진입니다.'});await env.PHOTOS.delete(key);await caches.default.delete(new Request(url.origin+'/photos'));return json(200,{ok:true});}
 return json(405,{error:'지원하지 않는 요청입니다.'});
 }catch{return json(502,{error:'사진 저장소에 연결하지 못했습니다. 다시 시도해 주세요.'});}
}};
