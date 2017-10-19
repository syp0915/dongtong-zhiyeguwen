package com.shfc.house.enums;

/**
 * @Package com.shfc.house.enums.NnsHouseAuditStatus
 * @Description: 审核状态(0-待审核 1-审核通过  2-审核不通过)
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/10 10:41
 * version V1.0.0
 */
public enum NnsHouseAuditStatus {
    STAY_AUDIT("待审核", 0),
    AUDIT_SUCCESS("审核通过", 1),
    AUDIT_FAILED("审核不通过", 2);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    NnsHouseAuditStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (NnsHouseAuditStatus status : NnsHouseAuditStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public NnsHouseAuditStatus getTypeByValue(int value) {
        for (NnsHouseAuditStatus status : NnsHouseAuditStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }
}
