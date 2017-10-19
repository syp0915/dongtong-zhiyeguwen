package com.shfc.adviser.ao;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.PlotAddressDTO;
import com.shfc.house.dto.PlotRoomDTO;
import com.shfc.house.dto.PlotUnitDTO;
import com.shfc.house.query.NearbyPlotQuery;
import com.shfc.house.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.adviser.ao.PlotAO
 * @Description: 小区
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 13:57
 * version V1.0.0
 */
@Service
public class PlotAO {
    @Autowired
    private PlotService plotService;

    public ResultDO<List<PlotAddressDTO>> queryPlotByKeyword(String keyword){
        ResultDO<List<PlotAddressDTO>> resultDO = new ResultDO<List<PlotAddressDTO>>();
        if(ValidateHelper.isEmptyString(keyword)){
            resultDO.setErrMsg("名称或地址不能为空");
            return resultDO;
        }

        return plotService.queryPlotByKeyword(keyword.trim());
    }

    public ResultDO<List<PlotAddressDTO>> queryNearbyPlotGPS(NearbyPlotQuery query){
        ResultDO<List<PlotAddressDTO>> resultDO = new ResultDO<List<PlotAddressDTO>>();

        if(query == null  || ValidateHelper.isEmptyString(query.getLatitude()) ||
                ValidateHelper.isEmptyString(query.getLongitude())){
            resultDO.setErrMsg("经纬度不能为空");
            return resultDO;
        }

        return plotService.queryNearbyPlotGPS(query);
    }

    public ResultDO<List<PlotUnitDTO>> findPlotUnitByPlotId(Long plotId){
        ResultDO<List<PlotUnitDTO>> resultDO = new ResultDO<List<PlotUnitDTO>>();

        if(plotId == null || plotId.longValue() <= 0l){
            resultDO.setErrMsg("小区id不存在");
            return resultDO;
        }

        return plotService.findPlotUnitByPlotId(plotId);
    }

    public ResultDO<List<PlotRoomDTO>> findRoomByPlotUnitId(Long plotUnitId){
        ResultDO<List<PlotRoomDTO>> resultDO = new ResultDO<List<PlotRoomDTO>>();
        if(plotUnitId == null || plotUnitId.longValue() <= 0l){
            resultDO.setErrMsg("小区楼栋id不存在");
            return resultDO;
        }

        return plotService.findRoomByPlotUnitId(plotUnitId);
    }
}
