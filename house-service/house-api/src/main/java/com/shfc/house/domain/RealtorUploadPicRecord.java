package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.house.domain.RealtorUploadPicRecord.java
 * @Description: 
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author xiehb
 * @date 2017/03/22 14:40
 * version v1.0.0
 */
public class RealtorUploadPicRecord extends BaseBean {
    /**
     * 经纪人账户ID
     */
    private Long realtorId;

    /**
     * 上传微信图片Id
     */
    private String mediaId;

    /**
     * 处理结果 0：未处理，1，已处理
     */
    private Integer type;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 获取经纪人账户ID
     *
     * @return realtor_id
     */
    public Long getRealtorId() {
        return realtorId;
    }

    /**
     * 设置经纪人账户ID
     *
     * @param realtorId
     */
    public void setRealtorId(Long realtorId) {
        this.realtorId = realtorId;
    }

    /**
     * 获取上传微信图片Id
     *
     * @return media_id
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * 设置上传微信图片Id
     *
     * @param mediaId
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    /**
     * 获取处理结果 0：未处理，1，已处理
     *
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置处理结果 0：未处理，1，已处理
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取失败原因
     *
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置失败原因
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * @Title toString
     * @Author xiehb
     * @Date 2017/03/22 14:40
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
        sb.append(", mediaId=").append(mediaId);
        sb.append(", type=").append(type);
        sb.append(", reason=").append(reason);
        sb.append("]");
        return sb.toString();
    }
}