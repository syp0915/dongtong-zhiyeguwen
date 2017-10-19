package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-04-10 16:07
 **/
public class MemberStatusDTO implements Serializable {
    private static final long serialVersionUID = 3300277783104101522L;

    private String status;//会员状态  0:正常,1:过期，2：未开通
    private String describe;//会员状态描述

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
