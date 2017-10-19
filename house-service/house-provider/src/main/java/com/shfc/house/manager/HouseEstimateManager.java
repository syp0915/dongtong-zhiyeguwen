package com.shfc.house.manager;

import com.shfc.house.dao.HouseEstimateMapper;
import com.shfc.house.domain.HouseEstimate;
import com.shfc.house.query.HouseEstimateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.house.manager.HouseEstimateManager
 * @Description: 估价
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 10:56
 * version V1.0.0
 */
@Service
public class HouseEstimateManager {
    @Autowired
    private HouseEstimateMapper houseEstimateMapper;

    /**
     * @Description: 查询近期估价15天
     * @Title queryRecentEstimate
     * @Author  lv bin
     * @Date 2016/9/28 15:39
     * @param  query
     * @return com.fc.house.domain.HouseEstimate
     * @throws
     */
    public HouseEstimate queryRecentEstimate(HouseEstimateQuery query){
        return houseEstimateMapper.queryRecentEstimate(query);
    }


    public Long saveEstimate(HouseEstimate estimate){
        houseEstimateMapper.insert(estimate);

        return estimate.getId();
    }
}
