package com.keji.blog.dao;

import java.util.List;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
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