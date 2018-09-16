package com.keji.blog.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.keji.blog.bo.ArticleBO;
import com.keji.blog.bo.LinkBO;
import com.keji.blog.dataobject.InfoBoardDO;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.dataobject.UpdateTimeLineDO;
import com.keji.blog.service.admin.ArticleAdminService;
import com.keji.blog.service.admin.InfoBoardService;
import com.keji.blog.service.admin.NavService;
import com.keji.blog.service.admin.TextSettingsService;
import com.keji.blog.service.home.ArticleTagRelService;
import com.keji.blog.service.home.LinkService;
import com.keji.blog.service.home.UpdateTimeLineService;
import com.keji.blog.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    private TextSettingsService textSettingsService;
    private NavService navService;
    private InfoBoardService boardService;
    private ArticleTagRelService articleTagRelService;
    private ArticleAdminService articleAdminService;
    private UpdateTimeLineService timeLineService;
    private LinkService linkService;

    @Autowired
    public IndexController(TextSettingsService textSettingsService, NavService navService,
                           InfoBoardService boardService, ArticleTagRelService articleTagRelService,
                           ArticleAdminService articleAdminService, UpdateTimeLineService timeLineService,
                           LinkService linkService) {
        this.textSettingsService = textSettingsService;
        this.navService = navService;
        this.boardService = boardService;
        this.articleTagRelService = articleTagRelService;
        this.articleAdminService = articleAdminService;
        this.timeLineService = timeLineService;
        this.linkService = linkService;
    }

    @RequestMapping(value = {"", "/index"})
    public String index(Model model) {
        try {
            TextSettingsDO textSettingsDO = textSettingsService.query();
            List<NavDO> navDOS = navService.listAll(initNavDO());
            List<InfoBoardDO> list = boardService.listAll(new InfoBoardDO());
            List<String> titleList = list.stream().map(InfoBoardDO::getTitle).collect(Collectors.toList());
            Map<String, Integer> hotTag = articleTagRelService.queryHotTag();
            //网站文案设置
            model.addAttribute("settings", textSettingsDO);
            //顶部右侧导航
            model.addAttribute("navDOS", navDOS);
            //网站信息板
            model.addAttribute("titleList", titleList);
            model.addAttribute("contentList", list);
            //热门标签
            model.addAttribute("hotTag", hotTag);
        } catch (Exception e) {
            LogUtil.error(logger, e, "查询文本设置发生异常");
        }
        return "/home/index";
    }

    @RequestMapping(value = {"/home/{page}"})
    public String publishBlog(@PathVariable String page,Model model) {

        String updatePageName = "update";
        String linkPageName = "link";


        TextSettingsDO textSettingsDO = textSettingsService.query();
        List<NavDO> navDOS = navService.listAll(initNavDO());

        model.addAttribute("settings", textSettingsDO);
        model.addAttribute("navDOS", navDOS);

        if (page.equals(updatePageName)) {
            List<UpdateTimeLineDO> updateTimeLineDOS = timeLineService.listAll();
            model.addAttribute("updateTimeLineDOS",updateTimeLineDOS);
        }

        if (page.equals(linkPageName)) {
            List<LinkBO> linkBOS = linkService.listAll(new LinkBO());
            model.addAttribute("linkBOS", linkBOS);
        }

        return "/home/"+page;
    }

    private NavDO initNavDO() {
        NavDO navDO = new NavDO();
        navDO.setStatus(0);
        return navDO;
    }

    @RequestMapping("/blog")
    public String showBlogDetail(Long id,Model model) {
        ArticleBO articleBO = articleAdminService.queryById(id);
        model.addAttribute("article", articleBO);
        return "/home/blogDetail";
    }
}
