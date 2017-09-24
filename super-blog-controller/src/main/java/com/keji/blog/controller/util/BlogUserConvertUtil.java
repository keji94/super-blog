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
        if (userVO.getEmail() != null) {
            userDO.setName(userVO.getEmail());
        }
        if (userVO.getPassword() != null) {
            userDO.setPassword(userVO.getPassword());
        }
        return userDO;
    }
}
