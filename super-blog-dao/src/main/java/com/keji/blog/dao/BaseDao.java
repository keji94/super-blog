package com.keji.blog.dao;

import java.util.List;

/**
 * Created by wb-ny291824 on 2017/6/28.
 */
public interface BaseDao<T,Q> {
    int insert(T objectData);

    int update(T objectData);

    int deleteById(long id);

    T getById(long id);

    List<T> queryByPage(Q query);

    List<T> getAll();

    int count(Q query);

    int batchInsert(final List<T> dataObjectList);

    void deleteByQuery(Q query);

}
