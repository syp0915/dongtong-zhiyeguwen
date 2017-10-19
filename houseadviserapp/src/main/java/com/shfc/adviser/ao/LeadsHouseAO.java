package com.shfc.adviser.ao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateFormatUtils;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.LeadsHouse;
import com.shfc.house.dto.*;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.LeadsHouseQuery;
import com.shfc.house.service.LeadsHouseService;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.adviser.ao.LeadsHouseAO
 * @Description: LeadsHouse ao
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 9:43
 * version V1.0.0
 */
@Service
public class LeadsHouseAO {

    @Autowired
    private LeadsHouseService leadsHouseService;

    /**
     * 推荐房源
     * @param count
     * @return
     */
    public ResultDO<List<LeadsHouseDTO>> recommendLeadsHouse(Integer count, String longitude, String latitude){
        ResultDO<List<LeadsHouseDTO>> resultDO = new ResultDO<>();
        if(count == null || count < 1){
            resultDO.setErrMsg("加载数据量必须大于1");
            return resultDO;
        }

        return leadsHouseService.recommendLeadsHouse(count, HttpSessionUtils.getCurrentRealtorId(), longitude, latitude);
    }

    /**
     * 房源筛选
     * @param query
     * @return
     */
    public ResultDO<Page<LeadsHouseDTO>> queryLeadsHouse(LeadsHouseQuery query){
        return leadsHouseService.queryLeadsHouse(query);
    }

    /**
     * 房源纠错
     * @param dto
     * @return
     */
    public ResultDO<Boolean> correctLeadsHouse(LeadsHouseCorrectDTO dto){

        ResultDO<Boolean> resultDO = new ResultDO<>();
        if(dto.getLeadsHouseId() == null){
            resultDO.setErrMsg("房源id不能为空");
            return resultDO;
        }

        if(ValidateHelper.isEmpty(dto.getContent()) && ValidateHelper.isEmpty(dto.getTagIds())){
            resultDO.setErrMsg("纠正内容不能为空");
            return resultDO;
        }

        return leadsHouseService.correctLeadsHouse(dto, HttpSessionUtils.getCurrentRealtorId());
    }

    /**
     * 房源详情
     * @param leadsHouseId
     * @return
     */
    public ResultDO<LeadsHouseDetailDTO> detailLeadsHouse(Long leadsHouseId){

        ResultDO<LeadsHouseDetailDTO> resultDO = new ResultDO<>();
        if(leadsHouseId == null){
            resultDO.setErrMsg("房源id不能为空");
            return resultDO;
        }

        return leadsHouseService.detailLeadsHouse(leadsHouseId, HttpSessionUtils.getCurrentRealtorId());
    }

    /**
     * 按小区名称或地址检索房源
     * @param keyword
     * @return
     */
    public ResultDO<List<LeadsPlotDTO>> queryByKeyword(String keyword){
        return leadsHouseService.queryByKeyword(keyword);
    }

    /**
     * 已看过的房源
     * @param query
     * @return
     */
    public ResultDO<Page<LeadsHouseDateDTO>> scanLeadsHouse(BaseQuery query){

        return leadsHouseService.scanLeadsHouse(query, HttpSessionUtils.getCurrentRealtorId());
    }

    /**
     * 已拨打过电话的房源
     * @param query
     * @return
     */
    public ResultDO<Page<LeadsHouseDateDTO>> callLeadsHouse(BaseQuery query){

        return leadsHouseService.callLeadsHouse(query, HttpSessionUtils.getCurrentRealtorId());
    }

    /**
     * h5获取房源信息
     * @param id
     * @return
     */
    public ResultDO<JSONObject> h5LeadsHouseInfo(Long id){
        LeadsHouse leadsHouse = leadsHouseService.getLeadsHouseById(id);
        ResultDO<JSONObject> resultDO = new ResultDO<>();
        if(leadsHouse == null){
            resultDO.setErrMsg("房源不存在");
            return resultDO;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("plotName", leadsHouse.getPlotName());
        jsonObject.put("unitNo", leadsHouse.getUnitNo());
        jsonObject.put("houseNo", leadsHouse.getHouseNo());
        jsonObject.put("grantStatus", leadsHouse.getGrantStatus());
//        jsonObject.put("grantSmsTime", DateUtils.date2String(leadsHouse.getGrantSmsTime(), DateFormatUtils.DATE_FORMAT2));
        jsonObject.put("grantSmsTime", leadsHouse.getGrantSmsTime().getTime());

        resultDO.setData(jsonObject);
        resultDO.setSuccess(true);

        return resultDO;
    }

    /**
     * h5获取房源信息
     * @param id
     * @return
     */
    public ResultDO<Boolean> h5Grant(Long id, Integer agree){

        return leadsHouseService.h5Grant(id, agree);
    }
}

