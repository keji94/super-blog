package com.keji.blog.service.admin.impl;

import com.keji.blog.dao.UserDAO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/20
 * @modified: By:
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDO selectUserSelective(UserDO userDO) {
        return userDAO.selectSelective(userDO);
    }
}
