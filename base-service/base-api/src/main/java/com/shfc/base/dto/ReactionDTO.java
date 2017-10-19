package com.shfc.base.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 建议反馈
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-09 13:27
 **/
public class ReactionDTO implements Serializable {

    private static final long serialVersionUID = 169700676286974416L;

    private String userId;
    private String retroaction;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRetroaction() {
        return retroaction;
    }

    public void setRetroaction(String retroaction) {
        this.retroaction = retroaction;
    }
}
