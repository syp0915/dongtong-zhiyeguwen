package com.shfc.house.dto;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.HbWinPrizeDTO
 * @Description: 抽奖中奖返回的DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/17 16:10
 * version V1.0.0
 */
public class HbWinPrizeDTO implements Serializable{
    private Long prizeId;//红包id
    private String prizeName;//红包名称
    private String prizeMoney;//红包金额

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(String prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
}
