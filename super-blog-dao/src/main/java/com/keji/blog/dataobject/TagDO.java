package com.keji.blog.dataobject;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author wb-ny291824
 * @version $Id: TagDO.java, v 0.1 2018/3/26 10:29 wb-ny291824 Exp $
 */
@Data
public class TagDO implements Serializable{

    private static final long serialVersionUID = -1446176003850660343L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;
}