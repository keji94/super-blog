package com.keji.blog.dao;

import com.keji.blog.dataobject.RoleResourceRelDO;
import org.springframework.stereotype.Repository;

/**
 * @author wb-ny291824
 * @version $Id: RoleResourceRelDAO.java, v 0.1 2017-10-30 11:34 wb-ny291824 Exp $$
 */
@Repository
public interface RoleResourceRelDAO extends BaseDAO<RoleResourceRelDO, RoleResourceRelDO> {

    /**
     * 根据roleId删除
     *
     * @param roleId
     * @return
     */
    int deleteByRoleId(Long roleId);
}
