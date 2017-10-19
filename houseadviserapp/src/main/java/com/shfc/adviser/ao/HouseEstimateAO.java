package com.shfc.adviser.ao;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.HouseEstimateDTO;
import com.shfc.house.query.HouseEstimateQuery;
import com.shfc.house.service.HouseEstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.adviser.ao.HouseEstimateAO
 * @Description: 房源估价
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 16:31
 * version V1.0.0
 */
@Service
public class HouseEstimateAO {
    @Autowired
    private HouseEstimateService houseEstimateService;

    public ResultDO<HouseEstimateDTO> estimate(HouseEstimateQuery query){
        return houseEstimateService.estimate(query);
    }
}
