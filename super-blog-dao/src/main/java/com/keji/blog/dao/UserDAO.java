package com.keji.blog.dao;

import java.util.List;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.UserDO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wb-ny291824
 * @version $Id: TextSettingsDAO.java, v 0.1 2018/3/20 10:09 wb-ny291824 Exp $
 */
@Repository
public interface UserDAO extends BaseDAO<UserDO,UserDO> {

    /**
     * 查询用户拥有的资源
     * @param userId
     * @return
     */
   List<ResourceDO> selectUserPermission(Long userId);

}