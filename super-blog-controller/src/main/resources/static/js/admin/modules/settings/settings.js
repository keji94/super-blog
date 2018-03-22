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
        var homeIcon = $("#homeIcon").val();
        var note = $("#note").val();
        var noteIcon = $("#noteIcon").val();
        var about = $("#about").val();
        var aboutIcon = $("#aboutIcon").val();
        var search = $("#search").val();
        var searchIcon = $("#searchIcon").val();
        var iconUrl = $("#iconUrl").val();
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
                "homeIcon": homeIcon,
                "note": note,
                "noteIcon": noteIcon,
                "about": about,
                "aboutIcon": aboutIcon,
                "search": search,
                "searchIcon": searchIcon,
                "iconUrl": iconUrl,
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
            $("#homeIcon").val(data.data.homeIcon);
            $("#note").val(data.data.note);
            $("#noteIcon").val(data.data.noteIcon);
            $("#about").val(data.data.about);
            $("#aboutIcon").val(data.data.aboutIcon);
            $("#search").val(data.data.search);
            $("#searchIcon").val(data.data.searchIcon);
            $("#iconUrl").val(data.data.iconUrl);
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