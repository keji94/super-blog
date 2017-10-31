package com.keji.blog.service.requirement.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dao.RequirementDAO;
import com.keji.blog.dataobject.RequirementDO;
import com.keji.blog.service.requirement.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementDAO requirementDAO;

    @Override
    public PageInfo<RequirementDO> query(RequirementDO requirementDO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<RequirementDO> requirementDOS = requirementDAO.selectByCondition(requirementDO);
        PageInfo<RequirementDO> pageInfo = new PageInfo<>(requirementDOS);
        return new PageInfo<RequirementDO>(requirementDOS);
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
