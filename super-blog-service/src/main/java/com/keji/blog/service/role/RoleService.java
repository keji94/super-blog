package com.keji.blog.service.role;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.dto.RoleDTO;

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
     *
     * @return
     */
    List<RoleDO> findAllRole();

    /**
     * 分页查询角色
     *
     * @param roleDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<RoleDO> queryByPage(RoleDO roleDO, Integer pageIndex, Integer pageSize);

    /**
     * 根据用户Id查询角色
     *
     * @param userId
     * @return
     */
    List<RoleDO> findRoleByUserId(Long userId);

    /**
     * 新增角色
     *
     * @param roleDO
     * @param resourceIds
     * @return
     */
    Integer save(RoleDO roleDO, List<Long> resourceIds);

    /**
     * 更新角色
     *
     * @param roleDO
     * @param resourceIdS
     * @return
     */
    Integer update(RoleDO roleDO, List<Long> resourceIdS);

    /**
     * 根据Id查询role
     *
     * @param id
     * @return
     */
    RoleDO queryById(Long id);

    /**
     * 删除角色
     *
     * @param ids
     * @return
     */
    Integer delete(Long[] ids);
}
