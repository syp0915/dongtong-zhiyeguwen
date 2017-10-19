package com.shfc.house.service;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.NnsHouse;
import com.shfc.house.domain.Plot;
import com.shfc.house.dto.NnsHouseDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustDTO;
import com.shfc.house.enums.HouseType;
import com.shfc.house.enums.PriceType;
import com.shfc.house.manager.NnsHouseManager;
import com.shfc.house.manager.PlotManager;
import com.shfc.house.query.NnsHousePublishQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.house.service.NnsHouseServiceImpl
 * @Description: 997房源
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 10:31
 * version V1.0.0
 */
@Service
public class NnsHouseServiceImpl implements NnsHouseService {

    @Autowired
    private NnsHouseManager nnsHouseManager;
    @Autowired
    private PlotManager plotManager;

    public static final Logger LOGGER = Logger.getLogger(NnsHouseServiceImpl.class);

    @Override
    public ResultDO<Long> queryNnsHousePublish(NnsHousePublishQuery query) {
        ResultDO<Long> resultDO = new ResultDO<Long>();
        try {
            resultDO.setData(nnsHouseManager.queryNnsHousePublish(query));
            resultDO.setSuccess(true);
        } catch (Exception e) {
            LOGGER.error("查询房源是否发布异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }

        return resultDO;
    }

    @Override
    public NnsHouse findHouseById(Long nnsHouseId) {
        return nnsHouseManager.findHouseById(nnsHouseId);
    }

    @Override
    public ResultDO<NnsHouseDetailDTO> findDetailHouseById(Long nnsHouseId) {

        ResultDO<NnsHouseDetailDTO> resultDO = new ResultDO<NnsHouseDetailDTO>();
        try {
            resultDO.setData(nnsHouseManager.findDetailHouseById(nnsHouseId));
            resultDO.setSuccess(true);
        } catch (Exception e) {
            LOGGER.error("根据id查询二手房详情", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }

        return resultDO;
    }

    @Override
    public ResultDO<Long> saveNnsHouseEntrust(NnsHouseEntrustDTO dto) {
        ResultDO<Long> resultDO = new ResultDO<Long>();

        String error = checkoutParameters(dto);

        if (error != null) {
            resultDO.setErrMsg(error);
            return resultDO;
        }
        try {
            Plot plot = plotManager.findPlotById(dto.getPlotId());
            if (plot == null) {
                resultDO.setErrMsg("小区不存在");
                return resultDO;
            }
            resultDO = nnsHouseManager.saveNnsHouseEntrust(dto);
        } catch (Exception e) {
            LOGGER.error("添加协议异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }

    private String checkoutParameters(NnsHouseEntrustDTO dto) {

        if (dto.getPlotId() == null) {
            return "小区id不能为空";
        }
        if (ValidateHelper.isEmpty(dto.getUnitNo())) {
            return "楼栋号不能为空";
        }
        if (ValidateHelper.isEmpty(dto.getRoomNo())) {
            return "门牌号不能为空";
        }
        if (dto.getFloor() == null) {
            return "楼层不能为空";
        }
        if (dto.getFloor() < 1 || dto.getFloor() > 100) {
            return "您输入的楼层不太合理，请重新输入";
        }
        if (dto.getTotalFloor() == null) {
            return "总楼层不能为空";
        }
        if (dto.getTotalFloor() < 1 || dto.getTotalFloor() > 100) {
            return "您输入的总楼层不太合理，请重新输入";
        }
        if (dto.getArea() == null) {
            return "建筑面积不能为空";
        }
        if (dto.getArea() < 5.00f || dto.getArea() > 2000.00f) {
            return "您输入的面积不太合理，请重新输入";
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
        if (dto.getHouseType() == null) {
            return "房产证类型不能为空";
        }
        if (dto.getHouseType() < HouseType.UNDER_TWO_YEAR.getValue() ||
                dto.getHouseType() > HouseType.FULL_FIVE_YEAR.getValue()) {
            return "房产证类型错误";
        }
        if (dto.getPriceType() == null) {
            return "房价类型不能为空";
        }
        if (dto.getPriceType() < PriceType.ACTUAL_HAND.getValue() ||
                dto.getPriceType() > PriceType.DUTCH_TAX.getValue()) {
            return "房价类型错误";
        }
        if (dto.getTotalPrice() == null) {
            return "房价不能为空";
        }

        return null;
    }
}
