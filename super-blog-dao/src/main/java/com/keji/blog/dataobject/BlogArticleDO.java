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
    private Long id;

    private String title;

    private Integer status;

    private Integer istop;

    private Long userId;

    private Long categoryId;

    private Date gmtCreated;

    private Date gmtModified;

    private String content;
}