package com.shfc.base.service;

import com.shfc.base.dto.PlotDTO;
import com.shfc.common.result.ResultDO;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 热门小区
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-10 09:17
 **/
public interface QueryHotPlotService {
    /**
     * @Description: 根据板块查询热门小区
     * @Title queryPlotByKeyword
     * @Author  wuky
     * @Date 2017/1/10 17:17
     * @param  plotId
     * @return ResultDO<PlotAddressDTO>
     * @throws
     */
    public ResultDO<List<PlotDTO>> queryPlot(String plotId);
}
