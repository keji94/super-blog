package com.keji.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 注解进行参数校验的配置
 *
 * @author wb-ny291824
 * @version $Id: ValidatorConfiguration.java, v 0.1 2017/10/31 11:24 wb-ny291824 Exp $
 */
@Configuration
public class ValidatorConfiguration {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}