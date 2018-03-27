//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

var layer, form;

layui.use(["layer", "form"], function () {
    layer = layui.layer;
    form = layui.form;
});

$(function () {
    $("#jqGrid").jqGrid({
        url: '/adminArticle/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', hidden: true, classes: "id", width: 100},
            {label: '文章标题', name: 'title', classes: "title", width: 75},
            {label: '文章分类', name: 'category', classes: "category", width: 75},
            {label: '发布时间', name: 'gmtCreate', classes: "gmtCreate", width: 75},
            {label: '浏览数', name: 'pageviews', classes: "pageviews", width: 75},
            {
                label: '评论', width: 60, formatter: function () {
                return '<form class="layui-form"><input type="checkbox" name="commentable" value="1" id="commentable" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF"></form>'
            }
            },
            {
                label: '置顶', width: 60, formatter: function () {
                return '<input type="checkbox" name="top" value="1" id="top" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">'
            }
            },
            {
                label: '操作', width: 60, formatter: function () {
                return '<a class="btn btn-success" onclick="alertUpdateWindow(this)"> 编辑</a>'
            }
            }
        ],
        viewrecords: true,
        height: "100%",
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
    var title = $("#title").val();
    reload(title)
}

function reload(title) {
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        postData: {"title": title},
        page: page
    }).trigger("reloadGrid");
}
