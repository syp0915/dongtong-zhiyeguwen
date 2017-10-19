package com.shfc.adviser.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shfc.adviser.errorCode.ErrorCodeProperties;
import com.shfc.common.base.ValidateHelper;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.apache.log4j.Logger;

/**
 * @Package com.shfc.adviser.filter.AdviserResponseFilter
 * @Description: 响应结果拦截器
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/20 9:56
 * version V1.0.0
 */
public class AdviserResponseFilter implements ContainerResponseFilter {

    public static final Logger LOGGER = Logger.getLogger(AdviserResponseFilter.class);

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {

        String result = String.valueOf(response.getEntity());

        LOGGER.info("响应结果-----------" + result);

        if (!ValidateHelper.isEmpty(result) && !"null".equals(result)) {
            JSONObject object = JSON.parseObject(result);

            if (!object.getBoolean("success")) {
                // 请求失败
                int code = object.getInteger("errCode");
                String msg = object.getString("errMsg");
                if (code != 0 && ValidateHelper.isEmpty(msg)) {
                    String errorMsg = ErrorCodeProperties.getProperties(code);
                    if(!ValidateHelper.isEmpty(errorMsg)){
                        object.put("errMsg", errorMsg);
                    }
                }
                response.setEntity(object.toJSONString());
            }
        }

        return response;
    }
}
