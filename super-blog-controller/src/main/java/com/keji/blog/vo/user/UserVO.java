package com.keji.blog.vo.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author keji
 * @version $Id: UserVO.java, v 0.1 2018/3/18 下午2:45 keji Exp $
 */
@Data
public class UserVO {

    /**
     * 主键
     */
    @NotNull(message = "用户id为空!", groups = UpdateGroup.class)
    private Long id;

    /**
     * 用户名称
     */
    @NotBlank(message = "*姓名不能为空!", groups = {AddGroup.class, UpdateGroup.class})
    private String name;

    /**
     * 登录邮箱
     */
    @NotBlank(message = "*邮箱不能为空!", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message = "*邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    /**
     * 安全问题
     */
    private String question;

    /**
     * 头像
     */
    private String picture;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 密码
     */
    @NotBlank(message = "*密码不能为空!", groups = AddGroup.class)
    private String password;

    /**
     * 记住我
     */
    private String rememberMe;

    /**
     * 关联角色
     */
    private List<Long> roleIdList;

    /**
     * 手机
     */
    @Pattern(regexp = BlogConstants.PHONE_REGULAR, message = "手机号格式不正确" , groups = {AddGroup.class, UpdateGroup.class})
    private String phone;

}
