package com.keji.blog.redis;

import java.util.List;

/**
 * 从数据库加载缓存的实现
 *
 * @author qinjiao
 * @version $Id: CacheLoader.java, v 0.1 2018-03-20 17:47 qinjiao Exp $$
 */
public interface CacheLoader<T> {

    /**
     * 查询要放入缓存的数据
     *
     * @param t 参数
     * @return List<T>
     */
    List<T> load(T t);

}
