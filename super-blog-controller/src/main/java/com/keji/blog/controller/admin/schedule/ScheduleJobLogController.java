package com.keji.blog.controller.admin.schedule;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.ScheduleJobLogDO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.admin.ScheduleJobLogService;
import com.keji.blog.util.ScheduleJobLogConvertUtil;
import com.keji.blog.vo.schedule.ScheduleJobLogQueryVO;
import com.keji.blog.vo.schedule.ScheduleJobLogVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleJobLogController.java, v 0.1 2017-11-03 15:12 wb-ny291824 Exp $$
 */
@RestController
@RequestMapping("/admin/sys/scheduleLog")
public class ScheduleJobLogController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ScheduleJobLogService scheduleJobLogService;

    /**
     * 定时任务日志列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:log")
    public PageResult list(ScheduleJobLogQueryVO queryVO) {

        List<ScheduleJobLogVO> scheduleJobLogVOS;
        PageInfo<ScheduleJobLogDO> pageInfo;
        try {
            pageInfo = scheduleJobLogService.queryByPage(ScheduleJobLogConvertUtil.convertQueryVO2DO(queryVO),queryVO.getPageIndex(),queryVO.getPageSize());
            scheduleJobLogVOS = ScheduleJobLogConvertUtil.convertDOS2VOs(pageInfo.getList());
        } catch (Exception e) {
            logger.error("查看日志列表失败",e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return PageResult.makeSuccess(scheduleJobLogVOS, pageInfo.getTotal(), pageInfo.getPages());

    }

}
