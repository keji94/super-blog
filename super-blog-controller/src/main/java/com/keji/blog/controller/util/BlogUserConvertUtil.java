package com.keji.blog.controller.util;

import com.keji.blog.controller.vo.BlogUserVO;
import com.keji.blog.dataobject.BlogUserDO;

/**
 * @Author: wb-ny291824
 * @Description
 * @Date: Created in 2017/9/18
 * @Modified: By:
 */
public class BlogUserConvertUtil {
    private BlogUserConvertUtil(){}

    public static BlogUserDO userVO2DO(BlogUserVO userVO){
        BlogUserDO userDO = new BlogUserDO();
        if (userVO.getUsername() != null) {
            userDO.setName(userVO.getUsername());
        }
        if (userVO.getPassword() != null) {
            userDO.setPassword(userVO.getPassword());
        }
        return userDO;
    }
}
