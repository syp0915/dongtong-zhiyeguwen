package com.shfc.base.query;

import java.io.Serializable;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/12 下午8:10.
 */
public class AliyunTokenQuery implements Serializable {

    private String osType;//系统类型0-iOS 1-Android

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}
