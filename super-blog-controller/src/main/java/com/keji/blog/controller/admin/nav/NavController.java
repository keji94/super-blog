package com.keji.blog.controller.admin.nav;

import java.util.Arrays;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.NavDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.admin.NavService;
import com.keji.blog.util.LogUtil;
import com.keji.blog.util.NavConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.nav.NavQueryVO;
import com.keji.blog.vo.nav.NavVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wb-ny291824
 * @version $Id: NavController.java, v 0.1 2018-03-22 17:25 wb-ny291824 Exp $$
 */
@Controller
@RequestMapping("/adminNav")
public class NavController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NavService navService;

    @ResponseBody
    @RequestMapping("/list")
    public PageResult list(NavQueryVO queryVO) {
        try {
            ValidatorUtils.validateEntity(queryVO, QueryGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        PageInfo<NavDO> pageInfo;
        try {
            pageInfo = navService.list(NavConvertUtil.convertQueryVO2DO(queryVO), queryVO.getPageIndex(),
                    queryVO.getPageSize());
            return PageResult.makeSuccess(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPages());

        } catch (Exception e) {
            LogUtil.error(logger,e,"[NavController#list]查询菜单发生异常，queryVO=%s",queryVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/add")
    public BaseResult add(NavVO navVO) {
        try {
            ValidatorUtils.validateEntity(navVO, AddGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            navService.insert(NavConvertUtil.convertVO2DO(navVO));
            return BaseResult.makeSuccess();
        } catch (JsonProcessingException e) {
            LogUtil.error(logger,e,"[NavController#add]更新缓存时，json转换发生异常,navVO=%s",navVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }catch (Exception e){
            LogUtil.error(logger,e,"[NavController#add]新增菜单发生异常,navVO=%s",navVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(NavVO navVO) {
        try {
            ValidatorUtils.validateEntity(navVO, UpdateGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            navService.update(NavConvertUtil.convertVO2DO(navVO));
            return BaseResult.makeSuccess();
        } catch (JsonProcessingException e) {
            LogUtil.error(logger,e,"[NavController#update]更新缓存时，json转换发生异常,navVO=%s",navVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }catch (Exception e){
            LogUtil.error(logger,e,"[NavController#update]更新菜单发生异常,navVO=%s",navVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Long[] ids) {
        try {
            navService.delete(ids);
            return BaseResult.makeSuccess();
        } catch (Exception e) {
            LogUtil.error(logger,e,"[NavController#delete]批量删除时发生异常,ids", Arrays.toString(ids));
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }
}
