package com.keji.blog.vo.category;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author keji
 * @version $Id: CategoryDO.java, v 0.1 2018/3/24 下午10:19 keji Exp $
 */
@Data
public class CategoryVO implements Serializable {

    private static final long serialVersionUID = 1521901139318L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    @NotNull(message = "更新时id为空",groups = {UpdateGroup.class})
    private Long id;

    /**
    * 
    * isNullAble:0
    */
    @NotBlank(message = "分类名称为空",groups = {AddGroup.class,UpdateGroup.class})
    private String name;

    /**
    * 
    * isNullAble:0
    */
    @NotBlank(message = "父类名称为空",groups = {AddGroup.class,UpdateGroup.class})
    private String parentName;

    /**
    * 是否是父节点:1表示是，0表示不是
    * isNullAble:0,defaultVal:1
    */
    @NotNull(message = "类型为空",groups = {AddGroup.class,UpdateGroup.class})
    private Integer type;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    @NotNull(message = "父id为空",groups = {AddGroup.class,UpdateGroup.class})
    private Long parentId;

    /**
    * 
    * isNullAble:0
    */
    private Date gmtCreated;

    /**
    * 
    * isNullAble:0
    */
    private Date gmtModified;




}
