package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

@Data
public class BlogCategoryDO {
    private Long id;

    private String name;

    private Integer status;

    private String url;

    private Integer orderNum;

    private Boolean isParent;

    private Long parentId;

    private Date gmtCreated;

    private Date gmtModified;
}