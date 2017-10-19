package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-12 9:44
 * version V1.0.0
 **/
public class CommissionDTO implements Serializable{


    private static final long serialVersionUID = -2415701847000224442L;

    private BigDecimal Commission;

    private Integer status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getCommission() {
        return Commission;
    }

    public void setCommission(BigDecimal commission) {
        Commission = commission;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
