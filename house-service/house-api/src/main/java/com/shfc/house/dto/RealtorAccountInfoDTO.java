package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 经纪人账户信息
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 09:28
 **/
public class RealtorAccountInfoDTO implements Serializable {

    private static final long serialVersionUID = 5824973890161748260L;
    private String wxopenId;
    private String realtorId;

    public String getWxopenId() {
        return wxopenId;
    }

    public void setWxopenId(String wxopenId) {
        this.wxopenId = wxopenId;
    }

    public String getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(String realtorId) {
        this.realtorId = realtorId;
    }
}
