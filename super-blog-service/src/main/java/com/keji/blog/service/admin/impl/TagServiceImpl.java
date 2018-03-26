package com.keji.blog.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.TagDAO;
import com.keji.blog.dataobject.TagDO;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.admin.TagService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.util.cache.CacheTemplate;
import com.keji.blog.util.cache.TagCacheLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-ny291824
 * @version $Id: NavServiceImpl.java, v 0.1 2018-03-22 16:48 wb-ny291824 Exp $$
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagDAO tagDAO;
    @Resource
    private CacheTemplate cacheTemplate;
    @Resource
    private TagCacheLoader tagCacheLoader;
    @Resource
    private RedisClient redisClient;

    @Override
    public PageInfo<TagDO> list(TagDO tagDO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<TagDO> tagDOS = tagDAO.selectByCondition(tagDO);
        return new PageInfo<>(tagDOS);
    }

    @Override
    public List<TagDO> listAll(TagDO tagDO) {
        return cacheTemplate.findList(BlogConstants.NAV_KEY, TagDO.class, tagCacheLoader, tagDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TagDO tagDO) throws JsonProcessingException {
        tagDAO.updateByPrimaryKeySelective(tagDO);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TagDO tagDO) throws JsonProcessingException {
        tagDAO.insert(tagDO);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long[] ids) throws JsonProcessingException {
        tagDAO.deleteBatch(ids);
        updateCache();
    }

    /**
     * 更新缓存
     * @throws JsonProcessingException json转换异常
     */
    private void updateCache() throws JsonProcessingException {
        //更新缓存
        List<TagDO> value = tagDAO.selectByCondition(new TagDO());
        redisClient.set(BlogConstants.NAV_KEY, JsonUtil.object2Json(value));
    }
}
