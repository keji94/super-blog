package com.keji.blog.redis.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.redis.CacheLoader;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.util.LogUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * @author qinjiao
 * @since 2018/4/23
 */
@Service
public class CacheServiceImpl implements CacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Resource
    private RedisClient redisClient;

    @Override
    public <T> T findObject(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition) {

        String json = null;
        try {
            json = redisClient.get(key);
            if (StringUtils.isNotEmpty(json)) {
                return JsonUtil.json2Object(json, valueType);
            }

            List<T> list = cacheLoader.load(condition);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            redisClient.set(key, JsonUtil.object2Json(list.get(0)));
            return list.get(0);
        } catch (IOException e) {
            LogUtil.error(LOGGER, e, "Json数据转换出现异常。key=%s,json=%s", key, json);
            return null;
        }
    }

    @Override
    public <T> T findObjectSafety(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition) {

        String json = null;
        try {
            json = redisClient.get(key);
            if (StringUtils.isEmpty(json)) {
                synchronized (this) {
                    if (StringUtils.isNotEmpty(json)) {
                        return JsonUtil.json2Object(json, valueType);
                    }

                    List<T> list = cacheLoader.load(condition);
                    if (CollectionUtils.isEmpty(list)) {
                        return null;
                    }
                    redisClient.set(key, JsonUtil.object2Json(list.get(0)));

                    return list.get(0);
                }
            }
            return JsonUtil.json2Object(json, valueType);
        } catch (IOException e) {
            LogUtil.error(LOGGER, e, "Json数据转换出现异常。key=%s,json=%s", key, json);
            return null;
        }
    }

    @Override
    public <T> List<T> findList(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition) {

        String json = null;
        try {
            json = redisClient.get(key);
            if (StringUtils.isNotEmpty(json)) {
                return JsonUtil.json2List(json, valueType);
            }

            List<T> list = cacheLoader.load(condition);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            redisClient.set(key, JsonUtil.object2Json(list));
            return list;
        } catch (IOException e) {
            LogUtil.error(LOGGER, "Json数据转换出现异常。key=%s,json=%s", key, json);
            return null;
        }
    }

    @Override
    public <T> List<T> findListSafety(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition) {

        String json = null;
        try {
            json = redisClient.get(key);
            if (StringUtils.isEmpty(json)) {
                synchronized (this) {
                    if (StringUtils.isNotEmpty(json)) {
                        return JsonUtil.json2List(json, valueType);
                    }

                    List<T> list = cacheLoader.load(condition);
                    redisClient.set(key, JsonUtil.object2Json(list));
                    return list;
                }
            }
            return JsonUtil.json2List(json, valueType);
        } catch (IOException e) {
            LogUtil.error(LOGGER, "Json数据转换出现异常。key=%s,json=%s", key, json);
            return null;
        }
    }

}
