package com.shfc.house.httpbean.resp;

import com.shfc.house.base.BaseRespBean;

import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:33.
 */
public class RespBean60101 extends BaseRespBean {

    private List<RespBean60101Detail> entrustList;

    public List<RespBean60101Detail> getEntrustList() {
        return entrustList;
    }

    public void setEntrustList(List<RespBean60101Detail> entrustList) {
        this.entrustList = entrustList;
    }
}
