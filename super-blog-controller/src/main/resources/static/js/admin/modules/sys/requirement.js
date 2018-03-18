$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/requirement/query',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '标题', name: 'title', width: 75 },
			{ label: '内容', name: 'content', width: 90 },
			{ label: '总结', name: 'summary', width: 100 },
			{ label: '状态', name: 'status', width: 60, formatter: function(value, options, row){

			    if (value === 0){
			        return'<span class="label label-info">新建</span>'
                }else if (value === 1) {
                    return'<span class="label label-warning">开发中...</span>'
                }else if (value === 2) {
                    return'<span class="label label-success">开发完成</span>'
                }else{
                    return'<span class="label label-danger">放弃</span>'
                }


				return value === 1 ?
					'<span class="label label-danger">禁用</span>' : 
					'<span class="label label-success">正常</span>';
			}},
			{ label: '创建时间', name: 'gmtCreated', index: "gmtCreated", width: 85},
            { label: '最后修改时间', name: 'gmtModified', index: "gmtModified", width: 85}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
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
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            title: null
        },
        showList: true,
        title:null,
        roleList:{},
        requirement:{
            status:1,
            roleIdList:[]
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.roleList = {};
            vm.requirement = {status:1, roleIdList:[]};
        },
        update: function () {
            var requirementId = getSelectedRow();
            if(requirementId == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getRequirement(requirementId);
        },
        del: function () {
            var requirementIds = getSelectedRows();
            if(requirementIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "/requirement/delete",
                    contentType: "application/json",
                    data: JSON.stringify(requirementIds),
                    success: function(r){
                        if(r.success){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.errorMsg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            var url = vm.requirement.id == null ? "requirement/save" : "requirement/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.requirement),
                success: function(r){
                    if(r.success){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.errorMsg);
                    }
                }
            });
        },
        getRequirement: function(userId){
            $.get("/requirement/queryById?id="+userId, function(r){
                vm.requirement = r.data;
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'title': vm.q.title},
                page:page
            }).trigger("reloadGrid");
        }
    }
});