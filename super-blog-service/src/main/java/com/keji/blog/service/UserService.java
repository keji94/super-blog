package com.keji.blog.service;

import com.keji.blog.dataobject.UserDO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    UserDO showUserData(String userName);

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    UserDO selectUserByEamil(String email);
}
