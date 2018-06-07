package com.keji.blog.config;

import java.util.LinkedHashMap;
import java.util.Map;

import com.keji.blog.shiro.MyShiroRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wb-ny291824
 * @description shiro配置类
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Configuration
public class ShiroConfiguration {

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 启用shiro方法注解进行权限控制
     *  @RequiresPermissions("admin"):需要admin的权限才能访问
     *  @RequiresAuthentication 需要登录，等同于方法subject.isAuthenticated() 结果为true时。
     *  @RequiresUser 需要登录或者被记忆，一种是成功登录的（subject.isAuthenticated() 结果为true）,另外一种是被记忆的（ subject.isRemembered()结果为true）。
     *  @RequiresGuest 需要时guest请求。与@ RequiresUser完全相反。换言之，RequiresUser  == ! RequiresGuest 。此时subject.getPrincipal() 结果为null.
     *  @RequiresRoles 需要某一个角色才能访问
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager());
        return aasa;
    }

    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean getShiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();
        //必须设置securityManager
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.html"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/");
        //拦截器链.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        //<!-- authc:必须认证通过才可以访问; anon:可以匿名访问;perms["name"]:需要名为name权限的过滤器-->
        filterChainDefinitionMap.put("/adminuser/login", "anon");
        filterChainDefinitionMap.put("/getCaptcha", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/vue", "anon");
        filterChainDefinitionMap.put("/home/createBlog.html", "anon");
        filterChainDefinitionMap.put("/article/list", "anon");
        filterChainDefinitionMap.put("/blog.html", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/category/list", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        //配置记住我或认证通过可以访问的地址

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getShiroRealm());
//        securityManager.setCacheManager(getEhCacheManager());
        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean(name = "myShiroRealm")
    public MyShiroRealm getShiroRealm() {
        return new MyShiroRealm();
    }


//    @Bean(name = "shiroEhcacheManager")
//    public EhCacheManager getEhCacheManager() {
//        EhCacheManager em = new EhCacheManager();
//        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
//        return em;
//    }

    /**
     * cookie对象;
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;

    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }

    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1000 * 60 * 60 * 24);
        return sessionManager;
    }

}
