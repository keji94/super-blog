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
            {label: '文章分类', name: 'categoryName', classes: "categoryName", width: 75},
            {label: '发布时间', name: 'gmtCreated', width: 75},
            {label: '浏览数', name: 'pageviews', width: 75},
            {
                label: '评论功能', width: 60, name: "commentable", formatter: function (value) {
                    if (value === 1) {
                        return '<input type="checkbox" name="top" checked >'
                    } else {
                        return '<input type="checkbox" name="commentable">'
                    }
                }
            },
            {
                label: '置顶', width: 60, name: "top",formatter: function (value) {
                    if (value === 1) {
                        return '<input type="checkbox" name="top" checked  id="top">'
                    } else {
                        return '<input type="checkbox" name="top"  id="top">'
                    }
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


    $(function () {
        $('#tags').tagsInput({
            defaultText: "点我新增标签",
            width: "auto",
            minChars: 1,
            onChange: function (a) {
            }
        });

        KindEditor.create('#editor', {
            width: "auto",
            minHeight: 300,
            items: [
                'source', 'preview', 'undo', 'redo', 'code', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', 'fullscreen', '/',
                'formatblock', 'fontname', 'fontsize', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', 'image', 'graft',
                'flash', 'insertfile', 'table', 'hr', 'emoticons', 'pagebreak',
                'link', 'unlink', 'about'
            ],
            uploadJson: 'php/qiniu/upload_json.php',
            dialogOffset: 0, //对话框距离页面顶部的位置，默认为0居中，
            allowImageUpload: true,
            allowMediaUpload: true,
            themeType: 'black',
            fixToolBar: true,
            autoHeightMode: true,
            filePostName: 'uploadFile',//指定上传文件form名称，默认imgFile
            resizeType: 1,//可以改变高度
            afterBlur: function () {
                //失去焦点的时候保存下草稿防止操作失误不小心
            },
            //错误处理 handler
            errorMsgHandler: function (message, type) {
                try {
                    JDialog.msg({type: type, content: message, timer: 2000});
                } catch (Error) {
                    alert(message);
                }
            }
        });
        $(".form-tags>span.label.label-info").remove()

    });

});

function alertUpdateWindow() {
    layer.open({
        type: 2,
        title: '修改文章',
        shadeClose: true,
        shade: 0.8,
        area: ['100%', '100%'],
        content: '/templates/admin/modules/sys/updateArticle.html'
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
