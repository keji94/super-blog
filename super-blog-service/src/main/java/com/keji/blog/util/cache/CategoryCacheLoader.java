package com.keji.blog.util.cache;

import java.util.List;

import com.keji.blog.dao.CategoryDAO;
import com.keji.blog.dataobject.CategoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author keji
 * @version $Id: CategoryCacheLoader.java, v 0.1 2018-03-25 下午3:46 keji Exp $$
 */
@Component
public class CategoryCacheLoader implements CacheLoader<CategoryDO>{

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<CategoryDO> load(CategoryDO categoryDO) {
        return categoryDAO.selectByCondition(categoryDO);
    }
}
