package com.keji.blog.controller.resource;

import java.util.Arrays;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.bo.ResourceBO;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.resource.ResourceService;
import com.keji.blog.util.ResourceConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.vo.resource.ResourceQueryVO;
import com.keji.blog.vo.resource.ResourceVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wb-ny291824
 * @version $Id: ResourceController.java, v 0.1 2017-10-26 19:21 wb-ny291824 Exp $$
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResourceService resourceService;

    @ResponseBody
    @RequestMapping("/query")
    public List<ResourceVO> query() {

        List<ResourceDO> resourceDOS;
        List<ResourceVO> resourceVOS;
        try {
            resourceDOS = resourceService.list();
            resourceVOS = ResourceConvertUtil.convertDOS2VOS(resourceDOS);
        } catch (Exception e) {
            logger.error("查询资源失败", e);
            return null;
        }
        return resourceVOS;

    }

    /**
     * 查找没有按钮级别的资源
     */
    @ResponseBody
    @RequestMapping("/queryNoButtonResource")
    public BaseResult<List<ResourceVO>> queryNoButtonResource() {

        List<ResourceDO> resourceDOS ;
        List<ResourceVO> resourceVOS;
        try {
            resourceDOS = resourceService.queryNoButtonResource();

            //添加顶级菜单
            ResourceDO root = new ResourceDO();
            root.setId(0L);
            root.setResourceName("一级菜单");
            root.setParentId(-1L);
            resourceDOS.add(root);
            resourceVOS = ResourceConvertUtil.convertDOS2VOS(resourceDOS);
        } catch (Exception e) {
            logger.error("queryNoButtonResource 发生异常",e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(resourceVOS);

    }

    @ResponseBody
    @RequestMapping("/queryById")
    public BaseResult<ResourceVO> queryById(Long id) {

        List<ResourceDO> resoureceById;
        ResourceVO resourceVO;
        try {
            resoureceById = resourceService.getResoureceById(Arrays.asList(id));
            resourceVO = ResourceConvertUtil.convertDO2VO(resoureceById.get(0));
            if (CollectionUtils.isEmpty(resoureceById)) {
                throw new RuntimeException();
            }

        } catch (Exception e) {
            logger.error("根据id查询资源失败,id:"+id,e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(resourceVO);
    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult save(ResourceVO resourceVO) {
        return BaseResult.makeSuccess();
    }



}
