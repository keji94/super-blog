package com.keji.blog.service.role.impl;

import com.keji.blog.dao.RoleDAO;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<RoleDO> findAllRole() {
        return roleDAO.selectByCondition(new RoleDO());
    }

    @Override
    public List<RoleDO> findRoleByUserId(Long userId) {
        return roleDAO.selectByUserId(userId);
    }
}
