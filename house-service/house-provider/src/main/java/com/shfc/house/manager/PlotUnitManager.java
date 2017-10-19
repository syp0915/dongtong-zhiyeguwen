package com.shfc.house.manager;

import com.shfc.house.dao.PlotUnitMapper;
import com.shfc.house.domain.PlotUnit;
import com.shfc.house.dto.PlotUnitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package com.shfc.house.manager.PlotUnitManager
 * @Description: 小区楼栋列表
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 9:57
 * version V1.0.0
 */
@Service
public class PlotUnitManager {
    @Autowired
    private PlotUnitMapper plotUnitMapper;

    /**
     * @Title: findPlotUnitByPlotId
     * @Description: 根据小区id查询楼栋列表
     * @param @param plotId
     * @param @return    设定文件
     * @return List<PlotUnitBean>    返回类型
     * @throws
     */
    public List<PlotUnitDTO> findPlotUnitByPlotId(Long plotId){

        return plotUnitMapper.findPlotUnitByPlotId(plotId);
    }

    /**
     * @Description: 保存小区楼栋
     * @Title savePlotUnit
     * @Author  lv bin
     * @Date 2016/9/28 12:58
     * @param  list
     * @return void
     * @throws
     */
    @Transactional
    public void savePlotUnit(List<PlotUnitDTO> list){
        if(list != null && list.size() > 0){
            for (PlotUnitDTO dto: list) {
                PlotUnit plotUnit = new PlotUnit();
                BeanUtils.copyProperties(dto, plotUnit);
                plotUnit.setBuildingId(dto.getId());
                plotUnit.setId(null);
                plotUnit.setCreator(-1L);
                plotUnitMapper.insert(plotUnit);
            }

        }
    }
}
