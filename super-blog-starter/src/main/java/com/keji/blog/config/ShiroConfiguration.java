package com.keji.blog.config;

import com.keji.blog.controller.shiro.MyShiroRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

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
        return new AuthorizationAttributeSourceAdvisor();
    }

    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean getShiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();
        //必须设置securityManager
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/admin/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");

        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        //TODO 退出登录待验证
//        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- authc:必须认证通过才可以访问; anon:可以匿名访问;perms["name"]:需要名为name权限的过滤器-->
//        filterChainDefinitionMap.put("/**", "authc");   //所有的资源都需要认证
            filterChainDefinitionMap.put("/admin/*", "authc");
            filterChainDefinitionMap.put("/admin/login", "anon");
            filterChainDefinitionMap.put("/static/**", "anon");
            filterChainDefinitionMap.put("/login", "anon");
            filterChainDefinitionMap.put("/", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(getShiroRealm());
//        dwsm.setCacheManager(getEhCacheManager());
        return dwsm;
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



}
