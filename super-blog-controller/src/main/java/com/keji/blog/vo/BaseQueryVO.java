package com.keji.blog.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.keji.blog.validator.group.QueryGroup;
import lombok.Data;

/**
 *
 * @author keji
 * @version $Id: BaseQueryVO.java, v 0.1 2018/3/18 下午2:44 keji Exp $
 */
@Data
public class BaseQueryVO {
    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空",groups = QueryGroup.class)
    @Min(1)
    private Integer pageIndex;

    /**
     * 页面大小
     */
    @NotNull(message = "每页显示个数不能为空", groups = QueryGroup.class)
    @Min(1)
    private Integer pageSize;
}
