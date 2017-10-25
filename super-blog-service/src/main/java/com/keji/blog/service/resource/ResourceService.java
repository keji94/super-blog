package com.keji.blog.service.resource;

import java.util.List;

import com.keji.blog.bo.ResourceBO;
import com.keji.blog.dataobject.ResourceDO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/24
 * @modified: By:
 */
public interface ResourceService {

    /**
     * 获取所有的资源
     * @return
     */
    List<ResourceBO> getAllResource();

    /**
     * 根据roleCode获取资源
     * @param roleIds
     * @return
     */
    List<ResourceDO> getResoureceById(List<Long> roleIds);


}
