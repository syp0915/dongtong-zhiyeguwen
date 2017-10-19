package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.BaseAdvertisement.java
 * @Description: 广告
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author wuky
 * @date 2016/12/28 11:26
 * version v1.0.0
 */
public class BaseAdvertisement extends BaseBean {
    /**
     * 广告类型
     */
    private Integer adType;

    /**
     * 广告排序
     */
    private Integer orderNum;

    /**
     * 广告图片url
     */
    private String adPicUrl;

    /**
     * 跳转url
     */
    private String toUrl;

    /**
     * 广告位置：0-登录广告，1-首页
     */
    private Integer position;

    /**
     * 点击数
     */
    private Long clickNum;

    /**
     * 0-专业终端 1-用户app 2-经纪人App 3-web
     */
    private String source;

    /**
     * 广告描述文字
     */
    private String content;

    /**
     * 获取广告类型
     *
     * @return ad_type
     */
    public Integer getAdType() {
        return adType;
    }

    /**
     * 设置广告类型
     *
     * @param adType
     */
    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    /**
     * 获取广告排序
     *
     * @return order_num
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置广告排序
     *
     * @param orderNum
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取广告图片url
     *
     * @return ad_pic_url
     */
    public String getAdPicUrl() {
        return adPicUrl;
    }

    /**
     * 设置广告图片url
     *
     * @param adPicUrl
     */
    public void setAdPicUrl(String adPicUrl) {
        this.adPicUrl = adPicUrl == null ? null : adPicUrl.trim();
    }

    /**
     * 获取跳转url
     *
     * @return to_url
     */
    public String getToUrl() {
        return toUrl;
    }

    /**
     * 设置跳转url
     *
     * @param toUrl
     */
    public void setToUrl(String toUrl) {
        this.toUrl = toUrl == null ? null : toUrl.trim();
    }

    /**
     * 获取广告投放平台（手机/web/终端）
     *
     * @return position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 设置广告投放平台（手机/web/终端）
     *
     * @param position
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 获取点击数
     *
     * @return click_num
     */
    public Long getClickNum() {
        return clickNum;
    }

    /**
     * 设置点击数
     *
     * @param clickNum
     */
    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    /**
     * 获取0-专业终端 1-用户app 2-经纪人App 3-web
     *
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置0-专业终端 1-用户app 2-经纪人App 3-web
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取广告描述文字
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置广告描述文字
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @Title toString
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adType=").append(adType);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", adPicUrl=").append(adPicUrl);
        sb.append(", toUrl=").append(toUrl);
        sb.append(", position=").append(position);
        sb.append(", clickNum=").append(clickNum);
        sb.append(", source=").append(source);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}