package com.keji.blog.redis.loader;

import java.util.List;

import com.keji.blog.bo.LinkBO;
import com.keji.blog.dao.LinkDao;
import com.keji.blog.redis.CacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author keji
 * @version $Id: LinkCacheLoader.java, v 0.1 2018-09-16 11:02 keji Exp $$
 */
@Component
public class LinkCacheLoader implements CacheLoader<LinkBO> {

    private LinkDao linkDao;

    @Autowired
    public LinkCacheLoader(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public List<LinkBO> load(LinkBO linkBO) {
        return linkDao.listAll();
    }
}
