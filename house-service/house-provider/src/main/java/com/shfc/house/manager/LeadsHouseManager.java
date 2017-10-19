package com.shfc.house.manager;

import com.shfc.house.dao.LeadsHouseMapper;
import com.shfc.house.dao.LeadsHouseScanMapper;
import com.shfc.house.dao.LeadsHouseSeeMapper;
import com.shfc.house.domain.LeadsHouse;
import com.shfc.house.domain.LeadsHouseScan;
import com.shfc.house.domain.LeadsHouseSee;
import com.shfc.house.dto.LeadsHouseDTO;
import com.shfc.house.dto.LeadsHouseDateDTO;
import com.shfc.house.dto.LeadsHouseDetailDTO;
import com.shfc.house.dto.LeadsPlotDTO;
import com.shfc.house.enums.YesNo;
import com.shfc.house.query.LeadsHouseQuery;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package com.shfc.house.manager.LeadsHouseManager
 * @Description: LeadsHouseManager
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 13:33
 * version V1.0.0
 */
@Service
public class LeadsHouseManager {

    @Autowired
    private LeadsHouseMapper leadsHouseMapper;
    @Autowired
    private LeadsHouseScanMapper leadsHouseScanMapper;
    @Autowired
    private LeadsHouseSeeMapper leadsHouseSeeMapper;
    public LeadsHouse findLeadsHouseById(Long id){

        return leadsHouseMapper.selectByPrimaryKey(id);
    }

    public int modifyLeadsHouse(LeadsHouse leadsHouse){
        return leadsHouseMapper.updateByPrimaryKeySelective(leadsHouse);
    }

    public List<LeadsHouseDTO> recommendLeadsHouse(Integer count, String plotNameList, List<Long> leadsHouseIds) {
        return leadsHouseMapper.recommendLeadsHouse(count, plotNameList, leadsHouseIds);
    }

    public Page<LeadsHouseDTO> queryLeadsHouse(Page<LeadsHouseDTO> page) {

        leadsHouseMapper.queryLeadsHouse(page);

        return page;
    }

    public List<LeadsPlotDTO> queryByKeyword(String keyword){

        return leadsHouseMapper.queryByKeyword(keyword);
    }

    public Page<LeadsHouseDateDTO> scanLeadsHouse(Page<LeadsHouseDateDTO> page, Long realtorId){

        leadsHouseMapper.scanLeadsHouse(page, realtorId);

        return page;
    }

    public Page<LeadsHouseDateDTO> callLeadsHouse(Page<LeadsHouseDateDTO> page, Long realtorId){

        leadsHouseMapper.callLeadsHouse(page, realtorId);

        return page;
    }

    @Transactional
    public LeadsHouseDetailDTO getLeadsHouseById(Long leadsHouseId, Long realtorId){

        LeadsHouseDetailDTO dto = leadsHouseMapper.getLeadsHouseById(leadsHouseId);
        // 插入房源查看统计表
        LeadsHouseSee see = new LeadsHouseSee(leadsHouseId, realtorId, realtorId);
        leadsHouseSeeMapper.insert(see);
        // 判断该经济人是否已经浏览过此房源
        LeadsHouseScan scan = leadsHouseScanMapper.findScanByHouseAndRealtorId(leadsHouseId, realtorId);
        if(scan == null){
            scan = new LeadsHouseScan();
            scan.setStatus(YesNo.NO.getValue());
            scan.setCreater(realtorId);
            scan.setLeadsHouseId(leadsHouseId);
            scan.setRealtorId(realtorId);
            leadsHouseScanMapper.insert(scan);
        }

        return dto;
    }

    public List<LeadsHouseDTO> nearbyLeadsHouse(Integer count, String longitude, String latitude) {
        return leadsHouseMapper.nearbyLeadsHouse(count, longitude, latitude);
    }
}
