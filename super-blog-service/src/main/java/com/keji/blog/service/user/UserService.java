package com.keji.blog.service.user;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.UserDO;
import java.util.List;

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

    /**
     * 分页查询用户
     * @param userDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<UserDO> queryUserByPage(UserDO userDO, Integer pageIndex, Integer pageSize);

    /**
     * 查询用户的所有资源
     * @param userId
     * @return
     */
    List<ResourceDO> selectUserPermissions(Long userId);

}
