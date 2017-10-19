package com.shfc.adviser.ao;

import com.shfc.base.dto.BlockInfoDTO;
import com.shfc.base.dto.RegionInfoDTO;
import com.shfc.base.service.AreaExtService;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 区域板块
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-06 14:16
 **/
@Service
public class AreaAO {
    @Autowired
    private AreaExtService areaExtService;

    public ResultDO<List<RegionInfoDTO>> getRegionBlockInfo(String cityId){
        return  areaExtService.getRegionBlockInfo(cityId);
    }
    /**
     * @Description: 根据cityId查询区域
     * @Title queryHotPlot
     * @Author  wuky
     * @Date 2017/4/10 14:16
     * @param cityId
     * @return String
     * @throws
     */
    public ResultDO<List<RegionInfoDTO>> queryRegion(String cityId){
        return  areaExtService.queryRegion(cityId);
    }

    /**
     * @Description: 根据districtId查询板块
     * @Title queryHotPlot
     * @Author  wuky
     * @Date 2017/4/10 14:16
     * @param districtId
     * @return String
     * @throws
     */
    public ResultDO<List<BlockInfoDTO>> queryBlock(String districtId){
        return  areaExtService.queryBlock(districtId);
    }
}
