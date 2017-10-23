package com.keji.blog.controller.requirement;

import java.util.List;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.RequirementDO;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.requirement.RequirementService;
import com.keji.blog.util.RequirementConvertUtil;
import com.keji.blog.vo.requirement.RequirementQueryVO;
import com.keji.blog.vo.requirement.RequirementVO;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
@Controller
@RequestMapping("/requirement")
public class RequirementController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RequirementService requirementService;

    @ResponseBody
    @RequestMapping("/query")
    public PageResult<List<RequirementVO>> query(RequirementQueryVO queryVO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.warn("参数校验不通过,queryVO:"+queryVO);
            return PageResult.makeFail(bindingResult);
        }

        PageInfo<RequirementDO> pageInfo = null;
        List<RequirementVO> pageResultVO = null;
        try {
            pageInfo = requirementService.query(
                RequirementConvertUtil.convertQueryVO2DO(queryVO), queryVO.getPageIndex(),
                queryVO.getPageSize());
            pageResultVO = RequirementConvertUtil.convertDOS2VOS(pageInfo.getList());
        } catch (Exception e) {
            logger.error("需求查询失败,查询参数:"+queryVO,e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return PageResult.makeSuccess(pageResultVO,pageInfo.getTotal());

    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult<Integer> save(@Valid RequirementVO requirementVO,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.warn("参数校验不通过,参数："+requirementVO);
            return BaseResult.makeFail(bindingResult);
        }

        Integer count = null;
        try {
            count = requirementService.save(RequirementConvertUtil.convertVO2DO(requirementVO));
        } catch (Exception e) {
            logger.error("新增需求失败,参数:"+requirementVO,e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(count);
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult<Integer> update(RequirementVO requirementVO) {

        if (validateParam(requirementVO)) {
            logger.warn("参数校验不通过,param:"+requirementVO);
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        Integer count = null;
        try {
            count = requirementService.update(RequirementConvertUtil.convertVO2DO(requirementVO));
        } catch (Exception e) {
            logger.error("更新需求失败,参数："+requirementVO,e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(count);

    }

    private Boolean validateParam(RequirementVO requirementVO) {
        if (null == requirementVO.getId()) {
            return Boolean.FALSE;
        }
        if (null == requirementVO.getTitle()) {
            return Boolean.FALSE;
        }
        if (null == requirementVO.getStatus()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
