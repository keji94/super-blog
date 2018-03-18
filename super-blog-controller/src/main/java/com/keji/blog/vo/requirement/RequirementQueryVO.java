package com.keji.blog.vo.requirement;

import com.keji.blog.vo.BaseQueryVO;
import lombok.Data;

/**
 *
 * @author keji
 * @version $Id: RequirementQueryVO.java, v 0.1 2018/3/18 下午2:45 keji Exp $
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
