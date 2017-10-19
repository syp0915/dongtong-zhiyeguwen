package com.shfc.house.remote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shfc.common.remote.jersey.RemoteReqService;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.PlotPrice;
import com.shfc.house.enums.PlotPriceType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.fc.house.remote.DealTrendRemoteServe
 * @Description: 交易趋势远程请求服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2016/10/9 10:46
 * version V1.0.0
 */
@Service
public class DealTrendRemoteServe {

    @Autowired
    private RemoteReqService remoteReqService;

    private final static String  CITY_DEAL_TREND = "city/deal/trend/"; // 2.18.	上海市交易趋势查询
    private final static String  DISTRICT_DEAL_TREND = "district/deal/trend/"; // 2.19.	各区县交易趋势查询
    private final static String  BLOCK_DEAL_TREND = "block/deal/trend/"; // 2.20.	各板块交易趋势查询
    private final static String  RESIDENCE_DEAL_TREND = "residence/deal/trend/"; // 2.21.	小区交易趋势查询

    private final static String VERSION = "V2.0.0";  // 估价宝版本号

    public static final Logger LOGGER = Logger.getLogger(DealTrendRemoteServe.class);

    /**
     * @Description: 上海市交易趋势查询-默认查询一年
     * @Title cityDealTrend
     * @Author  lv bin
     * @Date 2016/10/9 10:54
     * @param  month eg:月份（201607） N
     * @return com.fc.common.result.ResultDO<java.util.List<com.fc.house.domain.PlotPrice>>
     * @throws
     */
    public ResultDO<List<PlotPrice>> cityDealTrend(String month){
        ResultDO<List<PlotPrice>> resultDO = new ResultDO<List<PlotPrice>>();
        Map<String, Object> params = new HashMap<String, Object>();
        if(!StringUtils.isEmpty(month)){
            params.put("month", month);  // 月份（201607） N
        }
        // 响应结果:result：districtId-区县Id    month-月份  dealAvgPrice1st-一手房成交均价 dealCount1st - 一手房成交数量
        //                  dealAvgPrice2nd-二手房成交均价 dealCount2nd - 二手房成交数量
        // 返回状态 02001200000
        String paramsString = JSON.toJSONString(params);
        String result = remoteReqService.remoteReq(CITY_DEAL_TREND, VERSION, paramsString);
        LOGGER.info("---------------上海市交易趋势查询--result:::" + result);
        if(!StringUtils.isEmpty(result)){
            JSONObject obj = JSON.parseObject(result);
            String resStatus = obj.getString("resStatus");
            if(resStatus.equals("02001200000")){
                JSONArray array = obj.getJSONArray("result");

                List<PlotPrice> list = new ArrayList<PlotPrice>(array.size());
                for (int i = 0; i < array.size() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    PlotPrice plotPrice = new PlotPrice();
                    plotPrice.setCreator(-1L);
                    plotPrice.setBizId(310000L);
                    plotPrice.setType(PlotPriceType.CITY_TREND.getValue());
                    plotPrice.setMonth(object.getInteger("month"));
                    plotPrice.setDealAvgPrice1st(object.getBigDecimal("dealAvgPrice1st"));
                    plotPrice.setDealCount1st(object.getInteger("dealCount1st"));
                    plotPrice.setDealAvgPrice2nd(object.getBigDecimal("dealAvgPrice2nd"));
                    plotPrice.setDealCount2nd(object.getInteger("dealCount2nd"));
                    list.add(plotPrice);
                }
                resultDO.setData(list);
                resultDO.setSuccess(true);
            }else{
                resultDO.setErrMsg(obj.getString("resMessage"));
            }
        }else{
            resultDO.setErrMsg("上海市交易趋势查询失败");
        }

        return resultDO;
    }

    /**
     * @Description: 各区县交易趋势查询-默认查询一年
     * @Title districtDealTrend
     * @Author  lv bin
     * @Date 2016/10/9 10:54
     * @param  districtId Y
     * @param  month eg:月份（201607） N
     * @return com.fc.common.result.ResultDO<java.util.List<com.fc.house.domain.PlotPrice>>
     * @throws
     */
    public ResultDO<List<PlotPrice>> districtDealTrend(Long districtId, String month){
        ResultDO<List<PlotPrice>> resultDO = new ResultDO<List<PlotPrice>>();

        if(districtId == null || districtId.longValue() == 0l){
            resultDO.setErrMsg("未找到该区县信息");
            return resultDO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("districtId", districtId); // 区域Id Y
        if(!StringUtils.isEmpty(month)){
            params.put("month", month);  // 月份（201607） N
        }
        // 响应结果:result：districtId-区县Id    month-月份  dealAvgPrice1st-一手房成交均价 dealCount1st - 一手房成交数量
        //                  dealAvgPrice2nd-二手房成交均价 dealCount2nd - 二手房成交数量
        // 返回状态 02001200000
        String paramsString = JSON.toJSONString(params);
        String result = remoteReqService.remoteReq(DISTRICT_DEAL_TREND, VERSION, paramsString);
        LOGGER.info("---------------区县交易趋势查询--result:::" + result);
        if(!StringUtils.isEmpty(result)){
            JSONObject obj = JSON.parseObject(result);
            String resStatus = obj.getString("resStatus");
            if(resStatus.equals("02001200000")){
                JSONArray array = obj.getJSONArray("result");

                List<PlotPrice> list = new ArrayList<PlotPrice>(array.size());
                for (int i = 0; i < array.size() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    PlotPrice plotPrice = new PlotPrice();
                    plotPrice.setCreator(-1L);
                    plotPrice.setBizId(districtId);
                    plotPrice.setType(PlotPriceType.DISTRICT_TREND.getValue());
                    plotPrice.setMonth(object.getInteger("month"));
                    plotPrice.setDealAvgPrice1st(object.getBigDecimal("dealAvgPrice1st"));
                    plotPrice.setDealCount1st(object.getInteger("dealCount1st"));
                    plotPrice.setDealAvgPrice2nd(object.getBigDecimal("dealAvgPrice2nd"));
                    plotPrice.setDealCount2nd(object.getInteger("dealCount2nd"));
                    list.add(plotPrice);
                }
                resultDO.setData(list);
                resultDO.setSuccess(true);
            }else{
                resultDO.setErrMsg(obj.getString("resMessage"));
            }
        }else{
            resultDO.setErrMsg("区县交易信息查询失败");
        }

        return resultDO;
    }

    /**
     * @Description: 板块交易趋势查询-默认查询一年
     * @Title blockDealTrend
     * @Author  lv bin
     * @Date 2016/10/9 10:54
     * @param  blockId Y
     * @param  month eg:月份（201607） N
     * @return com.fc.common.result.ResultDO<java.util.List<com.fc.house.domain.PlotPrice>>
     * @throws
     */
    public ResultDO<List<PlotPrice>> blockDealTrend(Long blockId, String month){
        ResultDO<List<PlotPrice>> resultDO = new ResultDO<List<PlotPrice>>();

        if(blockId == null || blockId.longValue() == 0l){
            resultDO.setErrMsg("未找到该板块信息");
            return resultDO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("blockId", blockId); // 板块Id Y
        if(!StringUtils.isEmpty(month)){
            params.put("month", month);  // 月份（201607） N
        }
        // 响应结果:result：blockId-板块Id    month-月份  dealAvgPrice1st-一手房成交均价 dealCount1st - 一手房成交数量
        //                  dealAvgPrice2nd-二手房成交均价 dealCount2nd - 二手房成交数量
        // 返回状态 02001200000
        String paramsString = JSON.toJSONString(params);
        String result = remoteReqService.remoteReq(BLOCK_DEAL_TREND, VERSION, paramsString);
        LOGGER.info("---------------板块交易趋势查询--result:::" + result);
        if(!StringUtils.isEmpty(result)){
            JSONObject obj = JSON.parseObject(result);
            String resStatus = obj.getString("resStatus");
            if(resStatus.equals("02001200000")){
                JSONArray array = obj.getJSONArray("result");

                List<PlotPrice> list = new ArrayList<PlotPrice>(array.size());
                for (int i = 0; i < array.size() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    PlotPrice plotPrice = new PlotPrice();
                    plotPrice.setCreator(-1L);
                    plotPrice.setBizId(blockId);
                    plotPrice.setType(PlotPriceType.BLOCK_TREND.getValue());
                    plotPrice.setMonth(object.getInteger("month"));
                    plotPrice.setDealAvgPrice1st(object.getBigDecimal("dealAvgPrice1st"));
                    plotPrice.setDealCount1st(object.getInteger("dealCount1st"));
                    plotPrice.setDealAvgPrice2nd(object.getBigDecimal("dealAvgPrice2nd"));
                    plotPrice.setDealCount2nd(object.getInteger("dealCount2nd"));
                    list.add(plotPrice);
                }
                resultDO.setData(list);
                resultDO.setSuccess(true);
            }else{
                resultDO.setErrMsg(obj.getString("resMessage"));
            }
        }else{
            resultDO.setErrMsg("板块交易信息查询失败");
        }

        return resultDO;
    }

    /**
     * @Description: 小区交易趋势查询-默认查询一年
     * @Title residenceDealTrend
     * @Author  lv bin
     * @Date 2016/10/9 10:55
     * @param  residenceId Y
     * @param  month eg:月份（201607） N
     * @return com.fc.common.result.ResultDO<java.util.List<com.fc.house.domain.PlotPrice>>
     * @throws
     */
    public ResultDO<List<PlotPrice>> residenceDealTrend(Long residenceId, Long plotId, String month){

        ResultDO<List<PlotPrice>> resultDO = new ResultDO<List<PlotPrice>>();

        if(residenceId == null || residenceId.longValue() == 0l){
            resultDO.setErrMsg("未找到该小区信息");
            return resultDO;
        }


        Map<String, Object> params = new HashMap<String, Object>();
        params.put("residenceId", residenceId); // 小区Id Y
        if(!StringUtils.isEmpty(month)){
            params.put("month", month);  // 月份（201607） N
        }

        // 响应结果:result：residenceId-小区Id   month-月份  dealAvgPrice1st-一手房成交均价 dealCount1st - 一手房成交数量
        //                  dealAvgPrice2nd-二手房成交均价 dealCount2nd - 二手房成交数量
        // 返回状态 02001200000
        String paramsString = JSON.toJSONString(params);
        String result = remoteReqService.remoteReq(RESIDENCE_DEAL_TREND, VERSION, paramsString);
        LOGGER.info("---------------小区交易趋势查询--result:::" + result);
        if(!StringUtils.isEmpty(result)){
            JSONObject obj = JSON.parseObject(result);
            String resStatus = obj.getString("resStatus");
            if(resStatus.equals("02001200000")){
                JSONArray array = obj.getJSONArray("result");

                List<PlotPrice> list = new ArrayList<PlotPrice>(array.size());
                for (int i = 0; i < array.size() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    PlotPrice plotPrice = new PlotPrice();
                    plotPrice.setCreator(-1L);
                    plotPrice.setBizId(plotId);
                    plotPrice.setType(PlotPriceType.PLOT_TREND.getValue());
                    plotPrice.setMonth(object.getInteger("month"));
                    plotPrice.setDealAvgPrice1st(object.getBigDecimal("dealAvgPrice1st"));
                    plotPrice.setDealCount1st(object.getInteger("dealCount1st"));
                    plotPrice.setDealAvgPrice2nd(object.getBigDecimal("dealAvgPrice2nd"));
                    plotPrice.setDealCount2nd(object.getInteger("dealCount2nd"));
                    list.add(plotPrice);
                }
                resultDO.setData(list);
                resultDO.setSuccess(true);
            }else{
                resultDO.setErrMsg(obj.getString("resMessage"));
            }
        }else{
            resultDO.setErrMsg("小区交易信息查询失败");
        }

        return resultDO;
    }
}
