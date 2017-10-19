package com.shfc.house.query;

import java.io.Serializable;

/**
 * @Package com.shfc.house.query.NnsHousePublishQuery
 * @Description: 997 房源是否发布查询
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 10:27
 * version V1.0.0
 */
public class NnsHousePublishQuery implements Serializable {

    private static final long serialVersionUID = -3523793892299767867L;
    private Long plotId; // 小区id
    private String unitNo;// 楼栋号
    private String roomNo;// 门牌号

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}
