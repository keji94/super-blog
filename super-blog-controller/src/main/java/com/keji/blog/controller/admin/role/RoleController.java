package com.keji.blog.controller.admin.role;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.resource.ResourceService;
import com.keji.blog.service.role.RoleService;
import com.keji.blog.util.RoleConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.vo.role.RoleQueryVO;
import com.keji.blog.vo.role.RoleVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wb-ny291824
 * @version $Id: RoleController.java, v 0.1 2017-10-26 9:19 wb-ny291824 Exp $$
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @ResponseBody
    @RequestMapping("/querywithoutpage")
    public PageResult<List<RoleVO>> query() {

        List<RoleDO> roleDOS;
        List<RoleVO> roleVOS;

        try {
            roleDOS = roleService.findAllRole();
            roleVOS = RoleConvertUtil.convertDOS2VOS(roleDOS);
        } catch (Exception e) {
            logger.error("查询角色失败", e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return PageResult.makeSuccess(roleVOS);

    }

    @ResponseBody
    @RequestMapping("/queryByPage")
    public PageResult<List<RoleDO>> queryByPage(RoleQueryVO queryVO) {

        try {
            ValidatorUtils.validateEntity(queryVO, QueryGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(e.getMsg());
        } catch (Exception e) {
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        PageInfo<RoleDO> pageInfo;
        RoleDO roleDO = new RoleDO();
        try {
            if (StringUtils.isNotBlank(queryVO.getRoleName())) {
                roleDO.setRoleName(queryVO.getRoleName());
            }

            pageInfo = roleService.queryByPage(roleDO, queryVO.getPageIndex(), queryVO.getPageSize());
        } catch (Exception e) {
            logger.error("角色查询失败", e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return PageResult.makeSuccess(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPages());
    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult save(@RequestBody RoleVO roleVO) {

        try {
            ValidatorUtils.validateEntity(roleVO, AddGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        }

        Integer count = null;
        try {
            count = roleService.save(RoleConvertUtil.convertVO2DO(roleVO), roleVO.getResourceIdS());
        } catch (Exception e) {
            logger.error("新增角色失败,param:" + roleVO, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(count);
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(@RequestBody RoleVO roleVO) {

        try {
            ValidatorUtils.validateEntity(roleVO, AddGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        }

        Integer count;
        try {
            count = roleService.update(RoleConvertUtil.convertVO2DO(roleVO), roleVO.getResourceIdS());
        } catch (Exception e) {
            logger.error("更新角色失败,param:" + roleVO, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(count);
    }

    @ResponseBody
    @RequestMapping("/info")
    public BaseResult roleInfo(Long id) {
        if (id == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        RoleDO roleDO;
        RoleVO roleVO;
        try {
            roleDO = roleService.queryById(id);
            roleVO = RoleConvertUtil.convertDO2VO(roleDO);
            List<ResourceDO> resourceDOS = resourceService.getResoureceByRoleId(id);
            roleVO.setResourceIdS(resourceDOS.stream().map(ResourceDO::getId).collect(Collectors.toList()));
        } catch (Exception e) {
            logger.error("根据Id查询role失败，id：" + id, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(roleVO);

    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Long[] roleIds) {
        if (roleIds == null || roleIds.length <= 0) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            roleService.delete(roleIds);
        } catch (Exception e) {
            logger.error("删除角色失败，id：" + Arrays.toString(roleIds), e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess();

    }

}
