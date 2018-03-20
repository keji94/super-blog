package com.keji.blog.util.cache;

/**
 * 从数据库加载缓存的实现
 *
 * @author wb-ny291824
 * @version $Id: CacheLoader.java, v 0.1 2018-03-20 17:47 wb-ny291824 Exp $$
 */
public interface CacheLoader<T> {

    /**
     * 从数据库查询要放入缓存的数据
     * @return T
     */
    T load();

}
