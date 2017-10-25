package com.keji.blog.util;

import com.keji.blog.vo.user.UserVO;
import com.keji.blog.dataobject.UserDO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
public class UserConvertUtil {
    private UserConvertUtil(){}

    public static UserDO userVO2DO(UserVO userVO){
        UserDO userDO = new UserDO();
        if (userVO.getEmail() != null) {
            userDO.setName(userVO.getEmail());
        }
        if (userVO.getPassword() != null) {
            userDO.setPassword(userVO.getPassword());
        }
        return userDO;
    }

    public static UserVO userDO2VO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setEmail(userDO.getEmail());
        userVO.setGmtCreated(userDO.getGmtCreated());
        userVO.setId(userDO.getId());
        userVO.setIp(userDO.getIp());
        userVO.setName(userDO.getName());
        userVO.setPicture(userDO.getPicture());
        userVO.setQuestion(userDO.getQuestion());
        userVO.setStatus(userDO.getStatus());
        return userVO;
    }
}
