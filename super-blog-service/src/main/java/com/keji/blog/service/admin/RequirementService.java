package com.keji.blog.service.admin;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.RequirementDO;


/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
public interface RequirementService {

    /**
     * 查询所有需求
     *
     * @param requirementDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<RequirementDO> query(RequirementDO requirementDO, Integer pageIndex, Integer pageSize);

    /**
     * 新增需求
     *
     * @param requirementDO
     * @return
     */
    Integer save(RequirementDO requirementDO);

    /**
     * 更新需求
     *
     * @param requirementDO
     * @return
     */
    Integer update(RequirementDO requirementDO);

    /**
     * 删除需求
     *
     * @param ids
     * @return
     */
    Integer delete(Long[] ids);

    /**
     * 根据id查找需求
     *
     * @param id
     * @return
     */
    RequirementDO queryById(Long id);

}
