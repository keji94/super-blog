package com.keji.blog.service.admin;

import com.keji.blog.dataobject.BlogUserDO;

/**
 * @Author: wb-ny291824
 * @Description
 * @Date: Created in 2017/9/20
 * @Modified: By:
 */
public interface AdminUserService {

    BlogUserDO selectUserSelective(BlogUserDO userDO);
}
