package com.shfc.user.httpbean.wxBean;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/15 下午3:17.
 */
public class WxTemplateMessageDataBean implements Serializable{
    private WxMessageVCBean first;
    private WxMessageVCBean remark;
    private WxMessageVCBean keyword1;
    private WxMessageVCBean keyword2;
    private WxMessageVCBean keyword3;
    private WxMessageVCBean keyword4;

    public WxMessageVCBean getFirst() {
        return first;
    }

    public void setFirst(WxMessageVCBean first) {
        this.first = first;
    }

    public WxMessageVCBean getRemark() {
        return remark;
    }

    public void setRemark(WxMessageVCBean remark) {
        this.remark = remark;
    }

    public WxMessageVCBean getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(WxMessageVCBean keyword1) {
        this.keyword1 = keyword1;
    }

    public WxMessageVCBean getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(WxMessageVCBean keyword2) {
        this.keyword2 = keyword2;
    }

    public WxMessageVCBean getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(WxMessageVCBean keyword3) {
        this.keyword3 = keyword3;
    }

    public WxMessageVCBean getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(WxMessageVCBean keyword4) {
        this.keyword4 = keyword4;
    }
}
