package com.keji.blog.config;

import java.util.List;

import com.keji.blog.assept.requestparambinder.FieldParamProcessor;
import com.keji.blog.assept.requestparambinder.MyRequestParamMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring拦截规则配置. 由于引入了shiro,这里的拦截器暂时不使用了.
 *
 * @author keji
 * @version $Id: WebMvcConfig.java, v 0.1 2018/6/1 上午10:11 keji Exp $
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter  {

    /**
     * 定义静态资源和模板的位置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(
                ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        super.addResourceHandlers(registry);
    }

    /**
     * 多个拦截器组成一个拦截器链
     * addPathPatterns 用于添加拦截规则
     * excludePathPatterns 用户排除拦截
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(getFormParamRequestParamMethodArgumentResolver());
        argumentResolvers.add(getQueryParamRequestParamMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    /**
     * 对象参数绑定
     * @return FieldParamProcessor
     */
    @Bean
    public FieldParamProcessor getFormParamRequestParamMethodArgumentResolver(){
        return new FieldParamProcessor(true);
    }

    /**
     * 查询参数绑定
     * @return MyRequestParamMethodArgumentResolver
     */
    @Bean
    public MyRequestParamMethodArgumentResolver getQueryParamRequestParamMethodArgumentResolver(){
        return new MyRequestParamMethodArgumentResolver(true);
    }
}
