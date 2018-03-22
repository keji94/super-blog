package com.keji.blog.util;

import com.keji.blog.dataobject.NavDO;
import com.keji.blog.vo.nav.NavQueryVO;
import com.keji.blog.vo.nav.NavVO;

/**
 * @author wb-ny291824
 * @version $Id: NavConvertUtil.java, v 0.1 2018-03-22 17:43 wb-ny291824 Exp $$
 */
public class NavConvertUtil {

    public static NavDO convertQueryVO2DO(NavQueryVO queryVO) {
        NavDO navDO = new NavDO();
        navDO.setIcon(queryVO.getIcon());
        navDO.setName(queryVO.getName());
        navDO.setUrl(queryVO.getUrl());
        return navDO;
    }

    public static NavDO convertVO2DO(NavVO navVO) {
        NavDO navDO = new NavDO();
        navDO.setIcon(navVO.getIcon());
        navDO.setName(navVO.getName());
        navDO.setUrl(navVO.getUrl());
        navDO.setId(navVO.getId());
        navDO.setGmtCreate(navVO.getGmtCreate());
        navDO.setGmtModified(navVO.getGmtModified());
        return navDO;
    }
}
