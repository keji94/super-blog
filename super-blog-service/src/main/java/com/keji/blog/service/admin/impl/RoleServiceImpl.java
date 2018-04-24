package com.keji.blog.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dao.RoleDAO;
import com.keji.blog.dao.RoleResourceRelDAO;
import com.keji.blog.dataobject.RoleDO;
import com.keji.blog.dataobject.RoleResourceRelDO;
import com.keji.blog.service.admin.RoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author keji
 * @version $Id: RoleServiceImpl.java, v 0.1 2018/4/24 下午6:45 keji Exp $
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private RoleResourceRelDAO roleResourceRelDAO;

    @Override
    public List<RoleDO> findAllRole() {
        return roleDAO.selectByCondition(new RoleDO());
    }

    @Override
    public PageInfo<RoleDO> queryByPage(RoleDO roleDO, Integer pageIndex, Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);

        List<RoleDO> roleDOS = roleDAO.selectByCondition(roleDO);

        return new PageInfo<>(roleDOS);
    }

    @Override
    public List<RoleDO> findRoleByUserId(Long userId) {
        return roleDAO.selectByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(RoleDO roleDO,List<Long> resourceIds) {

        //增加角色
        int count = roleDAO.insert(roleDO);
        //同步关联角色资源
        saveRoleResourceRel(roleDO.getId(), resourceIds);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(RoleDO roleDO, List<Long> resourceIdS) {

        int count = roleDAO.updateByPrimaryKeySelective(roleDO);

        //修改角色资源关系：先删除原来的，然后新增
        if (CollectionUtils.isNotEmpty(resourceIdS)) {
            roleResourceRelDAO.deleteByRoleId(roleDO.getId());
            saveRoleResourceRel(roleDO.getId(),resourceIdS);
        }
        return count;
    }

    private void saveRoleResourceRel(Long roleId, List<Long> resourceIds) {
        if (CollectionUtils.isNotEmpty(resourceIds)) {
            resourceIds.forEach(id->{
                RoleResourceRelDO roleResourceRelDO = new RoleResourceRelDO();
                roleResourceRelDO.setResourceId(id);
                roleResourceRelDO.setRoleId(roleId);
                roleResourceRelDAO.insert(roleResourceRelDO);
            });
        }
    }

    @Override
    public RoleDO queryById(Long id) {
        return roleDAO.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long[] ids) {

        Integer count = 0;
        for (Long id : ids) {
            roleResourceRelDAO.deleteByRoleId(id);
            count = roleDAO.deleteByPrimaryKey(id);
            count++;
        }
        return count;
    }
}
