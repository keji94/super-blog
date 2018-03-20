package com.keji.blog.redis.impl;

import javax.annotation.Resource;

import com.keji.blog.redis.RedisClient;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * redis客户端集群实现类
 *
 * @author wb-ny291824
 * @version $Id: RedisClientClusterImpl.java, v 0.1 2018-03-20 14:38 wb-ny291824 Exp $$
 */
@Component("redisClientCluster")
public class RedisClientClusterImpl implements RedisClient{

    @Resource
    private JedisCluster jedisCluster;

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String set(String key, String value, int seconds) {
        return jedisCluster.setex(key, seconds, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return jedisCluster.exists(key);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedisCluster.expire(key,seconds);
    }

    @Override
    public Long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public Long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value);
    }

    @Override
    public String hget(String key, String field) {
        return jedisCluster.hget(key,field);
    }

    @Override
    public Long hdel(String key, String... field) {
        return jedisCluster.hdel(key,field);
    }
}
