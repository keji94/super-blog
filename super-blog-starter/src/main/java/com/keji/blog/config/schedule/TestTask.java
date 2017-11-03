package com.keji.blog.config.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 定时任务类
 *
 * @author wb-ny291824
 * @version $Id: TestTask.java, v 0.1 2017-11-02 16:23 wb-ny291824 Exp $$
 */
@Component
public class TestTask {

    private Logger logger = LoggerFactory.getLogger(getClass());


    public void test() {
        logger.info("时间任务执行了...");
    }
}
