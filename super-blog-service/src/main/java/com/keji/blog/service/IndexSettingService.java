package com.keji.blog.service;

import com.keji.blog.dataobject.IndexSettingDO;

/**
 * @author keji
 * @version $Id: IndexSettingService.java, v 0.1 2018-09-21 11:02 keji Exp $$
 */
public interface IndexSettingService {

    /**
     * 查询首页设置
     *
     * @return IndexSettingDO
     */
    IndexSettingDO selectIndexSetting();

}
