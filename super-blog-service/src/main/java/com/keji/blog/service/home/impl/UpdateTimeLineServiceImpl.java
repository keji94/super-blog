package com.keji.blog.service.home.impl;

import java.util.List;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dataobject.UpdateTimeLineDO;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.loader.UpdateTimeLineCacheLoader;
import com.keji.blog.service.home.UpdateTimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keji
 * @version $Id: UpdateTimeLineServiceImpl.java, v 0.1 2018-09-16 9:34 keji Exp $$
 */
@Service
public class UpdateTimeLineServiceImpl implements UpdateTimeLineService {

    private UpdateTimeLineCacheLoader cacheLoader;

    private CacheService cacheService;

    @Autowired
    public UpdateTimeLineServiceImpl(UpdateTimeLineCacheLoader cacheLoader, CacheService cacheService) {
        this.cacheLoader = cacheLoader;
        this.cacheService = cacheService;
    }

    @Override
    public List<UpdateTimeLineDO> listAll() {
        return cacheService.findList(BlogConstants.UPDATE_TIME_LINE_KEY, UpdateTimeLineDO.class, cacheLoader,
                new UpdateTimeLineDO());
    }
}
