package com.shfc.house.service;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.RealtorHouseStatusFlowMapper;
import com.shfc.house.domain.Plot;
import com.shfc.house.domain.RealtorHouse;
import com.shfc.house.domain.RealtorHouseStatusFlow;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.dto.RealtorHouseDTO;
import com.shfc.house.dto.RealtorHouseDetailDTO;
import com.shfc.house.dto.RealtorHouseInfoDTO;
import com.shfc.house.enums.IsDelete;
import com.shfc.house.enums.Orientation;
import com.shfc.house.manager.PlotManager;
import com.shfc.house.manager.RealtorHouseManager;
import com.shfc.house.manager.RealtorInfoManager;
import com.shfc.house.query.BaseQuery;
import com.shfc.house.query.RealtorHouseQuery;
import com.shfc.mybatis.pagination.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 经纪人房源推广
 *
 * @author wuky
 * @version V1.0
 * @create 2017-08-22 14:20
 **/
@Service
public class RealtorHouseServiceImpl implements RealtorHouseService {
    @Autowired
    private PlotManager plotManager;
    @Autowired
    private RealtorHouseManager realtorHouseManager;

    @Autowired
    private RealtorHouseStatusFlowMapper realtorHouseStatusFlowMapper;

    @Autowired
    private RealtorInfoManager realtorInfoManager;


    public static final Logger LOGGER = Logger.getLogger(RealtorHouseServiceImpl.class);


    @Override
    public ResultDO<Long> addRealtorHouse(RealtorHouseDTO dto,Long realtorId) {
        ResultDO<Long> resultDO=new ResultDO<>();
        String error=checkAddHouseParams(dto);
        if(!ValidateHelper.isEmpty(error)){
            resultDO.setErrMsg(error);
            return resultDO;
        }
        //小区Id不为空时,判断小区信息是否正确
        if(dto.getPlotId()!=null){
            Plot plot = plotManager.findPlotById(dto.getPlotId());
            if (plot == null) {
                resultDO.setErrMsg("小区不存在");
                return resultDO;
            }
            if(!plot.getPlotName().equals(dto.getImportPlotName())){
                resultDO.setErrMsg("小区名称输入有误");
                return resultDO;
            }
            if(!plot.getDistrictId().equals(dto.getDistrictId())||!plot.getBlockId().equals(dto.getBlockId())
                    ||!plot.getLongtitude().equals(dto.getLongitude())||!plot.getLatitude().equals(dto.getLatitude())
                    ||!plot.getPlotAddress().equals(dto.getAddress())){
                resultDO.setErrMsg("小区相关信息输入错误");
                return resultDO;
            }

        }
        //保存房源
        try{
            resultDO=realtorHouseManager.saveRealtorHouse(dto,realtorId);
        }catch (AppException e ){
            LOGGER.error("发布房源异常", e);
            resultDO.setErrMsg("数据库操作异常,请联系管理员");
        }

        return resultDO;
    }
    public String checkAddHouseParams(RealtorHouseDTO dto){
        if (ValidateHelper.isEmpty(dto.getImportPlotName())) {
            return "小区名不能为空";
        }
        if(ValidateHelper.isEmpty(dto.getAddress())){
            return "小区地址不能为空";
        }
//        if(ValidateHelper.isEmpty(dto.getLatitude())||ValidateHelper.isEmpty(dto.getLongitude())){
//            return "小区经纬度不能为空";
//        }
        if (ValidateHelper.isEmpty(dto.getUnitNo())) {
            return "楼栋号不能为空";
        }
        if (ValidateHelper.isEmpty(dto.getUnitNo())) {
            return "楼栋号不能为空";
        }
        if(ValidateHelper.isEmpty(dto.getHouseNo())){
            return "室号不能为空";
        }
        if (dto.getFloor() == null) {
            return "楼层不能为空";
        }
        if (dto.getFloor() < 1 || dto.getFloor() > 1000) {
            return "您输入的楼层不太合理，请重新输入";
        }
        if (dto.getTotalFloor() == null) {
            return "总楼层不能为空";
        }
        if (dto.getTotalFloor() < 1 || dto.getTotalFloor() > 1000) {
            return "您输入的总楼层不太合理，请重新输入";
        }
        if (dto.getArea() == null) {
            return "建筑面积不能为空";
        }
        if (dto.getArea() < 5.00f || dto.getArea() > 2000.00f) {
            return "您输入的面积不太合理，请重新输入";
        }
        if(dto.getOrientation()==null){
            return "朝向不能为空";
        }
        if(dto.getOrientation()< Orientation.EAST.getValue()||dto.getOrientation()>Orientation.NORTHSOUTH.getValue()){
            return "朝向输入有误";
        }

        if (dto.getRoom() == null) {
            return "房间数不能为空";
        }
        if (dto.getHall() == null) {
            return "厅数不能为空";
        }
        if (dto.getBathroom() == null) {
            return "卫生间数不能为空";
        }
        if (dto.getTotalPrice() == null) {
            return "房价不能为空";
        }
        if(ValidateHelper.isEmpty(dto.getEntrustUrl())||dto.getEntrustUrl().size()==0){
            return "需上传委托协议";
        }

        return null;
    }


    @Override
    public ResultDO<String> modifyRealtorHouse(RealtorHouseDTO dto,Long realtorId) {
        ResultDO<String> resultDO=new ResultDO<>();
        if(dto.getHouseId()==null){
            resultDO.setErrMsg("房源Id不能为空");
            return resultDO;
        }
        //step 1:根据houseId获取房源信息
        RealtorHouse realtorHouse=realtorHouseManager.findRealtorHouseById(dto.getHouseId());
        if(realtorHouse==null){
            resultDO.setErrMsg("房源Id对应的房源不存在");
            return resultDO;
        }
        if(realtorHouse.getIsDelete().intValue()== IsDelete.YES.getValue()){
            resultDO.setErrMsg("该房源已删除,不可修改");
            return resultDO;
        }
        if(!realtorHouse.getRealtorId().equals(realtorId)){
            resultDO.setErrMsg("该房源的发布人与当前登录经纪人不符");
            return resultDO;
        }
        //step 2:plotId不为空时,小区名称,区域板块,经纬度不能为空
        // 同时判断小区名称,区域板块id,经纬度是否正确
        if(dto.getPlotId()!=null){
            Plot plot=plotManager.findPlotById(dto.getPlotId());
            if (plot == null) {
                resultDO.setErrMsg("小区不存在");
                return resultDO;
            }
            if(ValidateHelper.isEmpty(dto.getImportPlotName())||ValidateHelper.isEmpty(dto.getDistrictId())
                    ||ValidateHelper.isEmpty(dto.getBlockId())||ValidateHelper.isEmpty(dto.getLongitude())
                    ||ValidateHelper.isEmpty(dto.getLatitude())||ValidateHelper.isEmpty(dto.getAddress())){
                resultDO.setErrMsg("小区相关信息不可为空");
                return resultDO;
            }
            if(!plot.getPlotName().equals(dto.getImportPlotName())){
                resultDO.setErrMsg("小区名称输入不正确");
                return resultDO;
            }
            if(!plot.getDistrictId().equals(dto.getDistrictId())||!plot.getBlockId().equals(dto.getBlockId())
                    ||!plot.getLongtitude().equals(dto.getLongitude())||!plot.getLatitude().equals(dto.getLatitude())
                    ||!plot.getPlotAddress().equals(dto.getAddress())){
                resultDO.setErrMsg("小区相关信息输入错误");
                return resultDO;
            }

        }

        //step 3:修改房源
        try{
            resultDO=realtorHouseManager.modifyRealtorHouse(realtorHouse,dto,realtorId);
        }catch (AppException e ){
            LOGGER.error("修改房源异常",e);
            resultDO.setErrMsg("数据库操作异常,请联系管理员");
        }

        return resultDO;
    }


    @Override
    public ResultDO<Page<RealtorHouseInfoDTO>> getRealtorHouseList(BaseQuery query, Long realtorId) {
        ResultDO<Page<RealtorHouseInfoDTO>> resultDO=new ResultDO<>();
        try {
            RealtorUnitiveAccount account = realtorInfoManager.findById(realtorId);
            if(account == null){
                resultDO.setErrMsg("经纪人不存在");
                return resultDO;
            }
            Page<RealtorHouseInfoDTO> page = new Page<>(query.getPageNumber(), query.getPageSize());
            resultDO.setData(realtorHouseManager.queryHouseList(page, realtorId));
        }catch (Exception e) {
            com.shfc.common.base.Logger.warn(RealtorHouseServiceImpl.class, "二手房列表异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<RealtorHouseDetailDTO> getRealtorHouseDetail(Long houseId,Long realtorId) {
        ResultDO<RealtorHouseDetailDTO> resultDO=new ResultDO<>();
        try{
            RealtorHouse realtorHouse=realtorHouseManager.findRealtorHouseById(houseId);
            if(realtorHouse==null){
                resultDO.setErrMsg("房源不存在");
                return resultDO;
            }
            Long real=realtorHouse.getRealtorId();
            if(real!=null){
                if(realtorId.longValue()!=real.longValue()){
                    resultDO.setErrMsg("该房源不是您发布的房源，暂无权限查看");
                    return resultDO;
                }
            }else{
                resultDO.setErrMsg("该房源暂无经纪人");
                return resultDO;
            }
            RealtorHouseDetailDTO realtorHouseDetailDTO =realtorHouseManager.queryHouseDatail(houseId,realtorId);
            if(realtorHouseDetailDTO.getTotalPrice()!=null){
                realtorHouseDetailDTO.setTotalPrice(realtorHouse.getTotalPrice().divide(new BigDecimal(10000)));
            }
            resultDO.setData(realtorHouseDetailDTO);
        }catch (Exception e) {
            com.shfc.common.base.Logger.warn(RealtorHouseServiceImpl.class, "二手房详情异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<Boolean> upDownOrDel(RealtorHouseQuery realtorHouseQuery) {
        ResultDO<Boolean> resultDO=new ResultDO<>();
        String type=null;
        try {
            RealtorHouse realHouse=realtorHouseManager.findRealtorHouseById(realtorHouseQuery.getHouseId());
            if(realHouse==null){
                resultDO.setErrMsg("房源不存在");
                return resultDO;
            }
            RealtorHouse realtorHouse=new RealtorHouse();
            realtorHouse.setId(realtorHouseQuery.getHouseId());
            //0-上架
            if(realtorHouseQuery.getType()==0){
                realtorHouse.setStatus(2);
                type="上架";
            }
            //1-下架
            if(realtorHouseQuery.getType()==1){
                realtorHouse.setStatus(3);
                type="下架";
            }
            //2-删除
            if(realtorHouseQuery.getType()==2){
                realtorHouse.setIsDelete(2);
                type="删除";
            }
            realtorHouse.setRealtorId(realtorHouseQuery.getRealtorId());
            realtorHouse.setModifier(realtorHouseQuery.getRealtorId());
            int result = realtorHouseManager.updOperation(realtorHouse);
            if (result < 1) {
                resultDO.setData(false);
                resultDO.setErrMsg(type+"操作失败");
                return resultDO;
            }
            //插入上下架状态记录
            if(realtorHouseQuery.getType()!=2){
                RealtorHouseStatusFlow realtorHouseStatusFlow=new RealtorHouseStatusFlow();
                realtorHouseStatusFlow.setHouseId(realtorHouse.getId());
                realtorHouseStatusFlow.setStatus(realtorHouse.getStatus());
                realtorHouseStatusFlow.setCreater(realtorHouse.getRealtorId());
                realtorHouseStatusFlow.setCreateTime(new Date());
                realtorHouseStatusFlowMapper.insert(realtorHouseStatusFlow);
            }
        }catch (Exception e) {
            com.shfc.common.base.Logger.warn(RealtorHouseServiceImpl.class, type+"操作异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }
        resultDO.setData(true);
        resultDO.setSuccess(true);
        return resultDO;
    }

}
