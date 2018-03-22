$(function () {
    $("#jqGrid").jqGrid({
        url: '/adminNav/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: "id", width: 45, key: true },
            { label: '名称', name: 'name', width: 75 },
            { label: 'icon', name: 'email', width: 90 },
            { label: 'url', name: 'phone', width: 100 },
            { label: '状态', name: 'status', width: 60, formatter: function(value){
                return value === 1 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }},
            { label: '创建时间', name: 'gmtCreated', index: "gmtCreated", width: 85}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 20,
        rowList : [20,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "data",
            page: "pageIndex",
            total: "totalPage",
            records: "totalCount"
        },
        prmNames : {
            page:"pageIndex",
            rows:"pageSize",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});