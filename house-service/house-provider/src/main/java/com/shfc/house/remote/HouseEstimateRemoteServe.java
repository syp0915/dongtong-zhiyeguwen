package com.shfc.house.remote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.common.remote.jersey.RemoteReqService;
import com.shfc.common.result.ResultDO;
import com.shfc.house.query.HouseEstimateQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.fc.house.remote.HouseRemoteServe
 * @Description: 房源估价
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2016/9/28 14:12
 * version V1.0.0
 */
@Service
public class HouseEstimateRemoteServe {
    @Autowired
    private RemoteReqService remoteReqService;

    private final static String ESTIMATE = "estimate/"; // 即时估价

    private final static String VERSION = "V2.0.0";  // 估价宝版本号

    public static final Logger LOGGER = Logger.getLogger(HouseEstimateRemoteServe.class);

    /**
     * @Description: 即时估价
     * @Title estimate
     * @Author  lv bin
     * @Date 2016/9/28 15:00
     * @param  query
     * @return ResultDO<java.lang.String>
     * @throws
     */
    public ResultDO<String> estimate(HouseEstimateQuery query){

        ResultDO<String> resultDO = new ResultDO<String>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("residenceId", query.getPlotId()); // 小区id Y
        params.put("roomNum", query.getRoom()); // 房间数 Y
        params.put("hallNum", query.getHall()); // 厅数 N
        params.put("toiletNum", query.getBathroom()); // 卫生间数 N
        params.put("buildingNo", query.getUnitNo()); // 楼栋号 N
        params.put("roomNo", query.getRoomNo()); // 室号 N
        params.put("propertyTypeId", query.getServeType()); // 物业类型 Y -1：里弄房 2：新工房 3：公寓
        //5：独栋别墅 6：双拼别墅 7：联排别墅 8：叠加别墅 14：新里洋房
        params.put("propertyArea", query.getArea()); //面积 Y
        params.put("placeFloor", query.getFloor()); // 楼层 Y （别墅除外）
        params.put("totalFloor", query.getTotalFloor()); // 总楼层 Y （别墅除外）

        // 响应结果 assUnitPrice	估计单价 assTotalPrice估价总价
        String paramsString = JSON.toJSONString(params);
        String result = remoteReqService.remoteReq(ESTIMATE, VERSION, paramsString);
        LOGGER.info("---------------即时估价--result:::" + result);
        // 状态码 02001200000
        if(!StringUtils.isEmpty(result)){
            JSONObject obj = JSON.parseObject(result);
            String resStatus = obj.getString("resStatus");
            if(resStatus.equals("02001200000")){
                resultDO.setData(obj.getJSONObject("result").toJSONString());
                resultDO.setSuccess(true);
            }else{
                resultDO.setErrMsg(obj.getString("resMessage"));
            }
        }else{
            resultDO.setErrMsg("暂无法为您提供准确估价");
        }
        return resultDO;

    }
}
