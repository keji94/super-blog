package com.keji.blog.redis.impl;

import java.util.UUID;

import javax.annotation.Resource;

import com.keji.blog.redis.RedisLockService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author keji
 * @version $Id: RedisLockServiceImpl.java, v 0.1 2018-04-09 下午1:32 keji Exp $$
 */
public class RedisLockServiceImpl implements RedisLockService{

    /**
     * 加锁成功返回结果
     */
    private static final String LOCK_SUCCESS = "OK";

    /**
     * 释放成功返回结果
     */
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 当key不存在时，进行set操作；若key已经存在，则不做任何操作
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * 意思是要给这个key加一个过期的设置，具体时间由第五个参数决定
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    @Resource
    private JedisPool jedisPool;

    @Override
    public Boolean setLock(String key) {

        String result;
        try(Jedis jedis = jedisPool.getResource()){
            result = jedis.set(key, UUID.randomUUID().toString(), SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 60);
        }

        if (!LOCK_SUCCESS.equals(result)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean releaseLock(String key) {

        //lua语言：首先获取锁对应的value值，检查是否与requestId相等，如果相等则删除锁（解锁）。确保上述操作是原子性的
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        Object result;
        try(Jedis jedis = jedisPool.getResource()){
            result = jedis.eval(script);
        }
        if (!RELEASE_SUCCESS.equals(result)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
