webpackJsonp([7],{bphS:function(t,e,l){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a={data:function(){return{labelPosition:"left",form:{id:null,context:"",tag:"",title:""},toolbars:{bold:!0,italic:!0,header:!0,underline:!0,mark:!0,superscript:!0,quote:!0,ol:!0,link:!0,imagelink:!0,help:!0,code:!0,subfield:!0,fullscreen:!0,readmodel:!0,undo:!0,trash:!0,save:!0,navigation:!0}}},created:function(){this.getParams()},components:{sunHeader:l("DqOJ").a},methods:{onSubmit:function(){this.$post("/api/article/articleEdit",this.form,!0).then(function(t){})},getParams:function(){var t=this,e=this.$route.params.id;null!=e&&this.$fetch("/api/article/articleInfo",{id:e},!1).then(function(e){console.log(e.data.articleInfo),null!=e.data&&(t.form=e.data.articleInfo)})}},watch:{$route:"getParams"}},o={render:function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("div",{staticClass:"index"},[l("sunHeader"),t._v(" "),l("el-main",[l("el-card",{staticClass:"box-card"},[l("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[l("span",[t._v("添加文章")])]),t._v(" "),l("el-radio-group",{attrs:{size:"small"},model:{value:t.labelPosition,callback:function(e){t.labelPosition=e},expression:"labelPosition"}},[l("el-radio-button",{attrs:{label:"left"}},[t._v("左对齐")]),t._v(" "),l("el-radio-button",{attrs:{label:"right"}},[t._v("右对齐")]),t._v(" "),l("el-radio-button",{attrs:{label:"top"}},[t._v("顶部对齐")])],1),t._v(" "),l("div",{staticStyle:{margin:"20px"}}),t._v(" "),l("el-form",{staticStyle:{border:"0"},attrs:{"label-position":t.labelPosition,"label-width":"80px",model:t.form}},[l("el-form-item",{attrs:{label:"文章标题"}},[l("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1),t._v(" "),l("el-form-item",{attrs:{label:"文章标签"}},[l("el-input",{model:{value:t.form.tag,callback:function(e){t.$set(t.form,"tag",e)},expression:"form.tag"}})],1),t._v(" "),l("el-form-item",{attrs:{label:"文章正文"}},[l("mavon-editor",{attrs:{toolbars:t.toolbars},on:{keydown:function(t){}},model:{value:t.form.context,callback:function(e){t.$set(t.form,"context",e)},expression:"form.context"}})],1),t._v(" "),l("el-form-item",[l("el-button",{attrs:{type:"primary"},on:{click:t.onSubmit}},[t._v("提交")])],1)],1)],1)],1)],1)},staticRenderFns:[]},i=l("C7Lr")(a,o,!1,null,null,null);e.default=i.exports}});
//# sourceMappingURL=7.a909b4debb82135cae2a.js.map