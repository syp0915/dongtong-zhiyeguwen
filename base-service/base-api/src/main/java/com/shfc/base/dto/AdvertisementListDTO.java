package com.shfc.base.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 广告查询结果
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-04 09:50
 **/
public class AdvertisementListDTO implements Serializable {
    /**
	 * @author wky
	 * @date 2017年1月4日 下午1:30:00
	 * @version V1.0
	 */
	private static final long serialVersionUID = 548220715711390002L;
	private String adPicUrl;//adPicUrl
    private String toUrl;//外部url
    private String title;//标题
    private String status;//跳转链接类型 0-外部 1-内部连接

    private String innerType;//内部链接类型

    private Long bizId;//内部链接业务Id

    public String getAdPicUrl() {
        return adPicUrl;
    }

    public void setAdPicUrl(String adPicUrl) {
        this.adPicUrl = adPicUrl;
    }

    public String getToUrl() {
        return toUrl;
    }

    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInnerType() {
        return innerType;
    }

    public void setInnerType(String innerType) {
        this.innerType = innerType;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

}
