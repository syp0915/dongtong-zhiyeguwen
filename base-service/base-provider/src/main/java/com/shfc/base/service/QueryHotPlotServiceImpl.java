package com.shfc.base.service;

import com.shfc.base.domain.BaseBlock;
import com.shfc.base.dto.PlotDTO;
import com.shfc.base.manager.AreaExtManager;
import com.shfc.common.base.ValidateHelper;
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
 * @create 2017-01-10 09:23
 **/
@Service
public class QueryHotPlotServiceImpl implements QueryHotPlotService {
    @Autowired
    private AreaExtManager areaExtManager;
    @Override
    public ResultDO<List<PlotDTO>> queryPlot(String plotId) {
        ResultDO<List<PlotDTO>> resultDO=new ResultDO<List<PlotDTO>>();

        if(ValidateHelper.isEmpty(plotId)){
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        BaseBlock baseBlock=areaExtManager.queryByBlockId(Long.parseLong(plotId));

        if(baseBlock==null){
            resultDO.setErrMsg("板块Id对应的板块不存在");
            return resultDO;
        }

        resultDO.setData(areaExtManager.queryHotPlotByBlockId(Long.parseLong(plotId)));


        resultDO.setSuccess(true);
        return resultDO;
    }
}
