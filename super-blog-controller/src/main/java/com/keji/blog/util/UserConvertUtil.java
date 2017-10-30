package com.keji.blog.util;

import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.vo.user.UserQueryVO;
import com.keji.blog.vo.user.UserVO;
import com.keji.blog.dataobject.UserDO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
public class UserConvertUtil {
    private UserConvertUtil() {
    }

    public static UserDO userVO2DO(UserVO userVO) {
        UserDO userDO = new UserDO();
        userDO.setId(userVO.getId());
        userDO.setPassword(userVO.getPassword());
        userDO.setEmail(userVO.getEmail());
        userDO.setName(userVO.getName());
        userDO.setPhone(userVO.getPhone());
        userDO.setStatus(userVO.getStatus());
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
        userVO.setPassword(userDO.getPassword());
        return userVO;
    }

    public static UserDO userQueryVO2DO(UserQueryVO userQueryVO) {
        UserDO userDO = new UserDO();
        userDO.setName(userQueryVO.getName());
        return userDO;
    }

    public static List<UserVO> userDOS2VOS(List<UserDO> userDOS) {

        List<UserVO> userVOS = Lists.newArrayList();

        userDOS.forEach(userDO -> {
            UserVO userVO = new UserVO();

            userVO.setPassword(userDO.getPassword());
            userVO.setStatus(userDO.getStatus());
            userVO.setQuestion(userDO.getQuestion());
            userVO.setPicture(userDO.getPicture());
            userVO.setName(userDO.getName());
            userVO.setIp(userDO.getIp());
            userVO.setGmtCreated(userDO.getGmtCreated());
            userVO.setEmail(userDO.getEmail());
            userVO.setPhone(userDO.getPhone());

            userVOS.add(userVO);

        });

        return userVOS;
    }
}
