package com.keji.blog.service.admin.impl;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.TextSettingsDAO;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.admin.TextSettingsService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.redis.loader.TextSettingsCacheLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsServiceImpl.java, v 0.1 2018-03-20 10:32 wb-ny291824 Exp $$
 */
@Service
public class TextSettingsServiceImpl implements TextSettingsService {

    @Resource
    private CacheService cacheService;
    @Resource
    private TextSettingsDAO textSettingsDAO;
    @Resource
    private TextSettingsCacheLoader textSettingsCacheLoader;
    @Resource
    private RedisClient redisClient;

    @Override
    public TextSettingsDO query(){
        return cacheService.findObjectSafety(BlogConstants.TEXT_SETTINGS_KEY, TextSettingsDO.class, textSettingsCacheLoader,new TextSettingsDO());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TextSettingsDO textSettingsDO) throws JsonProcessingException {

        int i = textSettingsDAO.updateByPrimaryKeySelective(textSettingsDO);

        if (i == 1) {
            redisClient.set(BlogConstants.TEXT_SETTINGS_KEY, JsonUtil.object2Json(textSettingsDO));
        }

    }
}
