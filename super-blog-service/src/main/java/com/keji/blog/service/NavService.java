package com.keji.blog.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.NavDO;

/**
 * @author wb-ny291824
 * @version $Id: NavService.java, v 0.1 2018-03-22 16:48 wb-ny291824 Exp $$
 */
public interface NavService {

    /**
     * 查询导航信息
     * @param navDO 查询条件
     * @param pageIndex 开始页
     * @param pageSize 结束页
     * @return PageInfo<NavDO>
     */
    PageInfo<NavDO> list(NavDO navDO, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有
     * @param navDO 条件
     * @return List<NavDO>
     */
    List<NavDO> listAll(NavDO navDO);

    /**
     * 修改
     * @param navDO record
     */
    void update(NavDO navDO);

    /**
     * 新增
     * @param navDO record
     */
    void insert(NavDO navDO);

    /**
     * 删除
     * @param ids id
     */
    void delete(Long[] ids);
}
