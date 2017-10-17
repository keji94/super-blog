package com.keji.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wb-ny291824
 * @Description
 * @Date: Created in 2017/9/18
 * @Modified: By:
 */
@Controller
public class IndexController {

    @RequestMapping("/admin/{page}")
    public String amdinIndex(@PathVariable String page) {
        return "/admin/" + page;
    }

    @RequestMapping("/login")
    public String index() {
        return "login2";
    }
}
