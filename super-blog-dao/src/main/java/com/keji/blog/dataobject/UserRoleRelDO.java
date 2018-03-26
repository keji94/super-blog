package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @author wb-ny291824
 * @version $Id: UserRoleRelDO.java, v 0.1 2018/3/26 11:25 wb-ny291824 Exp $
 */
@Data
public class UserRoleRelDO {
    /**
     * 主键
     */
    /**
     *
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long userId;

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