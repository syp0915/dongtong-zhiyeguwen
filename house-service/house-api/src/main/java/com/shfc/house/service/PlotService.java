package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.PlotAddressDTO;
import com.shfc.house.dto.PlotRoomDTO;
import com.shfc.house.dto.PlotUnitDTO;
import com.shfc.house.query.NearbyPlotQuery;

import java.util.List;

/**
 * @Package com.shfc.house.service.PlotService
 * @Description: 小区接口
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/3 17:12
 * version V1.0.0
 */
public interface PlotService {

     /**
      * @Description: 根据关键字查询小区
      * @Title queryPlotByKeyword
      * @Author  lv bin
      * @Date 2017/1/3 17:17
      * @param  keyword
      * @return ResultDO<PlotAddressDTO>
      * @throws
      */
     ResultDO<List<PlotAddressDTO>> queryPlotByKeyword(String keyword);

     /**
      * @Description: 根据经纬度获取周边小区
      * @Title queryNearbyPlotGPS
      * @Author  lv bin
      * @Date 2017/1/3 17:17
      * @param  query
      * @return ResultDO<PlotAddressDTO>
      * @throws
      */
     ResultDO<List<PlotAddressDTO>> queryNearbyPlotGPS(NearbyPlotQuery query);

     /**
       * @Description: 查询小区楼栋数量
       * @Title findPlotUnitByPlotId
       * @Author  lv bin
       * @Date 2017/1/4 9:53
       * @param  plotId
       * @return ResultDO<List<PlotUnitDTO>>
       * @throws
       */
     ResultDO<List<PlotUnitDTO>> findPlotUnitByPlotId(Long plotId);

     /**
      * @Description: 根据小区楼栋id查询房屋编号
      * @Title: findRoomByPlotUnitId
      * @param @param plotUnitId
      * @return ResultDO<List<PlotRoomDTO>>
      * @throws
      */
     ResultDO<List<PlotRoomDTO>> findRoomByPlotUnitId(Long plotUnitId);
}
