package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

@Data
public class BlogPictureDO {
    private Long id;

    private String name;

    private String resource;

    private Integer status;

    private Integer orderNum;

    private Long articleId;

    private Date gmtCreated;

    private Date gmtModified;
}