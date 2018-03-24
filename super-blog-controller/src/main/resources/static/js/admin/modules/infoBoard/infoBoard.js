//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

var layer, form;

$(function () {
    $("#jqGrid").jqGrid({
        url: '/infoBoard/list',
        datatype: "json",
        colModel: [
            {label: '标题', name: 'title', classes: "title", width: 75},
            {label: 'id', name: 'id', classes: "id", hidden: true, width: 100},
            {
                label: '内容', name: 'content', classes: "content", width: 90, formatter: function (value) {
                    return '<pre  class="layui-code">' + value + '</pre>';
                }
            },
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
        area: '500px',
        title: '新增导航', //不显示标题
        content: $('#add'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        btn: ['确定', '取消'],
        yes: function (index, layero) {
            var title = $("#title").val();
            var content = $("#content").val();

            if ('' === title) {
                layer.msg("标题不能为空");
                return;
            }
            if ('' === content) {
                layer.msg("内容不能为空");
                return;
            }

            layer.close(index);
            $.ajax({
                type: "POST",
                url: "/infoBoard/add",
                dataType: "json",
                data: {
                    "title": title,
                    "content": content
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

            $("#title").val('');
            $("#content").val('');

        },
        btn2: function (index) {
            layer.close(index);
        }
    });
}

function alertUpdateWindow(e) {
    var tr = $(e).closest("tr");
    var id = tr.find(".id").html();
    var title = tr.find(".title").html();
    var content = tr.find(".content").html();

    $("#updateId").val(id);
    $("#updateTitle").val(title);
    $("#updateContent").val(content);

    //捕获页
    layer.open({
        type: 1,
        shade: false,
        area: ['500px','500px'],
        title: '更新信息板', //不显示标题
        content: $('#update'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        btn: ['确定', '取消'],
        yes: function (index, layero) {
            var title = $("#updateTitle").val();
            var content = $("#updateContent").val();
            var id = $("#updateId").val();

            if ('' === title) {
                layer.msg("标题不能为空");
                return;
            }
            if ('' === content) {
                layer.msg("content不能为空");
                return;
            }

            layer.close(index);
            $.ajax({
                type: "POST",
                url: "/infoBoard/update",
                dataType: "json",
                data: {
                    "title": title,
                    "content": content,
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
            url: "/infoBoard/delete",
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
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        postData: {},
        page: page
    }).trigger("reloadGrid");
}
