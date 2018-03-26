package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: ResourceDO.java, v 0.1 2018/3/26 11:23 wb-ny291824 Exp $
 */
@Data
public class ResourceDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 父资源id
     */
    private Long parentId;

    /**
     * 父资源名称
     */
    private String parentName;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源路径
     */
    private String resourceUrl;

    /**
     * 对应权限
     */
    private String permission;

    /**
     * 资源类型0：目录   1：菜单   2：按钮'
     */
    private Integer type;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

}