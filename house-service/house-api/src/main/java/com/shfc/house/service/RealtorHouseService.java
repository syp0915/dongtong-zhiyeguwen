package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.RealtorHouseDTO;
import com.shfc.house.dto.RealtorHouseDetailDTO;
import com.shfc.house.dto.RealtorHouseInfoDTO;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.RealtorHouseQuery;
import com.shfc.mybatis.pagination.Page;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wuky
 * @version V1.0
 * @create 2017-08-22 14:18
 **/
public interface RealtorHouseService {
    /**
     * 经纪人发布房源
     * @param dto,realtorId
     * @return
     */
    ResultDO<Long> addRealtorHouse(RealtorHouseDTO dto,Long realtorId);

    /**
     * 经纪人编辑房源
     * @param dto,realtorId
     * @return
     */
    ResultDO<String> modifyRealtorHouse(RealtorHouseDTO dto,Long realtorId);


    /**
     * 我发布的二手房列表
     * @return
     */
    ResultDO<Page<RealtorHouseInfoDTO>> getRealtorHouseList(BaseQuery query, Long realtorId);


    /**
     * 根据房源Id查询二手房详情
     * @param houseId
     * @return
     */
    ResultDO<RealtorHouseDetailDTO> getRealtorHouseDetail(Long houseId,Long realtorId);

    /**
     * 二手房上/下架/删除操作
     * @param realtorHouseQuery
     * @return
     */
    ResultDO<Boolean> upDownOrDel(RealtorHouseQuery realtorHouseQuery);
}
