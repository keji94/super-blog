var M = {};
function alertSuccess(message) {
    M.dialog = jqueryAlert({
        'icon': '/static/images/right.png',
        'content': message,
        'closeTime': 1500
    });
    setTimeout('M.dialog.destroy()', 1500);
}

function alertFail(message) {
    M.dialog = jqueryAlert({
        'icon': '/static/images/error.png',
        'content': message,
        'closeTime': 1500
    });
    setTimeout('M.dialog.destroy()', 1500);
}

function alertConfirm(content,url,data,successMsg) {

    M.dialogConfirm = jqueryAlert({
        'title': '警告!',
        'content': content,
        'modal': true,
        'width': '220',
        'buttons': {
            '确定': function () {
                $.ajax({
                    type: "POST",
                    url: url,
                    contentType: "application/json",
                    data: data,
                    success: function (r) {
                        if (r.success) {
                            M.dialogConfirm.close();
                            alertSuccess(successMsg);
                            vm.reload();
                        } else {
                            alertFail(r.errorMsg);
                        }
                    }
                });
            },
            '取消': function () {
                //关闭
                M.dialogConfirm.close();
                //销毁
                M.dialogConfirm.destroy()
            }
        }
    });
}