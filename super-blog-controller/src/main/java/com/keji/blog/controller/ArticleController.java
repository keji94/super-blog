package com.keji.blog.controller;

import java.util.Arrays;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.bo.ArticleBO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.ArticleService;
import com.keji.blog.util.ArticleConvertUtil;
import com.keji.blog.util.LogUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.article.ArticleQueryVO;
import com.keji.blog.vo.article.ArticleVO;
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
@RequestMapping("/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping("/list")
    public PageResult list(ArticleQueryVO queryVO) {
        try {
            ValidatorUtils.validateEntity(queryVO, QueryGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        PageInfo<ArticleBO> pageInfo;
        try {
            pageInfo = articleService.list(ArticleConvertUtil.convertQueryVO2BO(queryVO), queryVO.getPageIndex(),
                    queryVO.getPageSize());
            return PageResult.makeSuccess(ArticleConvertUtil.convertBOS2VOS(pageInfo.getList()), pageInfo.getTotal(),
                    pageInfo.getPages());

        } catch (Exception e) {
            LogUtil.error(logger, e, "[ArticleController#list]查询文章发生异常，queryVO=%s", queryVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/queryById")
    public PageResult queryById(Long id) {
        if (null == id) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        ArticleBO articleBO;
        try {
            articleBO = articleService.queryById(id);
            return PageResult.makeSuccess(ArticleConvertUtil.convertBO2VO(articleBO));

        } catch (Exception e) {
            LogUtil.error(logger, e, "[ArticleController#queryById]根据Id查询文章异常，id=%s", id);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(ArticleVO articleVO) {
        try {
            ValidatorUtils.validateEntity(articleVO, UpdateGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            articleService.update(ArticleConvertUtil.convertVO2DO(articleVO));
            return BaseResult.makeSuccess();
        } catch (Exception e) {
            LogUtil.error(logger, e, "[ArticleController#update]更新文章发生异常,articleVO=%s", articleVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Long[] ids) {
        try {
            articleService.delete(ids);
            return BaseResult.makeSuccess();
        } catch (Exception e) {
            LogUtil.error(logger, e, "[ArticleController#delete]批量删除时发生异常,ids", Arrays.toString(ids));
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }
}
