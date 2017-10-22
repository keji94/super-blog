package com.keji.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dao.UserDAO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDO showUserData(String userName) {
        return null;
    }

    @Override
    public UserDO selectUserByEamil(String email) {
        UserDO userDO = new UserDO();
        userDO.setEmail(email);
        return userDAO.selectSelective(userDO);
    }

    @Override
    public PageResult<List<UserDO>> queryUserByPage(UserDO userDO, Integer pageIndex, Integer pageSize) {
        //TODO 分页插件没有测试成功
        PageHelper.startPage(pageIndex, pageSize);
        List<UserDO> userDOS = userDAO.selectByCondition(userDO);
        PageInfo<UserDO> pageInfo = new PageInfo<>(userDOS);
        PageResult<List<UserDO>> pageResult = new PageResult<>(userDOS, pageInfo.getTotal());
        return pageResult;
    }


}
