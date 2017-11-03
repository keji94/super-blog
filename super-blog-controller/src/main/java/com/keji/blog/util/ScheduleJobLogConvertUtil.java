package com.keji.blog.util;

import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.dataobject.ScheduleJobDO;
import com.keji.blog.dataobject.ScheduleJobLogDO;
import com.keji.blog.vo.schedule.ScheduleJobLogQueryVO;
import com.keji.blog.vo.schedule.ScheduleJobLogVO;
import com.keji.blog.vo.schedule.ScheduleJobQueryVO;
import com.keji.blog.vo.schedule.ScheduleJobVO;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleJobConvertUtil.java, v 0.1 2017-11-02 10:36 wb-ny291824 Exp $$
 */
public class ScheduleJobLogConvertUtil {

    private ScheduleJobLogConvertUtil() {
    }

    public static ScheduleJobLogDO convertVO2DO(ScheduleJobLogVO scheduleJobLogVO) {

        ScheduleJobLogDO scheduleJobLogDO = new ScheduleJobLogDO();
        scheduleJobLogDO.setBeanName(scheduleJobLogVO.getBeanName());
        scheduleJobLogDO.setGmtCreated(scheduleJobLogVO.getGmtCreated());
        scheduleJobLogDO.setGmtModified(scheduleJobLogVO.getGmtModified());
        scheduleJobLogDO.setId(scheduleJobLogVO.getId());
        scheduleJobLogDO.setMethodName(scheduleJobLogVO.getMethodName());
        scheduleJobLogDO.setParams(scheduleJobLogVO.getParams());
        scheduleJobLogDO.setStatus(scheduleJobLogVO.getStatus());
        return scheduleJobLogDO;
    }

    public static ScheduleJobLogVO convertDO2VO(ScheduleJobLogDO scheduleJobLogDO) {

        ScheduleJobLogVO scheduleJobLogVO = new ScheduleJobLogVO();
        scheduleJobLogVO.setBeanName(scheduleJobLogDO.getBeanName());
        scheduleJobLogVO.setGmtCreated(scheduleJobLogDO.getGmtCreated());
        scheduleJobLogVO.setGmtModified(scheduleJobLogDO.getGmtModified());
        scheduleJobLogVO.setId(scheduleJobLogDO.getId());
        scheduleJobLogVO.setMethodName(scheduleJobLogDO.getMethodName());
        scheduleJobLogVO.setParams(scheduleJobLogDO.getParams());
        scheduleJobLogVO.setStatus(scheduleJobLogDO.getStatus());
        return scheduleJobLogVO;
    }

    public static ScheduleJobLogDO convertQueryVO2DO(ScheduleJobLogQueryVO scheduleJobLogQueryVO) {
        ScheduleJobLogDO scheduleJobLogDO = new ScheduleJobLogDO();
        scheduleJobLogDO.setJobId(scheduleJobLogQueryVO.getJobId());
        return scheduleJobLogDO;
    }

    public static List<ScheduleJobLogVO> convertDOS2VOs(List<ScheduleJobLogDO> scheduleJobLogDOS) {

        List<ScheduleJobLogVO> scheduleJobLogVOS = Lists.newArrayList();

        scheduleJobLogDOS.forEach(scheduleJobDO -> {
            scheduleJobLogVOS.add(convertDO2VO(scheduleJobDO));
        });
        return scheduleJobLogVOS;
    }

}
