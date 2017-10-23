package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Data
public class BlogArticleDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 需求标题
     */
    private String title;

    /**
     * 需求内容
     */
    private String content;

    /**
     * 完成总结
     */
    private String  summary;

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