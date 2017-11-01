package com.keji.blog.dao;

import java.util.List;

/**
 * 基础的DAO类，里面是一些共有的方法
 *
 * @author wb-ny291824
 * @version $Id: BaseDAO.java, v 0.1 2017/11/1 14:11 wb-ny291824 Exp $
 */
public interface BaseDAO<T, Q> {

    /**
     * 增加(所有属性)
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 增加(不为空的属性 )
     *
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);

    /**
     * 根据属性查询
     *
     * @param record
     * @return
     */
    T selectSelective(Q record);

    /**
     * 查询所有记录，带分页
     *
     * @param record
     * @return
     */
    List<T> selectByCondition(Q record);

    /**
     * 根据id更新不为空的字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
}
