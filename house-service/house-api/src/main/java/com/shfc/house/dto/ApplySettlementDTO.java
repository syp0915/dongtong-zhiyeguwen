package com.shfc.house.dto;


import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description:结算申请
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 15:26
 * version V1.0.0
 **/
public class ApplySettlementDTO implements Serializable{


    private static final long serialVersionUID = 5130648774937111429L;


    /**
     * 结算申请结果
     */
    private Boolean result;

    /**
     * 申请后订单状态
     */
    private Integer status;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
