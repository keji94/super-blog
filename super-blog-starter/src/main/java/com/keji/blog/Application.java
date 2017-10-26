package com.keji.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author: wb-ny291824
 * @description
 * 		@SpringBootApplication 开启组件扫描和自动配置，由以下三个注解组成
 * 	 						 @Configuration: 标明该类使用Spring基于Java的配置
 * 							 @ComponentScan: 启动组件扫描
 * 							 @EnableAutoConfiguration  开启springboot自动配置
 * 		@ServletComponentScan :扫描@WebListener和@WebFilter注解
 * @date: Created in 2017/9/20
 * @modified: By:
 * main() : 把程序在命令行当成一个可执行的jar运行
 */
@SpringBootApplication(scanBasePackages = {"com.keji.blog"})
@PropertySource(value = "classpath:application.yml")
@EnableTransactionManagement
@ImportResource(value = {"classpath:/WEB-INF/base-config.xml"})
@ServletComponentScan(basePackages = {"com.keji.blog.servlet"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
