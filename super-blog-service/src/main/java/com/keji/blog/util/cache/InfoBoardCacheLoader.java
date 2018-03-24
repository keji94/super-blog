package com.keji.blog.util.cache;

import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.dao.InfoBoardDAO;
import com.keji.blog.dataobject.InfoBoardDO;
import org.springframework.stereotype.Component;

/**
 * @author keji
 * @version $Id: InfoBoardCacheLoader.java, v 0.1 2018-03-23 下午9:17 keji Exp $$
 */
@Component
public class InfoBoardCacheLoader implements CacheLoader<InfoBoardDO>{

    @Resource
    private InfoBoardDAO boardDAO;

    @Override
    public List<InfoBoardDO> load(InfoBoardDO record) {
        return boardDAO.selectByCondition(record);
    }
}
