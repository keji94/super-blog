package com.keji.blog.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author: wb-ny291824
 * @Description  定时任务deomo,启动项目就开始执行拉。
 * @Date: Created in 2017/9/19
 * @Modified: By:
 */
@Configuration
@EnableScheduling
public class SchedulingConf {

//    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduler() {
        System.out.println("5秒执行一次...");
    }

}
