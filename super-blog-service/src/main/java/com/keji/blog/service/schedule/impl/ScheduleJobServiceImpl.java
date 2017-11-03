package com.keji.blog.service.schedule.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dao.ScheduleJobDAO;
import com.keji.blog.dataobject.ScheduleJobDO;
import com.keji.blog.enums.ScheduleStatusEnum;
import com.keji.blog.service.schedule.ScheduleJobService;
import com.keji.blog.util.schedule.ScheduleUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleJobServiceImpl.java, v 0.1 2017-11-02 10:29 wb-ny291824 Exp $$
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Autowired
    private ScheduleJobDAO scheduleJobDAO;
    @Autowired
    private Scheduler scheduler;

    @Override
    public PageInfo<ScheduleJobDO> queryByPage(ScheduleJobDO scheduleJobDO, Integer pageIndex, Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<ScheduleJobDO> scheduleJobDOS = scheduleJobDAO.selectByCondition(scheduleJobDO);
        return new PageInfo<>(scheduleJobDOS);
    }

    @Override
    public ScheduleJobDO queryById(Long jobId) {
        return scheduleJobDAO.selectByPrimaryKey(jobId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(ScheduleJobDO scheduleJobDO) {
        scheduleJobDO.setStatus(ScheduleStatusEnum.NORMAL.getValue());
        int count = scheduleJobDAO.insert(scheduleJobDO);
        ScheduleUtils.createScheduleJob(scheduler, scheduleJobDO);
        return count;
    }

    @Override
    public Integer update(ScheduleJobDO scheduleJobDO) {
        if (null != scheduleJobDO.getCronExpression()) {
            ScheduleUtils.updateScheduleJob(scheduler, scheduleJobDO);
        }
        return scheduleJobDAO.updateByPrimaryKeySelective(scheduleJobDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long[] jobIds) {

        Integer count = 0;
        for (Long jobId : jobIds) {
            ScheduleUtils.deleteScheduleJob(scheduler,jobId);
            Integer i = scheduleJobDAO.deleteByPrimaryKey(jobId);
            count += i;
        }
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.run(scheduler, queryById(jobId));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pause(Long[] jobIds) {
        ScheduleJobDO scheduleJobDO = new ScheduleJobDO();
        scheduleJobDO.setStatus(ScheduleStatusEnum.PAUSE.getValue());
        for (Long jobId : jobIds) {
            scheduleJobDO.setId(jobId);
            ScheduleUtils.pauseJob(scheduler,jobId);
            update(scheduleJobDO);
        }
    }

    @Override
    public void resume(Long[] jobIds) {
        ScheduleJobDO scheduleJobDO = new ScheduleJobDO();
        scheduleJobDO.setStatus(ScheduleStatusEnum.NORMAL.getValue());
        for (Long jobId : jobIds) {
            scheduleJobDO.setId(jobId);
            ScheduleUtils.resumeJob(scheduler,jobId);
            update(scheduleJobDO);
        }
    }
}
