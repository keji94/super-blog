var simplemde;

$(function () {

    simplemde = new SimpleMDE({ element: $("#test")[0] });
});

layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form;

    //监听提交
    form.on('submit(publish)', function(){

        //查询分类列表
        $.ajax({
            type: "POST",
            url: "/admin/category/list",
            dataType: "json",
            success: function (r) {
                var html = '';
                for(var i = 0 ;i<r.length;i++){
                    html += "<input type='checkbox' name=" + r[i].id + "lay-skin='primary' title=" + r[i].name + ">";
                }
                $("#categoryDiv").append(html);
                form.render();
            }
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
                //TODO 提交数据
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


        console.log(simplemde.value());
        // layer.alert(JSON.stringify(data.field), {
        //     title: '最终的提交信息'
        // });
        return false;
    });


});
