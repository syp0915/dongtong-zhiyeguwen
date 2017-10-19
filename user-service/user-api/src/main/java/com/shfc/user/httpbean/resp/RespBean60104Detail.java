package com.shfc.user.httpbean.resp;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:47.
 */
public class RespBean60104Detail implements Serializable{
    private static final long serialVersionUID = 3346448819630305781L;
    private int status;//	状态
    private String statusTitle;//	状态标题
    private String statusDesc;//	状态描述
    private String happenedTime;//	发生时间

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getHappenedTime() {
        return happenedTime;
    }

    public void setHappenedTime(String happenedTime) {
        this.happenedTime = happenedTime;
    }
}
