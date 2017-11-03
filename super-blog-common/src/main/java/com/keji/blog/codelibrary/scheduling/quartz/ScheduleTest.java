package com.keji.blog.codelibrary.scheduling.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleTest.java, v 0.1 2017-11-02 16:46 wb-ny291824 Exp $$
 */
public class ScheduleTest {
    public static void main(String[] args) {

        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            //通过schedulerFactory获取一个调度器
            scheduler = stdSchedulerFactory.getScheduler();
        } catch (Exception e) {
            System.out.println("创建调度器失败");
            e.printStackTrace();
        }

        // 创建jobDetail实例，绑定Job实现类
        // 指明job的名称，所在组的名称，以及绑定job类
        JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class).withIdentity("JobName", "JobGroupName").build();

        //定义调度触发规则
        //1.SimpleTrigger的方式(每3秒执行一次,总共执行6+1次)
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger", "SimpleTriggerGroup")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3).withRepeatCount(6)).startNow().build();
        //2.corn表达式的方式(每5秒执行一次)
        TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup").withSchedule(
                CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).startNow().build();

        try {
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail, trigger);
            //启动调度
            scheduler.start();
            // 停止调度
            //scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
