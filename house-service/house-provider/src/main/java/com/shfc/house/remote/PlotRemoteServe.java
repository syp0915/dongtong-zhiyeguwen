package com.shfc.house.remote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shfc.common.remote.jersey.RemoteReqService;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.PlotRoomDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.house.remote.PlotRemoteServe
 * @Description: 小区远程请求服务
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2016/9/28 10:05
 * version V1.0.0
 */
@Service
public class PlotRemoteServe {
    @Autowired
    private RemoteReqService remoteReqService;

    private final static String  RESIDENCE_BUILDING = "residence/building/"; // 2.14.	小区楼栋查询
    private final static String  BUILDING_HOUSE = "building/house/"; // 2.15.	楼栋房屋查询

    private final static String VERSION = "V2.0.0";  // 估价宝版本号

    public static final Logger LOGGER = Logger.getLogger(PlotRemoteServe.class);
    /**
     * @Description: 根据估价宝小区id查询楼盘信息
     * @Title residenceBuilding
     * @Author  lv bin
     * @Date 2016/9/28 10:18
     * @param  residenceId
     * @return ResultDO<java.lang.String>
     * @throws
     */
    public ResultDO<String> residenceBuilding(Long residenceId){

        ResultDO<String> resultDO = new ResultDO<String>();

        if(residenceId == null || residenceId.longValue() == 0l){
            resultDO.setErrMsg("未找到该小区信息");
            return resultDO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("residenceId", residenceId); // 小区id Y

        // 响应结果:result：buildingNo-楼栋号  buildingId-楼栋Id  totalFloor-总楼层
        //                totalRoomNum - 总户数 baiduLon-百度经度  baiduLat - 百度纬度
        // 返回状态 02001200000
        String paramsString = JSON.toJSONString(params);
        String result = remoteReqService.remoteReq(RESIDENCE_BUILDING, VERSION, paramsString);
        LOGGER.info("---------------根据估价宝小区id查询楼盘信息--result:::" + result);
        if(!StringUtils.isEmpty(result)){
            JSONObject obj = JSON.parseObject(result);
            String resStatus = obj.getString("resStatus");
            if(resStatus.equals("02001200000")){
                JSONArray array = obj.getJSONArray("result");
                resultDO.setData(array.toJSONString());

                resultDO.setSuccess(true);
            }else{
                resultDO.setErrMsg(obj.getString("resMessage"));
            }
        }else{
            resultDO.setErrMsg("未找到该小区楼栋信息");
        }

        return resultDO;
    }


    /**
     * @Description: 根据估价宝楼栋id查询房屋信息
     * @Title buildingHouse
     * @Author  lv bin
     * @Date 2016/9/28 10:18
     * @param  buildingId
     * @return ResultDO<PlotRoomBean>
     * @throws
     */
    public ResultDO<List<PlotRoomDTO>> buildingHouse(Long buildingId){

        ResultDO<List<PlotRoomDTO>> resultDO = new ResultDO<List<PlotRoomDTO>>();

        if(buildingId == null || buildingId.longValue() == 0l){
            resultDO.setErrMsg("未找到该小区楼栋信息");
            return resultDO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("buildingId", buildingId); // 楼栋id Y

        // 响应结果:result：roomNo-房号    houseId-房屋Id
        // 返回状态 02001200000
        String paramsString = JSON.toJSONString(params);
        String result = remoteReqService.remoteReq(BUILDING_HOUSE, VERSION, paramsString);
        LOGGER.info("---------------估价宝楼栋id查询房屋信息--result:::" + result);
        if(!StringUtils.isEmpty(result)){
            JSONObject obj = JSON.parseObject(result);
            String resStatus = obj.getString("resStatus");
            if(resStatus.equals("02001200000")){
                JSONArray array = obj.getJSONArray("result");

                List<PlotRoomDTO> list = new ArrayList<PlotRoomDTO>(array.size());
                for (int i = 0; i < array.size() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    PlotRoomDTO bean = new PlotRoomDTO(object.getString("houseId"), object.getString("roomNo"));
                    list.add(bean);
                }
                resultDO.setData(list);
                resultDO.setSuccess(true);
            }else{
                resultDO.setErrMsg(obj.getString("resMessage"));
            }
        }else{
            resultDO.setErrMsg("未找到该楼栋房屋信息");
        }

        return resultDO;
    }

}
