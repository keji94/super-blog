package com.keji.blog.controller.home;

import java.io.IOException;

import javax.annotation.Resource;

import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.home.TextSettingsService;
import com.keji.blog.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站首页IndexController
 *
 * @author wb-ny291824
 * @version $Id: IndexController.java, v 0.1 2018-03-19 14:38 wb-ny291824 Exp $$
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TextSettingsService textSettingsService;

    @RequestMapping("/index")
    public String index(Model model) {
        try {
            TextSettingsDO textSettingsDO = textSettingsService.query();
            model.addAttribute("settings", textSettingsDO);
        } catch (IOException e) {
            LogUtil.error(logger, e, "json转换时发生异常");
        } catch (Exception e) {
            LogUtil.error(logger,e,"查询文本设置发生异常");
        }
        return "/home/index";
    }

    @RequestMapping("")
    public String indexPage() {
        return "/home/index";
    }
}
