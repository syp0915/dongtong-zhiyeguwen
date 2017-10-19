package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.RealtorStatus
 * @Description: 经纪人状态
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/9 18:06
 * version V1.0.0
 */
public enum RealtorSource {
    REALTOR_APP("经纪人App", 1),
    REALTOR_NNS("经纪人App（997）", 2),
    REALTOR_PLATFORM("经纪合作平台", 3),
    OPERATION("运营后台(997)", 4),
    WECHAT_REALTOTR_HB("红包公众号",5);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    RealtorSource(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (RealtorSource status : RealtorSource.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public RealtorSource getTypeByValue(int value) {
        for (RealtorSource status : RealtorSource.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
