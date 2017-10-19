package com.shfc.house.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package com.shfc.house.dto
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author zhoumin
 * @date 17/2/13 下午10:00
 * version V1.0.0
 */
public class HbPrizeRecordDTO implements Serializable {
    private String phone;//中奖人电话

    private String createTime;//修改时间

    public HbPrizeRecordDTO(String phone, String createTime) {
        this.phone = phone;
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
