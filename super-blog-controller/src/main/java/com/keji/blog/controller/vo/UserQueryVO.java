package com.keji.blog.controller.vo;

import lombok.Data;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
@Data
public class UserQueryVO {

    /**
     * 当前页
     */
    private Integer pageIndex;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 查询条件
     */
    private String condition;

}
