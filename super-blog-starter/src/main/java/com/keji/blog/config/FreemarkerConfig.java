package com.keji.blog.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.keji.blog.dataobject.InfoBoardDO;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.service.admin.ArticleAdminService;
import com.keji.blog.service.admin.InfoBoardService;
import com.keji.blog.service.admin.NavService;
import com.keji.blog.service.admin.TextSettingsService;
import com.keji.blog.service.home.ArticleTagRelService;
import com.keji.blog.shiro.ShiroTag;
import com.keji.blog.util.LogUtil;
import freemarker.core.Configurable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Freemarker配置
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017/9/28 21:32
 */
@Configuration
public class FreemarkerConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TextSettingsService textSettingsService;
    private NavService navService;
    private InfoBoardService boardService;
    private ArticleTagRelService articleTagRelService;

    @Autowired
    public FreemarkerConfig(TextSettingsService textSettingsService, NavService navService,
                            InfoBoardService boardService, ArticleTagRelService articleTagRelService) {
        this.textSettingsService = textSettingsService;
        this.navService = navService;
        this.boardService = boardService;
        this.articleTagRelService = articleTagRelService;
    }

    /**
     * 自定义Shiro标签
     *
     * @param shiroTag
     * @return
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(ShiroTag shiroTag) {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/templates/");

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("shiro", shiroTag);
        configurer.setFreemarkerVariables(variables);

        Properties settings = new Properties();
        settings.setProperty("default_encoding", "utf-8");
        settings.setProperty("number_format", "0.##");
        configurer.setFreemarkerSettings(settings);

        return configurer;
    }

    @Bean
    public FreeMarkerViewResolver getFreemarkViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(false);
        freeMarkerViewResolver.setSuffix(".html");
        freeMarkerViewResolver.setRequestContextAttribute("request");
        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        return freeMarkerViewResolver;
    }

    private NavDO initNavDO() {
        NavDO navDO = new NavDO();
        navDO.setStatus(1);
        return navDO;
    }
}
