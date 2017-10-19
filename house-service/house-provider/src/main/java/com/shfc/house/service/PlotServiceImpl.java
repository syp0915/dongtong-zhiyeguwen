package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shfc.common.remote.jersey.RemoteReqService;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.Plot;
import com.shfc.house.dto.PlotAddressDTO;
import com.shfc.house.dto.PlotRoomDTO;
import com.shfc.house.dto.PlotUnitDTO;
import com.shfc.house.manager.PlotManager;
import com.shfc.house.manager.PlotUnitManager;
import com.shfc.house.query.NearbyPlotQuery;
import com.shfc.house.remote.PlotRemoteServe;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.house.service.PlotServiceImpl
 * @Description: 小区
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/3 17:13
 * version V1.0.0
 */
@Service
public class PlotServiceImpl implements PlotService{

    @Autowired
    private PlotManager plotManager;
    @Autowired
    private PlotUnitManager plotUnitManager;
    @Autowired
    private PlotRemoteServe plotRemoteServe;

    public static final Logger LOGGER = Logger.getLogger(PlotServiceImpl.class);
    @Override
    public ResultDO<List<PlotAddressDTO>> queryPlotByKeyword(String keyword) {
        ResultDO<List<PlotAddressDTO>> resultDO = new ResultDO<List<PlotAddressDTO>>();

        try {
            resultDO.setData(plotManager.queryPlotByKeyword(keyword));
            resultDO.setSuccess(true);
        }catch (Exception e){
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }

        return resultDO;
    }

    @Override
    public ResultDO<List<PlotAddressDTO>> queryNearbyPlotGPS(NearbyPlotQuery query) {

        ResultDO<List<PlotAddressDTO>> resultDO = new ResultDO<List<PlotAddressDTO>>();
        try {
            resultDO.setData(plotManager.queryNearbyPlotGPS(query));
            resultDO.setSuccess(true);
        }catch (Exception e){
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }

        return resultDO;
    }

    @Override
    public ResultDO<List<PlotUnitDTO>> findPlotUnitByPlotId(Long plotId) {

        ResultDO<List<PlotUnitDTO>> resultDO = new ResultDO<List<PlotUnitDTO>>();

        try {
            Plot plot = plotManager.findPlotById(plotId);
            if(plot == null){
                resultDO.setErrMsg("小区不存在");
                return resultDO;
            }

            List<PlotUnitDTO> plotUnitBeanList = plotUnitManager.findPlotUnitByPlotId(plotId);
            if(plotUnitBeanList == null || plotUnitBeanList.size() == 0){

                if(plot.getResidenceId() == null || plot.getResidenceId().longValue() == 0l){
                    resultDO.setErrMsg("未查询到该小区楼栋信息");
                    return resultDO;
                }

                ResultDO<String> resultDOStr = plotRemoteServe.residenceBuilding(plot.getResidenceId());
                if(!resultDOStr.isSuccess()){
                    resultDO.setErrMsg(resultDOStr.getErrMsg());
                    return resultDO;
                }

                JSONArray array = JSON.parseArray(resultDOStr.getData());
                if(array != null && array.size() > 0){
                    plotUnitBeanList = new ArrayList<PlotUnitDTO>(array.size());
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        PlotUnitDTO bean = new PlotUnitDTO();
                        bean.setId(object.getLong("buildingId"));
                        bean.setLatitude(object.getString("baiduLat"));
                        bean.setLongitude(object.getString("baiduLon"));
                        bean.setPlotId(plotId);
                        bean.setTotalFloor(object.getInteger("totalFloor"));
                        bean.setTotalRoom(object.getInteger("totalRoomNum"));
                        bean.setUnitNo(object.getString("buildingNo"));
                        plotUnitBeanList.add(bean);
                    }
                    // 同步小区楼栋到本地数据库中
                    plotUnitManager.savePlotUnit(plotUnitBeanList);
                }

                // 新增的重新查询排序后的结果
                plotUnitBeanList = plotUnitManager.findPlotUnitByPlotId(plotId);
            }
            resultDO.setData(plotUnitBeanList);
            resultDO.setSuccess(true);
        }catch (Exception e){
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }

        return resultDO;
    }

    @Override
    public ResultDO<List<PlotRoomDTO>> findRoomByPlotUnitId(Long plotUnitId) {

        return  plotRemoteServe.buildingHouse(plotUnitId);
    }
}
