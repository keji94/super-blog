package com.keji.blog.redis;

/**
 * redis分布式锁实现
 *
 * @author keji
 * @version $Id: RedisLockService.java, v 0.1 2018-04-09 下午1:29 keji Exp $$
 */
public interface RedisLockService {

    /**
     * 加锁
     * @param key key
     * @return 是否成功
     */
    Boolean setLock(String key);

    /**
     * 释放锁
     * @param key key
     * @return 是否成功
     */
    Boolean releaseLock(String key);

}
