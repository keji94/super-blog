package com.keji.blog.bo;

import java.util.List;

import lombok.Data;

/**
 *
 * @author keji
 * @version $Id: ResourceBO.java, v 0.1 2018/4/17 下午8:03 keji Exp $
 */
@Data
public class ResourceBO {
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
     * 子资源
     */
    private List<ResourceBO> subResource;
}
