package com.keji.blog.service.resource;

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
     * @return
     */
    List<ResourceBO> getAllResource();

    /**
     * 根据roleCode获取资源
     * @param roleIds
     * @return
     */
    List<ResourceDO> getResoureceById(List<Long> roleIds);

    /**
     * 分页查询资源
     * @param resourceDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<ResourceDO> queryByPage(ResourceDO resourceDO, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有的资源，没有层级包含关系
     * @return
     */
    List<ResourceDO> list();

    /**
     * 查找没有按钮级别的资源
     * @return
     */
    List<ResourceDO> queryNoButtonResource();

}
