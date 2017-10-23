package com.keji.blog.service.role;

import com.keji.blog.dataobject.RoleDO;

import java.util.List;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
public interface RoleService {
    /**
     * 查找所有的角色
     * @return
     */
    List<RoleDO> findAllRole();
}
