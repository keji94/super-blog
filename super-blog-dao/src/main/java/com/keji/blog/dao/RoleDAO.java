package com.keji.blog.dao;

import com.keji.blog.dataobject.RoleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Repository
public interface RoleDAO extends BaseDAO<RoleDO,RoleDO> {

    /**
     * 根据userId查询user的所有角色
     * @param userId
     * @return
     */
    List<RoleDO> selectByUserId(Long userId);

}
