package com.keji.blog.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.NavDAO;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.admin.NavService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.redis.loader.NavCacheLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-ny291824
 * @version $Id: NavServiceImpl.java, v 0.1 2018-03-22 16:48 wb-ny291824 Exp $$
 */
@Service
public class NavServiceImpl implements NavService {

    @Resource
    private NavDAO navDAO;
    @Resource
    private CacheService cacheService;
    @Resource
    private NavCacheLoader navCacheLoader;
    @Resource
    private RedisClient redisClient;

    @Override
    public PageInfo<NavDO> list(NavDO navDO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<NavDO> navDOS = navDAO.selectByCondition(navDO);
        return new PageInfo<>(navDOS);
    }

    @Override
    public List<NavDO> listAll(NavDO navDO) {
        return cacheService.findListSafety(BlogConstants.NAV_KEY, NavDO.class, navCacheLoader, navDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(NavDO navDO) throws JsonProcessingException {
        navDAO.updateByPrimaryKeySelective(navDO);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(NavDO navDO) throws JsonProcessingException {
        navDAO.insert(navDO);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long[] ids) throws JsonProcessingException {
        navDAO.deleteBatch(ids);
        updateCache();
    }

    /**
     * 更新缓存
     * @throws JsonProcessingException ex
     */
    private void updateCache() throws JsonProcessingException {
        //更新缓存
        List<NavDO> value = navDAO.selectByCondition(new NavDO());
        redisClient.set(BlogConstants.NAV_KEY, JsonUtil.object2Json(value));
    }
}
