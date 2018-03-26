//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

var layer, form;

$(function () {
    $("#jqGrid").jqGrid({
        url: '/adminTag/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', classes: "id", width: 100},
            {label: '名称', name: 'name', classes: "name", width: 75},
            {
                label: '操作', width: 60, formatter: function () {
                return '<a class="btn btn-success" onclick="alertUpdateWindow(this)"> 修改</a>'
            }
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 20,
        rowList: [20, 30, 50],
        rownumbers: false,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data",
            page: "pageIndex",
            total: "totalPage",
            records: "totalCount"
        },
        prmNames: {
            page: "pageIndex",
            rows: "pageSize",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

layui.use(["layer", "form"], function () {
    layer = layui.layer;
    form = layui.form;
});

function alertAddWindow() {
    //捕获页
    layer.open({
        type: 1,
        shade: false,
        area: '300px',
        title: '新增标签', //不显示标题
        content: $('#add'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        btn: ['确定', '取消'],
        yes: function (index, layero) {
            var name = $("#name").val();

            if ('' === name) {
                layer.msg("名称不能为空");
                return;
            }
            layer.close(index);
            $.ajax({
                type: "POST",
                url: "/adminTag/add",
                dataType: "json",
                data: {
                    "name": name
                },
                success: function (r) {
                    if (r.success) {
                        alertSuccess("新增成功");
                        reload();
                    } else {
                        alertFail("新增成功");
                    }
                }
            });

            $("#name").val('');

        },
        btn2: function (index) {
            layer.close(index);
        }
    });
}

function alertUpdateWindow(e) {
    var tr = $(e).closest("tr");
    var id = tr.find(".id").html();
    var name = tr.find(".name").html();

    $("#updateId").val(id);
    $("#updateName").val(name);

    //捕获页
    layer.open({
        type: 1,
        shade: false,
        area: '300px',
        title: '修改标签', //不显示标题
        content: $('#update'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        btn: ['确定', '取消'],
        yes: function (index, layero) {
            var name = $("#updateName").val();
            var id = $("#updateId").val();

            if ('' === name) {
                layer.msg("名称不能为空");
                return;
            }

            layer.close(index);
            $.ajax({
                type: "POST",
                url: "/adminTag/update",
                dataType: "json",
                data: {
                    "name": name,
                    "id": id
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

        },
        btn2: function (index) {
            layer.close(index);
        }
    });
}

function del() {
    var ids = getSelectedRows();
    if (null == ids) {
        return;
    }

    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消'] //按钮
    }, function (index) {
        $.ajax({
            type: "POST",
            url: "/adminTag/delete",
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

function queryByCondition() {
    var tagName = $("#tagName").val();
    reload(tagName)
}

function reload(tagName) {
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        postData: {"name":tagName},
        page: page
    }).trigger("reloadGrid");
}
