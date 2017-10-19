package com.shfc.building.service;

import com.shfc.building.dto.BuildingBasicDetailDTO;
import com.shfc.building.dto.BuildingDTO;
import com.shfc.building.dto.BuildingListRespDTO;
import com.shfc.common.result.ResultDO;

import java.math.BigDecimal;

/**
 * @File com.fc.plot.service.ParkBuildingService.java
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:上海房产
 * 
 * @author lvbin
 * @date 2016年9月5日 下午6:35:50
 * @version V1.0
 */
public interface BuildingService {

    /**
     * 查询楼盘列表
     * @param keyword
     * @param districtId
     * @param blockId
     * @param maxPrice
     * @param minPrice
     * @param roomCount
     * @param ownerType
     * @param pageSize
     * @param pageNumber
     * @return
     */
    ResultDO<BuildingListRespDTO> getBuildingList(String keyword, Long districtId, Long blockId, BigDecimal maxPrice, BigDecimal minPrice, Integer roomCount, Integer ownerType, Integer pageSize, Integer pageNumber);

    /**
     * 获取指定经纪人关注的楼盘列表
     * @param realtorId
     * @param pageSize
     * @param pageNumber
     * @return
     */
    ResultDO<BuildingListRespDTO> getBuildingAttentionList(Long realtorId, Integer pageSize, Integer pageNumber);

    /**
     * 首页新房推荐列表
     * @param longitude
     * @param latitude
     * @return
     */
    ResultDO<BuildingListRespDTO> recommendBuilding(Integer count,String longitude,String latitude);

    /**
     * 新房详情-基本信息
     * @param buildingId
     * @return
     */
    ResultDO<BuildingBasicDetailDTO> buildingBasicDetail(Long realtorId,Long buildingId);


    /**
     * 新房关注操作
     * @param realtorId
     * @param buildingId
     * @param oprType
     * @return
     */
    ResultDO operateBuildingAttention(Long realtorId, Long buildingId, Integer oprType);


    /**
//     * 新房海报/修改
//     * @param buildingDTO
//     * @param buildingId
//     * @param templateId
//     * @return
//     */
//    ResultDO<PosterDTO> buildingPoster(Long buildingId,Long templateId,BuildingDTO buildingDTO);

    ResultDO<BuildingDTO> queryBuildingPoster(Long buildingId);
}
