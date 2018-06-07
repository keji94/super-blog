package com.keji.blog.controller;

import java.util.Arrays;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.TagDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.admin.TagService;
import com.keji.blog.util.LogUtil;
import com.keji.blog.util.TagConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.tag.TagQueryVO;
import com.keji.blog.vo.tag.TagVO;
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
@RequestMapping("/tag")
public class TagController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TagService tagService;

    @ResponseBody
    @RequestMapping("/list")
    public PageResult list(TagQueryVO queryVO) {
        try {
            ValidatorUtils.validateEntity(queryVO, QueryGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        PageInfo<TagDO> pageInfo;
        try {
            pageInfo = tagService.list(TagConvertUtil.convertQueryVO2DO(queryVO), queryVO.getPageIndex(),
                    queryVO.getPageSize());
            return PageResult.makeSuccess(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPages());

        } catch (Exception e) {
            LogUtil.error(logger,e,"[TagController#list]查询标签发生异常，queryVO=%s",queryVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/add")
    public BaseResult add(TagVO tagVO) {
        try {
            ValidatorUtils.validateEntity(tagVO, AddGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            tagService.insert(TagConvertUtil.convertVO2DO(tagVO));
            return BaseResult.makeSuccess();
        } catch (JsonProcessingException e) {
            LogUtil.error(logger,e,"[TagController#add]更新缓存时，json转换发生异常,tagVO=%s",tagVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }catch (Exception e){
            LogUtil.error(logger,e,"[TagController#add]新增菜单发生异常,tagVO=%s",tagVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(TagVO tagVO) {
        try {
            ValidatorUtils.validateEntity(tagVO, UpdateGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            tagService.update(TagConvertUtil.convertVO2DO(tagVO));
            return BaseResult.makeSuccess();
        } catch (JsonProcessingException e) {
            LogUtil.error(logger,e,"[TagController#update]更新缓存时，json转换发生异常,tagVO=%s",tagVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }catch (Exception e){
            LogUtil.error(logger,e,"[TagController#update]更新菜单发生异常,tagVO=%s",tagVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Long[] ids) {
        try {
            tagService.delete(ids);
            return BaseResult.makeSuccess();
        } catch (Exception e) {
            LogUtil.error(logger,e,"[TagController#delete]批量删除时发生异常,ids", Arrays.toString(ids));
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }
}
