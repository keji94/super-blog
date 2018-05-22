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

function generatorContent(data) {

    var tagBody = '';
    for(var i = 0 ; i < data.tagDOS.length;i++) {
        tagBody += "<span class=\"layui-badge-rim\"><i class=\"fa fa-tag\"></i> "+data.tagDOS[i].name+"</span>\n";
    }

    var content = "<div class=\"layui-collapse layui-panel layui-article animated flipInX\">\n" +
        "                <div class=\"layui-colla-item\">\n" +
        "                    <div class=\"layui-colla-content layui-show layui-article\">\n" +
        "                        <fieldset class=\"layui-elem-field layui-field-title\">\n" +
        "                            <legend class=\"center-to-head \"><a href='blog.html'>"+data.title+"</a></legend>\n" +
        "                            <div class=\"layui-field-box\">\n"+data.content+
        "<a class=\"loading\" href=\"blog.html\"> 阅读全文<i\n" + "class=\"fa fa-angle-double-right\"></i> </a>\n" +
        "                            </div>\n" +
        "                            <div class=\"operation\">\n" +
        "                                <div class=\"tags\">\n" +
                                            tagBody +
        "                                </div>\n" +
        "                                <div class=\"info\">\n" +
        "                                    <span class=\"views\"><i class=\"fa fa-eye\"></i>"+data.pageviews+"</span>\n" +
        "                                    <span class=\"datetime\"><i class=\"fa fa-clock-o\"></i> "+data.gmtCreated+"</span>\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                        </fieldset>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>";
    return content;
}

function nextPage(page, next) { //执行下一页的回调

    $.ajax({
        type: "POST",
        url: "/adminArticle/list",
        dataType: "json",
        data: {
            "pageIndex": page,
            "pageSize": 10
        },
        success: function (r) {
            if (r.success) {
                var lis = [];
                for (var i = 0; i < r.data.length; i++) {
                    lis.push(generatorContent(r.data[i]));
                }
                next(lis.join(''), page < r.totalPages);
            } else {
                alertFail("获取文章信息失败");
            }
        }
    });
}