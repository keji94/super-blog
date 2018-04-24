package com.keji.blog.service.admin.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.InfoBoardDAO;
import com.keji.blog.dataobject.InfoBoardDO;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.admin.InfoBoardService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.redis.loader.InfoBoardCacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author keji
 * @version $Id: InfoBoardServiceImpl.java, v 0.1 2018-03-23 下午9:10 keji Exp $$
 */
@Service
public class InfoBoardServiceImpl implements InfoBoardService {

    @Autowired
    private InfoBoardDAO boardDAO;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private InfoBoardCacheLoader cacheLoader;
    @Autowired
    private RedisClient redisClient;

    @Override
    public PageInfo<InfoBoardDO> list(InfoBoardDO boardDO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<InfoBoardDO> list = boardDAO.selectByCondition(boardDO);
        return new PageInfo<>(list);
    }

    @Override
    public List<InfoBoardDO> listAll(InfoBoardDO record) {
        return cacheService.findListSafety(BlogConstants.INFO_BOARD_KEY,InfoBoardDO.class,cacheLoader,record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(InfoBoardDO record) throws JsonProcessingException {
        boardDAO.updateByPrimaryKeySelective(record);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(InfoBoardDO record) throws JsonProcessingException {
        boardDAO.insert(record);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long[] ids) throws JsonProcessingException {
        boardDAO.deleteBatch(ids);
        updateCache();
    }

    /**
     * 更新缓存
     * @throws JsonProcessingException ex
     */
    private void updateCache() throws JsonProcessingException {
        //更新缓存
        List<InfoBoardDO> value = boardDAO.selectByCondition(new InfoBoardDO());
        redisClient.set(BlogConstants.INFO_BOARD_KEY, JsonUtil.object2Json(value));
    }
}
