package com.keji.blog.service.impl;

import com.keji.blog.dao.BlogUserMapper;
import com.keji.blog.dataobject.BlogUser;
import com.keji.blog.dataobject.BlogUserExample;
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
public class UserServiceImpl implements UserService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlogUserMapper userMapper;

    public BlogUser showUserData(String userName) {
        BlogUserExample example = new BlogUserExample();
        BlogUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<BlogUser> list = userMapper.selectByExample(example);
        if (list != null && list.size() == 1){
            return list.get(0);
        }
        return null;
    }
}
