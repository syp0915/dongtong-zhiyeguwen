package com.shfc.house.enums;

import com.shfc.common.base.ValidateHelper;

/**
 * @Package com.shfc.house.enums.LeadsOrderParam
 * @Description: 订单相关参数枚举
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/11 20:00
 * version V1.0.0
 */
public enum  LeadsOrderParam {
    merchantNo("商户号", "0");


    private final String name;
    private final String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    LeadsOrderParam(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(String val) {
        if (ValidateHelper.isEmptyString(val)) {
            String value = val;
            for (LeadsOrderParam type : LeadsOrderParam.values()) {
                if (type.value .equals(value)) {
                    return type.name;
                }
            }
        }
        return "";
    }


}
