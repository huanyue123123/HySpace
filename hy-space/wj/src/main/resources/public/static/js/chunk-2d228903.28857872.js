(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d228903"],{da5e:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("el-button",{staticStyle:{"margin-bottom":"10px"},attrs:{type:"primary",size:"mini",icon:"el-icon-plus"},on:{click:t.onAdd}},[t._v("新增模板")]),t._v(" "),n("el-table",{attrs:{data:t.tableData,border:"","highlight-current-row":""}},[n("el-table-column",{attrs:{prop:"name",label:"模板名称",width:"200"}}),t._v(" "),n("el-table-column",{attrs:{prop:"fileName",label:"文件名称"}}),t._v(" "),n("el-table-column",{attrs:{label:"操作",width:"150"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(n){return t.onTableUpdate(e.row)}}},[t._v("修改")]),t._v(" "),n("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(n){return t.onTableDelete(e.row)}}},[t._v("删除")])]}}])})],1)],1)},o=[],l=(n("7f7f"),{data:function(){return{tableData:[]}},created:function(){this.loadTable()},methods:{loadTable:function(){this.post("/template/list",{},(function(t){this.tableData=t.data}))},onTableUpdate:function(t){this.goRoute("edit/".concat(t.id))},onTableDelete:function(t){this.confirm("确认要删除【".concat(t.name,"】吗？"),(function(e){this.post("/template/del",t,(function(){e(),this.tip("删除成功"),this.loadTable()}))}))},onAdd:function(){this.goRoute("edit/0")}}}),i=l,c=n("2877"),r=Object(c["a"])(i,a,o,!1,null,null,null);e["default"]=r.exports}}]);