package com.shfc.house.dto;

import com.shfc.house.base.BaseRespBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description:结算明细响应参数
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 16:57
 * version V1.0.0
 **/
public class SettlementDetailRespDTO extends BaseRespBean implements Serializable{

    private static final long serialVersionUID = 4169866902051546982L;

    /**
     * 结算明细列表
     */
    private List<SettlementDetailDTO> settlementDetailList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<SettlementDetailDTO> getSettlementDetailList() {
        return settlementDetailList;
    }

    public void setSettlementDetailList(List<SettlementDetailDTO> settlementDetailList) {
        this.settlementDetailList = settlementDetailList;
    }
}
