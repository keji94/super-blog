package com.keji.blog.vo.schedule;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 定时任务日志VO
 *
 * @author wb-ny291824
 * @version $Id: ScheduleJobDO.java, v 0.1 2017/11/2 10:15 wb-ny291824 Exp $
 */
@Data
public class ScheduleJobLogVO implements Serializable {

    private static final long serialVersionUID = 4567096755100954170L;
    /**
     * 日志主键
     */
    private Long id;

    /**
     * 定时任务主键
     */
    private Long jobId;

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
     * 失败信息
     */
    private String errorMsg;

    /**
     * 耗时
     */
    private Integer consumeTime;

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