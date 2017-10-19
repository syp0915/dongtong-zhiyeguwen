package com.shfc.house.query;

import com.shfc.house.base.BaseReqBean;

import java.io.Serializable;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description：请求入参
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 14:08
 * version V1.0.0
 **/
public class CommissionQuery extends BaseReqBean implements Serializable{

    private static final long serialVersionUID = -7749393917531795864L;

    /**
     * 经纪人Id
     */
    private Long referrerId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(Long referrerId) {
        this.referrerId = referrerId;
    }
}
