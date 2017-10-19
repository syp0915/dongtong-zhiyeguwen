package com.shfc.adviser.ao;

import com.shfc.base.dto.PlotDTO;
import com.shfc.base.service.QueryHotPlotService;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 热门小区
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-10 14:09
 **/
@Service
public class HotPlotAO {
    @Autowired
    private QueryHotPlotService queryHotPlotService;

    public ResultDO<List<PlotDTO>> queryPlot(String blockId){
        return queryHotPlotService.queryPlot(blockId);
    }
}
