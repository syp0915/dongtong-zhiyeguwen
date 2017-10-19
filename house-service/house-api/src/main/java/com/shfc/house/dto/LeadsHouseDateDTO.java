package com.shfc.house.dto;

/**
 * @Package com.shfc.house.dto.LeadsHouseDateDTO
 * @Description: LeadsHouseDateDTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 11:06
 * version V1.0.0
 */
public class LeadsHouseDateDTO extends LeadsHouseDTO{

    /**
     * 拨打日期 MM月dd日
     */
    private String dateStr;

    /**
     * 获取属性 拨打日期 MM月dd日
     */
    public String getDateStr() {
        return this.dateStr;
    }

    /**
     * 设置属性 拨打日期 MM月dd日
     */
    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
