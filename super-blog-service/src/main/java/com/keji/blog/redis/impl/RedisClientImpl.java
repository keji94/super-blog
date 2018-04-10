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
        String result;
        //1.7引入的try-with-resource 它会自动关闭实现了Closable接口的类中的close()方法。jedis的close()会将jedis放回池中
        try(Jedis jedis = jedisPool.getResource()){
            result = jedis.set(key, value);
        }
        return result;
    }

    @Override
    public String set(String key, String value, int seconds) {

        String result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.setex(key, seconds, value);
        }
        return result;
    }

    @Override
    public String get(String key) {
        String result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.get(key);
        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Boolean result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.exists(key);
        }
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        Long result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.expire(key, seconds);
        }
        return result;
    }

    @Override
    public Long ttl(String key) {
        Long result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.ttl(key);
        }
        return result;
    }

    @Override
    public Long incr(String key) {
        Long result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.incr(key);
        }
        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Long result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.incr(key);
        }
        return result;
    }

    @Override
    public String hget(String key, String field) {
        String result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.hget(key,field);
        }
        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        Long result;
        try(Jedis jedis = jedisPool.getResource()) {
            result = jedis.hdel(key);
        }
        return result;
    }
}
