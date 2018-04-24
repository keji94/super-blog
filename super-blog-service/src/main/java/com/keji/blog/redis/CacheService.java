package com.keji.blog.redis;

import java.util.List;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * 缓存服务
 *
 * @author qinjiao
 * @since 2018/4/23
 */
public interface CacheService {

    /**
     * 从缓存中获取数据，没有则从数据库获取
     *
     * @param key         key
     * @param valueType   数据类型
     * @param cacheLoader 获取数据的实现
     * @param condition   查询条件
     * @param <T>         类型
     * @return t
     */
    <T> T findObject(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition);

    /**
     * 从缓存中获取数据，没有则从数据库获取,对缓存击穿处理
     *
     * @param key         key
     * @param valueType   数据类型
     * @param cacheLoader 获取数据的实现
     * @param condition   查询条件
     * @param <T>         类型
     * @return t
     */
    <T> T findObjectSafety(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition);


    /**
     * 从缓存中获取集合数据，没有则从数据库获取
     *
     * @param <T>         类型
     * @param key         key
     * @param valueType   数据类型
     * @param cacheLoader 从数据库获取数据的实现
     * @param condition   查询条件
     * @return t
     */
    <T> List<T> findList(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition);


    /**
     * 从缓存中获取集合数据，没有则从数据库获取,对缓存击穿处理
     *
     * @param <T>         类型
     * @param key         key
     * @param valueType   数据类型
     * @param cacheLoader 从数据库获取数据的实现
     * @param condition   查询条件
     * @return t
     */
    <T> List<T> findListSafety(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition);

}
