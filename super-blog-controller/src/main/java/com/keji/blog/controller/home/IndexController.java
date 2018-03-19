package com.keji.blog.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站首页IndexController
 *
 * @author wb-ny291824
 * @version $Id: IndexController.java, v 0.1 2018-03-19 14:38 wb-ny291824 Exp $$
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "/home/index";
    }

    @RequestMapping("")
    public String indexPage() {
        return "/home/index";
    }
}
