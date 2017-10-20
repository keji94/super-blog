package com.keji.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
@Controller
public class IndexController {

    @RequestMapping("/admin/{page}")
    public String amdinIndex(@PathVariable String page) {
        return "/admin/" + page;
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequiresPermissions("admin")
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
