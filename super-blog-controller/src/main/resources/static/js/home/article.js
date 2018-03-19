layui.define(function (exports) {
    exports('article', function (page, next) {
        return nextPage(page, next)
    });
});

var content = "<div class=\"layui-collapse layui-panel layui-article animated flipInX\">\n" +
    "                <div class=\"layui-colla-item\">\n" +
    "                    <div class=\"layui-colla-content layui-show layui-article\">\n" +
    "                        <fieldset class=\"layui-elem-field layui-field-title\">\n" +
    "                            <legend class=\"center-to-head \"><a href='blog.html'> 有关 WebMagic 爬虫扒取 magnet 磁力链接的一些问题的解决</a></legend>\n" +
    "                            <div class=\"layui-field-box\">\n" +
    "                                &nbsp;&nbsp;&nbsp;&nbsp;最近在研究爬虫,想扒取资源.\n" +
    "                                研究了多了国人的爬虫webCollector/webMagic等,最后决定使用webMagic,感觉这个比较容易上手,而且定义比较灵活,也容易懂.\n" +
    "                                具体文档请移步:http://webmagic.io/<a class=\"loading\" href=\"blog.html\"> 阅读全文<i\n" +
    "                                    class=\"fa fa-angle-double-right\"></i> </a>\n" +
    "                            </div>\n" +
    "                            <div class=\"operation\">\n" +
    "                                <div class=\"tags\">\n" +
    "                                    <span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i> 爬虫</span>\n" +
    "                                    <span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i> Java</span>\n" +
    "                                    <span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i> 开源</span>\n" +
    "                                    <span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i> webmagic</span>\n" +
    "                                </div>\n" +
    "                                <div class=\"info\">\n" +
    "                                    <span class=\"views\"><i class=\"fa fa-eye\"></i> 265</span>\n" +
    "                                    <span class=\"datetime\"><i class=\"fa fa-clock-o\"></i> 2018-01-08</span>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                        </fieldset>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>";

function nextPage(page, next) { //执行下一页的回调
    //模拟数据插入
    setTimeout(function () {
        var lis = [];
        for (var i = 0; i < 8; i++) {
            lis.push(content)
        }

        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
        next(lis.join(''), page < 3); //假设总页数为 10
    }, 500);
}