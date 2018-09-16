package com.keji.blog.redis.loader;

import java.util.List;

import com.keji.blog.dao.UpdateTimeLineDao;
import com.keji.blog.dataobject.UpdateTimeLineDO;
import com.keji.blog.redis.CacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author keji
 * @version $Id: UpdateTimeLineCacheLoader.java, v 0.1 2018-09-16 9:41 keji Exp $$
 */
@Component
public class UpdateTimeLineCacheLoader implements CacheLoader<UpdateTimeLineDO> {

    private UpdateTimeLineDao timeLineDao;

    @Autowired
    public UpdateTimeLineCacheLoader(UpdateTimeLineDao timeLineDao) {
        this.timeLineDao = timeLineDao;
    }

    @Override
    public List<UpdateTimeLineDO> load(UpdateTimeLineDO updateTimeLineDO) {
        return timeLineDao.listAll();
    }
}
