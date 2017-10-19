package com.shfc.house.service;

import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.LeadsHouse;
import com.shfc.house.domain.LeadsHouseCall;
import com.shfc.house.domain.LeadsHouseScan;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.dto.*;
import com.shfc.house.enums.LeadsHouseStatus;
import com.shfc.house.enums.RealtorStatus;
import com.shfc.house.manager.*;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.LeadsHouseQuery;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.house.service.LeadsHouseServiceImpl
 * @Description: LeadsHouseService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 11:57
 * version V1.0.0
 */
@Service
public class LeadsHouseServiceImpl implements LeadsHouseService {

    @Autowired
    private LeadsHouseManager leadsHouseManager;
    @Autowired
    private RealtorInfoManager realtorInfoManager;
    @Autowired
    private LeadsHouseCorrectManager leadsHouseCorrectManager;
    @Autowired
    private LeadsHouseScanManager leadsHouseScanManager;
    @Autowired
    private LeadsHouseCallManager leadsHouseCallManager;
    @Autowired
    private MemberManager memberManager;
    @Override
    public ResultDO<List<LeadsHouseDTO>> recommendLeadsHouse(Integer count, Long realtorId, String longitude, String latitude) {

        ResultDO<List<LeadsHouseDTO>> resultDO = new ResultDO<>();
        List<LeadsHouseDTO> list = new ArrayList<>();
        try {

            if(!ValidateHelper.isEmpty(longitude) && !ValidateHelper.isEmpty(latitude)){
                // 拉取附近的几套房源
                list = leadsHouseManager.nearbyLeadsHouse(count, longitude, latitude);
            }
            // 查询经纪人 根据关注的小区查询房源
            if(realtorId != null && list.size() < count){
                RealtorInfoDTO realtorInfoDTO = realtorInfoManager.myInfo(realtorId);
                if(realtorInfoDTO != null && !ValidateHelper.isEmpty(realtorInfoDTO.getBuildingNameList())){

                    List<Long> leadsHouseIds = null;
                    if(list.size() > 0){
                        leadsHouseIds = new ArrayList<Long>(list.size());
                        for (LeadsHouseDTO dto: list) {
                            leadsHouseIds.add(dto.getId());
                        }
                    }

                    List<LeadsHouseDTO> addList = leadsHouseManager.recommendLeadsHouse(count - list.size(), realtorInfoDTO.getBuildingNameList(), leadsHouseIds);
                    if(addList != null && addList.size() > 0){
                        list.addAll(addList);
                    }
                }
            }
            if(list.size() == 0){
                // 推荐房源没有拉取到就拉取最新的房源
                list = leadsHouseManager.recommendLeadsHouse(count, null, null);
            }
            if(list.size() < count){
                // 根据小区名字拉取数量不足  在数据库拉取一次 且排除
                // 取出已经获取到的房源id
                List<Long> leadsHouseIds = null;
                if(list.size() > 0){
                    leadsHouseIds = new ArrayList<Long>(list.size());
                    for (LeadsHouseDTO dto: list) {
                        leadsHouseIds.add(dto.getId());
                    }
                }
                // 补充拉取
                List<LeadsHouseDTO> addList = leadsHouseManager.recommendLeadsHouse(count - list.size(), null, leadsHouseIds);

                if(addList != null && addList.size() > 0){
                    list.addAll(addList);
                }
            }
        } catch (Exception e) {
            Logger.error(LeadsHouseServiceImpl.class, "查询推荐房源异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }

        resultDO.setData(list);
        resultDO.setSuccess(true);

        return resultDO;
    }

    @Override
    public ResultDO<Page<LeadsHouseDTO>> queryLeadsHouse(LeadsHouseQuery query) {
        ResultDO<Page<LeadsHouseDTO>> resultDO = new ResultDO<>();
        // 房源排序规则：默认按照时间倒序；
        Page<LeadsHouseDTO> page = new Page<>(query.getPageNumber(), query.getPageSize());
        page.setQuery(query);
        try {
            resultDO.setData(leadsHouseManager.queryLeadsHouse(page));
        }catch (Exception e) {
            Logger.error(LeadsHouseServiceImpl.class, "查询房源列表异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }

        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<Boolean> correctLeadsHouse(LeadsHouseCorrectDTO dto, Long realtorId) {

        ResultDO<Boolean> resultDO = new ResultDO<>();
        try {
            LeadsHouse leadsHouse = leadsHouseManager.findLeadsHouseById(dto.getLeadsHouseId());
            if(leadsHouse == null){
                resultDO.setErrMsg("房源不存在");
                return resultDO;
            }
            RealtorUnitiveAccount account = realtorInfoManager.findById(realtorId);
            if(account == null){
                resultDO.setErrMsg("经纪人不存在");
                return resultDO;
            }

            leadsHouseCorrectManager.correctLeadsHouse(dto, realtorId);

            resultDO.setData(true);
        }catch (Exception e) {
            Logger.error(LeadsHouseServiceImpl.class, "房源纠错异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }

        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<LeadsHouseDetailDTO> detailLeadsHouse(Long leadsHouseId, Long realtorId) {

        ResultDO<LeadsHouseDetailDTO> resultDO = new ResultDO<>();
        try {

            LeadsHouse leadsHouse = leadsHouseManager.findLeadsHouseById(leadsHouseId);
            if(leadsHouse == null){
                resultDO.setErrMsg("房源不存在");
                return resultDO;
            }

            RealtorUnitiveAccount account = realtorInfoManager.findById(realtorId);
            if(account == null){
                resultDO.setErrMsg("经纪人不存在");
                return resultDO;
            }

            if(account.getStatus() != RealtorStatus.PASS_AUDIT.getValue()){
                resultDO.setErrMsg("经纪人当前：" + RealtorStatus.getNameByValue(account.getStatus()));
                return resultDO;
            }

            // 判断经纪人是否已查看过该房源
            LeadsHouseScan scan = leadsHouseScanManager.findScanByHouseAndRealtorId(leadsHouseId, realtorId);
            // 是否有权查看标记
            if(scan == null) {
                // 没有查看过-查看权益
                ResultDO<Boolean> booleanResultDO =  memberManager.checkHouseInterest(realtorId);
                if(!booleanResultDO.isSuccess()){
                    // 会员错误状态码 41
                    resultDO.setErrMsg(booleanResultDO.getErrMsg());
                    resultDO.setErrCode(booleanResultDO.getErrCode());

                    return resultDO;
                }
            }

            // 获取是否已经拨打过
            LeadsHouseCall call = leadsHouseCallManager.findCallByHouseAndRealtorId(leadsHouseId, realtorId);

            LeadsHouseDetailDTO detailDTO = leadsHouseManager.getLeadsHouseById(leadsHouseId, realtorId);
            if(detailDTO != null){
                detailDTO.setStatusName(LeadsHouseStatus.getNameByValue(detailDTO.getStatus()));
                if(call != null){
                    detailDTO.setIsCall(true);
                }else{
                    detailDTO.setIsCall(false);
                }
                if(scan != null){
                    detailDTO.setIsScan(true);
                }else{
                    detailDTO.setIsScan(false);
                }
            }

            resultDO.setData(detailDTO);
        }catch (Exception e) {
            Logger.error(LeadsHouseServiceImpl.class, "房源详情异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }

        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<List<LeadsPlotDTO>> queryByKeyword(String keyword) {

        ResultDO<List<LeadsPlotDTO>> resultDO = new ResultDO<>();
        try {
            if(ValidateHelper.isEmpty(keyword)){
                resultDO.setErrMsg("小区名称或地址不能为空");
                return resultDO;
            }
            resultDO.setData(leadsHouseManager.queryByKeyword(keyword));
        }catch (Exception e) {
            Logger.error(LeadsHouseServiceImpl.class, "按小区名称或地址检索房源异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }

        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<Page<LeadsHouseDateDTO>> scanLeadsHouse(BaseQuery query, Long realtorId) {

        ResultDO<Page<LeadsHouseDateDTO>> resultDO = new ResultDO<>();

        try {
            RealtorUnitiveAccount account = realtorInfoManager.findById(realtorId);
            if(account == null){
                resultDO.setErrMsg("经纪人不存在");
                return resultDO;
            }
            Page<LeadsHouseDateDTO> page = new Page<>(query.getPageNumber(), query.getPageSize());
            resultDO.setData(leadsHouseManager.scanLeadsHouse(page, realtorId));
        }catch (Exception e) {
            Logger.error(LeadsHouseServiceImpl.class, "已看过的房源异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }


        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<Page<LeadsHouseDateDTO>> callLeadsHouse(BaseQuery query, Long realtorId) {
        ResultDO<Page<LeadsHouseDateDTO>> resultDO = new ResultDO<>();
        try {
            RealtorUnitiveAccount account = realtorInfoManager.findById(realtorId);
            if(account == null){
                resultDO.setErrMsg("经纪人不存在");
                return resultDO;
            }
            Page<LeadsHouseDateDTO> page = new Page<>(query.getPageNumber(), query.getPageSize());
            resultDO.setData(leadsHouseManager.callLeadsHouse(page, realtorId));
        }catch (Exception e) {
            Logger.error(LeadsHouseServiceImpl.class, "已看过的房源异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }

        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public LeadsHouse getLeadsHouseById(Long id) {
        return leadsHouseManager.findLeadsHouseById(id);
    }

    @Override
    public ResultDO<Boolean> h5Grant(Long id, Integer agree) {
        ResultDO<Boolean> resultDO = new ResultDO<>();
        LeadsHouse leadsHouse = leadsHouseManager.findLeadsHouseById(id);
        if(leadsHouse == null){
            resultDO.setErrMsg("房源不存在");
            return resultDO;
        }

        LeadsHouse house = new LeadsHouse();
        house.setId(id);
        house.setVersion(leadsHouse.getVersion());
        house.setModifier(-1L);
        if(agree.intValue() == 0){
            // 不同意授权
            if(leadsHouse.getGrantStatus() == 4){
                resultDO.setErrMsg("该房源已拒绝授权");
                return resultDO;
            }
            house.setGrantStatus(4);
            leadsHouseManager.modifyLeadsHouse(house);
        }else{
            // 同意授权
            if(leadsHouse.getGrantStatus() == 2){
                resultDO.setErrMsg("该房源已同意授权");
                return resultDO;
            }
            house.setGrantStatus(2);
            house.setGrantTime(new Date());
            leadsHouseManager.modifyLeadsHouse(house);
        }

        resultDO.setSuccess(true);
        return resultDO;
    }
}
