package com.keji.blog.service.home.impl;

import java.io.IOException;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.TextSettingsDAO;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.home.TextSettingsService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.util.cache.CacheLoader;
import com.keji.blog.util.cache.CacheTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsServiceImpl.java, v 0.1 2018-03-20 10:32 wb-ny291824 Exp $$
 */
@Service
public class TextSettingsServiceImpl implements TextSettingsService {

    @Resource
    private CacheTemplate cacheTemplate;
    @Resource
    private TextSettingsDAO textSettingsDAO;
    @Resource
    private CacheLoader<TextSettingsDO> textSettingsCacheLoader;
    @Resource
    private RedisClient redisClient;

    @Override
    public TextSettingsDO query() throws IOException {
        textSettingsDAO.selectByCondition(new TextSettingsDO());
        return cacheTemplate.findData(BlogConstants.TEXT_SETTINGS_KEY, new TypeReference<TextSettingsDO>() {
        }, textSettingsCacheLoader);
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
