package com.keji.blog.util;

import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.dataobject.ScheduleJobDO;
import com.keji.blog.vo.schedule.ScheduleJobQueryVO;
import com.keji.blog.vo.schedule.ScheduleJobVO;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleJobConvertUtil.java, v 0.1 2017-11-02 10:36 wb-ny291824 Exp $$
 */
public class ScheduleJobConvertUtil {

    private ScheduleJobConvertUtil() {
    }

    public static ScheduleJobDO convertVO2DO(ScheduleJobVO scheduleJobVO) {

        ScheduleJobDO scheduleJobDO = new ScheduleJobDO();
        scheduleJobDO.setBeanName(scheduleJobVO.getBeanName());
        scheduleJobDO.setCronExpression(scheduleJobVO.getCronExpression());
        scheduleJobDO.setGmtCreated(scheduleJobVO.getGmtCreated());
        scheduleJobDO.setGmtModified(scheduleJobVO.getGmtModified());
        scheduleJobDO.setId(scheduleJobVO.getId());
        scheduleJobDO.setMethodName(scheduleJobVO.getMethodName());
        scheduleJobDO.setParams(scheduleJobVO.getParams());
        scheduleJobDO.setRemark(scheduleJobVO.getRemark());
        scheduleJobDO.setStatus(scheduleJobVO.getStatus());
        return scheduleJobDO;
    }

    public static ScheduleJobVO convertDO2VO(ScheduleJobDO scheduleJobDO) {

        ScheduleJobVO scheduleJobVO = new ScheduleJobVO();
        scheduleJobVO.setBeanName(scheduleJobDO.getBeanName());
        scheduleJobVO.setCronExpression(scheduleJobDO.getCronExpression());
        scheduleJobVO.setGmtCreated(scheduleJobDO.getGmtCreated());
        scheduleJobVO.setGmtModified(scheduleJobDO.getGmtModified());
        scheduleJobVO.setId(scheduleJobDO.getId());
        scheduleJobVO.setMethodName(scheduleJobDO.getMethodName());
        scheduleJobVO.setParams(scheduleJobDO.getParams());
        scheduleJobVO.setRemark(scheduleJobDO.getRemark());
        scheduleJobVO.setStatus(scheduleJobDO.getStatus());
        return scheduleJobVO;
    }

    public static ScheduleJobDO convertQueryVO2DO(ScheduleJobQueryVO scheduleJobVO) {
        ScheduleJobDO scheduleJobDO = new ScheduleJobDO();
        scheduleJobDO.setBeanName(scheduleJobVO.getBeanName());
        return scheduleJobDO;
    }

    public static List<ScheduleJobVO> convertDOS2VOs(List<ScheduleJobDO> scheduleJobDOS) {

        List<ScheduleJobVO> scheduleJobVOS = Lists.newArrayList();

        scheduleJobDOS.forEach(scheduleJobDO -> {
            scheduleJobVOS.add(convertDO2VO(scheduleJobDO));
        });
        return scheduleJobVOS;
    }

}
