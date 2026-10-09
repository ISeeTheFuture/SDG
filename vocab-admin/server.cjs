const http=require('node:http'),fs=require('node:fs'),path=require('node:path');
function createServer({base=process.env.DATA_BASE||'https://mantledb.sh/v2',namespace=process.env.DATA_NAMESPACE||'dy-vocab-9f31d7c0-5a4d-4de8-b5a6-c3a9c8e2f641'}={}){


return http.createServer(async(req,res)=>{res.setHeader('Cache-Control','no-store');res.setHeader('X-Content-Type-Options','nosniff');res.setHeader('Referrer-Policy','no-referrer');res.setHeader('Content-Security-Policy',"default-src 'self'; script-src 'self'; style-src 'self'; connect-src 'self'; frame-ancestors 'none'; base-uri 'none'; form-action 'self'");
const send=(status,data)=>{res.writeHead(status,{'Content-Type':'application/json; charset=utf-8'});res.end(JSON.stringify(data));};const url=new URL(req.url,'http://localhost');
if(url.pathname==='/health'){send(200,{ok:true});return;}
if(req.method!=='GET'){send(405,{error:'조회만 가능합니다.'});return;}
if(url.pathname.startsWith('/api/')){if(url.pathname!=='/api/learning'||req.method!=='GET'){send(404,{error:'없는 기능입니다.'});return;}
try{const children=await Promise.all(['dennis','yura'].map(async user=>{const r=await fetch(base+'/'+namespace+'/'+user,{signal:AbortSignal.timeout(12000)});if(!r.ok)throw Error('Data unavailable');const d=await r.json();return {user,xp:d.xp||0,words:d.words||[],answers:d.learningHistory||Object.values(d.answers||{}),detailedSince:d.learningHistorySince||null,lastQuizAt:d.lastQuizAt||null};}));send(200,{children,updatedAt:new Date().toISOString()});}catch{send(502,{error:'학습 기록을 불러오지 못했습니다. 새로고침해 주세요.'});}return;}
const files={'/':'index.html','/index.html':'index.html','/admin.js':'admin.js','/admin.css':'admin.css','/stats.js':'stats.js'};if(req.method!=='GET'||!files[url.pathname]){send(404,{error:'페이지가 없습니다.'});return;}res.writeHead(200,{'Content-Type':url.pathname.endsWith('.js')?'text/javascript; charset=utf-8':url.pathname.endsWith('.css')?'text/css; charset=utf-8':'text/html; charset=utf-8'});res.end(fs.readFileSync(path.join(__dirname,'public',files[url.pathname])));
});}
if(require.main===module)createServer().listen(process.env.PORT||3000,'0.0.0.0',()=>console.log('Vocabulary admin ready'));
module.exports={createServer};
