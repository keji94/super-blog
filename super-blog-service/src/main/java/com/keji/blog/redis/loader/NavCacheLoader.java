package com.keji.blog.redis.loader;

import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.dao.NavDAO;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.redis.CacheLoader;
import org.springframework.stereotype.Component;

/**
 * @author wb-ny291824
 * @version $Id: NavCacheLoader.java, v 0.1 2018-03-22 17:06 wb-ny291824 Exp $$
 */
@Component
public class NavCacheLoader implements CacheLoader<NavDO> {

    @Resource
    private NavDAO navDAO;

    @Override
    public List<NavDO> load(NavDO navDO) {
        return navDAO.selectByCondition(navDO);
    }
}
