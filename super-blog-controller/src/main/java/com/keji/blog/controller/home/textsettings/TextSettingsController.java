package com.keji.blog.controller.home.textsettings;

import java.io.IOException;

import javax.annotation.Resource;

import com.keji.blog.dataobject.TextSettingsDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.home.TextSettingsService;
import com.keji.blog.util.LogUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.textsetting.TextSettingsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文案设置controller
 *
 * @author wb-ny291824
 * @version $Id: TextSettingsController.java, v 0.1 2018-03-21 11:17 wb-ny291824 Exp $$
 */
@Controller
@RequestMapping("/textsettings")
public class TextSettingsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TextSettingsService textSettingsService;

    @ResponseBody
    @RequestMapping("/query")
    public BaseResult query() {
        try {
            TextSettingsDO textSettingsDO = textSettingsService.query();
            return BaseResult.makeSuccess(textSettingsDO);
        } catch (IOException e) {
            LogUtil.error(logger, e, "json转换时发生异常");
            return BaseResult.makeFail("json转换时发生异常");
        } catch (Exception e) {
            LogUtil.error(logger,e,"查询文本设置发生异常");
            return BaseResult.makeFail("查询文本设置发生异常");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(@RequestBody TextSettingsVO textSettingsVO) {
        try {
            textSettingsService.update(convertVO2DO(textSettingsVO));
            return BaseResult.makeSuccess();
        } catch (Exception e) {
            LogUtil.error(logger,e,"更新文案发生异常,TextSettingsVO=",textSettingsVO);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

    }

    private TextSettingsDO convertVO2DO(TextSettingsVO settingsVO) {
        TextSettingsDO textSettingsDO = new TextSettingsDO();
        textSettingsDO.setAbout(settingsVO.getAbout());
        textSettingsDO.setHome(settingsVO.getHome());
        textSettingsDO.setInformationBoard(settingsVO.getInformationBoard());
        textSettingsDO.setLogo(settingsVO.getLogo());
        textSettingsDO.setNote(settingsVO.getNote());
        textSettingsDO.setPageHeader(settingsVO.getPageHeader());
        textSettingsDO.setPageRooting(settingsVO.getPageRooting());
        textSettingsDO.setSearch(settingsVO.getSearch());
        textSettingsDO.setTitle(settingsVO.getTitle());
        textSettingsDO.setId(settingsVO.getId());
        textSettingsDO.setCommentOpen(settingsVO.getCommentOpen());
        textSettingsDO.setLeaveWordOpen(settingsVO.getLeaveWordOpen());
        textSettingsDO.setAnnouncement(settingsVO.getAnnouncement());
        textSettingsDO.setLeaveWordAnnouncement(settingsVO.getLeaveWordAnnouncement());
        return textSettingsDO;
    }

}
