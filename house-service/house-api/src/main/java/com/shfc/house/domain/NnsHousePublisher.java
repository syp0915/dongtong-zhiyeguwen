package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package: com.shfc.house.domain.NnsHousePublisher.java
 * @Description: 置业顾问房源发布历史
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
public class NnsHousePublisher extends BaseBean {
    /**
     * 房源id
     */
    private Long nnsHouseId;

    /**
     * 发布人id
     */
    private Long publishId;

    /**
     * 发布价格
     */
    private BigDecimal publishPrice;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 获取房源id
     *
     * @return nns_house_id
     */
    public Long getNnsHouseId() {
        return nnsHouseId;
    }

    /**
     * 设置房源id
     *
     * @param nnsHouseId
     */
    public void setNnsHouseId(Long nnsHouseId) {
        this.nnsHouseId = nnsHouseId;
    }

    /**
     * 获取发布人id
     *
     * @return publish_id
     */
    public Long getPublishId() {
        return publishId;
    }

    /**
     * 设置发布人id
     *
     * @param publishId
     */
    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    /**
     * 获取发布价格
     *
     * @return publish_price
     */
    public BigDecimal getPublishPrice() {
        return publishPrice;
    }

    /**
     * 设置发布价格
     *
     * @param publishPrice
     */
    public void setPublishPrice(BigDecimal publishPrice) {
        this.publishPrice = publishPrice;
    }

    /**
     * 获取发布时间
     *
     * @return publish_time
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置发布时间
     *
     * @param publishTime
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nnsHouseId=").append(nnsHouseId);
        sb.append(", publishId=").append(publishId);
        sb.append(", publishPrice=").append(publishPrice);
        sb.append(", publishTime=").append(publishTime);
        sb.append("]");
        return sb.toString();
    }
}