package com.keji.blog.service.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keji.blog.dataobject.TextSettingsDO;

/**
 * 网站文案设置service
 *
 * @author wb-ny291824
 * @version $Id: TextSettingsService.java, v 0.1 2018-03-20 10:31 wb-ny291824 Exp $$
 */
public interface TextSettingsService {

    /**
     * 查询文案
     *
     * @return
     */
    TextSettingsDO query();

    /**
     * 更新文案
     * @param textSettingsDO 文案对象
     * @throws JsonProcessingException
     */
    void update(TextSettingsDO textSettingsDO) throws JsonProcessingException;
}
