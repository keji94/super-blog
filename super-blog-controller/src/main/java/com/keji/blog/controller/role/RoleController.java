package com.keji.blog.controller.role;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.role.RoleService;
import com.keji.blog.util.RoleConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.vo.BaseQueryVO;
import com.keji.blog.vo.role.RoleVO;
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
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

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
    @RequestMapping("queryByPage")
    public PageResult<List<RoleDO>> queryByPage(BaseQueryVO queryVO) {

        try {
            ValidatorUtils.validateEntity(queryVO, QueryGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(e.getMsg());
        } catch (Exception e) {
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        PageInfo<RoleDO> pageInfo ;
        try {
            pageInfo = roleService.queryByPage(new RoleDO(), queryVO.getPageIndex(),
                    queryVO.getPageSize());
        } catch (Exception e) {
            logger.error("角色查询失败",e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return PageResult.makeSuccess(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPages());
    }


}
