package com.shfc.house.manager;

import com.shfc.house.dao.LeadsHouseScanMapper;
import com.shfc.house.domain.LeadsHouseScan;
import com.shfc.house.dto.LeadsHouseDateDTO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.house.manager.LeadsHouseScanManager
 * @Description: LeadsHouseScanManager
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 17:13
 * version V1.0.0
 */
@Service
public class LeadsHouseScanManager {
    @Autowired
    private LeadsHouseScanMapper leadsHouseScanMapper;

    /**
     * 查看经纪人是否看过某个房源
     * @param leadsHouseId
     * @param realtorId
     * @return
     */
    public LeadsHouseScan findScanByHouseAndRealtorId(Long leadsHouseId, Long realtorId){
        return leadsHouseScanMapper.findScanByHouseAndRealtorId(leadsHouseId, realtorId);
    }
}
