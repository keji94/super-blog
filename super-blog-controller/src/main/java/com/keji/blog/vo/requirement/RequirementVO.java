package com.keji.blog.vo.requirement;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

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
    private Long id;

    /**
     * 需求标题
     */
    @NotBlank(message = "需求标题不能为空")
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

}
