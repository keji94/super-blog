$(function () {
    var prefix = 'res/blog/js/admin/controller';
    vipspa.start({
        view: '#admin-body',
        router: {
            'home': {
                templateUrl: 'admin_home.html',
                controller: prefix + '/home.js'
            },
            'profile': {
                templateUrl: 'admin_profile.html',
                controller: prefix + '/profile.js'
            },
            'blog': {
                templateUrl: 'admin_blog.html',
                controller: prefix + '/blog.js'
            },
            'note': {
                templateUrl: 'admin_note.html',
                controller: prefix + '/note.js'
            },
            'blogs': {
                templateUrl: 'admin_blogs.html',
                controller: prefix + '/blogs.js'
            },
            'mine': {
                templateUrl: 'admin_mine.html',
                controller: prefix + '/mine.js'
            },
            'noteblog': {
                templateUrl: 'admin_noteblog.html',
                controller: prefix + '/noteblog.js'
            },
            'defaults': 'home' //默认路由
        }
    });

});
