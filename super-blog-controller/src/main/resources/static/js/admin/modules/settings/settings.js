layui.use(['form', 'element'], function () {
    var element = layui.element,
        $ = layui.jquery,
        form = layui.form;

    //监听提交
    form.on('submit(submitBtn)', function (data) {
        $.ajax({
            type: "POST",
            url: "/textsettings/update",
            contentType: "application/json",
            data: JSON.stringify(data.field),
            success: function (r) {
                if (r.success) {
                    alertSuccess("修改成功");
                } else {
                    alertFail("修改异常");
                }
            }
        });
        return false;
    });

    //监听提交
    form.on('submit(submitBtn2)', function (data) {

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
        var announcement = $("#announcement").val();
        var leaveWordAnnouncement = $("#leaveWordAnnouncement").val();
        var commentOpen = $("#commentOpen").get(0).checked ? 1 : 0;
        var leaveWordOpen = $("#leaveWordOpen").get(0).checked ? 1 : 0;

        $.ajax({
            type: "POST",
            url: "/textsettings/update",
            dataType: "json",
            data: {
                "logo": logo,
                "title": title,
                "pageHeader": pageHeader,
                "pageRooting": pageRooting,
                "home": home,
                "note": note,
                "about": about,
                "search": search,
                "informationBoard": informationBoard,
                "id": id,
                "announcement": announcement,
                "commentOpen": commentOpen,
                "leaveWordOpen": leaveWordOpen,
                "leaveWordAnnouncement": leaveWordAnnouncement
            },
            success: function (r) {
                if (r.success) {
                    alertSuccess("修改成功");
                    form.render();
                } else {
                    alertFail("修改异常");
                }
            }
        });
        return false;
    });

    $.post("/textsettings/query", function (data) {
        if (data.success) {
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
            if (1 === data.data.commentOpen) {
                $("#commentOpen").prop('checked', true);
                form.render();
            }
            if (1 === data.data.leaveWordOpen) {
                $("#leaveWordOpen").prop('checked', true);
                form.render();
            }
            $("#announcement").val(data.data.announcement);
            $("#leaveWordAnnouncement").val(data.data.leaveWordAnnouncement);
        } else {
            alertFail("获取文案信息失败");
        }

    })

});