package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/15 下午3:17.
 */
public class WxTemplateMessageDataDTO implements Serializable{
    private static final long serialVersionUID = -546462000776630125L;
    private WxMessageVCDTO first;
    private WxMessageVCDTO remark;
    private WxMessageVCDTO keyword1;
    private WxMessageVCDTO keyword2;
    private WxMessageVCDTO keyword3;
    private WxMessageVCDTO keyword4;

    public WxMessageVCDTO getFirst() {
        return first;
    }

    public void setFirst(WxMessageVCDTO first) {
        this.first = first;
    }

    public WxMessageVCDTO getRemark() {
        return remark;
    }

    public void setRemark(WxMessageVCDTO remark) {
        this.remark = remark;
    }

    public WxMessageVCDTO getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(WxMessageVCDTO keyword1) {
        this.keyword1 = keyword1;
    }

    public WxMessageVCDTO getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(WxMessageVCDTO keyword2) {
        this.keyword2 = keyword2;
    }

    public WxMessageVCDTO getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(WxMessageVCDTO keyword3) {
        this.keyword3 = keyword3;
    }

    public WxMessageVCDTO getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(WxMessageVCDTO keyword4) {
        this.keyword4 = keyword4;
    }
}
