package com.keji.blog.controller.user;

import com.keji.blog.dataobject.UserDO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
 */
@Controller
@RequestMapping("user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @RequestMapping("/showUserData")
    @ResponseBody
    public BaseResult showUserData( String userName) {
        if (userName == null) {
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        UserDO user = userService.showUserData(userName);

        if (user == null){
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(user);
    }
}
