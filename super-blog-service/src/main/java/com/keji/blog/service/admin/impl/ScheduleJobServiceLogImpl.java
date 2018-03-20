package com.keji.blog.service.admin.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dao.ScheduleJobLogDAO;
import com.keji.blog.dataobject.ScheduleJobLogDO;
import com.keji.blog.service.admin.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleJobServiceImpl.java, v 0.1 2017-11-02 10:29 wb-ny291824 Exp $$
 */
@Service("scheduleJobLogService")
public class ScheduleJobServiceLogImpl implements ScheduleJobLogService {

    @Autowired
    private ScheduleJobLogDAO scheduleJobLogDAO;

    @Override
    public Integer save(ScheduleJobLogDO scheduleJobLogDO) {
        return scheduleJobLogDAO.insert(scheduleJobLogDO);
    }

    @Override
    public PageInfo<ScheduleJobLogDO> queryByPage(ScheduleJobLogDO scheduleJobLogDO, Integer pageIndex, Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<ScheduleJobLogDO> scheduleJobLogDOS = scheduleJobLogDAO.selectByCondition(scheduleJobLogDO);
        return new PageInfo<>(scheduleJobLogDOS);
    }
}
