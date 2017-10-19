package com.shfc.house.manager;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.PlotMapper;
import com.shfc.house.dao.PlotPriceMapper;
import com.shfc.house.domain.Plot;
import com.shfc.house.domain.PlotPrice;
import com.shfc.house.dto.PlotPriceDTO;
import com.shfc.house.enums.PlotPriceType;
import com.shfc.house.remote.DealTrendRemoteServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package com.shfc.house.manager.PlotPriceManager
 * @Description: 价格趋势
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 11:05
 * version V1.0.0
 */
@Service
public class PlotPriceManager {
    @Autowired
    private PlotPriceMapper plotPriceMapper;
    @Autowired
    private DealTrendRemoteServe dealTrendRemoteServe;
    @Autowired
    private PlotMapper plotMapper;


    public List<PlotPriceDTO> queryPlotPrice(PlotPriceDTO bean, String month, int count){

        List<PlotPriceDTO> list = plotPriceMapper.queryPlotPrice(bean, month, count);
        if(list == null || list.size() == 0 || list.size() < count){
            ResultDO<List<PlotPrice>> resultDO = new ResultDO<List<PlotPrice>>();
            // 数据不存在时候，不满足查询条的时候 拉取远程数据
            if(bean.getType() == PlotPriceType.PLOT_TREND.getValue()){
                Plot plot = plotMapper.selectByPrimaryKey(bean.getBizId());
                if(plot != null && plot.getResidenceId() != null){
                    resultDO = dealTrendRemoteServe.residenceDealTrend(plot.getResidenceId(), plot.getId(), null);
                }
            }else if(bean.getType() == PlotPriceType.BLOCK_TREND.getValue()){
                resultDO = dealTrendRemoteServe.blockDealTrend(bean.getBizId(), null);
            }else if(bean.getType() == PlotPriceType.DISTRICT_TREND.getValue()){
                resultDO = dealTrendRemoteServe.districtDealTrend(bean.getBizId(), null);
            }else if(bean.getType() == PlotPriceType.CITY_TREND.getValue()){
                resultDO = dealTrendRemoteServe.cityDealTrend(null);
            }

            if(resultDO.isSuccess()){
                // 远程数据拉取成功
                savePlotPrice(resultDO.getData());
                list = plotPriceMapper.queryPlotPrice(bean, month, count);
            }
        }

        return list;
    }

    @Transactional
    public void savePlotPrice(List<PlotPrice> list){
        if(list != null && list.size() > 0){
            for (PlotPrice plotPrice: list) {
                PlotPrice price = plotPriceMapper.findPlotPrice(plotPrice);
                if(price != null){
                    // 存在则更新记录
                    PlotPrice pp = new PlotPrice();
                    pp.setId(price.getId());
                    pp.setVersion(price.getVersion());
                    pp.setModifier(-1L);
                    pp.setDealAvgPrice1st(plotPrice.getDealAvgPrice1st());
                    pp.setDealAvgPrice2nd(plotPrice.getDealAvgPrice2nd());
                    pp.setDealCount1st(plotPrice.getDealCount1st());
                    pp.setDealCount2nd(plotPrice.getDealCount2nd());
                    plotPriceMapper.updateByPrimaryKeySelective(pp);
                }else{
                    plotPriceMapper.insert(plotPrice);
                }
            }
        }
    }
}
