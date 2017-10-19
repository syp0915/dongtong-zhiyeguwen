package com.shfc.house.manager;

import com.shfc.house.dao.LeadsHouseCallMapper;
import com.shfc.house.domain.LeadsHouseCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.house.manager.LeadsHouseCallManager
 * @Description: LeadsHouseCallManager
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 17:12
 * version V1.0.0
 */
@Service
public class LeadsHouseCallManager {
    @Autowired
    private LeadsHouseCallMapper leadsHouseCallMapper;

    /**
     * 查看经纪人是否已拨打过某个房源
     * @param leadsHouseId
     * @param realtorId
     * @return
     */
    public LeadsHouseCall findCallByHouseAndRealtorId(Long leadsHouseId, Long realtorId){
        return leadsHouseCallMapper.findCallByHouseAndRealtorId(leadsHouseId, realtorId);
    }

    /**
     * 保存电话拨打记录
     * @param record
     * @return
     */
    public int insert(LeadsHouseCall record){
        return leadsHouseCallMapper.insert(record);
    }
}
