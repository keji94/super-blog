package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: PictureDO.java, v 0.1 2018/3/26 11:23 wb-ny291824 Exp $
 */
@Data
public class PictureDO {
    private Long id;

    private String name;

    private String resource;

    private Integer status;

    private Integer orderNum;

    private Long articleId;

    private Date gmtCreated;

    private Date gmtModified;
}