$(function(){
    //页面加载完成之后执行
    pageInit();
});
function pageInit(){
    //创建jqGrid组件
    $("#requirementList").jqGrid({
        url: '/requirement/query?pageIndex=1&pageSize=1',//组件创建完成之后请求数据的url
        datatype: "json",
        colModel: [
            { label: '需求ID', name: 'id', index: "id", width: 45, key: true,align : "center" },
            { label: '需求标题', name: 'title', width: 75 ,align : "center"},
            { label: '需求内容', name: 'content', width: 75 ,align : "center"},
            { label: '创建时间', name: 'gmtCreated', width: 90 ,align : "center"},
            { label: '状态', name: 'status',align : "center", width: 60, formatter: function(value, options, row){
                if(value === 0){
                    return  '<span class="label label-warning">新建</span>';
                }else if (value === 1){
                    return '<span class="label label-primary">开发中</span>';
                }else if (value === 2){
                    return '<span class="label label-success">正常</span>';
                }else if (value === 3){
                    return '<span class="label label-danger">危险</span>';
                }
            }},
            { label: '完成时间', name: 'gmtModified', index: "gmt_modified", width: 85,align : "center"},
            { label: '总结', name: 'summary', index: "summary", width: 85,align : "center"}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#pager",
        jsonReader : {
            root: "data",
            page: "currPage",
            total: "totalPage",
            records: "totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });



    jQuery("#requirementList").jqGrid(
        {
            url : '/requirement/query?pageIndex=1&pageSize=1',//组件创建完成之后请求数据的url
            datatype : "json",//请求数据返回的类型。可选json,xml,txt
            colNames : [ '需求ID', '需求标题', '需求内容', '创建时间', '状态','完成时间', '总结' ],//jqGrid的列显示名字
            colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
                {name : 'data.id',index : 'id',width : 55},
                {name : 'data.title',index : 'title',width : 90},
                {name : 'data.content',index : 'content',width : 100},
                {name : 'data.gmt_created',index : 'gmt_created',width : 80,align : "right"},
                {name : 'data.status',index : 'status',width : 80,align : "right",formatter: function(value, options, row){
                    if(value === 0){
                        return  '<span class="label label-warning">新建</span>';
                    }else if (value === 1){
                        return '<span class="label label-primary">开发中</span>';
                    }else if (value === 2){
                        return '<span class="label label-success">正常</span>';
                    }else if (value === 3){
                        return '<span class="label label-danger">危险</span>';
                    }
                }},
                {name : 'data.gmt_modified',index : 'total',width : 80,align : "right"},
                {name : 'data.summary',index : 'summary',width : 150,sortable : false}
            ],
            rowNum : 10,//一页显示多少条
            rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
            pager : '#pager',//表格页脚的占位符(一般是div)的id
            sortname : 'id',//初始化的时候排序的字段
            sortorder : "asc",//排序方式,可选desc,asc
            mtype : "post",//向后台请求数据的ajax的类型。可选post,get
            viewrecords : true,
            caption : "需求列表"//表格的标题名字
        });
    /*创建jqGrid的操作按钮容器*/
    /*可以控制界面上增删改查的按钮是否显示*/
    jQuery("#requirementList").jqGrid('navGrid', '#pager', {edit : false,add : false,del : false});
}