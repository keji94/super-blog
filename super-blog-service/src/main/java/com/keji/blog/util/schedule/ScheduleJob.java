package com.keji.blog.util.schedule;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

import com.alibaba.druid.util.DaemonThreadFactory;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dataobject.ScheduleJobDO;
import com.keji.blog.dataobject.ScheduleJobLogDO;
import com.keji.blog.service.schedule.ScheduleJobLogService;
import com.keji.blog.util.SpringContextUtils;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月30日 下午12:44:21
 */
public class ScheduleJob extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *  线程池:初始线程5,最大线程10，最大阻塞线程10,线程工厂使用德鲁伊,线程数量爆炸由AbortPolicy处理
     */
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(10), new DaemonThreadFactory("myThreadFactory"), new AbortPolicy());

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ScheduleJobDO scheduleJob = (ScheduleJobDO)context.getMergedJobDataMap().get(BlogConstants.JOB_PARAM_KEY);

        //获取spring bean
        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService)SpringContextUtils.getBean(
                "scheduleJobLogService");

        //数据库保存执行记录
        ScheduleJobLogDO scheduleLog = new ScheduleJobLogDO();
        scheduleLog.setJobId(scheduleJob.getId());
        scheduleLog.setBeanName(scheduleJob.getBeanName());
        scheduleLog.setMethodName(scheduleJob.getMethodName());
        scheduleLog.setParams(scheduleJob.getParams());
        scheduleLog.setGmtCreated(new Date());

        //任务开始时间
        long startTime = System.currentTimeMillis();

        try {
            //执行任务
            if (logger.isInfoEnabled()) {
                logger.info("任务准备执行，任务ID：" + scheduleJob.getId());
            }
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(), scheduleJob.getMethodName(),
                    scheduleJob.getParams());

            executor.execute(task);

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            scheduleLog.setConsumeTime((int)times);
            //任务状态    0：成功    1：失败
            scheduleLog.setStatus(0);

            logger.info("任务执行完毕，任务ID：" + scheduleJob.getId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            logger.error("任务执行失败，任务ID：" + scheduleJob.getId(), e);

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            scheduleLog.setConsumeTime((int)times);

            //任务状态    0：成功    1：失败
            scheduleLog.setStatus(1);
            scheduleLog.setErrorMsg(StringUtils.substring(e.toString(), 0, 2000));
        } finally {
            scheduleJobLogService.save(scheduleLog);
        }
    }
}
