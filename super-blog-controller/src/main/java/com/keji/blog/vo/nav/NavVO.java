package com.keji.blog.vo.nav;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wb-ny291824
 * @version $Id: NavVO.java, v 0.1 2018-03-22 17:40 wb-ny291824 Exp $$
 */
@Data
public class NavVO {

    @NotNull(message = "主键为空",groups = UpdateGroup.class)
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    @NotBlank(message = "名称为空",groups = {AddGroup.class,UpdateGroup.class})
    private String name;

    private String icon;

    @NotBlank(message = "url为空",groups = {AddGroup.class,UpdateGroup.class})
    private String url;

    /**
     * 状态
     */
    @NotNull(message = "状态为空",groups = {UpdateGroup.class})
    private Integer status;

}
