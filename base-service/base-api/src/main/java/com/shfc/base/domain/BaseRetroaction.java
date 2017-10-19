package com.shfc.base.domain;

import com.shfc.common.httpbean.BaseBean;

/**
 * @Package: com.shfc.base.domain.BaseRetroaction.java
 * @Description: 反馈信息
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author wuky
 * @date 2016/12/28 11:26
 * version v1.0.0
 */
public class BaseRetroaction extends BaseBean {
    private String userid;

    /**
     * 反馈内容
     */
    private String retroaction;

    /**
     * @return userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 获取反馈内容
     *
     * @return retroaction
     */
    public String getRetroaction() {
        return retroaction;
    }

    /**
     * 设置反馈内容
     *
     * @param retroaction
     */
    public void setRetroaction(String retroaction) {
        this.retroaction = retroaction == null ? null : retroaction.trim();
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
        sb.append(", userid=").append(userid);
        sb.append(", retroaction=").append(retroaction);
        sb.append("]");
        return sb.toString();
    }
}