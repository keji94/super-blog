var setting = {
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
    }
};
var ztree;

var vm = new Vue({
    el:'#app',
    data:{
        showList: true,
        title: null,
        category:{
            parentName:null,
            parentId:0,
            type:1
        }
    },
    methods: {
        getCategory: function(){
            //加载菜单树
            $.get(baseURL + "category/categoryTree", function(r){
                ztree = $.fn.zTree.init($("#categoryTree"), setting, r);
                var node = ztree.getNodeByParam("categoryId", vm.category.parentId);
                ztree.selectNode(node);
                vm.category.parentName = node.name;
            })
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.category = {parentName:null,parentId:0,type:1};
            vm.getCategory();
        },
        update: function () {
            var id = getCategoryId();
            if(id == null){
                return ;
            }

            $.get(baseURL + "category/queryById?id="+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.category = r.data;

                vm.getCategory();
            });
        },
        del: function () {
            var id = getCategoryId();
            if(id == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "category/delete",
                    data: "id=" + id,
                    success: function(r){
                        if(r.success){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }

            var url = vm.category.id == null ? "category/save" : "category/update";
            $.ajax({
                type: "POST",
                url:  baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.category),
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
        categoryTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择菜单",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#categoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.category.parentId = node[0].id;
                    vm.category.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            Category.table.refresh();
        },
        validator: function () {
            if(isBlank(vm.category.name)){
                alert("菜单名称不能为空");
                return true;
            }
        }
    }
});


var Category = {
    id: "categoryTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Category.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'ID', field: 'id', visible: false, align: 'center', valign: 'middle', width: '80px'},
        {title: '资源名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '上级资源', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {
            title: '类型',
            field: 'type',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '100px',
            formatter: function (item, index) {
                if (item.type === 0) {
                    return '<span class="label label-primary">目录</span>';
                }
                if (item.type === 1) {
                    return '<span class="label label-success">菜单</span>';
                }
                if (item.type === 2) {
                    return '<span class="label label-warning">按钮</span>';
                }
            }
        }];
    return columns;
};


function getCategoryId () {
    var selected = $('#categoryTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}


$(function () {
    var colunms = Category.initColumn();
    var table = new TreeTable(Category.id, baseURL + "category/list", colunms);
    table.setExpandColumn(2);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("parentId");
    table.setExpandAll(true);
    table.init();
    Category.table = table;
});
