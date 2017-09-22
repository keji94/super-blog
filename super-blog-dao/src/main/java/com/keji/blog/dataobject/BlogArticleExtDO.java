package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

@Data
public class BlogArticleExtDO {
    private Long id;

    private Integer good;

    private Integer bad;

    private Long articleId;

    private Date gmtCreated;

    private Date gmtModified;
}