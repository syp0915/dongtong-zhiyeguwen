package com.shfc.house.query;

import java.io.Serializable;

/**
 * @Package com.shfc.house.query.RealtorMessageQuery
 * @Description: 经纪人消息查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/15 13:49
 * version V1.0.0
 */
public class RealtorMessageQuery implements Serializable {

    private Integer userType;//用户类型1.经纪人，2.用户
    private Integer mesType ;//详见 SysMessageType.java



    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getMesType() {
        return mesType;
    }

    public void setMesType(Integer mesType) {
        this.mesType = mesType;
    }
}
