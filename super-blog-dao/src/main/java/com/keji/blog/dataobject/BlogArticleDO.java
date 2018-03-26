package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: BlogArticleDO.java, v 0.1 2018/3/26 11:22 wb-ny291824 Exp $
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