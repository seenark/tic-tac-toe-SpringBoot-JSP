(function(t){function n(n){for(var i,o,a=n[0],u=n[1],c=n[2],f=0,h=[];f<a.length;f++)o=a[f],Object.prototype.hasOwnProperty.call(s,o)&&s[o]&&h.push(s[o][0]),s[o]=0;for(i in u)Object.prototype.hasOwnProperty.call(u,i)&&(t[i]=u[i]);l&&l(n);while(h.length)h.shift()();return r.push.apply(r,c||[]),e()}function e(){for(var t,n=0;n<r.length;n++){for(var e=r[n],i=!0,a=1;a<e.length;a++){var u=e[a];0!==s[u]&&(i=!1)}i&&(r.splice(n--,1),t=o(o.s=e[0]))}return t}var i={},s={app:0},r=[];function o(n){if(i[n])return i[n].exports;var e=i[n]={i:n,l:!1,exports:{}};return t[n].call(e.exports,e,e.exports,o),e.l=!0,e.exports}o.m=t,o.c=i,o.d=function(t,n,e){o.o(t,n)||Object.defineProperty(t,n,{enumerable:!0,get:e})},o.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},o.t=function(t,n){if(1&n&&(t=o(t)),8&n)return t;if(4&n&&"object"===typeof t&&t&&t.__esModule)return t;var e=Object.create(null);if(o.r(e),Object.defineProperty(e,"default",{enumerable:!0,value:t}),2&n&&"string"!=typeof t)for(var i in t)o.d(e,i,function(n){return t[n]}.bind(null,i));return e},o.n=function(t){var n=t&&t.__esModule?function(){return t["default"]}:function(){return t};return o.d(n,"a",n),n},o.o=function(t,n){return Object.prototype.hasOwnProperty.call(t,n)},o.p="/vue/";var a=window["webpackJsonp"]=window["webpackJsonp"]||[],u=a.push.bind(a);a.push=n,a=a.slice();for(var c=0;c<a.length;c++)n(a[c]);var l=u;r.push([0,"chunk-vendors"]),e()})({0:function(t,n,e){t.exports=e("56d7")},"034f":function(t,n,e){"use strict";var i=e("85ec"),s=e.n(i);s.a},"56d7":function(t,n,e){"use strict";e.r(n);e("e260"),e("e6cf"),e("cca6"),e("a79d");var i=e("2b0e"),s=function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",{attrs:{id:"app"}},[e("h1",[t._v("Tic-Tac-Toe: HadesGod")]),e("Game")],1)},r=[],o=function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",[e("b-container",[e("b-row",{staticClass:"m-3",attrs:{"align-h":"center"}},[e("b-form",[e("b-input-group",{staticClass:"mt-1",attrs:{prepend:"Set Table Dimensions"}},[e("b-form-input",{attrs:{type:"number",step:"1"},model:{value:t.dimension,callback:function(n){t.dimension=n},expression:"dimension"}}),e("b-input-group-append",[e("b-button",{attrs:{variant:"info"},on:{click:t.dimensionSet}},[t._v("SET")]),e("b-button",{attrs:{variant:"danger"},on:{click:t.reValues}},[t._v("RESET")])],1)],1)],1)],1),e("b-row",{staticClass:"mt-0",attrs:{"align-h":"center"}},[e("div",{staticClass:"game-table",style:t.cssVarGameTable},t._l(t.values,(function(n,i){return e("b-row",{key:i},t._l(n,(function(n,s){return e("b-button",{key:s,staticClass:"game-btn",attrs:{squared:""},on:{click:function(n){return t.btnClick(i,s)}}},[t._v(t._s(n))])})),1)})),1)])],1)],1)},a=[],u=(e("d3b7"),e("ddb0"),{data:function(){return{values:[],dimension:3,xTurn:!0,xRow:0,xCol:0,xCrossL:0,xCrossR:0,oRow:0,oCol:0,oCrossL:0,oCrossR:0,xWin:!1,oWin:!1}},mounted:function(){0==this.values.length&&this.reValues()},methods:{reValues:function(){this.xTurn=!0,this.xWin=!1,this.oWin=!1,this.xRow=0,this.xCol=0,this.oRow=0,this.oCol=0,this.values=new Array(this.dimension);for(var t=0;t<this.dimension;t++){this.values[t]=new Array(this.dimension);for(var n=0;n<this.dimension;n++)this.values[t][n]=""}},btnClick:function(t,n){if(""==this.values[t][n]){if(1==this.xTurn){var e=this.values[t];e[n]="X",this.$set(this.values,t,e)}else{var i=this.values[t];i[n]="O",this.$set(this.values,t,i)}this.whoWinAfterClick(t,n,this.xTurn?"X":"O"),this.xTurn=!this.xTurn}},dimensionSet:function(){this.values.length!=this.dimension&&""!=this.dimension&&this.reValues()},printTable:function(){for(var t=0;t<this.values.length;t++)for(var n=0;n<this.values[t].length;n++)console.log("i",t,"j",n,": ",this.values[t][n])},whoWinAfterClick:function(t,n,e){this.checkRow(t,n,e),this.checkColumn(t,n,e),this.checkCrossL(t,n,e),this.checkCrossR(e),this.checkDraw()},checkRow:function(t,n,e){for(var i=0,s=0;s<this.dimension;s++){var r=this.values[t][s];if(""==r)return;r==e&&(i+=1,i==this.dimension&&setTimeout((function(){alert(e+" Win")}),100))}},checkColumn:function(t,n,e){for(var i=0,s=0;s<this.dimension;s++){var r=this.values[s][n];if(""==r)return;r==e&&(i+=1,i==this.dimension&&setTimeout((function(){alert(e+" Win")}),100))}},checkCrossL:function(t,n,e){var i=0;if(t==n)for(var s=0;s<this.dimension;s++){var r=this.values[s][s];if(r!=e)return;i+=1,i==this.dimension&&setTimeout((function(){alert(e+" Win")}),100)}},checkCrossR:function(t){for(var n=0,e=0;e<this.dimension;e++){var i=this.dimension-(e+1),s=this.values[e][i];if(s!=t)return;n+=1,n==this.dimension&&setTimeout((function(){alert(t+" Win")}),100)}},checkDraw:function(){for(var t=0,n=0;n<this.dimension;n++)for(var e=0;e<this.dimension;e++){if(""==this.values[n][e])return;t++,t==this.dimension*this.dimension&&setTimeout((function(){alert("Draw")}),100)}}},computed:{cssVarGameTable:function(){return""!=this.dimension?this.dimension:0}}}),c=u,l=(e("c342"),e("2877")),f=Object(l["a"])(c,o,a,!1,null,"db29c576",null),h=f.exports,d={name:"App",components:{Game:h}},v=d,m=(e("034f"),Object(l["a"])(v,s,r,!1,null,null,null)),p=m.exports,b=e("5f5b"),w=e("b1e0");e("f9e3"),e("2dd8");i["default"].use(b["a"]),i["default"].use(w["a"]),i["default"].config.productionTip=!1,new i["default"]({render:function(t){return t(p)}}).$mount("#app")},7899:function(t,n,e){},"85ec":function(t,n,e){},c342:function(t,n,e){"use strict";var i=e("7899"),s=e.n(i);s.a}});
//# sourceMappingURL=app.9cc54970.js.map