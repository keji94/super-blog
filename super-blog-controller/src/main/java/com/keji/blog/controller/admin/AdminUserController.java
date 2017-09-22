package com.keji.blog.controller.admin;

import com.keji.blog.controller.util.BlogUserConvertUtil;
import com.keji.blog.controller.vo.BlogUserVO;
import com.keji.blog.dataobject.BlogUserDO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.admin.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * Created by wb-ny291824 on 2017/8/7.
 */
@Controller
@RequestMapping("admin")
public class AdminUserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/loginAdmin")
    public BaseResult loginAdmin(BlogUserVO userVO,HttpSession session) {
        BlogUserConvertUtil.userVO2DO(userVO);
        BlogUserDO userDO = adminUserService.selectUserSelective(BlogUserConvertUtil.userVO2DO(userVO));
        if (userDO == null) {
            return BaseResult.makeFail(BaseErrorEnum.FORBIDDEN);
        }
        session.setAttribute("user",userDO.getName());
        return BaseResult.makeSuccess();
    }

}
