package com.keji.blog.util.cache;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.redis.RedisClient;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.util.LogUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 缓存查询模板，封装对缓存击穿的处理
 *
 * @author wb-ny291824
 * @version $Id: CacheTemplate.java, v 0.1 2018-03-20 17:46 wb-ny291824 Exp $$
 */
@Component
public class CacheTemplate {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RedisClient redisClient;

    /**
     * 从缓存中获取数据，没有则从数据库获取
     * @param <T> 类型
     * @param key key
     * @param valueType 数据类型
     * @param cacheLoader 从数据库获取数据的实现
     * @return t
     */
    public <T> T findObject(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition) {

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
            LogUtil.error(logger, e,"Json数据转换出现异常。key=%s,json=%s", key, json);
            return null;
        }
    }

    /**
     * 从缓存中获取数据，没有则从数据库获取
     * @param <T> 类型
     * @param key key
     * @param valueType 数据类型
     * @param cacheLoader 从数据库获取数据的实现
     * @return t
     */
    public <T> List<T> findList(String key, Class<T> valueType, CacheLoader<T> cacheLoader, T condition) {

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
            LogUtil.error(logger, "Json数据转换出现异常。key=%s,json=%s", key, json);
            return null;
        }
    }

}
