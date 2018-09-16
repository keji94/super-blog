package com.keji.blog.service.home.impl;

import java.util.List;

import com.keji.blog.bo.LinkBO;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.loader.LinkCacheLoader;
import com.keji.blog.service.home.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keji
 * @version $Id: LinkServiceImpl.java, v 0.1 2018-09-16 11:32 keji Exp $$
 */
@Service
public class LinkServiceImpl implements LinkService {

    private CacheService cacheService;

    private LinkCacheLoader cacheLoader;

    @Autowired
    public LinkServiceImpl(CacheService cacheService, LinkCacheLoader cacheLoader) {
        this.cacheService = cacheService;
        this.cacheLoader = cacheLoader;
    }

    @Override
    public List<LinkBO> listAll(LinkBO linkBO) {
        return cacheService.findList(BlogConstants.LINK_KEY,LinkBO.class, cacheLoader,linkBO);
    }
}
