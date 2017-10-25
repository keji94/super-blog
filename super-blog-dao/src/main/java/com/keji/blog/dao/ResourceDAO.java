package com.keji.blog.dao;

import com.keji.blog.bo.ResourceBO;
import com.keji.blog.dataobject.ResourceDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Repository
public interface ResourceDAO extends BaseDAO<ResourceDO,ResourceDO>{

    /**
     * 根据roleId 获取其对应的权限
     * @param roleId
     * @return
     */
    List<ResourceDO> selectByRoleId(Long roleId);

    /**
     * 根据parentId查询资源
     * @param parentId
     * @return
     */
    List<ResourceBO> selectByParentId(Long parentId);


}
