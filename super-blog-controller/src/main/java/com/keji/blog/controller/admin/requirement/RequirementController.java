package com.keji.blog.controller.admin.requirement;

import java.util.Arrays;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.RequirementDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.requirement.RequirementService;
import com.keji.blog.util.RequirementConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.vo.requirement.RequirementQueryVO;
import com.keji.blog.vo.requirement.RequirementVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author keji
 * @version $Id: RequirementController.java, v 0.1 2018/3/18 下午2:44 keji Exp $
 */
@Controller
@RequestMapping("/admin/requirement")
public class RequirementController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RequirementService requirementService;

    @ResponseBody
    @RequestMapping("/query")
    public PageResult<List<RequirementVO>> query(RequirementQueryVO queryVO) {

        try {
            ValidatorUtils.validateEntity(queryVO, QueryGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(e.getMsg());
        }

        PageInfo<RequirementDO> pageInfo;
        List<RequirementVO> pageResultVO;
        try {
            pageInfo = requirementService.query(RequirementConvertUtil.convertQueryVO2DO(queryVO),
                    queryVO.getPageIndex(), queryVO.getPageSize());
            pageResultVO = RequirementConvertUtil.convertDOS2VOS(pageInfo.getList());
        } catch (Exception e) {
            logger.error("需求查询失败,查询参数:" + queryVO, e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return PageResult.makeSuccess(pageResultVO, pageInfo.getTotal());

    }

    @ResponseBody
    @RequestMapping("/queryById")
    public BaseResult<RequirementVO> queryById(Long id) {

        if (id == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        RequirementDO requirementDO;
        RequirementVO requirementVO;
        try {
            requirementDO = requirementService.queryById(id);
            requirementVO = RequirementConvertUtil.convertDO2VO(requirementDO);
        } catch (Exception e) {
            logger.error("需求查询失败,查询参数:" + id, e);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(requirementVO);

    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult<Integer> save(@RequestBody RequirementVO requirementVO) {

        try {
            ValidatorUtils.validateEntity(requirementVO, AddGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        Integer count;
        try {
            count = requirementService.save(RequirementConvertUtil.convertVO2DO(requirementVO));
        } catch (Exception e) {
            logger.error("新增需求失败,参数:" + requirementVO, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(count);
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult<Integer> update(@RequestBody RequirementVO requirementVO) {

        if (!validateParam(requirementVO)) {
            logger.warn("参数校验不通过,param:" + requirementVO);
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        Integer count = null;
        try {
            count = requirementService.update(RequirementConvertUtil.convertVO2DO(requirementVO));
        } catch (Exception e) {
            logger.error("更新需求失败,参数：" + requirementVO, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
        return BaseResult.makeSuccess(count);

    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Long[] ids) {

        if (ids == null || ids.length <= 0) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        Integer count;
        try {
            count = requirementService.delete(ids);
        } catch (Exception e) {
            logger.error("删除失败..ids:" + Arrays.toString(ids), e);
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
