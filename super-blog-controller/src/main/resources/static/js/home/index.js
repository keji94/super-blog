var ztreeSetting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        }
    },

    callback: {
        beforeClick: getCurrentNode,
        onclick: zTreeOnclick
    }
};
var ztree;

function getCurrentNode(treeId, treeNode) {
    zTreeOnclick(treeNode);
}

function getCategory() {
    //加载菜单树
    $.get("admin/category/list", function (r) {
        ztree = $.fn.zTree.init($("#categoryTree"), ztreeSetting, r);
    })
}

function zTreeOnclick(treeNode) {
    var name = treeNode.name;
    //todo   根据name查询文章
}


layui.config({
    base: '/static/js/home/'
}).extend({
    clock: 'clock'
    , article: 'article'
    , note: 'note'
});

layui.use(['layer', 'form', 'laypage', 'laydate', 'element', 'util', 'flow', 'layedit', 'clock', 'article', 'note'], function () {
    var layer = layui.layer
        , laypage = layui.laypage
        , laydate = layui.date
        , element = layui.element
        , util = layui.util
        , form = layui.form
        , flow = layui.flow
        , layedit = layui.layedit
        , clock = layui.clock
        , article = layui.article
        , note = layui.note;

    //文章加载
    flow.load({
        elem: '#article-list' //流加载容器
        , done: function (page, next) { //执行下一页的回调
            return article(page, next);
        }
    });


    flow.load({
        elem: '#timeline'
        , done: function (page, next) {
            return note($(".layui-note-cover"), page, next);
        }
    });

    var hasChat = false;
    //首页固定块
    util.fixbar({
        bar1: true
        , css: {right: 10, bottom: 25}
        , bgcolor: '#9F9F9F'
        , click: function (type) {
            if (type === 'bar1') {
                if (!hasChat) {
                    hasChat = true;
                    layer.open({
                        type: 2,
                        title: '欢迎打扰',
                        shade: [0.1, '#ccc'],
                        anim: 2,
                        area: ['580px', '480px'],
                        content: 'chat.html',
                        end: function () {
                            hasChat = false;
                        }
                    });
                }
            }
        }
    });


    layedit.build('comment-input', {
        hideTool: ['image']
        , height: 150
    }); //建立编辑器


    //一些事件监听
    element.on('tab(mine-tab)', function (data) {
        console.log(data);
    });

});

$(function ($) {
    var $body = $("body");
    var agent = navigator.userAgent;
    var affixed = !(agent.indexOf("Edge/") > -1) && !(agent.indexOf("Firefox/") > -1);
    if (document.getElementById("main-body") != null && affixed) {
        $("#index-affix-side").hcSticky({
            stickTo: '#main-body'
            , innerSticker: '#search-panel'
            , queries: {
                980: {
                    disable: true
                }
            }
            , top: 10
        });
    }

    //博文页右侧固定div
    if (document.getElementById("blog-body") !== null) {
        $("#affix-side").hcSticky({
            stickTo: '#blog-body'
            , queries: {
                980: {
                    disable: true
                }
            }
            , top: 15
        });
    }

    if (document.getElementById("note-body") !== null) {
        $("#note-operate").hcSticky({
            stickTo: '#note-body'
            , top: 10
        });
    }

    $body.on("click", ".layui-timeline-title", function () {
        var $this = $(this);
        var $timelineBody = $this.next(".timeline-body")
        $timelineBody.slideToggle()
    });

    $body.on("click", "#note-operate #expand", function () {
        $(".timeline-body").slideDown()
    });

    $body.on("click", "#note-operate #collaspan", function () {
        $(".timeline-body").slideUp()
    });


    $("#side-nav").click(function () {
        var $sideNav = $(".nav-header .layui-nav-side");
        if ($sideNav.css("width") !== "0px") {
            $sideNav.animate({
                width: "0"
            }, 200)
        } else {
            $sideNav.animate({
                width: "200px"
            }, 200);
            layer.open({
                type: 1
                , title: false
                , shade: [0.6, '#f8f8f8']
                , shadeClose: true
                , closeBtn: 0
            })

        }
    });

    $body.click(function () {
        var $sideNav = $(".nav-header .layui-nav-side");
        if ($sideNav.css("width") !== "0px") {
            $sideNav.animate({
                width: "0"
            }, 200)
        }
    });

    getCategory();

});
