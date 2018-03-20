package com.keji.blog.config;

import java.util.Set;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * redis配置
 *
 * @author wb-ny291824
 * @version $Id: RedisConfiguration.java, v 0.1 2018-03-20 13:48 wb-ny291824 Exp $$
 */
@Component
public class RedisConfiguration {

    @Bean
    public JedisPool getJedisPool() {
        return new JedisPool("127.0.0.1");
    }

    @Bean
    public JedisCluster getJedisCluster() {

        Set<HostAndPort> hostAndPort = Sets.newHashSet();
        hostAndPort.add(new HostAndPort("127.0.0.1", 6345));
        hostAndPort.add(new HostAndPort("127.0.0.1", 6346));
        hostAndPort.add(new HostAndPort("127.0.0.1", 6347));

        return new JedisCluster(hostAndPort);
    }
}
