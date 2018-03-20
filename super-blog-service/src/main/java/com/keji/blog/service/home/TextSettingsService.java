package com.keji.blog.service.home;

import java.io.IOException;

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
    TextSettingsDO query() throws IOException;
}
