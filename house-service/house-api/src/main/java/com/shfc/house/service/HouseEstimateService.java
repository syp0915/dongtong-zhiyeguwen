package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.HouseEstimateDTO;
import com.shfc.house.query.HouseEstimateQuery;

/**
 * @Package com.shfc.house.service.HouseEstimateService
 * @Description: 估价记录
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 10:29
 * version V1.0.0
 */
public interface HouseEstimateService {

    /** 
      * @Description: 估价
      * @Title estimate
      * @Author  lv bin
      * @Date 2017/1/4 10:47
      * @param  query
      * @return ResultDO<HouseEstimateDTO>
      * @throws 
      */
    ResultDO<HouseEstimateDTO> estimate(HouseEstimateQuery query);
}
