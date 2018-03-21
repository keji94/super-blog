layui.use(['form','element'], function(){
    var element = layui.element,
        $ = layui.jquery,
        form = layui.form;

    //监听提交
    form.on('submit(submitBtn)', function(data){
        $.ajax({
            type: "POST",
            url: "/textsettings/update",
            contentType: "application/json",
            data: JSON.stringify(data.field),
            success: function(r){
                if (r.success){
                    alertSuccess("修改成功");
                }else {
                    alertFail("修改异常");
                }
            }
        });
        return false;
    });

    var commentOpen;
    var leaveWordOpen;

    //监听指定开关
    form.on('switch(switchTest)', function(data){
        commentOpen = this.checked ? 1 : 0;
        if (!this.checked){
            layer.tips('将关闭所有文章的评论功能', data.othis)
        }
    });
    form.on('switch(switchTest2)', function(data){
        leaveWordOpen = this.checked ? 1 : 0;
        if (!this.checked){
            layer.tips('将关闭留言功能', data.othis)
        }
    });

    //监听提交
    form.on('submit(submitBtn2)', function(data){

        var logo = $("#logo").val();
        var title = $("#title").val();
        var pageHeader = $("#pageHeader").val();
        var pageRooting = $("#pageRooting").val();
        var home = $("#home").val();
        var note = $("#note").val();
        var about = $("#about").val();
        var search = $("#search").val();
        var informationBoard = $("#informationBoard").val();
        var id = $(".textSettingId").val();
        var commentOpen = $("#commentOpen").val();
        var title = $("#leaveWordOpen").val();
        var title = $("#announcement").val();
        var title = $("#leaveWordAnnouncement").val();

        $.ajax({
            type: "POST",
            url: "/textsettings/update",
            contentType: "application/json",
            data: JSON.stringify(data.field),
            success: function(r){
                if (r.success){
                    alertSuccess("修改成功");
                }else {
                    alertFail("修改异常");
                }
            }
        });
        return false;
    });

    $.post("/textsettings/query",function(data) {
        if(data.success) {
            $("#logo").val(data.data.logo);
            $("#title").val(data.data.title);
            $("#pageHeader").val(data.data.pageHeader);
            $("#pageRooting").val(data.data.pageRooting);
            $("#home").val(data.data.home);
            $("#note").val(data.data.note);
            $("#about").val(data.data.about);
            $("#search").val(data.data.search);
            $("#informationBoard").val(data.data.informationBoard);
            $(".textSettingId").val(data.data.id);
            $("#commentOpen").val(data.data.commentOpen);
            $("#leaveWordOpen").val(data.data.leaveWordOpen);
            $("#announcement").val(data.data.announcement);
            $("#leaveWordAnnouncement").val(data.data.leaveWordAnnouncement);
        }else {
            alertFail("获取文案信息失败");
        }

    })

});