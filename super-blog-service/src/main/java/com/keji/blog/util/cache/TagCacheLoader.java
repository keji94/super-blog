package com.keji.blog.util.cache;

import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.dao.TagDAO;
import com.keji.blog.dataobject.TagDO;
import org.springframework.stereotype.Component;

/**
 * @author wb-ny291824
 * @version $Id: NavCacheLoader.java, v 0.1 2018-03-22 17:06 wb-ny291824 Exp $$
 */
@Component
public class TagCacheLoader implements CacheLoader<TagDO>{

    @Resource
    private TagDAO tagDAO;

    @Override
    public List<TagDO> load(TagDO tagDO) {
        return tagDAO.selectByCondition(tagDO);
    }
}
