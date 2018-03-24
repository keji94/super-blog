package com.keji.blog.controller.home;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.keji.blog.dataobject.InfoBoardDO;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.service.admin.InfoBoardService;
import com.keji.blog.service.admin.NavService;
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
    @Resource
    private NavService navService;
    @Resource
    private InfoBoardService boardService;

    @RequestMapping(value = {"", "/index"})
    public String index(Model model) {
        try {
            TextSettingsDO textSettingsDO = textSettingsService.query();
            List<NavDO> navDOS = navService.listAll(initNavDO());
            List<InfoBoardDO> list = boardService.listAll(new InfoBoardDO());
            List<String> titleList = list.stream().map(InfoBoardDO::getTitle).collect(Collectors.toList());

            model.addAttribute("settings", textSettingsDO);
            model.addAttribute("navDOS", navDOS);
            model.addAttribute("titleList", titleList);
            model.addAttribute("contentList", list);
        } catch (Exception e) {
            LogUtil.error(logger, e, "查询文本设置发生异常");
        }
        return "/home/index";
    }

    private NavDO initNavDO() {
        NavDO navDO = new NavDO();
        navDO.setStatus(1);
        return navDO;
    }
}
