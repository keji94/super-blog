package com.keji.blog.dao;

import com.keji.blog.dataobject.RoleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wb-ny291824
 * @version $Id: TextSettingsDAO.java, v 0.1 2018/3/20 10:09 wb-ny291824 Exp $
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
