package com.keji.blog.vo.user;

import com.keji.blog.vo.BaseQueryVO;
import lombok.Data;


/**
 *
 * @author keji
 * @version $Id: UserQueryVO.java, v 0.1 2018/3/18 下午2:44 keji Exp $
 */
@Data
public class UserQueryVO extends BaseQueryVO{

    /**
     * 姓名
     */
    private String name;

}
