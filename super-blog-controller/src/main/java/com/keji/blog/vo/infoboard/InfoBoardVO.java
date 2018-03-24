package com.keji.blog.vo.infoboard;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author wb-ny291824
 * @version $Id: NavDO.java, v 0.1 2018/3/22 17:28 wb-ny291824 Exp $
 */
@Data
public class InfoBoardVO {

    @NotNull(message = "id不能为空", groups = {UpdateGroup.class})
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    @NotBlank(message = "标题不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String title;

    @NotBlank(message = "内容",groups = {AddGroup.class,UpdateGroup.class})
    private String content;

}