package com.keji.blog.util;

import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.vo.role.RoleVO;

/**
 * @author wb-ny291824
 * @version $Id: RoleConvertUtil.java, v 0.1 2017-10-26 9:26 wb-ny291824 Exp $$
 */
public class RoleConvertUtil {

    private RoleConvertUtil() {
    }

    public static List<RoleVO> convertDOS2VOS(List<RoleDO> roleDOS) {

        List<RoleVO> roleVOS = Lists.newArrayList();

        roleDOS.forEach(roleDO -> {
            RoleVO roleVO = new RoleVO();
            roleVO.setId(roleDO.getId());
            roleVO.setRoleCode(roleDO.getRoleCode());
            roleVO.setRoleName(roleDO.getRoleName());
            roleVO.setStatus(roleDO.getStatus());
            roleVOS.add(roleVO);
        });
        return roleVOS;

    }

    public static RoleDO convertVO2DO(RoleVO roleVO) {

        RoleDO roleDO = new RoleDO();

        roleDO.setRoleCode(roleVO.getRoleCode());
        roleDO.setRoleName(roleVO.getRoleName());
        roleDO.setStatus(roleVO.getStatus());
        return roleDO;
    }

}
