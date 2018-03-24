package com.keji.blog.dataobject;
import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author keji
 * @version $Id: CategoryDO.java, v 0.1 2018/3/24 下午10:19 keji Exp $
 */
@Data
public class CategoryDO implements Serializable {

    private static final long serialVersionUID = 1521901139318L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 
    * isNullAble:0
    */
    private String name;

    /**
    * 
    * isNullAble:0
    */
    private String parentName;

    /**
    * 是否是父节点:1表示是，0表示不是
    * isNullAble:0,defaultVal:1
    */
    private Integer type;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    private Long parentId;

    /**
    * 
    * isNullAble:0
    */
    private java.time.LocalDateTime gmtCreated;

    /**
    * 
    * isNullAble:0
    */
    private java.time.LocalDateTime gmtModified;




}
