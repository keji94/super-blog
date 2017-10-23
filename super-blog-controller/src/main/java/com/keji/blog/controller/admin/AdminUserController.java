package com.keji.blog.controller.admin;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.vo.user.BlogUserVO;
import com.keji.blog.vo.user.UserQueryVO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import java.util.List;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/22
 * @modified: By:
 */
@Controller
@RequestMapping("/adminuser")
public class AdminUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public BaseResult login(BlogUserVO userVO) {
        if (userVO.getEmail() == null
                || userVO.getPassword() == null
                || userVO.getRememberMe() == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userVO.getEmail(), userVO.getPassword(), userVO.getRememberMe());

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            logger.error("用户名不存在", e);
            return BaseResult.makeFail(BlogConstants.LOGIN_ERROR);
        } catch (IncorrectCredentialsException e) {
            logger.error("密码错误", e);
            return BaseResult.makeFail(BlogConstants.LOGIN_ERROR);
        }
        return BaseResult.makeSuccess();
    }

    @RequestMapping("/logout")
    public String logout() {

        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            logger.error("退出登录异常!", e);
            //容错，发生异常也跳转到登录页面。
            return "/login";
        }
        return "/login";
    }

    @ResponseBody
    @RequestMapping("/queryalluser")
    public PageResult<List<UserDO>> queryAllUser(@Valid UserQueryVO userQueryVO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.warn("参数校验不通过，错误信息："+bindingResult);
            return PageResult.makeFail(bindingResult);
        }

        PageResult<List<UserDO>> pageResult = userService.queryUserByPage(new UserDO(), userQueryVO.getPageIndex(), userQueryVO.getPageSize());

        return pageResult;
    }

}
