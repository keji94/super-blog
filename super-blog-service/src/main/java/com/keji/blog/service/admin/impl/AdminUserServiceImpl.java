package com.keji.blog.service.admin.impl;

import com.keji.blog.dao.BlogUserDAO;
import com.keji.blog.dataobject.BlogUserDO;
import com.keji.blog.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wb-ny291824
 * @Description
 * @Date: Created in 2017/9/20
 * @Modified: By:
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private BlogUserDAO userDAO;

    @Override
    public BlogUserDO selectUserSelective(BlogUserDO userDO) {
        return userDAO.selectSelective(userDO);
    }
}
