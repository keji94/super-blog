package com.keji.blog.service;

import java.util.List;

import com.keji.blog.dataobject.UpdateTimeLineDO;

/**
 * @author keji
 * @version $Id: UpdateTimeLineService.java, v 0.1 2018-09-16 9:34 keji Exp $$
 */
public interface UpdateTimeLineService {

    /**
     * 查询所有
     *
     * @return List<UpdateTimeLineDO>
     */
    List<UpdateTimeLineDO> listAll();
}
