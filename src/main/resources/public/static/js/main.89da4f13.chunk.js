(this["webpackJsonpwu-work"]=this["webpackJsonpwu-work"]||[]).push([[6],{110:function(e,t,n){"use strict";n.r(t);n(80);var a=n(49),r=n(0),c=n.n(r),s=n(18),o=n.n(s);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var i=n(55),u=n(45),p=n(13),l=n(14),f=n.n(l),d=n(16),h=n(27),b=n(12),m=n(56),O=n(15),w=[];function v(e){w.push(e)}function E(){var e=this,t=Object(m.a)(),n=function(e){var t={},n=[],a=[];return e.forEach((function(e){a.push([e.subscriptions,e.namespace]),t[e.namespace]=function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:e.state,n=arguments.length>1?arguments[1]:void 0;if(!n.type.includes("@@")){var a=n.type.split("/"),r=Object(h.a)(a,2),c=r[0],s=r[1];return e.reduces[s]&&c===e.namespace?e.reduces[s](t,n):t}return t};var r=f.a.mark((function t(n){return f.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,Object(O.d)(Object(d.a)({},n,{type:"".concat(e.namespace,"/").concat(n.type)}));case 2:case"end":return t.stop()}}),t)}));n.push(f.a.mark((function t(){var n,a,c,s,o;return f.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=3,Object(O.f)((function(t){return t.type.startsWith(e.namespace)}));case 3:if(n=t.sent,a=n.type.split("/"),c=Object(h.a)(a,2),s=c[0],o=c[1],s===e.namespace){t.next=7;break}return t.abrupt("continue",0);case 7:if(!e.effects[o]){t.next=10;break}return t.next=10,Object(O.a)(e.effects[o],n,{call:O.a,put:r,select:O.e,fork:O.c,delay:O.b});case 10:t.next=0;break;case 12:case"end":return t.stop()}}),t)})))})),{reducers:t,tasks:n,subscriptions:a}}(w),a=n.reducers,r=n.tasks,c=n.subscriptions;return this.store=Object(b.e)(Object(b.c)(a),Object(b.d)(Object(b.a)(t),window.__REDUX_DEVTOOLS_EXTENSION__?window.__REDUX_DEVTOOLS_EXTENSION__():function(e){return e})),r.forEach((function(e){return t.run(e)})),this.dispatch=this.store.dispatch,c.forEach((function(t){var n=t[1],a=function(t){e.store.dispatch(Object(d.a)({},t,{type:"".concat(n,"/").concat(t.type)}))};Object.keys(t[0]).forEach((function(e){t[0][e]({dispatch:a})}))})),this.store}var y={namespace:"global",state:{count:0},reduces:{add:function(e,t){return Object(d.a)({},e,{count:e.count+1})},sub:function(e,t){return Object(d.a)({},e,{count:e.count-1})}},effects:{addEffect:f.a.mark((function e(t,n){var a,r;return f.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return n.call,a=n.put,r=n.delay,e.next=3,r(1e3);case 3:return e.next=5,a({type:"add"});case 5:case"end":return e.stop()}}),e)}))},subscriptions:{init:function(e){(0,e.dispatch)({type:"add"})}}},j=(n(81),{model:v,start:E,store:null,dispatch:null});j.model(y),j.start();var k=Object(r.lazy)((function(){return Promise.all([n.e(3),n.e(11),n.e(14)]).then(n.bind(null,397))})),x=Object(r.lazy)((function(){return Promise.all([n.e(0),n.e(1),n.e(2),n.e(3),n.e(9)]).then(n.bind(null,398))}));o.a.render(c.a.createElement(i.a,{store:j.store},c.a.createElement(u.a,null,c.a.createElement(r.Suspense,{fallback:c.a.createElement(a.a,{style:{marginTop:"30%",marginLeft:"50%",transform:"translate(-50%, -50%)"},spinning:!0})},c.a.createElement(p.c,null,c.a.createElement(p.a,{path:"/login",component:x}),c.a.createElement(p.a,{path:"/",component:k}))))),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))},81:function(e,t,n){},85:function(e,t,n){e.exports=n(110)}},[[85,7,8]]]);
//# sourceMappingURL=main.89da4f13.chunk.js.map