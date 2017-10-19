package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.PlotRoomDTO
 * @Description: 室号列表
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/4 9:24
 * version V1.0.0
 */
public class PlotRoomDTO implements Serializable {
    private static final long serialVersionUID = 4051612775640151032L;

    private String roomId; // 房源id

    private String roomNo; // 房源编号


    public PlotRoomDTO() {
    }

    /**
     * @param roomId
     * @param roomNo
     */
    public PlotRoomDTO(String roomId, String roomNo) {
        this.roomId = roomId;
        this.roomNo = roomNo;
    }

    /**
     * @return the roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the roomNo
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}
