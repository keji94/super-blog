package com.keji.blog.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.dataobject.RequirementDO;
import com.keji.blog.vo.requirement.RequirementQueryVO;
import com.keji.blog.vo.requirement.RequirementVO;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/23
 * @modified: By:
 */
public class RequirementConvertUtil {

    private RequirementConvertUtil (){}

    public static RequirementDO convertVO2DO(RequirementVO requirementVO) {
        RequirementDO requirementDO = new RequirementDO();
        requirementDO.setContent(requirementVO.getContent());
        requirementDO.setStatus(requirementVO.getStatus());
        requirementDO.setSummary(requirementVO.getSummary());
        requirementDO.setTitle(requirementVO.getTitle());
        return requirementDO;
    }

    public static RequirementDO convertQueryVO2DO(RequirementQueryVO queryVO) {
        RequirementDO requirementDO = new RequirementDO();
        requirementDO.setContent(queryVO.getContent());
        requirementDO.setStatus(queryVO.getStatus());
        requirementDO.setTitle(queryVO.getTitle());
        return requirementDO;
    }

    public static List<RequirementVO> convertDOS2VOS(List<RequirementDO> list) {

        ArrayList<RequirementVO> listVO = Lists.newArrayList();

        list.forEach(requirementDO -> {
            RequirementVO requirementVO = new RequirementVO();
            requirementVO.setContent(requirementDO.getContent());
            requirementVO.setStatus(requirementDO.getStatus());
            requirementVO.setId(requirementDO.getId());
            requirementVO.setSummary(requirementDO.getSummary());
            requirementVO.setTitle(requirementDO.getTitle());
            listVO.add(requirementVO);
        });
        return listVO;
    }
}
