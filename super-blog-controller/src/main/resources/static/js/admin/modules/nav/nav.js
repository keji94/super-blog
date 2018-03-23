//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

var layer,form;

$(function () {
    $("#jqGrid").jqGrid({
        url: '/adminNav/list',
        datatype: "json",
        colModel: [
            { label: '名称', name: 'name',classes:"name", width: 75 },
            { label: 'icon', name: 'icon',classes:"icon", width: 90 },
            { label: 'url', name: 'url',classes:"url", width: 100 },
            { label: 'id', name: 'id',classes:"id",hidden:true, width: 100 },
            { label: '状态', name: 'status',classes:"status",hidden:true, width: 100 },
            { label: '状态', name: 'status', width: 60, formatter: function(value){
                return value === 0 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }},
            { label: '操作', width: 60, formatter: function(){
                return '<a class="btn btn-success" onclick="alertUpdateWindow(this)"> 修改</a>'
            }}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 20,
        rowList : [20,30,50],
        rownumbers: false,
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

layui.use(["layer","form"], function () {
    layer = layui.layer;
    form = layui.form;
});

function alertAddWindow() {
    //捕获页
    layer.open({
        type: 1,
        shade: false,
        area:'300px',
        title: '新增导航', //不显示标题
        content: $('#add'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        btn:['确定','取消'],
        yes:function (index,layero) {
            var name = $("#name").val();
            var icon = $("#icon").val();
            var url = $("#url").val();
            var id = $("#id").val();

            if ('' === name){
                layer.msg("名称不能为空");
                return;
            }
            if ('' === icon){
                layer.msg("icon不能为空");
                return;
            }
            if ('' === url){
                layer.msg("url不能为空");
                return;
            }

            layer.close(index);
            if ('' === id){
                $.ajax({
                    type: "POST",
                    url: "/adminNav/add",
                    dataType: "json",
                    data: {
                        "name": name,
                        "icon": icon,
                        "url": url
                    },
                    success: function (r) {
                        if (r.success) {
                            alertSuccess("新增成功");
                            reload();
                        } else {
                            alertFail("修改异常");
                        }
                    }
                });
            }else {
                $.ajax({
                    type: "POST",
                    url: "/adminNav/update",
                    dataType: "json",
                    data: {
                        "name": name,
                        "icon": icon,
                        "url": url,
                        "id":id
                    },
                    success: function (r) {
                        if (r.success) {
                            alertSuccess("修改成功");
                            reload();
                        } else {
                            alertFail("修改异常");
                        }
                    }
                });
            }
        },
        btn2:function (index) {
            layer.close(index);
        }
    });
}

function alertUpdateWindow(e) {
    var tr = $(e).closest("tr");
    var id = tr.find(".id").html();
    var name = tr.find(".name").html();
    var icon = tr.find(".icon").html();
    var url = tr.find(".url").html();
    var status = tr.find(".status").html();

    $("#updateId").val(id);
    $("#updateIcon").val(icon);
    $("#updateName").val(name);
    $("#updateUrl").val(url);

    if (1 === status){
        $("#normal").prop('checked', 'true');
        form.render();
    }else {
        $("#invalid").prop('checked', 'true');
        form.render();
    }

    //捕获页
    layer.open({
        type: 1,
        shade: false,
        area:'300px',
        title: '新增导航', //不显示标题
        content: $('#update'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        btn:['确定','取消'],
        yes:function (index,layero) {
            var name = $("#updateName").val();
            var icon = $("#updateIcon").val();
            var url = $("#updateUrl").val();
            var id = $("#updateId").val();
            debugger;
            var status = $("input[name='status']:checked").val();

            if ('' === name){
                layer.msg("名称不能为空");
                return;
            }
            if ('' === icon){
                layer.msg("icon不能为空");
                return;
            }
            if ('' === url){
                layer.msg("url不能为空");
                return;
            }

            layer.close(index);
            if ('' === id){
                $.ajax({
                    type: "POST",
                    url: "/adminNav/add",
                    dataType: "json",
                    data: {
                        "name": name,
                        "icon": icon,
                        "url": url
                    },
                    success: function (r) {
                        if (r.success) {
                            alertSuccess("新增成功");
                            reload();
                        } else {
                            alertFail("修改异常");
                        }
                    }
                });
            }else {
                $.ajax({
                    type: "POST",
                    url: "/adminNav/update",
                    dataType: "json",
                    data: {
                        "name": name,
                        "icon": icon,
                        "url": url,
                        "id":id,
                        "status":status
                    },
                    success: function (r) {
                        if (r.success) {
                            alertSuccess("修改成功");
                            reload();
                        } else {
                            alertFail("修改异常");
                        }
                    }
                });
            }
        },
        btn2:function (index) {
            layer.close(index);
        }
    });
}

function del() {
    var ids = getSelectedRows();
    if (null == ids){
        return;
    }

    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消'] //按钮
    }, function (index) {
        $.ajax({
            type: "POST",
            url: "/adminNav/delete",
            contentType: "application/json",
            data: JSON.stringify(ids),
            success: function (r) {
                if (r.success) {
                    layer.close(index);
                    alertSuccess("删除成功");
                    reload();
                } else {
                    layer.close(index);
                    alertSuccess(r.msg);
                }
            }
        });
    }, function (index) {
        layer.close(index);
    });

}

function reload() {
    var page = $("#jqGrid").jqGrid('getGridParam','page');
    $("#jqGrid").jqGrid('setGridParam', {
        postData: {},
        page: page
    }).trigger("reloadGrid");
}
