layui.define(function (exports) {
    exports('article', function (page, next) {
        return nextPage(page, next)
    });
});


function nextPage(page, next) { //执行下一页的回调

    $.ajax({
        type: "POST",
        url: "/article/list",
        dataType: "json",
        data: {
            "pageIndex": page,
            "pageSize": 5
        },
        success: function (r) {
            if (r.success) {
                var lis = [];
                for (var i = 0; i < r.data.length; i++) {
                    lis.push(generatorContent(r.data[i]));
                }
                next(lis.join(''), page < r.totalPage);
            } else {
                alertFail("获取文章信息失败");
            }
        }
    });
}
function generatorContent(data) {
    var content;

    if (1 === data.previewStyle) {
        content = getContent1(data);
    }else if (2 === data.previewStyle) {
        content = getContent2(data);
    }else if (3 === data.previewStyle) {
        content = getContent3(data);
    }else {
        content = getContent1(data);
    }
    return content;
}

function getContent1(data) {
    var imageUrl = "";
    var imageDO = data.articleImageDOS[0];
    if (!$.isEmptyObject(imageDO)) {
        imageUrl = imageDO.imageUrl;
    }
    return "\t\t\t\t\t\t<div class=\"post post-layout-list\" data-aos=\"fade-up\">\n" +
        "\t\t\t\t\t\t\t<div class=\"status_list_item icon_kyubo\">\n" +
        "\t\t\t\t\t\t\t\t<div class=\"status_user\" style=\"background-image: url("+imageUrl+");\">\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"status_section\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<a href=\"home/detail.html?id="+data.id+"\"  id='"+data.id+"' onclick='articleDetail(this.id)' class=\"status_btn\">"+data.title+"</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t<p class=\"section_p\">"+data.content+"</p>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t</div>";
}

function getContent2(data) {
    var imageUrl = "";
    var imageDO = data.articleImageDOS[0];
    if (!$.isEmptyObject(imageDO)) {
        imageUrl = imageDO.imageUrl;
    }

    return "\t\t\t\t\t\t<div class=\"post post-layout-list\" data-aos=\"fade-up\">\n" +
        "\t\t\t\t\t\t\t<div class=\"postnormal review \">\n" +
        "\t\t\t\t\t\t\t\t<div class=\"post-container review-item\">\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"row review-item-wrapper\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<a rel=\"nofollow\" href=\"home/detail.html\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"review-item-img\" style=\"background-image: url("+imageUrl+");\"></div>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9 flex-xs-middle\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"review-item-title\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"home/detail.html?id="+data.id+"\"  id='"+data.id+"' onclick='articleDetail(this.id)' rel=\"bookmark\">"+data.title+"</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<div class=\"review-item-creator\"><b>发布日期：</b>"+data.gmtCreated+"</div>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<span class=\"review-item-info\"><b>总浏览量：</b>"+data.pageViews+"</span>\n" +
        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"review-bg-wrapper\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"bg-blur\" style=\"background-image: url("+imageUrl+");\"></div>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t<div class=\"post-container\">\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"entry-content\">"+data.content+"</div>\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"post-footer\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<a class=\"gaz-btn primary\" href=\"\">READ MORE</a>\n" +
        // "\t\t\t\t\t\t\t\t\t\t<span class=\"total-comments-on-post pull-right\"><a href=\"\">31 Comments</a></span>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t</div>\n"
}

function getContent3(data) {
    var imageUrl = "";
    var imageDO = data.articleImageDOS[0];
    if (!$.isEmptyObject(imageDO)) {
        imageUrl = imageDO.imageUrl;
    }

    var imagehtml = getImageHtml(data);

    return "\t\t\t\t\t\t<div class=\"post post-layout-list js-gallery\" data-aos=\"fade-up\">\n" +
        "\t\t\t\t\t\t\t<div class=\"post-album\">\n" +
        "\t\t\t\t\t\t\t\t<div class=\"row content\">\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"bg\" style=\"background-image: url("+imageUrl+");\"></div>\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"contentext flex-xs-middle\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"album-title\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"home/detail.html?id="+data.id+"\"  id='"+data.id+"' onclick='articleDetail(this.id)'>"+data.title+"</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t\t<h5 class=\"review-item-creator\"><b>发布日期：</b>"+data.gmtCreated+"</h5>\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"album-content\">"+data.content+"</div>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"album-thumb-width flex-xs-middle\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"row album-thumb no-gutter\">\n" + imagehtml+
        "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t</div>\n";
}

function getImageHtml(data) {
    var imageHtml = "";
    if (data.articleImageDOS.length >=2){
        for (var i = 1; i < data.articleImageDOS.length; i++) {
            imageHtml += "\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-xs-4\"><img class=\"thumb\" src="+data.articleImageDOS[i].imageUrl+"/></div>\n";
            if (i === 4) {
                imageHtml += "\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"\">5 pics</a>\n";
                return imageHtml;
            }
        }
    }

    return imageHtml;
}