package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.LeadsHouse;
import com.shfc.house.dto.*;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.LeadsHouseQuery;
import com.shfc.mybatis.pagination.Page;

import java.util.List;

/**
 * @Package com.shfc.house.service.LeadsHouseService
 * @Description: LeadsHouseService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 10:22
 * version V1.0.0
 */
public interface LeadsHouseService {

    /**
     * 推荐房源
     * @param count
     * @param realtorId
     * @return
     */
    ResultDO<List<LeadsHouseDTO>> recommendLeadsHouse(Integer count, Long realtorId, String longitude, String latitude);

    /**
     * 房源筛选
     * @param query
     * @return
     */
    ResultDO<Page<LeadsHouseDTO>> queryLeadsHouse(LeadsHouseQuery query);

    /**
     * 房源纠错
     * @param dto
     * @param realtorId
     * @return
     */
    ResultDO<Boolean> correctLeadsHouse(LeadsHouseCorrectDTO dto, Long realtorId);

    /**
     * 房源详情
     * @param leadsHouseId
     * @param realtorId
     * @return
     */
    ResultDO<LeadsHouseDetailDTO> detailLeadsHouse(Long leadsHouseId, Long realtorId);

    /**
     * 按小区名称或地址检索房源
     * @param keyword
     * @return
     */
    ResultDO<List<LeadsPlotDTO>> queryByKeyword(String keyword);

    /**
     * 已看过的房源
     * @param query
     * @param realtorId
     * @return
     */
    ResultDO<Page<LeadsHouseDateDTO>> scanLeadsHouse(BaseQuery query, Long realtorId);

    /**
     * 已拨打过电话的房源
     * @param query
     * @param realtorId
     * @return
     */
    ResultDO<Page<LeadsHouseDateDTO>> callLeadsHouse(BaseQuery query, Long realtorId);

    /**
     * 根据id获取房源信息
     * @param id
     * @return
     */
    LeadsHouse  getLeadsHouseById(Long id);

    /**
     * 授权是否统一
     * @param id
     * @param agree 0-不同意  1-不同意
     * @return
     */
    ResultDO<Boolean> h5Grant(Long id, Integer agree);
}
