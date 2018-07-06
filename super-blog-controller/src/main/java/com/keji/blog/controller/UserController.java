package com.keji.blog.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.admin.RoleService;
import com.keji.blog.service.admin.UserService;
import com.keji.blog.util.UserConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.user.UserQueryVO;
import com.keji.blog.vo.user.UserVO;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author keji
 * @version $Id: UserController.java, v 0.1 2018/3/18 下午2:48 keji Exp $
 */
@Controller
@RequestMapping("/adminuser")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String PHONE = "手机";
    private static final String DUPLICATE_OF_PHONE = "手机号被占用";
    private static final String EMAIL = "邮箱";
    private static final String DUPLICATE_OF_EMAIL = "邮箱被占用";


    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/login")
    public BaseResult login(UserVO userVO) {

        if (StringUtils.isEmpty(userVO.getEmail()) || StringUtils.isEmpty(userVO.getPassword())) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(userVO.getEmail(), userVO.getPassword(),
                userVO.getRememberMe());

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
    public PageResult<List<UserVO>> queryAllUser(@Valid UserQueryVO userQueryVO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.warn("参数校验不通过，错误信息：" + bindingResult);
            return PageResult.makeFail(bindingResult);
        }

        PageInfo<UserDO> pageInfo = null;
        List<UserVO> userVOS;
        try {
            pageInfo = userService.queryUserByPage(UserConvertUtil.userQueryVO2DO(userQueryVO), userQueryVO.getPageIndex(), userQueryVO.getPageSize());
            userVOS = UserConvertUtil.userDOS2VOS(pageInfo.getList());
        } catch (Exception e) {
            logger.error("查询用户失败,参数：" + userQueryVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return PageResult.makeSuccess(userVOS, pageInfo.getTotal(), pageInfo.getPages());
    }

    @ResponseBody
    @RequestMapping("/showUserInfo")
    public BaseResult showUserData() {
        UserDO userDO = (UserDO)SecurityUtils.getSubject().getPrincipal();
        if (userDO == null) {
            return BaseResult.makeFail(BaseErrorEnum.FORBIDDEN);
        }
        return BaseResult.makeSuccess(UserConvertUtil.userDO2VO(userDO));
    }

    @ResponseBody
    @RequestMapping("/showUserById")
    public BaseResult showUserById(Long id) {
        if (id == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        UserDO userDO ;
        UserVO userVO ;
        try {
            userDO = userService.queryUserById(id);
            List<RoleDO> roleDOS = roleService.findRoleByUserId(id);
            userVO = UserConvertUtil.userDO2VO(userDO);
            userVO.setRoleIdList(roleDOS.stream().map(RoleDO::getId).collect(Collectors.toList()));
        } catch (Exception e) {
            logger.error("根据id查询用户失败,id=" + id, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(userVO);

    }



    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public BaseResult save(@RequestBody UserVO userVO) {

        try {
            ValidatorUtils.validateEntity(userVO, AddGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        } catch (Exception e) {
            return BaseResult.makeFail(BaseErrorEnum.VALIDATE_PARAM_ERROR);
        }

        String menssage = validateDuplicateOfEmailAndphone(userVO);
        if (menssage != null) {
            return BaseResult.makeFail(menssage);
        }

        int i = userService.saveUser(UserConvertUtil.userVO2DO(userVO), userVO.getRoleIdList());

        if (i == 0) {
            return BaseResult.makeFail("新增失败，请重试");
        }

        return BaseResult.makeSuccess(i);
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(@RequestBody UserVO userVO) {

        try {
            ValidatorUtils.validateEntity(userVO, UpdateGroup.class, AddGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        } catch (Exception e) {
            logger.error("参数校验失败param:" + userVO, e);
            return BaseResult.makeFail(BaseErrorEnum.VALIDATE_PARAM_ERROR);
        }
        String menssage = validateDuplicateOfEmailAndphone(userVO);
        if (menssage != null) {
            return BaseResult.makeFail(menssage);
        }
        int i = 0;
        try {
            i = userService.updateUser(UserConvertUtil.userVO2DO(userVO));
        } catch (Exception e) {
            logger.error("更新用户失败,param:"+userVO,e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(i);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Long[] userIds) {

        int i = 0;
        try {
            i = userService.inValidateUser(userIds);
        } catch (Exception e) {
            logger.error("删除员工失败!",e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(i);
    }


    /**
     * 验证邮箱和手机的重复性
     *
     * @param userVO
     * @return
     */
    private String validateDuplicateOfEmailAndphone(UserVO userVO) {

        Boolean update = false;
        String message ;

        Map<String, String> map = Maps.newHashMap();
        if (userVO.getPhone() != null) {
            map.put(PHONE,userVO.getPhone());
        }
        if (userVO.getEmail() != null) {
            map.put(EMAIL, userVO.getEmail());
        }

        if (userVO.getId() != null) {
            update = true;
        }

        for (Entry<String, String> entry : map.entrySet()) {

            UserDO userDO = new UserDO();

            if (entry.getKey().equals(PHONE)) {
                message = DUPLICATE_OF_PHONE;
                userDO.setPhone(userVO.getPhone());
            }else {
                message = DUPLICATE_OF_EMAIL;
                userDO.setEmail(userVO.getEmail());
            }
            List<UserDO> userDOS = userService.selectUserByCondition(userDO);

            if (userDOS.size() > 0 && !update) {
                return message;
            } else if (userDOS.size() > 1 && update) {
                return message;
            } else if (userDOS.size() == 1 && update && !userVO.getId().equals(userDOS.get(0).getId())) {
                return message;
            }
        }
        return null;
    }
}
