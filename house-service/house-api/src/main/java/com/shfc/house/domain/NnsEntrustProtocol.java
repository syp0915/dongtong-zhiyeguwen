package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.NnsEntrustProtocol.java
 * @Description: 委托协议表
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/08 13:19
 * version v1.0.0
 */
public class NnsEntrustProtocol extends BaseBean {
    /**
     * 经纪人id
     */
    private Long realtorId;

    /**
     * 置业顾问二手房id
     */
    private Long nnsHouseId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 房价
     */
    private BigDecimal totalPrice;

    /**
     * 房价类型
     */
    private Integer priceType;

    /**
     * 委托期限(0-一个月;1-两个月;2-三个月;3-六个月;)
     */
    private Integer deadline;

    /**
     * 协议类型(0-在线签订，1-拍照上传)
     */
    private Integer type;

    /**
     * 协议状态(0-等待签约，1-签约成功，2-签约已拒绝，3-签约已撤销，4-签约已过期，5-协议已线下签署)
     */
    private Integer status;

    /**
     * 签约成功时间
     */
    private Date successTime;
    /**
     * 协议有效截止日期
     */
    private Date overdueTime;
    /**
     * 协议图片
     */
    private String dealUrl;

    /**
     * 协议内容(富文本)
     */
    private String protocolContent;
    /**
     * 协议来源(0 经纪人直签，1线上授权)
     */
    private Integer source;

    /**
     * 获取经纪人id
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人id
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }


    /**
     * 获取置业顾问二手房id
     *
     * @return nns_house_id
     */
    public Long getNnsHouseId() {
        return nnsHouseId;
    }

    /**
     * 设置置业顾问二手房id
     *
     * @param nnsHouseId
     */
    public void setNnsHouseId(Long nnsHouseId) {
        this.nnsHouseId = nnsHouseId;
    }

    /**
     * 获取用户id
     *
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取房价
     *
     * @return total_price
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置房价
     *
     * @param totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取房价类型
     *
     * @return price_type
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * 设置房价类型
     *
     * @param priceType
     */
    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    /**
     * 获取委托期限(0-一个月;1-两个月;2-三个月;3-六个月;)
     *
     * @return deadline
     */
    public Integer getDeadline() {
        return deadline;
    }

    /**
     * 设置委托期限(0-一个月;1-两个月;2-三个月;3-六个月;)
     *
     * @param deadline
     */
    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    /**
     * 获取协议类型(0-在线签订，1-拍照上传)
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置协议类型(0-在线签订，1-拍照上传)
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取协议状态(0-等待签约，1-签约成功，2-签约已拒绝，3-签约已撤销，4-签约已过期，5-协议已线下签署)
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置协议状态(0-等待签约，1-签约成功，2-签约已拒绝，3-签约已撤销，4-签约已过期，5-协议已线下签署)
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取签约成功时间
     *
     * @return success_time
     */
    public Date getSuccessTime() {
        return successTime;
    }

    /**
     * 设置签约成功时间
     *
     * @param successTime
     */
    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Date getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    /**
     * 获取协议图片
     *
     * @return deal_url
     */
    public String getDealUrl() {
        return dealUrl;
    }

    /**
     * 设置协议图片
     *
     * @param dealUrl
     */
    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl == null ? null : dealUrl.trim();
    }

    /**
     * 获取协议内容(富文本)
     *
     * @return protocol_content
     */
    public String getProtocolContent() {
        return protocolContent;
    }

    /**
     * 协议编号
     */
    private String protocolNumber;

    /**
     * 设置协议内容(富文本)
     *
     * @param protocolContent
     */
    public void setProtocolContent(String protocolContent) {
        this.protocolContent = protocolContent == null ? null : protocolContent.trim();
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/01/08 13:19
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", realtorId=").append(realtorId);
        sb.append(", nnsHouseId=").append(nnsHouseId);
        sb.append(", userId=").append(userId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", priceType=").append(priceType);
        sb.append(", deadline=").append(deadline);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", successTime=").append(successTime);
        sb.append(", dealUrl=").append(dealUrl);
        sb.append(", protocolContent=").append(protocolContent);
        sb.append("]");
        return sb.toString();
    }
}