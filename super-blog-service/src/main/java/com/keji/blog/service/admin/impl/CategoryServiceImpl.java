package com.keji.blog.service.admin.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.CategoryDAO;
import com.keji.blog.dataobject.CategoryDO;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.admin.CategoryService;
import com.keji.blog.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author keji
 * @version $Id: CategoryServiceImpl.java, v 0.1 2018-03-25 下午3:43 keji Exp $$
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private RedisClient redisClient;

    @Override
    public List<CategoryDO> listAll(CategoryDO record) {
        return categoryDAO.selectByCondition(new CategoryDO());
    }

    @Override
    public CategoryDO queryById(Long id) {
        return categoryDAO.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CategoryDO record) throws JsonProcessingException {
        categoryDAO.updateByPrimaryKeySelective(record);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(CategoryDO record) throws JsonProcessingException {
        categoryDAO.insert(record);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws JsonProcessingException {
        categoryDAO.deleteByPrimaryKey(id);
        updateCache();
    }

    /**
     * 更新缓存
     * @throws JsonProcessingException ex
     */
    private void updateCache() throws JsonProcessingException {
        //更新缓存
        List<CategoryDO> value = categoryDAO.selectByCondition(new CategoryDO());
        redisClient.set(BlogConstants.CATEGORY_KEY, JsonUtil.object2Json(value));
    }



}
