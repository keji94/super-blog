package com.keji.blog.controller.admin.resource;

import java.util.List;

import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.resource.ResourceService;
import com.keji.blog.util.ResourceConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.resource.ResourceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wb-ny291824
 * @version $Id: ResourceController.java, v 0.1 2017-10-26 19:21 wb-ny291824 Exp $$
 */
@Controller
@RequestMapping("/admin/resource")
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

        List<ResourceDO> resourceDOS;
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
            logger.error("queryNoButtonResource 发生异常", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(resourceVOS);

    }

    @ResponseBody
    @RequestMapping("/queryById")
    public BaseResult<ResourceVO> queryById(Long id) {

        ResourceDO resourceDO;
        ResourceVO resourceVO;
        try {
            resourceDO = resourceService.queryById(id);
            resourceVO = ResourceConvertUtil.convertDO2VO(resourceDO);
        } catch (Exception e) {
            logger.error("根据id查询资源失败,id:" + id, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(resourceVO);
    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult save(@RequestBody ResourceVO resourceVO) {

        try {
            ValidatorUtils.validateEntity(resourceVO, AddGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        }

        try {
            Integer count = resourceService.save(ResourceConvertUtil.convertVO2DO(resourceVO));
        } catch (Exception e) {
            logger.error("新增接口失败...", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(@RequestBody ResourceVO resourceVO) {

        try {
            ValidatorUtils.validateEntity(resourceVO, UpdateGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        }

        try {
            Integer count = resourceService.update(ResourceConvertUtil.convertVO2DO(resourceVO));
        } catch (Exception e) {
            logger.error("更新接口失败...", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(Long id) {

        if (id == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            Integer count = resourceService.remove(id);
        } catch (Exception e) {
            logger.error("删除接口失败...", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

}
