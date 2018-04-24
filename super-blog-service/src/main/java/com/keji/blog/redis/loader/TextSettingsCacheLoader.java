package com.keji.blog.redis.loader;

import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.dao.TextSettingsDAO;
import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.redis.CacheLoader;
import org.springframework.stereotype.Component;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsCacheLoader.java, v 0.1 2018-03-20 17:48 wb-ny291824 Exp $$
 */
@Component
public class TextSettingsCacheLoader implements CacheLoader<TextSettingsDO> {

    @Resource
    private TextSettingsDAO textSettingsDAO;

    @Override
    public List<TextSettingsDO> load(TextSettingsDO textSettingsDO) {
        return textSettingsDAO.selectByCondition(textSettingsDO);
    }
}
