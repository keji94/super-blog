package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

@Data
public class BlogHitsDO {
    private Long id;

    private Long articleId;

    private Long count;

    private Date gmtCreated;

    private Date gmtModified;
}