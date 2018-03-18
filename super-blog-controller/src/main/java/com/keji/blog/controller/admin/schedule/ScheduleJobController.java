package com.keji.blog.controller.admin.schedule;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.ScheduleJobDO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.schedule.ScheduleJobService;
import com.keji.blog.util.ScheduleJobConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.vo.schedule.ScheduleJobQueryVO;
import com.keji.blog.vo.schedule.ScheduleJobVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时任务
 *
 * @author wb-ny291824
 * @version $Id: ScheduleJobController.java, v 0.1 2017-11-02 10:30 wb-ny291824 Exp $$
 */
@RestController
@RequestMapping("/admin/sys/schedule")
public class ScheduleJobController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 定时任务列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:list")
    public PageResult list(ScheduleJobQueryVO queryVO) {
        //查询列表数据
        PageInfo<ScheduleJobDO> pageInfo;
        List<ScheduleJobVO> scheduleJobVOS;
        try {
            pageInfo = scheduleJobService.queryByPage(ScheduleJobConvertUtil.convertQueryVO2DO(queryVO),
                    queryVO.getPageIndex(), queryVO.getPageSize());
            scheduleJobVOS = ScheduleJobConvertUtil.convertDOS2VOs(pageInfo.getList());
        } catch (Exception e) {
            logger.error("查询时间任务列表失败", e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return PageResult.makeSuccess(scheduleJobVOS, pageInfo.getTotal(), pageInfo.getPages());
    }

    /**
     * 查询定时任务信息
     *
     * @param jobId
     * @return
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedule:info")
    public BaseResult info(@PathVariable("jobId") Long jobId) {

        if (jobId == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        //查询列表数据
        ScheduleJobDO scheduleJobDO;
        ScheduleJobVO scheduleJobVO;
        try {
            scheduleJobDO = scheduleJobService.queryById(jobId);
            scheduleJobVO = ScheduleJobConvertUtil.convertDO2VO(scheduleJobDO);
        } catch (Exception e) {
            logger.error("查询时间任务对象失败", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(scheduleJobVO);
    }

    /**
     * 保存定时任务
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:schedule:save")
    public BaseResult save(@RequestBody ScheduleJobVO scheduleJobVO) {
        ValidatorUtils.validateEntity(scheduleJobVO);
        Integer count;
        try {
            count = scheduleJobService.save(ScheduleJobConvertUtil.convertVO2DO(scheduleJobVO));
        } catch (Exception e) {
            logger.error("保存时间任务失败", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    /**
     * 修改定时任务
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:schedule:update")
    public BaseResult update(@RequestBody ScheduleJobVO scheduleJobVO) {
        ValidatorUtils.validateEntity(scheduleJobVO);
        Integer count;
        try {
            count = scheduleJobService.update(ScheduleJobConvertUtil.convertVO2DO(scheduleJobVO));
        } catch (Exception e) {
            logger.error("更新时间任务失败", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    /**
     * 删除定时任务
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:schedule:delete")
    public BaseResult delete(@RequestBody Long[] jobIds) {
        Integer count;
        try {
            count = scheduleJobService.delete(jobIds);
        } catch (Exception e) {
            logger.error("批量删除时间任务失败", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(count);
    }

    /**
     * 立即执行任务
     */
    @RequestMapping("/run")
    @RequiresPermissions("sys:schedule:run")
    public BaseResult run(@RequestBody Long[] jobIds) {
        try {
            scheduleJobService.run(jobIds);
        } catch (Exception e) {
            logger.error("执行时间任务失败", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    /**
     * 暂停定时任务
     */
    @RequestMapping("/pause")
    @RequiresPermissions("sys:schedule:pause")
    public BaseResult pause(@RequestBody Long[] jobIds) {
        try {
            scheduleJobService.pause(jobIds);
        } catch (Exception e) {
            logger.error("暂停时间任务失败", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess();
    }

    /**
     * 恢复定时任务
     */
    @RequestMapping("/resume")
    @RequiresPermissions("sys:schedule:resume")
    public BaseResult resume(@RequestBody Long[] jobIds) {
        try {
            scheduleJobService.resume(jobIds);
        } catch (Exception e) {
            logger.error("恢复时间任务失败", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess();
    }



}
