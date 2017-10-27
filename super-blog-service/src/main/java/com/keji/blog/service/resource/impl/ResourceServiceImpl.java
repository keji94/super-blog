package com.keji.blog.service.resource.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.keji.blog.bo.ResourceBO;
import com.keji.blog.dao.ResourceDAO;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.dataobject.UserDO;
import com.keji.blog.enums.ResourceStatusEnum;
import com.keji.blog.enums.ResourceTypeEnum;
import com.keji.blog.service.resource.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/24
 * @modified: By:
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDAO resourceDAO;

    public List<ResourceBO> getUserResource(UserDO userDO,Boolean admin) {

        if (Boolean.TRUE) {
            //管理员，查询所有的资源
            return  getAllResource();
        }
        return null;
    }




    @Override
    public List<ResourceBO> getAllResource() {
        //查询所有的根目录
        List<ResourceBO> rootResources = getResourcesByParentId(0L);
        //查询根目录下所有的子目录
        getSubResource(rootResources);

        return rootResources;
    }

    private List<ResourceBO> getSubResource(List<ResourceBO> resourceBOS) {

        List<ResourceBO> subResources =  Lists.newArrayList();

        resourceBOS.forEach(resourceBO -> {
            if (resourceBO.getType() == ResourceTypeEnum.CATALOG.getValue()) {
                //是目录,查询子目录
                resourceBO.setSubResource(getSubResource(getResourcesByParentId(resourceBO.getId())));
            }
            subResources.add(resourceBO);
        });
        return subResources;
    }

    private List<ResourceBO> getResourcesByParentId(Long parentId) {
        return resourceDAO.selectByParentId(parentId);
    }

    @Override
    public List<ResourceDO> getResoureceById(List<Long> roleIds) {

        ArrayList<ResourceDO> result = Lists.newArrayList();

        roleIds.forEach(roleId -> {
            List<ResourceDO> resourceDOS = resourceDAO.selectByRoleId(roleId);
            result.addAll(resourceDOS);
        });

        return result;
    }

    @Override
    public PageInfo<ResourceDO> queryByPage(ResourceDO resourceDO, Integer pageIndex, Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);

        List<ResourceDO> resourceDOS = resourceDAO.selectByCondition(resourceDO);
        PageInfo<ResourceDO> pageInfo = new PageInfo<>(resourceDOS);
        return pageInfo;
    }

    @Override
    public List<ResourceDO> list() {
        List<ResourceDO> resourceDOS = resourceDAO.selectByCondition(new ResourceDO());
        return resourceDOS;
    }

    @Override
    public List<ResourceDO> queryNoButtonResource() {
        return resourceDAO.queryNoButtonResource();
    }
}
