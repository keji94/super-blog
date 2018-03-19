layui.use(['form','element'], function(){
    var element = layui.element,
        form = layui.form;
    //监听指定开关
    form.on('switch(switchTest)', function(data){
        layer.tips('该设置会覆盖文章的单独设置', data.othis)
    });
});