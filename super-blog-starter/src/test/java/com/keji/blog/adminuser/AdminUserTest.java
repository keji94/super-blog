package com.keji.blog.adminuser;

import java.util.List;

import com.keji.blog.ApplicationTests;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
public class AdminUserTest extends ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        PageResult<List<UserDO>> result = userService.queryUserByPage(new UserDO(), 1, 1);
        System.out.println(result);
    }
}
