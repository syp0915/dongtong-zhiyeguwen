package com.shfc.user.httpbean.resp;

import com.shfc.user.base.BaseRespBean;

import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:33.
 */
public class RespBean60104 extends BaseRespBean {

    private List<RespBean60104Detail> statusList;//状态列表

    public List<RespBean60104Detail> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<RespBean60104Detail> statusList) {
        this.statusList = statusList;
    }
}
