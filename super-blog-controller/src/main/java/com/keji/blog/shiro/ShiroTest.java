package com.keji.blog.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/24
 * @modified: By:
 */
public class ShiroTest {


    @Test
    public void testHelloWorld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager instance = managerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken passwordToken = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证
            subject.login(passwordToken);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        //断言用户已经登录
        Assert.assertEquals(true, subject.isAuthenticated());
        //6、退出
        subject.logout();
    }
}
