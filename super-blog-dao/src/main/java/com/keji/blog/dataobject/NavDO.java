package com.keji.blog.dataobject;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author wb-ny291824
 * @version $Id: NavDO.java, v 0.1 2018/3/22 17:28 wb-ny291824 Exp $
 */
@Data
public class NavDO {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private String icon;

    private String url;

    private Integer status;

    private Integer sortId;

    private String position;
}