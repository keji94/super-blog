package com.keji.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement
@ImportResource(value = {"classpath:/WEB-INF/base-config.xml"})
@ServletComponentScan(basePackages = {"com.keji.blog.servlet"})
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testname() {
		String s = "[\\u4e00-\\u9fa5]{2,6}";
		String name = "聂毅";
		boolean matches = name.matches(s);
		System.out.println(matches);
	}

	@Test
	public void testPhone() {
		String regx = "^1[0-9]{10}$";
		String phone = "15271888457";
		System.out.println(phone.matches(regx));
	}

}
