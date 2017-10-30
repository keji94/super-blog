package com.keji.blog.dto;

import java.util.List;

import com.keji.blog.dataobject.ResourceDO;
import lombok.Data;

/**
 * @author wb-ny291824
 * @version $Id: RoleDTO.java, v 0.1 2017-10-30 11:11 wb-ny291824 Exp $$
 */
@Data
public class RoleDTO {

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
     * 关联的资源
     */
    private List<Long> resourceIds;

}
