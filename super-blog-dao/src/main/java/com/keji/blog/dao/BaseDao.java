package com.keji.blog.dao;

/**
 * Created by wb-ny291824 on 2017/6/28.
 */
public interface BaseDao<T,Q> {

    /**
     * 增加(所有属性)
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 增加(不为空的属性 )
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
     */
    T selectSelective(Q record);

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
