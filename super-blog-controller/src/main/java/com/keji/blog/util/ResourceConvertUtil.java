package com.keji.blog.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.vo.resource.ResourceQueryVO;
import com.keji.blog.vo.resource.ResourceVO;

/**
 *
 * @author keji
 * @version $Id: ResourceConvertUtil.java, v 0.1 2018/4/27 下午3:00 keji Exp $
 */
public class ResourceConvertUtil {

    private ResourceConvertUtil() {
    }

    public static List<ResourceVO> convertDOS2VOS(List<ResourceDO> resourceDOS) {

        ArrayList<ResourceVO> resourceVOS = Lists.newArrayList();

        resourceDOS.forEach(resourceDO -> {
            ResourceVO resourceVO = new ResourceVO();
            resourceVO.setId(resourceDO.getId());
            resourceVO.setIcon(resourceDO.getIcon());
            resourceVO.setOrderNum(resourceDO.getOrderNum());
            resourceVO.setParentId(resourceDO.getParentId());
            resourceVO.setParentName(resourceDO.getParentName());
            resourceVO.setPermission(resourceDO.getPermission());
            resourceVO.setName(resourceDO.getResourceName());
            resourceVO.setResourceUrl(resourceDO.getResourceUrl());
            resourceVO.setStatus(resourceDO.getStatus());
            resourceVO.setType(resourceDO.getType());
            resourceVO.setOpen(true);
            resourceVOS.add(resourceVO);
        });

        return resourceVOS;
    }

    public static ResourceDO convertQueryVO2DO(ResourceQueryVO queryVO) {
        ResourceDO resourceDO = new ResourceDO();
        resourceDO.setResourceName(queryVO.getResourceName());
        return resourceDO;
    }

    public static ResourceVO convertDO2VO(ResourceDO resourceDO) {

        ResourceVO resourceVO = new ResourceVO();
        resourceVO.setId(resourceDO.getId());
        resourceVO.setIcon(resourceDO.getIcon());
        resourceVO.setOrderNum(resourceDO.getOrderNum());
        resourceVO.setParentId(resourceDO.getParentId());
        resourceVO.setParentName(resourceDO.getParentName());
        resourceVO.setPermission(resourceDO.getPermission());
        resourceVO.setName(resourceDO.getResourceName());
        resourceVO.setResourceUrl(resourceDO.getResourceUrl());
        resourceVO.setStatus(resourceDO.getStatus());
        resourceVO.setType(resourceDO.getType());
        resourceVO.setOpen(true);
        return resourceVO;

    }

    public static ResourceDO convertVO2DO(ResourceVO resourceVO) {
        ResourceDO resourceDO = new ResourceDO();
        resourceDO.setId(resourceVO.getId());
        resourceDO.setResourceName(resourceVO.getName());
        resourceDO.setIcon(resourceVO.getIcon());
        resourceDO.setParentId(resourceVO.getParentId());
        resourceDO.setParentName(resourceVO.getParentName());
        resourceDO.setOrderNum(resourceVO.getOrderNum());
        resourceDO.setPermission(resourceVO.getPermission());
        resourceDO.setResourceUrl(resourceVO.getResourceUrl());
        resourceDO.setType(resourceVO.getType());
        return resourceDO;
    }

}
