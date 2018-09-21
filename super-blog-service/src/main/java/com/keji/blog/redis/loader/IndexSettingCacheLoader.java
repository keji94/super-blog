package com.keji.blog.redis.loader;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.dao.IndexSettingDAO;
import com.keji.blog.dataobject.IndexSettingDO;
import com.keji.blog.redis.CacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keji
 * @version $Id: IndexSettingCacheLoader.java, v 0.1 2018-09-21 17:05 keji Exp $$
 */
@Service
public class IndexSettingCacheLoader implements CacheLoader<IndexSettingDO> {

    private IndexSettingDAO indexSettingDAO;

    @Autowired
    public IndexSettingCacheLoader(IndexSettingDAO indexSettingDAO) {
        this.indexSettingDAO = indexSettingDAO;
    }

    @Override
    public List<IndexSettingDO> load(IndexSettingDO indexSettingDO) {
        IndexSettingDO settingDO = indexSettingDAO.selectByPrimaryKey(1L);
        ArrayList<IndexSettingDO> result = Lists.newArrayList();
        result.add(settingDO);
        return result;
    }
}
