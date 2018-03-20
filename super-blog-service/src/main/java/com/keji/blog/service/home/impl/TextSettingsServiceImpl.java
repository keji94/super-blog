package com.keji.blog.service.home.impl;

import java.io.IOException;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.service.home.TextSettingsService;
import com.keji.blog.util.cache.CacheTemplate;
import com.keji.blog.util.cache.TextSettingsCacheLoader;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsServiceImpl.java, v 0.1 2018-03-20 10:32 wb-ny291824 Exp $$
 */
public class TextSettingsServiceImpl implements TextSettingsService {

    @Resource
    private CacheTemplate cacheTemplate;

    @Override
    public TextSettingsDO query() throws IOException {
        return cacheTemplate.findData(BlogConstants.TEXT_SETTINGS_KEY, new TypeReference<TextSettingsDO>() {
        }, new TextSettingsCacheLoader());
    }

}
