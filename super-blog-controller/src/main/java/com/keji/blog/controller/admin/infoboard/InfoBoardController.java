package com.keji.blog.controller.admin.infoboard;

import java.util.Arrays;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.InfoBoardDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.PageResult;
import com.keji.blog.service.admin.InfoBoardService;
import com.keji.blog.util.LogUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.QueryGroup;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.infoboard.InfoBoardQueryVO;
import com.keji.blog.vo.infoboard.InfoBoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author keji
 * @version $Id: InfoBoardController.java, v 0.1 2018-03-23 下午9:27 keji Exp $$
 */
@Controller
@RequestMapping("/infoBoard")
public class InfoBoardController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Resource
    private InfoBoardService infoBoardService;

    @ResponseBody
    @RequestMapping("/list")
    public PageResult list(InfoBoardQueryVO queryVO) {

        try {
            ValidatorUtils.validateEntity(queryVO, QueryGroup.class);
        } catch (BlogException e) {
            PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        PageInfo<InfoBoardDO> pageInfo ;
        try {
            pageInfo = infoBoardService.list(initDO(queryVO), queryVO.getPageIndex(),
                    queryVO.getPageSize());
            return PageResult.makeSuccess(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPages());
        } catch (Exception e) {
            LogUtil.error(logger,e,"[InfoBoardController#list]查询列表时发生异常,queryVO=%s",queryVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);

        }

    }

    @ResponseBody
    @RequestMapping("/add")
    public BaseResult add(InfoBoardVO boardVO) {
        try {
            ValidatorUtils.validateEntity(boardVO, QueryGroup.class);
        } catch (BlogException e) {
            PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            infoBoardService.insert(convertVO2DO(boardVO));
            return BaseResult.makeSuccess();
        } catch (Exception e) {
            LogUtil.error(logger,e,"[InfoBoardController#add]信息板新增时发生异常,boardVO=%s",boardVO);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(InfoBoardVO boardVO) {
        try {
            ValidatorUtils.validateEntity(boardVO, UpdateGroup.class);
        } catch (BlogException e) {
            return PageResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            infoBoardService.update(convertVO2DO(boardVO));
            return BaseResult.makeSuccess();
        } catch (JsonProcessingException e) {
            LogUtil.error(logger,e,"[InfoBoardController#update]更新缓存时，json转换发生异常,boardVO=%s",boardVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }catch (Exception e){
            LogUtil.error(logger,e,"[InfoBoardController#update]更新菜单发生异常,boardVO=%s",boardVO);
            return PageResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Long[] ids) {
        try {
            infoBoardService.delete(ids);
            return BaseResult.makeSuccess();
        } catch (Exception e) {
            LogUtil.error(logger,e,"[InfoBoardController#delete]批量删除时发生异常,ids", Arrays.toString(ids));
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }
    }

    private InfoBoardDO convertVO2DO(InfoBoardVO boardVO) {
        InfoBoardDO infoBoardDO = new InfoBoardDO();
        infoBoardDO.setTitle(boardVO.getTitle());
        infoBoardDO.setContent(boardVO.getContent());
        infoBoardDO.setGmtCreate(boardVO.getGmtCreate());
        infoBoardDO.setGmtModified(boardVO.getGmtModified());
        infoBoardDO.setId(boardVO.getId());
        return infoBoardDO;

    }

    private InfoBoardDO initDO(InfoBoardQueryVO queryVO) {
        InfoBoardDO infoBoardDO = new InfoBoardDO();
        infoBoardDO.setTitle(queryVO.getTitle());
        return infoBoardDO;
    }
}
