package com.keji.blog.service.impl;

import com.keji.blog.dao.BlogUserDAO;
import com.keji.blog.dataobject.BlogUserDO;
import com.keji.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wb-ny291824 on 2017/6/29.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlogUserDAO userMapper;

    public BlogUserDO showUserData(String userName) {
        return null;
    }
}
