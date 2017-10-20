package com.keji.blog.controller.admin;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.controller.vo.BlogUserVO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.admin.AdminUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;


/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Controller
@RequestMapping("/adminuser")
public class AdminUserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserService adminUserService;


    @ResponseBody
    @RequestMapping("/login")
    public BaseResult login(BlogUserVO userVO, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        if (userVO.getEmail() == null
                || userVO.getPassword() == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userVO.getEmail(), userVO.getPassword());

        try {
            subject.login(token);
//            UserDO userDO = (UserDO) subject.getPrincipal();
//            session.setAttribute("username", userDO.getName());
        } catch (UnknownAccountException e) {
            logger.error("用户名不存在", e);
            return BaseResult.makeFail(BlogConstants.LOGIN_ERROR);
        } catch (IncorrectCredentialsException e) {
            logger.error("密码错误",e);
            return BaseResult.makeFail(BlogConstants.LOGIN_ERROR);
        }
        return BaseResult.makeSuccess();
    }

    @ResponseBody
    @RequestMapping("/loginout")
    public BaseResult loginout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseResult.makeSuccess();
    }

}
