package com.keji.blog.util;

import com.keji.blog.vo.user.BlogUserVO;
import com.keji.blog.dataobject.UserDO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
public class BlogUserConvertUtil {
    private BlogUserConvertUtil(){}

    public static UserDO userVO2DO(BlogUserVO userVO){
        UserDO userDO = new UserDO();
        if (userVO.getEmail() != null) {
            userDO.setName(userVO.getEmail());
        }
        if (userVO.getPassword() != null) {
            userDO.setPassword(userVO.getPassword());
        }
        return userDO;
    }
}
