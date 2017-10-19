package com.shfc.house.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author sunyaping
 * @Package com.shfc.house.dto
 * @Description：我的佣金-佣金结算响应参数
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-07-11 14:18
 * version V1.0.0
 **/
public class CommissionRespDTO implements Serializable{


    private static final long serialVersionUID = 7973539325705685468L;

    /**
     * 总佣金
     */
    private BigDecimal totalCommission;


    /**
     * 待结算佣金
     */
    private BigDecimal settlementCommission;


    /**
     * 结算中佣金
     */
    private BigDecimal commissionInSettlement;


    /**
     * 已结算佣金
     */
    private BigDecimal settledCommission;






    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    public BigDecimal getSettlementCommission() {
        return settlementCommission;
    }

    public void setSettlementCommission(BigDecimal settlementCommission) {
        this.settlementCommission = settlementCommission;
    }

    public BigDecimal getCommissionInSettlement() {
        return commissionInSettlement;
    }

    public void setCommissionInSettlement(BigDecimal commissionInSettlement) {
        this.commissionInSettlement = commissionInSettlement;
    }

    public BigDecimal getSettledCommission() {
        return settledCommission;
    }

    public void setSettledCommission(BigDecimal settledCommission) {
        this.settledCommission = settledCommission;
    }
}
