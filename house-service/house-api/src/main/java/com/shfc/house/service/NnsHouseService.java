package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.NnsHouse;
import com.shfc.house.dto.NnsHouseDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustDTO;
import com.shfc.house.query.NnsHousePublishQuery;

/**
 * @Package com.shfc.house.service.NnsHouseService
 * @Description: 997 二手房
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 10:14
 * version V1.0.0
 */
public interface NnsHouseService {
    
    /** 
      * @Description: 查询房源是否发布
      * @Title queryNnsHousePublish
      * @Author  lv bin
      * @Date 2017/1/8 10:30
      * @param  query
      * @return ResultDO<Long>
      * @throws 
      */
    ResultDO<Long> queryNnsHousePublish(NnsHousePublishQuery query);

    /**
      * @Description: 根据id查询二手房
      * @Title findHouseById
      * @Author  lv bin
      * @Date 2017/1/8 11:47
      * @param  nnsHouseId
      * @return NnsHouse
      * @throws
      */
    NnsHouse findHouseById(Long nnsHouseId);

    /**
      * @Description: 根据id查询二手房详情
      * @Title findDetailHouseById
      * @Author  lv bin
      * @Date 2017/1/8 11:49
      * @param  nnsHouseId
      * @return ResultDO<NnsHouseDetailDTO>
      * @throws
      */
    ResultDO<NnsHouseDetailDTO> findDetailHouseById(Long nnsHouseId);

    /** 
      * @Description: 添加协议
      * @Title saveNnsHouseEntrust
      * @Author  lv bin
      * @Date 2017/1/10 10:03
      * @param  dto
      * @return ResultDO<Long>
      * @throws 
      */
    ResultDO<Long>  saveNnsHouseEntrust(NnsHouseEntrustDTO dto);
}
