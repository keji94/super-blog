package com.keji.blog.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.bo.ResourceBO;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.vo.resource.ResourceVO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/24
 * @modified: By:
 */
public class ResourceConvertUtil {

    private ResourceConvertUtil(){}

    public static List<ResourceVO> convertDOS2VOS(List<ResourceDO> resourceDOS) {

        ArrayList<ResourceVO> resourceVOS = Lists.newArrayList();

        resourceDOS.forEach(resourceDO -> {
            ResourceVO resourceVO = new ResourceVO();
            resourceVO.setId(resourceDO.getId());
            resourceVO.setIcon(resourceDO.getIcon());
            resourceVO.setOrderNum(resourceDO.getOrderNum());
            resourceVO.setParentId(resourceDO.getParentId());
            resourceVO.setPermission(resourceDO.getPermission());
            resourceVO.setResourceName(resourceDO.getResourceName());
            resourceVO.setResourceUrl(resourceDO.getResourceUrl());
            resourceVO.setStatus(resourceDO.getStatus());
            resourceVO.setType(resourceDO.getType());
            resourceVOS.add(resourceVO);
        });

        return resourceVOS;
    }
}
