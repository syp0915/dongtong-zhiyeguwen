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
public enum RealtorStatus {
    CHECK_AUDIT("待审核", 0),
    PASS_AUDIT("审核通过", 1),
    NOT_AUDIT("不通过(冻结)", 2),
    CANCEL("已解约", 3),
    UNDER_WAY("审核中",4);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    RealtorStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (RealtorStatus status : RealtorStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public RealtorStatus getTypeByValue(int value) {
        for (RealtorStatus status : RealtorStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
