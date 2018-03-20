package com.keji.blog.service.admin;

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
     * 根据id查询用户
     * @param id
     * @return
     */
    UserDO queryUserById(Long id);

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    UserDO selectUserByEamil(String email);

    /**
     * 按条件查询用户(id,email,name,phone)
     * @param userDO
     * @return
     */
    List<UserDO> selectUserByCondition(UserDO userDO);

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

    /**
     * 新增用户
     * @param userDO
     * @param roleIds
     * @return
     */
    int saveUser(UserDO userDO,List<Long> roleIds);

    /**
     * 更新用户
     * @param userDO
     * @return
     */
    int updateUser(UserDO userDO);

    /**
     * 禁用用户
     * @param ids
     * @return
     */
    int inValidateUser(Long[] ids);
}
