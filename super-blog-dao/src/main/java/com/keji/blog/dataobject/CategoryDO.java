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
public class CategoryDO {
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