package com.keji.blog.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.TagDO;

/**
 * @author wb-ny291824
 * @version $Id: NavService.java, v 0.1 2018-03-22 16:48 wb-ny291824 Exp $$
 */
public interface TagService {

    /**
     * 查询导航信息
     * @param tagDO 查询条件
     * @param pageIndex 开始页
     * @param pageSize 结束页
     * @return PageInfo<TagDO>
     */
    PageInfo<TagDO> list(TagDO tagDO, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有
     * @param tagDO 条件
     * @return List<TagDO>
     */
    List<TagDO> listAll(TagDO tagDO);

    /**
     * 更新
     *
     * @param tagDO tagDO
     * @throws JsonProcessingException json缓存异常
     */
    void update(TagDO tagDO) throws JsonProcessingException;

    /**
     * 新增
     *
     * @param tagDO record
     * @throws JsonProcessingException json缓存异常
     */
    void insert(TagDO tagDO) throws JsonProcessingException;

    /**
     * 删除
     *
     * @param ids ids
     * @throws JsonProcessingException json缓存异常
     */
    void delete(Long[] ids) throws JsonProcessingException;

    /**
     * 查询热门标签
     * @return return
     */
    List<TagDO> queryHotTag();
}
