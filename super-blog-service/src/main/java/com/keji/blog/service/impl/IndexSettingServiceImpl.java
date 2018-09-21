package com.keji.blog.service.impl;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.IndexSettingDAO;
import com.keji.blog.dataobject.IndexSettingDO;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.loader.IndexSettingCacheLoader;
import com.keji.blog.service.IndexSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keji
 * @version $Id: IndexSettingServiceImpl.java, v 0.1 2018-09-21 11:02 keji Exp $$
 */
@Service
public class IndexSettingServiceImpl implements IndexSettingService {

    private CacheService cacheService;
    private IndexSettingCacheLoader cacheLoader;

    @Autowired
    public IndexSettingServiceImpl(IndexSettingDAO indexSettingDAO, CacheService cacheService,
                                   IndexSettingCacheLoader cacheLoader) {
        this.cacheLoader = cacheLoader;
        this.cacheService = cacheService;
    }

    @Override
    public IndexSettingDO selectIndexSetting() {
        return cacheService.findObject(BlogConstants.INDEX_SETTING_KEY, IndexSettingDO.class, cacheLoader, null);
    }
}
