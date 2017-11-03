package com.keji.blog.service.schedule;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.ScheduleJobDO;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleJobService.java, v 0.1 2017-11-02 10:28 wb-ny291824 Exp $$
 */
public interface ScheduleJobService {

    /**
     * 分页查询时间任务
     *
     * @param scheduleJobDO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<ScheduleJobDO> queryByPage(ScheduleJobDO scheduleJobDO, Integer pageIndex, Integer pageSize);

    /**
     * 查询时间任务对象
     *
     * @param jobId
     * @return
     */
    ScheduleJobDO queryById(Long jobId);

    /**
     * 新增时间任务
     *
     * @param scheduleJobDO
     * @return
     */
    Integer save(ScheduleJobDO scheduleJobDO);

    /**
     * 更新时间任务
     *
     * @param scheduleJobDO
     * @return
     */
    Integer update(ScheduleJobDO scheduleJobDO);

    /**
     * 批量删除时间任务
     *
     * @param jobIds
     * @return
     */
    Integer delete(Long[] jobIds);

    /**
     * 执行定时任务
     *
     * @param jobIds
     * @return
     */
    void run(Long[] jobIds);

    /**
     * 暂停时间任务
     *
     * @param jobIds
     */
    void pause(Long[] jobIds);

    /**
     * 恢复时间任务
     *
     * @param jobIds
     */
    void resume(Long[] jobIds);
}
