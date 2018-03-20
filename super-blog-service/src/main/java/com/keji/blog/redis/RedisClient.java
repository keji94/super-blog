package com.keji.blog.redis;

/**
 * redis操作工具类
 *
 * @author wb-ny291824
 * @version $Id: RedisClient.java, v 0.1 2018-03-20 13:59 wb-ny291824 Exp $$
 */
public interface RedisClient {

    /**
     * 放缓存
     *
     * @param key   缓存的 key
     * @param value 缓存的value
     * @return 操作结果
     */
    String set(String key, String value);

    /**
     * 放缓存，并设置过期时间
     *
     * @param key   缓存的 key
     * @param value 缓存的value
     * @param seconds  过期时间(秒)
     * @return 操作结果
     */
    String set(String key, String value, int seconds);

    /**
     * 获取缓存
     *
     * @param key 缓存的key
     * @return 操作结果
     */
    String get(String key);

    /**
     * 是否存在当前key
     *
     * @param key 缓存的key
     * @return 操作结果
     */
    Boolean exists(String key);

    /**
     * 为已经存在的key设置过期时间
     *
     * @param key     缓存的key
     * @param seconds 秒
     * @return 操作结果
     */
    Long expire(String key, int seconds);

    /**
     * 查询当前key的过期时间，单位秒
     *
     * @param key 缓存的key
     * @return 操作结果
     */
    Long ttl(String key);

    /**
     * 将 key 中储存的数字值增一 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。
     *
     * @param key 缓存的key
     * @return 操作结果
     */
    Long incr(String key);

    /**
     * 将哈希表 key 中的域 field 的值设为 value，如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作
     *
     * @param key   缓存的key
     * @param field 域
     * @param value 缓存的value
     * @return 操作结果
     */
    Long hset(String key, String field, String value);

    /**
     * 返回哈希表 key 中给定域 field 的值。
     *
     * @param key   缓存的key
     * @param field 域
     * @return 操作结果
     */
    String hget(String key, String field);

    /**
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * @param key 缓存的key
     * @param field 域
     * @return 操作结果
     */
    Long hdel(String key, String... field);

}
