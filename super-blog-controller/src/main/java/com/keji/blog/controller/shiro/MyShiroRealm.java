package com.keji.blog.controller.shiro;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.ResourceDAO;
import com.keji.blog.dao.RoleDAO;
import com.keji.blog.dao.UserRoleRelDAO;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.dataobject.UserRoleRelDO;
import com.keji.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: wb-ny291824
 * @description shiro身份验证核心类
 * @date: Created in 2017/10/19
 * @modified: By:
 */
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private ResourceDAO resourceDAO;

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 获取当前登陆用户 ，根据当前登陆用户，查询对应角色信息
        Subject subject = SecurityUtils.getSubject();
        UserDO user = (UserDO) subject.getPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (user.getEmail().equals(BlogConstants.ADMIN_USER_NAME)) {
            // 如果admin ，查询所有角色和所有权限
            List<RoleDO> roles = roleDAO.selectByCondition(new RoleDO());
            roles.forEach(roleDO -> authorizationInfo.addRole(roleDO.getRoleCode()));
            List<ResourceDO> resourceDOS = resourceDAO.selectByCondition(new ResourceDO());
            resourceDOS.forEach(resourceDO -> authorizationInfo.addStringPermission(resourceDO.getResourceCode()));
        } else {
            // 普通用户 ， 根据当前用户，查询具有角色，通过角色获取权限
            List<RoleDO> roles = roleDAO.selectByUserId(user.getId());
            // 添加角色
            roles.forEach(
                    roleDO -> {
                        authorizationInfo.addRole(roleDO.getRoleCode());
                        List<ResourceDO> resourceDOS = resourceDAO.selectByRoleId(roleDO.getId());
                        List<String> resourceCodes = resourceDOS.stream().map(ResourceDO::getResourceCode).collect(Collectors.toList());
                        authorizationInfo.addStringPermissions(resourceCodes);
                    }
            );
        }
        return authorizationInfo;
    }

    /**
     * 获取认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String email = usernamePasswordToken.getUsername();

        UserDO userDO = userService.selectUserByEamil(email);
        if (userDO == null) {
            return null;
        }
        //2 返回AuthenticationInfo对象
        //将当前查询到的用户对象放入SimpleAuthenticationInfo中，可以通过subject获得
        Object principal = userDO;
        //密码，shiro负责比较查询到的密码和用户输入的密码是否一致
        Object credentials = userDO.getPassword();
        String realmName = super.getName();
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userDO, userDO.getPassword(), super.getName());
        return authenticationInfo;

    }
}
