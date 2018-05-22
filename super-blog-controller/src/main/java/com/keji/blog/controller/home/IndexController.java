package com.keji.blog.controller.home;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.keji.blog.bo.ArticleBO;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dataobject.InfoBoardDO;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.service.admin.ArticleAdminService;
import com.keji.blog.service.admin.InfoBoardService;
import com.keji.blog.service.admin.NavService;
import com.keji.blog.service.admin.TextSettingsService;
import com.keji.blog.service.home.ArticleTagRelService;
import com.keji.blog.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TextSettingsService textSettingsService;
    @Resource
    private NavService navService;
    @Resource
    private InfoBoardService boardService;
    @Resource
    private ArticleTagRelService articleTagRelService;
    @Resource
    private ArticleAdminService articleAdminService;

    @RequestMapping(value = {"", "/index"})
    public String index(Model model) {
        try {
            TextSettingsDO textSettingsDO = textSettingsService.query();
            List<NavDO> navDOS = navService.listAll(initNavDO());
            List<InfoBoardDO> list = boardService.listAll(new InfoBoardDO());
            List<String> titleList = list.stream().map(InfoBoardDO::getTitle).collect(Collectors.toList());
            Map<String, Integer> hotTag = articleTagRelService.queryHotTag();
            List<ArticleBO> articleBOS = articleAdminService.list(new ArticleBO(),1,10).getList();
            getSummary(articleBOS);
            //网站文案设置
            model.addAttribute("settings", textSettingsDO);
            //顶部右侧导航
            model.addAttribute("navDOS", navDOS);
            //网站信息板
            model.addAttribute("titleList", titleList);
            model.addAttribute("contentList", list);
            //热门标签
            model.addAttribute("hotTag", hotTag);
            //文章列表
            model.addAttribute("articleList", articleBOS);
        } catch (Exception e) {
            LogUtil.error(logger, e, "查询文本设置发生异常");
        }
        return "/home/index";
    }

    /**
     * 替换文章内容中的特俗字符，用于预览
     *
     * @param articleBOS articleBOS
     */
    private void getSummary(List<ArticleBO> articleBOS) {
        articleBOS.forEach(articleBO -> {
            String content = articleBO.getContent();
            if (null != content && content.length() >= BlogConstants.ARTICLE_SUMMARY_LENGTH) {
                articleBO.setContent(content.substring(0, 150));
            }
        });
    }

    @RequestMapping(value = {"/home/createBlog"})
    public String publishBlog() {
        return "/home/createBlog";
    }

    private NavDO initNavDO() {
        NavDO navDO = new NavDO();
        navDO.setStatus(1);
        return navDO;
    }
}
