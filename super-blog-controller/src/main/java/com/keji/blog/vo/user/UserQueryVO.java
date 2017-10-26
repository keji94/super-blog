package com.keji.blog.vo.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.keji.blog.vo.BaseQueryVO;
import lombok.Data;


/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
@Data
public class UserQueryVO extends BaseQueryVO{

    /**
     * 姓名
     */
    private String name;

}
