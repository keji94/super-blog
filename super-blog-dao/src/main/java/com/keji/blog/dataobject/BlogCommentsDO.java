package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

@Data
public class BlogCommentsDO {
    private Long id;

    private Long articleId;

    private Long userId;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer status;

    private String content;
}