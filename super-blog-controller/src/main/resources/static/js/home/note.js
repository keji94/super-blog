layui.define(function (exports) {
    exports('note', function (cover, page, next) {
        return nextShare(cover, page, next)
    });
});

var shares = "<li class=\"layui-timeline-item animated slideInUp\">\n" +
    "            <i class=\"layui-icon layui-timeline-axis\">&#xe63f;</i>\n" +
    "            <div class=\"layui-timeline-content layui-text\">\n" +
    "                <h3 class=\"layui-timeline-title\">8月18日</h3>\n" +
    "                <div class=\"timeline-body\"'>\n" +
    "                    <p>用cglib生成的代理类取不到注解的问题</p>\n" +
    "                    <p>直接在注解上面加@Inherited\n" +
    "                        CGLIB ，加上这个标志就可以令子类继承这个注解</p>\n" +
    "                    <hr>\n" +
    "                    <p> eclipse tomcat 启动45秒超时问题</p>\n" +
    "                    <p>找到workplace路径/./.plugins /org..wst.server.core/servers.xml，\n" +
    "                        编辑start-timeout，把45改大点就好。</p>\n" +
    "                </div>\n" +
    "            </div>" +
    "        </li>\n";
var shareEnds = "        <li class=\"layui-timeline-item layui-note-cover\">\n" +
    "            <i class=\"layui-icon layui-timeline-axis\">&#xe63f;</i>\n" +
    "            <div class=\"layui-timeline-content layui-text\">\n" +
    "                <h3 class=\"layui-timeline-title\">笔记封面</h3>\n" +
    "            </div>\n" +
    "        </li>";

function nextShare(cover, page, next) { //执行下一页的回调
    //模拟数据插入
    setTimeout(function () {
        var lis = [];
        for (var i = 0; i < 8; i++) {
            lis.push(shares)
        }
        lis.push(shareEnds)

        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
        cover.slideUp();
        next(lis.join(''), page < 10); //假设总页数为 10
    }, 500);
}