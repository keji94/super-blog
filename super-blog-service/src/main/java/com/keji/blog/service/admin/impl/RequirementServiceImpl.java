package com.keji.blog.service.admin.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dao.RequirementDAO;
import com.keji.blog.dataobject.RequirementDO;
import com.keji.blog.service.admin.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author keji
 * @version $Id: RequirementServiceImpl.java, v 0.1 2018/4/24 下午6:44 keji Exp $
 */
@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementDAO requirementDAO;

    @Override
    public PageInfo<RequirementDO> query(RequirementDO requirementDO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<RequirementDO> requirementDOS = requirementDAO.selectByCondition(requirementDO);
        return new PageInfo<>(requirementDOS);
    }

    @Override
    public Integer save(RequirementDO requirementDO) {
        return requirementDAO.insert(requirementDO);
    }

    @Override
    public Integer update(RequirementDO requirementDO) {
        return requirementDAO.updateByPrimaryKeySelective(requirementDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long[] ids) {

        Integer count = 0;
        for (Long id : ids) {
            count = requirementDAO.deleteByPrimaryKey(id);
            count++;
        }

        return count;
    }

    @Override
    public RequirementDO queryById(Long id) {
        return requirementDAO.selectByPrimaryKey(id);
    }
}
