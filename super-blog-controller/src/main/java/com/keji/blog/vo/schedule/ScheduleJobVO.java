package com.keji.blog.vo.schedule;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 定时任务DO
 *
 * @author wb-ny291824
 * @version $Id: ScheduleJobVO.java, v 0.1 2017/11/2 10:15 wb-ny291824 Exp $
 */
@Data
public class ScheduleJobVO implements Serializable {

    private static final long serialVersionUID = 2807399740318803024L;

    /**
     * 主键
     */
    @NotNull(message = "更新时id不能为空",groups = UpdateGroup.class)
    private Long id;

    /**
     * springBean 名称
     */
    @NotBlank(message = "bean名称不能为空",groups = {UpdateGroup.class, AddGroup.class})
    private String beanName;

    /**
     * 方法名
     */
    @NotBlank(message="方法名称不能为空",groups = {UpdateGroup.class, AddGroup.class})
    private String methodName;

    /**
     * 参数
     */
    private String params;

    /**
     * cron表达式
     */
    @NotBlank(message="cron表达式不能为空",groups = {UpdateGroup.class, AddGroup.class})
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