package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
@Data
public class ResourceDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 资源编码
     */
    private String resourceCode;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源路径
     */
    private String resourceUrl;

    /**
     * 父资源id
     */
    private Long parentId;

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