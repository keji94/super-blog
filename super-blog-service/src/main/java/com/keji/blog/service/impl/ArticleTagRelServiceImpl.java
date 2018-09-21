package com.keji.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.google.common.collect.Maps;
import com.keji.blog.dao.ArticleTagRelDAO;
import com.keji.blog.dataobject.ArticleTagRelDO;
import com.keji.blog.service.ArticleTagRelService;
import com.keji.blog.util.MapUtil;
import org.springframework.stereotype.Service;

/**
 * @author wb-ny291824
 * @version $Id: ArticleTagRelServiceImpl.java, v 0.1 2018-03-26 14:28 wb-ny291824 Exp $$
 */
@Service
public class ArticleTagRelServiceImpl implements ArticleTagRelService {

    @Resource
    private ArticleTagRelDAO articleTagRelDAO;

    @Override
    public Map<String, Integer> queryHotTag() {

        Map<String, Integer> hotTag = Maps.newHashMap();
        List<ArticleTagRelDO> articleTagRelDOS = articleTagRelDAO.selectByCondition(new ArticleTagRelDO());

        for (ArticleTagRelDO articleTagRelDO : articleTagRelDOS) {
            String key = articleTagRelDO.getTagName();
            if (hotTag.containsKey(key)) {
                Integer count = hotTag.get(key);
                hotTag.put(key, count + 1);
            }else {
                hotTag.put(key, 1);
            }
        }

        return MapUtil.sortByValue(hotTag,true);
    }
}
