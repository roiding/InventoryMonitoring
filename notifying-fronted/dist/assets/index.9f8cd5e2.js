var I=Object.defineProperty,D=Object.defineProperties;var k=Object.getOwnPropertyDescriptors;var E=Object.getOwnPropertySymbols;var T=Object.prototype.hasOwnProperty,S=Object.prototype.propertyIsEnumerable;var v=(e,u,r)=>u in e?I(e,u,{enumerable:!0,configurable:!0,writable:!0,value:r}):e[u]=r,_=(e,u)=>{for(var r in u||(u={}))T.call(u,r)&&v(e,r,u[r]);if(E)for(var r of E(u))S.call(u,r)&&v(e,r,u[r]);return e},A=(e,u)=>D(e,k(u));import{a as w,E as c,d as y,r as N,b as R,t as P,o as m,c as b,w as s,e as U,f as d,g as p,h as B,F,i as q,j as O,k as j,l as z,m as $,n as M,p as W,q as Z,s as H,z as K}from"./vendor.a7b4952b.js";const G=function(){const u=document.createElement("link").relList;if(u&&u.supports&&u.supports("modulepreload"))return;for(const l of document.querySelectorAll('link[rel="modulepreload"]'))i(l);new MutationObserver(l=>{for(const t of l)if(t.type==="childList")for(const o of t.addedNodes)o.tagName==="LINK"&&o.rel==="modulepreload"&&i(o)}).observe(document,{childList:!0,subtree:!0});function r(l){const t={};return l.integrity&&(t.integrity=l.integrity),l.referrerpolicy&&(t.referrerPolicy=l.referrerpolicy),l.crossorigin==="use-credentials"?t.credentials="include":l.crossorigin==="anonymous"?t.credentials="omit":t.credentials="same-origin",t}function i(l){if(l.ep)return;l.ep=!0;const t=r(l);fetch(l.href,t)}};G();const C=w.create({baseURL:"http://oracle-cloud2.ran-ding.ga/api",timeout:5e4});debugger;C.interceptors.response.use(e=>{if(e.status===200){if(e.data.state==null)return Promise.resolve(e);if(e.data.state=="200")return Promise.resolve(e);if(e.data.state!="993")return c.error(e.data.error),Promise.reject(e);c.error(e.data.error)}else return c.error("\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458,\u9519\u8BEF\u539F\u56E0"+e),Promise.reject(e)},e=>(e.response?c.error({message:"\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458,\u9519\u8BEF\u539F\u56E0<br/>"+e,dangerouslyUseHTMLString:!0}):c.error("\u65E0\u7F51\u7EDC\u6216\u540E\u53F0\u6B63\u5728\u66F4\u65B0\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01"),Promise.reject(e)));const J=(e,u,r,i)=>C.post("/subscribe/addNewNotify",{subscribeType:e,address:u,platform:r,itemId:i});var Q=(e,u)=>{const r=e.__vccOpts||e;for(const[i,l]of u)r[i]=l;return r};const X=y({name:"Welcome",setup(e,u){const r=N(null),l=R({form:{subscribeType:"",address:"",platform:"",itemId:void 0},subscribeTypeList:[{label:"\u90AE\u7BB1",value:"email",disabled:!1},{label:"Server\u9171",value:"ServerChan",disabled:!0},{label:"\u66F4\u591A\u9010\u6E10\u5B8C\u5584",value:"more",disabled:!0}],platformList:[{label:"\u4F0A\u5229\u7231\u513F",value:"yili-babycare",disabled:!1},{label:"\u6DD8\u5B9D",value:"taobao",disabled:!0},{label:"\u66F4\u591A\u9010\u6E10\u5B8C\u5584",value:"more",disabled:!0}],itemIdList:[{label:"\u4F0A\u5229-\u51B0\u58A9\u58A9\u94A5\u5319\u6263(49\u5143)",value:1,disabled:!1},{label:"\u4F0A\u5229-\u51B0\u58A9\u58A9\u62B1\u6795(68\u5143)",value:2,disabled:!1},{label:"\u66F4\u591A\u9010\u6E10\u5B8C\u5584",value:0,disabled:!0}],commitRules:{subscribeType:[{required:!0,message:"\u8BF7\u9009\u62E9\u8BA2\u9605\u7C7B\u578B",trigger:"change"}],address:[{required:!0,message:"\u5730\u5740\u4E0D\u80FD\u4E3A\u7A7A",trigger:"change"},{validator:(o,f,n)=>{/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(f)?n():n(new Error("\u8BF7\u8F93\u5165\u6B63\u786E\u7684\u90AE\u7BB1\u683C\u5F0F"))},trigger:"change"}],platform:[{required:!0,message:"\u8BF7\u9009\u62E9\u8BA2\u9605\u5E73\u53F0",trigger:"change"}],itemId:[{required:!0,message:"\u8BF7\u9009\u62E9\u8BA2\u9605\u5546\u54C1",trigger:"blur"}]}}),t=()=>{r.value.validate().then(()=>{J(l.form.subscribeType,l.form.address,l.form.platform,l.form.itemId).then(o=>{c.success(o.data.data)})}).catch(o=>{c.error("\u8BF7\u68C0\u67E5\u8868\u5355\u8F93\u5165")})};return A(_({submitForm:r},P(l)),{onSubmit:t})}}),Y=q("\u63D0\u4EA4");function x(e,u,r,i,l,t){const o=W,f=O,n=j,g=z,h=$,L=M,V=U;return m(),b(V,{gutter:12,justify:"center"},{default:s(()=>[d(L,{model:e.form,"label-width":"120px","status-icon":"",rules:e.commitRules,ref:"submitForm"},{default:s(()=>[d(n,{label:"\u8BA2\u9605\u7C7B\u578B",prop:"subscribeType"},{default:s(()=>[d(f,{modelValue:e.form.subscribeType,"onUpdate:modelValue":u[0]||(u[0]=a=>e.form.subscribeType=a)},{default:s(()=>[(m(!0),p(F,null,B(e.subscribeTypeList,a=>(m(),b(o,{key:a.value,label:a.label,value:a.value,disabled:a.disabled},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),d(n,{label:"\u5730\u5740",prop:"address"},{default:s(()=>[d(g,{modelValue:e.form.address,"onUpdate:modelValue":u[1]||(u[1]=a=>e.form.address=a)},null,8,["modelValue"])]),_:1}),d(n,{label:"\u8BA2\u9605\u5E73\u53F0",prop:"platform"},{default:s(()=>[d(f,{modelValue:e.form.platform,"onUpdate:modelValue":u[2]||(u[2]=a=>e.form.platform=a)},{default:s(()=>[(m(!0),p(F,null,B(e.platformList,a=>(m(),b(o,{key:a.value,label:a.label,value:a.value,disabled:a.disabled},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),d(n,{label:"\u8BA2\u9605\u5546\u54C1",prop:"itemId"},{default:s(()=>[d(f,{modelValue:e.form.itemId,"onUpdate:modelValue":u[3]||(u[3]=a=>e.form.itemId=a)},{default:s(()=>[(m(!0),p(F,null,B(e.itemIdList,a=>(m(),b(o,{key:a.value,label:a.label,value:a.value,disabled:a.disabled},null,8,["label","value","disabled"]))),128))]),_:1},8,["modelValue"])]),_:1}),d(n,null,{default:s(()=>[d(h,{type:"primary",onClick:e.onSubmit},{default:s(()=>[Y]),_:1},8,["onClick"])]),_:1})]),_:1},8,["model","rules"])]),_:1})}var ee=Q(X,[["render",x]]);const ue=y({setup(e){return(u,r)=>(m(),b(ee))}});Z(ue).use(H,{locale:K}).mount("#app");
