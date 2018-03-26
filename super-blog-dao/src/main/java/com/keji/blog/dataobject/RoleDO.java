package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: RoleDO.java, v 0.1 2018/3/26 11:24 wb-ny291824 Exp $
 */
@Data
public class RoleDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

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