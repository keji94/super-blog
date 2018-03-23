package com.keji.blog.service.admin;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.dataobject.InfoBoardDO;

/**
 * 信息版service
 *
 * @author keji
 * @version $Id: InfoBoardService.java, v 0.1 2018-03-23 下午9:06 keji Exp $$
 */
public interface InfoBoardService {

    /**
     * 列表查询
     *
     * @param boardDO boardDO
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo<InfoBoardDO>
     */
    PageInfo<InfoBoardDO> list(InfoBoardDO boardDO, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有
     *
     * @param record record
     * @return List<InfoBoardDO>
     */
    List<InfoBoardDO> listAll(InfoBoardDO record);

    /**
     * 修改
     * @param record record
     */
    void update(InfoBoardDO record) throws JsonProcessingException;

    /**
     * 新增
     * @param record record
     */
    void insert(InfoBoardDO record) throws JsonProcessingException;

    /**
     * 删除
     * @param ids ids
     */
    void delete(Long[] ids) throws JsonProcessingException;
}
