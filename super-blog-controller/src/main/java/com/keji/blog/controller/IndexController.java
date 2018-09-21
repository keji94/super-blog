package com.keji.blog.controller;

import java.util.List;

import com.keji.blog.bo.ArticleBO;
import com.keji.blog.bo.LinkBO;
import com.keji.blog.dataobject.IndexSettingDO;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.dataobject.UpdateTimeLineDO;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.IndexSettingService;
import com.keji.blog.service.ArticleService;
import com.keji.blog.service.NavService;
import com.keji.blog.service.LinkService;
import com.keji.blog.service.UpdateTimeLineService;
import com.keji.blog.util.LogUtil;
import com.keji.blog.util.RedisKeyUtil;
import com.keji.blog.vo.article.ArticleSearchResultVO;
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

    private NavService navService;
    private ArticleService articleService;
    private UpdateTimeLineService timeLineService;
    private LinkService linkService;
    private RedisClient redisClient;
    private IndexSettingService indexSettingService;

    @Autowired
    public IndexController(NavService navService, ArticleService articleService, UpdateTimeLineService timeLineService,
                           LinkService linkService, RedisClient redisClient, IndexSettingService indexSettingService) {
        this.navService = navService;
        this.articleService = articleService;
        this.timeLineService = timeLineService;
        this.linkService = linkService;
        this.redisClient = redisClient;
        this.indexSettingService = indexSettingService;
    }

    @RequestMapping(value = {"", "/index"})
    public String index(Model model) {
        try {
            IndexSettingDO indexSettingDO = indexSettingService.selectIndexSetting();
            List<NavDO> navDOS = navService.listAll(initNavDO());
            //顶部右侧导航
            model.addAttribute("navDOS", navDOS);
            model.addAttribute("settings", indexSettingDO);
        } catch (Exception e) {
            LogUtil.error(logger, e, "查询文本设置发生异常");
        }
        return "/home/index";
    }

    @RequestMapping(value = {"/home/{page}"})
    public String publishBlog(@PathVariable String page, Model model) {

        String updatePageName = "update";
        String linkPageName = "link";

        IndexSettingDO indexSettingDO = indexSettingService.selectIndexSetting();
        List<NavDO> navDOS = navService.listAll(initNavDO());

        model.addAttribute("settings", indexSettingDO);
        model.addAttribute("navDOS", navDOS);

        if (page.equals(updatePageName)) {
            List<UpdateTimeLineDO> updateTimeLineDOS = timeLineService.listAll();
            model.addAttribute("updateTimeLineDOS", updateTimeLineDOS);
        }

        if (page.equals(linkPageName)) {
            List<LinkBO> linkBOS = linkService.listAll(new LinkBO());
            model.addAttribute("linkBOS", linkBOS);
        }

        return "/home/" + page;
    }

    @RequestMapping(value = {"/home/detail"})
    public String articleDetail(Long id, Model model) {
        IndexSettingDO indexSettingDO = indexSettingService.selectIndexSetting();

        redisClient.incr(RedisKeyUtil.getArticlePageReviewsKey(id));

        List<NavDO> navDOS = navService.listAll(initNavDO());
        ArticleBO articleBO = articleService.queryById(id);
        model.addAttribute("articleBO", articleBO);
        model.addAttribute("settings", indexSettingDO);
        model.addAttribute("navDOS", navDOS);
        return "/home/detail";
    }

    @RequestMapping(value = {"/search","/home/search"})
    public String articleDetail(String key, Model model) {

        IndexSettingDO indexSettingDO = indexSettingService.selectIndexSetting();
        List<NavDO> navDOS = navService.listAll(initNavDO());

        ArticleBO bo = new ArticleBO();
        bo.setTitle(key);
        List<ArticleBO> articleBOS = articleService.queryByTitle(key);

        ArticleSearchResultVO resultVO = new ArticleSearchResultVO();
        resultVO.setKey(key);
        resultVO.setTotal(articleBOS.size());
        resultVO.setArticleBOS(articleBOS);
        model.addAttribute("resultVO", resultVO);
        model.addAttribute("settings", indexSettingDO);
        model.addAttribute("navDOS", navDOS);
        return "/home/search";
    }

    private NavDO initNavDO() {
        NavDO navDO = new NavDO();
        navDO.setStatus(1);
        return navDO;
    }

    @RequestMapping("/blog")
    public String showBlogDetail(Long id, Model model) {
        ArticleBO articleBO = articleService.queryById(id);
        model.addAttribute("article", articleBO);
        return "/home/blogDetail";
    }
}
