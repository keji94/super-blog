package com.keji.blog.service;

import com.keji.blog.dataobject.BlogUser;
import com.keji.blog.result.BaseResult;

import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */

public interface UserService {
    BlogUser showUserData(String userName);
}
