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
public class UserRoleRelDO {
    /**
     * 主键
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