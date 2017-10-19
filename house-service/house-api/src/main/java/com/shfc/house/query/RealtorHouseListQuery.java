package com.shfc.house.query;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.house.query
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-08-22 17:15
 * version V1.0.0
 **/
public class RealtorHouseListQuery extends BaseQuery implements Serializable{


    private static final long serialVersionUID = 4865072634890695229L;


    /**
     * 经纪人Id
     */
    private Long realtorId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }
}
