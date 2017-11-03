package com.keji.blog.dataobject;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 定时任务DO
 *
 * @author wb-ny291824
 * @version $Id: ScheduleJobDO.java, v 0.1 2017/11/2 10:15 wb-ny291824 Exp $
 */
@Data
public class ScheduleJobDO implements Serializable {

    private static final long serialVersionUID = 2807399740318803024L;

    /**
     * 主键
     */
    private Long id;

    /**
     * springBean 名称
     */
    private String beanName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数
     */
    private String params;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

}