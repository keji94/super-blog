layui.config({
    base: '/static/js/home/'
}).extend({
     article: 'article'
});

layui.use(['layer', 'form', 'laypage', 'laydate', 'element', 'util', 'flow', 'layedit', 'article'], function () {
    var layer = layui.layer
        , laypage = layui.laypage
        , laydate = layui.date
        , element = layui.element
        , util = layui.util
        , form = layui.form
        , flow = layui.flow
        , layedit = layui.layedit
        , article = layui.article;

    //文章加载
    flow.load({
        elem: '#article-list' ,
        isAuto : true,
        done: function (page, next) {
            //执行下一页的回调
            return article(page, next);
        },
        end: 'no more article'
    });
});
