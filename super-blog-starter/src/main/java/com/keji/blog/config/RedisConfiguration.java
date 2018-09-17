package com.keji.blog.config;

import java.util.Set;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis配置
 *
 * @author wb-ny291824
 * @version $Id: RedisConfiguration.java, v 0.1 2018-03-20 13:48 wb-ny291824 Exp $$
 */
@Configuration
@PropertySource("classpath:application.yml")
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private String timeout;

    @Bean
    public JedisPool getJedisPool() {

        return new JedisPool(new JedisPoolConfig(),host,port,3000,password);
    }

    @Bean
    public JedisPoolConfig getJedisPoolConfig() {
        return new JedisPoolConfig();
    }
    /**
     * 未用到
     * @return JedisCluster
     */
    @Bean
    public JedisCluster getJedisCluster() {

        Set<HostAndPort> hostAndPort = Sets.newHashSet();
        hostAndPort.add(new HostAndPort(host, 6345));
        hostAndPort.add(new HostAndPort(host, 6346));
        hostAndPort.add(new HostAndPort(host, 6347));

        return new JedisCluster(hostAndPort);
    }
}
