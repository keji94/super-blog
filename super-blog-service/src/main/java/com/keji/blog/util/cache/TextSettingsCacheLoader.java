package com.keji.blog.util.cache;

import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.dao.TextSettingsDAO;
import com.keji.blog.dataobject.TextSettingsDO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsCacheLoader.java, v 0.1 2018-03-20 17:48 wb-ny291824 Exp $$
 */
@Component
public class TextSettingsCacheLoader implements CacheLoader<TextSettingsDO>{

    @Resource
    private TextSettingsDAO textSettingsDAO;

    @Override
    public TextSettingsDO load() {
        List<TextSettingsDO> textSettingsDOS = textSettingsDAO.selectByCondition(new TextSettingsDO());
        if (CollectionUtils.isNotEmpty(textSettingsDOS)) {
            return textSettingsDOS.get(0);
        }
        return null;
    }
}
