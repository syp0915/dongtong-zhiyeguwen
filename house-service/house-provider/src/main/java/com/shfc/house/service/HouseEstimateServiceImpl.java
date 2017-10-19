package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.HouseEstimate;
import com.shfc.house.domain.Plot;
import com.shfc.house.dto.HouseEstimateDTO;
import com.shfc.house.dto.PlotPriceDTO;
import com.shfc.house.enums.PlotPriceType;
import com.shfc.house.manager.HouseEstimateManager;
import com.shfc.house.manager.PlotManager;
import com.shfc.house.manager.PlotPriceManager;
import com.shfc.house.query.HouseEstimateQuery;
import com.shfc.house.remote.HouseEstimateRemoteServe;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.house.service.HouseEstimateServiceImpl
 * @Description: 估价
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 10:47
 * version V1.0.0
 */
@Service
public class HouseEstimateServiceImpl implements HouseEstimateService {

    @Autowired
    private HouseEstimateManager houseEstimateManager;
    @Autowired
    private PlotPriceManager plotPriceManager;
    @Autowired
    private PlotManager plotManager;
    @Autowired
    private HouseEstimateRemoteServe houseEstimateRemoteServe;

    public static final Logger LOGGER = Logger.getLogger(HouseEstimateServiceImpl.class);

    @Override
    public ResultDO<HouseEstimateDTO> estimate(HouseEstimateQuery query) {

        ResultDO<HouseEstimateDTO> resultDO = new ResultDO<HouseEstimateDTO>();
        String result = checkoutParameters(query);
        if (result != null) {
            resultDO.setErrMsg(result);
            return resultDO;
        }
        // 调用本地库查询历史记录-15日内的记录
        HouseEstimate estimate = houseEstimateManager.queryRecentEstimate(query);
        Plot plot = null;
        Long residenceId = null;
        if (query.getPlotId() != null) {
            plot = plotManager.findPlotById(query.getPlotId());
            if(plot == null){
                resultDO.setErrMsg("小区信息拉取失败");
                return resultDO;
            }

            residenceId = plot.getResidenceId();
        }

        HouseEstimateDTO dto = new HouseEstimateDTO();
        if (estimate != null) {
            // 本地库存在记录-15日内的记录
            BeanUtils.copyProperties(query, dto);
            dto.setPlotName(plot.getPlotName());
            dto.setPrice(estimate.getPrice());
            dto.setTotalPrice(estimate.getTotalPrice());

            resultDO.setData(dto);
        } else {

            if (residenceId == null || residenceId.longValue() == 0l) {
                resultDO.setErrMsg("小区信息拉取失败");
                return resultDO;
            }

            // 回填估价宝小区id
            query.setPlotId(plot.getResidenceId());
            try {
                // 调用估价宝查询估价信息
                ResultDO<String> resultDOEstimate = houseEstimateRemoteServe.estimate(query);
                if (!resultDOEstimate.isSuccess()) {
                    resultDO.setErrMsg(resultDO.getErrMsg());
                    return resultDO;
                }

                String estimateResult = resultDOEstimate.getData();
                if (StringUtils.isEmpty(estimateResult) || JSON.parseObject(estimateResult) == null) {
                    resultDO.setErrMsg("未获取到估价信息");
                    return resultDO;
                }

                JSONObject object = JSON.parseObject(estimateResult);
                // 响应结果 assUnitPrice	估计单价 assTotalPrice估价总价
                BigDecimal assUnitPrice = object.getBigDecimal("assUnitPrice");
                BigDecimal assTotalPrice = object.getBigDecimal("assTotalPrice");

                HouseEstimate houseEstimate = new HouseEstimate();
                BeanUtils.copyProperties(query, houseEstimate);
                houseEstimate.setCreater(query.getRealtorId());
                houseEstimate.setPlotName(plot.getPlotName());
                houseEstimate.setDetailAddress(plot.getPlotAddress());
                houseEstimate.setLatitude(plot.getLatitude());
                houseEstimate.setLongitude(plot.getLongtitude());
                houseEstimate.setPrice(assUnitPrice);
                if (assTotalPrice != null) {
                    houseEstimate.setTotalPrice(assTotalPrice.multiply(new BigDecimal(10000)));
                }
                // 估算房屋信息
                Long estimateId = houseEstimateManager.saveEstimate(houseEstimate);
                BeanUtils.copyProperties(houseEstimate, dto);

                // 查询小区交易趋势
                PlotPriceDTO bean = new PlotPriceDTO();
                // 小区id不为空
                bean.setType(PlotPriceType.PLOT_TREND.getValue());
                bean.setBizId(plot.getId());
                List<PlotPriceDTO> list = plotPriceManager.queryPlotPrice(bean, DateUtils.getLastMonthDate(-7), 6);
                if (list == null && list.size() == 0) {
                    // 未获取到小区本地历史价格
                    list = new ArrayList<PlotPriceDTO>();
                }

                dto.setPriceList(list);
                resultDO.setData(dto);
                resultDO.setSuccess(true);

            } catch (Exception e) {
                LOGGER.error(e);
                resultDO.setErrMsg("系统异常，请联系管理员");
            }
        }

        return resultDO;
    }


    /**
     * @param @param  req
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Title: checkoutParameters
     * @Description: 参数校验
     */
    private String checkoutParameters(HouseEstimateQuery query) {
        if (query.getPlotId() == null) {
            return "小区id不能为空";
        }
        if (query.getArea() == null) {
            return "建筑面积不能为空";
        }
        if (query.getArea() < 5.00f || query.getArea() > 2000.00f) {
            return "您输入的面积不太合理，请重新输入";
        }
        if (query.getRoom() == null) {
            return "房间数不能为空";
        }
        if (query.getHall() == null) {
            return "厅数不能为空";
        }
        if (query.getBathroom() == null) {
            return "卫生间数不能为空";
        }

        if (query.getServeType() == null) {
            return "物业类型不能为空";
        }
        if (query.getServeType() < 1 || (query.getServeType() > 8 && query.getServeType() != 14)) {
            return "物业类型错误";
        }
        if(query.getServeType() < 5 || query.getServeType() > 8){
            // 别墅不需要传递楼层
            if (query.getFloor() == null) {
                return "楼层不能为空";
            }
            if (query.getFloor() < 1 || query.getFloor() > 100) {
                return "您输入的楼层不太合理，请重新输入";
            }
            if (query.getTotalFloor() == null) {
                return "总楼层不能为空";
            }
            if (query.getTotalFloor() < 1 || query.getTotalFloor() > 100) {
                return "您输入的总楼层不太合理，请重新输入";
            }
        }
        return null;
    }
}
