package com.keji.blog.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
@Data
public class BaseQueryVO {
    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    @Min(1)
    private Integer pageIndex;

    /**
     * 页面大小
     */
    @NotNull(message = "每页显示个数不能为空")
    @Min(1)
    private Integer pageSize;
}
