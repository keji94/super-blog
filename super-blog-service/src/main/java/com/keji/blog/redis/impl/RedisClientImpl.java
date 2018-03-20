package com.keji.blog.redis.impl;

import javax.annotation.Resource;

import com.keji.blog.redis.RedisClient;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis单机客户端
 *
 * @author wb-ny291824
 * @version $Id: RedisClientImpl.java, v 0.1 2018-03-20 14:19 wb-ny291824 Exp $$
 */
@Component("redisClient")
public class RedisClientImpl implements RedisClient {

    @Resource
    private JedisPool jedisPool;

    @Override
    public String set(String key, String value) {

        Jedis jedis = jedisPool.getResource();
        String result;
        try {
            result = jedis.set(key, value);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public String set(String key, String value, int seconds) {
        Jedis jedis = jedisPool.getResource();
        String result;
        try {
            result = jedis.setex(key, seconds, value);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String result;
        try {
            result = jedis.get(key);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean result;
        try {
            result = jedis.exists(key);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long result;
        try {
            result = jedis.expire(key, seconds);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result;
        try {
            result = jedis.ttl(key);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result;
        try {
            result = jedis.incr(key);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result;
        try {
            result = jedis.incr(key);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String result;
        try {
            result = jedis.hget(key,field);
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        Jedis jedis = jedisPool.getResource();
        Long result;
        try {
            result = jedis.hdel(key);
        } finally {
            jedis.close();
        }
        return result;
    }
}
