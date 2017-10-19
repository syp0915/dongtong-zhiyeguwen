package com.shfc.house.query;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Package com.shfc.house.query.NnsProtocolQuery
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 15:15
 * version V1.0.0
 */
public class NnsProtocolQuery implements Serializable {
    private Long realtorId; // 经纪人id
    private Long nnsHouseId;//房源id
    private Integer priceType;//房价类型	（0-实际到手 1-税费各付）
    private BigDecimal totalPrice;//房价
    private Integer type;//协议类型(0-在线签订，1-拍照上传)
    private String dealUrl;// 委托协议照片地址
    private String protocolContent;//协议内容

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public Long getNnsHouseId() {
        return nnsHouseId;
    }

    public void setNnsHouseId(Long nnsHouseId) {
        this.nnsHouseId = nnsHouseId;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDealUrl() {
        return dealUrl;
    }

    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl;
    }

    public String getProtocolContent() {
        return protocolContent;
    }

    public void setProtocolContent(String protocolContent) {
        this.protocolContent = protocolContent;
    }
}
