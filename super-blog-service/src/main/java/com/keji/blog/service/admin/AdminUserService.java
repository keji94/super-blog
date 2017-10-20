package com.keji.blog.service.admin;

import com.keji.blog.dataobject.UserDO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/20
 * @modified: By:
 */
public interface AdminUserService {

    /**
     * 按条件查询
     * @param userDO
     * @return
     */
    UserDO selectUserSelective(UserDO userDO);
}
