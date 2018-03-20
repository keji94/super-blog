package com.keji.blog.util.cache;

import java.io.IOException;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.util.LogUtil;
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
     * @param key key
     * @param clazz 数据类型
     * @param cacheLoader 从数据库获取数据的实现
     * @param <T> 类型
     * @return t
     */
    public <T> T findData(String key, TypeReference<T> clazz, CacheLoader<T> cacheLoader) {

        String josn = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            josn = redisClient.get(key);
            if (StringUtils.isEmpty(josn)) {
                synchronized (this) {
                    if (StringUtils.isNotEmpty(josn)) {
                        return mapper.readValue(josn, clazz);
                    }

                    T t = cacheLoader.load();
                    redisClient.set(key, mapper.writeValueAsString(t));
                    return t;
                }
            }
            return mapper.readValue(josn, clazz);
        } catch (IOException e) {
            LogUtil.error(logger, "Json数据转换出现异常。key=%s,json=%s", key, josn);
            return null;
        }
    }

}
