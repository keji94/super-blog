package com.keji.blog.adminuser;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.ApplicationTests;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.service.admin.UserService;
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
        PageInfo<UserDO> pageInfo = userService.queryUserByPage(new UserDO(), 1, 1);
        System.out.println(pageInfo);
    }

    @Test
    public void testSelectUserPermission() {
        List<ResourceDO> resourceDOS = userService.selectUserPermissions(1L);
        System.out.println(resourceDOS);
    }

    @Test
    public void testStringNumber() {
        String num = "7a";

        try {
            long l = Long.parseLong(num);

        } catch (Exception e) {
            System.out.println("数字转换失败");
        }
    }
}
