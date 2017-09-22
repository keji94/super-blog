package com.keji.blog.service;

import com.keji.blog.dataobject.BlogUserDO;

/**
 * Created by keji on 2017/7/31.
 */

public interface UserService {
    BlogUserDO showUserData(String userName);
}
