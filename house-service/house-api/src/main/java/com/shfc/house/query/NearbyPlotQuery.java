package com.shfc.house.query;

import java.io.Serializable;

/**
 * @Package com.shfc.house.query.NearbyPlotQuery
 * @Description: 附近小区查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/3 17:24
 * version V1.0.0
 */
public class NearbyPlotQuery implements Serializable{

    private static final long serialVersionUID = -9005517300784225128L;

    private String longitude;// 经度

    private String latitude;// 维度

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
