package com.keji.blog.redis;

import java.io.Serializable;

import javax.annotation.Resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keji.blog.ApplicationTests;
import com.keji.blog.dataobject.UserDO;
import org.junit.Test;

/**
 * @author wb-ny291824
 * @version $Id: RedisClientTest.java, v 0.1 2018-03-20 14:51 wb-ny291824 Exp $$
 */
public class RedisClientTest extends ApplicationTests {

    @Resource
    private RedisClient redisClient;

    @Test
    public void test() throws Exception{
        redisClient.set("key", "value");
        String s = redisClient.get("key");
        System.out.println(s);

        UserDO userDO = new UserDO();
        userDO.setName("克己");
        userDO.setId(1L);
        userDO.setEmail("798631828@qq.com");

        ObjectMapper mapper = new ObjectMapper();
        String s1 = mapper.writeValueAsString(userDO);
        JsonNode jsonNode = mapper.readTree(s1);
        UserDO userDO1 = mapper.readValue(s1, UserDO.class);
        System.out.println(s1);
        System.out.println(userDO1);
    }
}
