package com.keji.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @SpringBootApplication 开启组件扫描和自动配置，由以下三个注解组成
 * 							 @Configuration: 标明该类使用Spring基于Java的配置
 * 							 @ComponentScan: 启动组件扫描
 * 							 @EnableAutoConfiguration  开启springboot自动配置
 * main() : 把程序在命令行当成一个可执行的jar运行
 */
@SpringBootApplication(scanBasePackages = {"com.keji.blog"})
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement
@ImportResource(value = {"classpath:/WEB-INF/mybatis-conf.xml"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
