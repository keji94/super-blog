package com.keji.blog.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dao.UserDAO;
import com.keji.blog.dao.UserRoleRelDAO;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.dataobject.UserRoleRelDO;
import com.keji.blog.enums.BlogStatusEnum;
import com.keji.blog.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

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
    @Autowired
    private UserRoleRelDAO userRoleRelDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public UserDO queryUserById(Long id) {
        return userDAO.selectByPrimaryKey(id);
    }

    @Override
    public UserDO selectUserByEamil(String email) {
        UserDO userDO = new UserDO();
        userDO.setEmail(email);
        return userDAO.selectSelective(userDO);
    }

    @Override
    public PageInfo<UserDO> queryUserByPage(UserDO userDO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<UserDO> userDOS = userDAO.selectByCondition(userDO);
        PageInfo<UserDO> pageInfo = new PageInfo<>(userDOS);
        return pageInfo;
    }

    @Override
    public List<ResourceDO> selectUserPermissions(Long userId) {
        return userDAO.selectUserPermission(userId);
    }

    @Override
    public int saveUser(UserDO userDO, List<Long> roleIds) {

        return transactionTemplate.execute(status -> {

            int count = 0;
            try {

                count = userDAO.insert(userDO);
                roleIds.forEach(roleId -> {
                    UserRoleRelDO userRoleRelDO = new UserRoleRelDO();
                    userRoleRelDO.setUserId(userDO.getId());
                    userRoleRelDO.setRoleId(roleId);
                    userRoleRelDAO.insert(userRoleRelDO);
                });
            } catch (Exception e) {
                logger.error("新增用户service发生异常", e);
                status.setRollbackOnly();
                return 0;
            }
            return count;
        });
    }

    @Override
    public List<UserDO> selectUserByCondition(UserDO userDO) {
        return userDAO.selectByCondition(userDO);
    }

    @Override
    public int updateUser(UserDO userDO) {
        return userDAO.updateByPrimaryKeySelective(userDO);
    }

    @Override
    public int inValidateUser(Long[] ids) {
       return transactionTemplate.execute(status -> {
            try {
                for (Long id : ids) {
                    UserDO userDO = new UserDO();
                    userDO.setId(id);
                    userDO.setStatus(BlogStatusEnum.STOP_USE.getKey());
                    userDAO.updateByPrimaryKeySelective(userDO);
                }
            } catch (Exception e) {
                status.setRollbackOnly();
                return 0;
            }
           return ids.length;
        });
    }
}
