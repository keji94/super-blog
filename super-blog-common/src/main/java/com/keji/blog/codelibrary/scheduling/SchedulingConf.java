package com.keji.blog.codelibrary.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * spring定时任务deomo,启动项目就开始执行拉。
 *
 * @author keji
 * @version $Id: SchedulingConf.java, v 0.1 2018/3/18 下午2:56 keji Exp $
 */
@Configuration
@EnableScheduling
public class SchedulingConf {

    //    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduler() {
        System.out.println("5秒执行一次...");
    }

}
