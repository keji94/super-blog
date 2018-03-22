package com.keji.blog.vo.role;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wb-ny291824
 * @version $Id: RoleVO.java, v 0.1 2017-10-26 9:24 wb-ny291824 Exp $$
 */
@Data
public class RoleVO {
    /**
     * 主键
     */
    @NotNull(message = "更新时id不能为空",groups = UpdateGroup.class)
    private Long id;

    /**
     * 角色编码
     */
    @NotBlank(message = "角色编码不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String roleCode;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String roleName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 关联的资源
     */
    private List<Long> resourceIdS;

}
