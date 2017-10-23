package com.keji.blog.service.requirement;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.RequirementDO;
import com.keji.blog.result.PageResult;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
public interface RequirementService {

    /**
     * 查询所有需求
     * @param requirementDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<RequirementDO> query(RequirementDO requirementDO, Integer pageIndex, Integer pageSize);

    /**
     * 新增需求
     * @param requirementDO
     * @return
     */
    Integer save(RequirementDO requirementDO);

    /**
     * 更新需求
     * @param requirementDO
     * @return
     */
    Integer update(RequirementDO requirementDO);

}
