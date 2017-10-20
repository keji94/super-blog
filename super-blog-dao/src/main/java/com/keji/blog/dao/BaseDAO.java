package com.keji.blog.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
public interface BaseDAO<T,Q> {

    /**
     * 增加(所有属性)
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 增加(不为空的属性 )
     * @param record
     */
    int insertSelective(T record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);

    /**
     * 根据属性查询
     * @param record
     */
    T selectSelective(Q record);

    /**
     * 查询所有记录，带分页
     * @param record
     */
    List<T> selectByCondition(Q record);

    /**
     * 根据id更新不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
}
