package com.keji.blog.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.keji.blog.bo.ResourceBO;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.resource.ResourceService;
import com.keji.blog.service.role.RoleService;
import com.keji.blog.util.ResourceConvertUtil;
import com.keji.blog.vo.resource.ResourceVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/24
 * @modified: By:
 */
@Controller
@RequestMapping("/system")
public class SystemMenuController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/showNav")
    public BaseResult showNav() {

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return BaseResult.makeFail(BaseErrorEnum.FORBIDDEN);
        }

        ArrayList<ResourceVO> resourceVOS = Lists.newArrayList();

        if (subject.hasRole("admin")) {

            List<ResourceBO> resourceBOS = null;
            try {
                resourceBOS = resourceService.getAllResource();
            } catch (Exception e) {
                logger.error("查询所有资源失败",e);
                return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
            }
            return BaseResult.makeSuccess(resourceBOS);
        }
       UserDO userDO = (UserDO)subject.getPrincipal();

        List<RoleDO> roleDOS = roleService.findRoleByUserId(userDO.getId());

        List<ResourceDO> resourceDOS = null;
        try {
            resourceDOS = resourceService.getResoureceByRoleIds(
                roleDOS.stream().map(RoleDO::getId).collect(Collectors.toList()));
        } catch (Exception e) {
            logger.error("根据角色查询资源失败",e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(ResourceConvertUtil.convertDOS2VOS(resourceDOS));
    }
}
