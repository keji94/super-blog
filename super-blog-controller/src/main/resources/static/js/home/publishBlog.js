var simplemde;
var ztree;

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        }
    },
    check: {
        enable: true,
        chkStyle: "radio",
        radioType: "all"
    }
};

$(function () {
    simplemde = new SimpleMDE({
        element: $("#test")[0],
        toolbar: ["bold", "italic", "strikethrough", "heading", "heading-smaller", "heading-bigger",
            "heading-1", "heading-2", "heading-3", "code", "quote","unordered-list","ordered-list","clean-block",
            "link","image","table","horizontal-rule","preview","side-by-side","fullscreen","guide"]
    });
});

layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form;

    //监听提交
    form.on('submit(publish)', function (data) {

        //加载菜单树
        $.get("/admin/category/list", function (r) {
            ztree = $.fn.zTree.init($("#categoryTree"), setting, r);
        });

        //捕获页
        layer.open({
            type: 1,
            shade: false,
            area: '600px',
            title: '发布博客', //不显示标题
            content: $('#publish'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
            btn: ['确定', '取消'],
            yes: function (index, layero) {

                //标题
                var title = $("#title").val();
                //内容
                var content = simplemde.value();
                //标签
                var tags = $("#tags").val();
                //分类
                var nodes = ztree.getCheckedNodes(true);


                $.ajax({
                    type: "POST",
                    url: "/adminArticle/add",
                    dataType: "json",
                    data: {
                        "title": title,
                        "content": content,
                        "tagNameS": tags,
                        "categoryId": nodes[0].id,
                        "categoryName": nodes[0].name
                    },
                    success: function (r) {
                        if (r.success) {
                            layer.close(index);
                            alertSuccess("新增成功");
                            setTimeout(function () {
                                location.href = "/index";
                            }, 2000);
                        } else {
                            layer.close(index);
                            alertFail("新增失败");
                            X
                        }
                    }
                });
            },
            btn2: function (index) {
                layer.close(index);
            }
        });

        return false;
    });


});
