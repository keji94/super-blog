package com.keji.blog.service.schedule;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.ScheduleJobLogDO;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleJobLogService.java, v 0.1 2017-11-02 11:35 wb-ny291824 Exp $$
 */
public interface ScheduleJobLogService {

    /**
     * 新增时间任务设置
     *
     * @param scheduleLog
     */
    Integer save(ScheduleJobLogDO scheduleLog);

    /**
     * 分页查询时间任务日志
     *
     * @param scheduleJobLogDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<ScheduleJobLogDO> queryByPage(ScheduleJobLogDO scheduleJobLogDO, Integer pageIndex, Integer pageSize);
}
