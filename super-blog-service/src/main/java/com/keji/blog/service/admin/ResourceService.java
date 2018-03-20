package com.keji.blog.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.bo.ResourceBO;
import com.keji.blog.dataobject.ResourceDO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/24
 * @modified: By:
 */
public interface ResourceService {

    /**
     * 获取所有的资源,父资源包含子资源
     *
     * @return
     */
    List<ResourceBO> getAllResource();

    /**
     * 根据多个roleId获取资源
     *
     * @param roleIds
     * @return
     */
    List<ResourceDO> getResoureceByRoleIds(List<Long> roleIds);

    /**
     * 根据roleId获取资源
     *
     * @param roleId
     * @return
     */
    List<ResourceDO> getResoureceByRoleId(Long roleId);


    /**
     * 分页查询资源
     *
     * @param resourceDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<ResourceDO> queryByPage(ResourceDO resourceDO, Integer pageIndex, Integer pageSize);

    /**
     * 根据id查找资源
     *
     * @param id
     * @return
     */
    ResourceDO queryById(Long id);

    /**
     * 查询所有的资源，没有层级包含关系
     *
     * @return
     */
    List<ResourceDO> list();

    /**
     * 查找没有按钮级别的资源
     *
     * @return
     */
    List<ResourceDO> queryNoButtonResource();

    /**
     * 新增资源
     *
     * @param resourceDO
     * @return
     */
    Integer save(ResourceDO resourceDO);

    /**
     * 更新资源
     *
     * @param resourceDO
     * @return
     */
    Integer update(ResourceDO resourceDO);

    /**
     * 删除资源，同步删除其子资源
     *
     * @param id
     * @return
     */
    Integer remove(Long id);

}
