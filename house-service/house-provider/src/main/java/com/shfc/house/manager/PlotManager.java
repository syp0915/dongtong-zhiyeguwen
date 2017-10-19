package com.shfc.house.manager;

import com.shfc.house.dao.PlotMapper;
import com.shfc.house.domain.Plot;
import com.shfc.house.dto.PlotAddressDTO;
import com.shfc.house.query.NearbyPlotQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.shfc.house.manager.PlotManager
 * @Description: 小区接口
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/3 17:13
 * version V1.0.0
 */
@Service
public class PlotManager {

    @Autowired
    private PlotMapper plotMapper;

    public Plot findPlotById(Long id){
        return plotMapper.selectByPrimaryKey(id);
    }

    public List<PlotAddressDTO> queryPlotByKeyword(String keyword){

        return plotMapper.queryPlotByKeyword(keyword);
    }

    public List<PlotAddressDTO> queryNearbyPlotGPS(NearbyPlotQuery query){

        return plotMapper.queryNearbyPlotGPS(query);
    }
}
