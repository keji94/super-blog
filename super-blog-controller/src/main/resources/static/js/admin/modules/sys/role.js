$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'role/queryByPage',
        datatype: "json",
        colModel: [
            { label: '角色ID', name: 'id', index: "id", width: 45, key: true },
            { label: '角色名称', name: 'roleName', index: "role_name", width: 75 },
            { label: '角色编码', name: 'roleCode', index: "role_code", width: 75 },
            { label: '状态', name: 'status', width: 60, formatter: function(value, options, row){
                return value === 1 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }}
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

//菜单树
var menu_ztree;
var menu_setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    },
    check:{
        enable:true,
        nocheckInherit:true
    }
};

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title:null,
        role:{}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.role = {};
            vm.getMenuTree(null);
        },
        update: function () {
            var roleId = getSelectedRow();
            if(roleId == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";
            vm.getMenuTree(roleId);
        },
        del: function () {
            var roleIds = getSelectedRows();
            if(roleIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "role/delete",
                    contentType: "application/json",
                    data: JSON.stringify(roleIds),
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
        getRole: function(roleId){
            $.get(baseURL + "role/info?id="+roleId, function(r){
                vm.role = r.data;

                //勾选角色所拥有的菜单
                var menuIds = vm.role.resourceIdS;
                for(var i=0; i<menuIds.length; i++) {
                    var node = menu_ztree.getNodeByParam("id", menuIds[i]);
                    menu_ztree.checkNode(node, true, false);
                }

            });
        },
        saveOrUpdate: function () {
            //获取选择的菜单
            var nodes = menu_ztree.getCheckedNodes(true);
            var menuIdList = new Array();
            for(var i=0; i<nodes.length; i++) {
                menuIdList.push(nodes[i].id);
            }
            vm.role.resourceIdS = menuIdList;
            alert(vm.role.id);
            var url = vm.role.id == null ? "role/save" : "role/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.role),
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
        getMenuTree: function(roleId) {
            //加载菜单树
            $.get(baseURL + "resource/query", function(r){
                menu_ztree = $.fn.zTree.init($("#menuTree"), menu_setting, r);
                //展开所有节点
                menu_ztree.expandAll(true);

                if(roleId != null){
                    vm.getRole(roleId);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'roleName': vm.q.roleName},
                page:page
            }).trigger("reloadGrid");
        }
    }
});