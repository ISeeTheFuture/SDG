const MAX=3*1024*1024;
async function read(req,max){let chunks=[],size=0;for await(const c of req){size+=c.length;if(size>max)throw Object.assign(Error('사진 크기를 줄여 주세요.'),{status:413});chunks.push(c);}return Buffer.concat(chunks);}
function photoRoutes({service=process.env.PHOTO_SERVICE_URL||'',token=process.env.PHOTO_SERVICE_TOKEN||''}={}){
 const configured=!!(service&&token);
 return async(req,res,url,send)=>{
 if(!['/api/photos','/api/photo-login','/api/photo-logout'].includes(url.pathname)&&!url.pathname.startsWith('/api/photos/'))return false;
 try{
 if(!configured){send(503,{error:'사진 저장소 연결을 준비 중입니다.',configured:false});return true;}
 const upstream=async(path,opt={})=>{const r=await fetch(service.replace(/\/$/,'')+path,{...opt,signal:AbortSignal.timeout(20000)});const data=await r.json();if(!r.ok)throw Object.assign(Error(data.error||'사진 저장소에 연결하지 못했습니다.'),{status:r.status});return data;};
 if(req.method==='GET'&&url.pathname==='/api/photos'){send(200,{configured:true,authorized:true,...(await upstream('/photos'))});return true;}
 if(req.headers.origin&&req.headers.origin!==new URL('https://'+req.headers.host).origin&&req.headers.origin!==new URL('http://'+req.headers.host).origin){send(403,{error:'허용되지 않은 요청입니다.'});return true;}
 if(req.method==='POST'&&url.pathname==='/api/photos'){
 if(req.headers['content-type']!=='image/jpeg'){send(415,{error:'사진 파일을 선택해 주세요.'});return true;}
 const data=await upstream('/photos'+url.search,{method:'POST',headers:{Authorization:'Bearer '+token,'Content-Type':'image/jpeg'},body:await read(req,MAX)});send(201,data);return true;
 }
 if(req.method==='DELETE'&&url.pathname.startsWith('/api/photos/')){const key=decodeURIComponent(url.pathname.slice(12));if(!/^photos\/[0-9a-f-]{36}\.jpg$/.test(key)){send(400,{error:'잘못된 사진입니다.'});return true;}send(200,await upstream('/photos/'+encodeURIComponent(key),{method:'DELETE',headers:{Authorization:'Bearer '+token}}));return true;}
 send(405,{error:'지원하지 않는 요청입니다.'});return true;
 }catch(e){send(e.status||502,{error:e.message||'사진 관리에 실패했습니다.'});return true;}
 };
}
module.exports={photoRoutes};
