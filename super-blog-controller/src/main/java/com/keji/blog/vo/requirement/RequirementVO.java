package com.keji.blog.vo.requirement;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
@Data
public class RequirementVO {

    /**
     * 主键
     */
    @NotNull(message = "更新时Id不能为空",groups = UpdateGroup.class)
    private Long id;

    /**
     * 需求标题
     */
    @NotBlank(message = "需求标题不能为空",groups = {UpdateGroup.class, AddGroup.class})
    private String title;

    /**
     * 需求内容
     */
    private String content;

    /**
     * 总结
     */
    private String summary;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreated;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

}
