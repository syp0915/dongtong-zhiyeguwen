package com.shfc.house.dto;

import com.shfc.mybatis.pagination.Page;

import java.io.Serializable;

/**
 * @Package com.shfc.house.dto.CreateOrderDTO
 * @Description: 创建订单的DTO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/10 19:44
 * version V1.0.0
 */
public class OrderParamDTO implements Serializable {
    private Long orderId;//订单ID
    private Long realtorId;//经纪人ID
    private Long comboId;//套餐ID
    private Page<OrderParamDTO> page = new Page<>();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    public Long getComboId() {
        return comboId;
    }

    public void setComboId(Long comboId) {
        this.comboId = comboId;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return page.getPageSize();
    }

    public void setPageSize(Integer pageSize) {
        page.setPageSize(pageSize);
    }

    public Integer getPageNumber() {
        return page.getPageNumber();
    }

    public void setPageNumber(Integer pageNumber) {
        page.setPageNumber(pageNumber);
    }
}
