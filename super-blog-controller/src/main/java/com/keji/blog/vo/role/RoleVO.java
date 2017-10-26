package com.keji.blog.vo.role;

import java.util.Date;

import lombok.Data;

/**
 * @author wb-ny291824
 * @version $Id: RoleVO.java, v 0.1 2017-10-26 9:24 wb-ny291824 Exp $$
 */
@Data
public class RoleVO {
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

}
