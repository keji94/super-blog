package com.keji.blog.vo.requirement;

import com.keji.blog.vo.BaseQueryVO;
import lombok.Data;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
@Data
public class RequirementQueryVO extends BaseQueryVO{

    /**
     * 需求标题
     */
    private String title;

    /**
     * 需求内容
     */
    private String content;

    /**
     * 状态
     */
    private Integer status;


}
