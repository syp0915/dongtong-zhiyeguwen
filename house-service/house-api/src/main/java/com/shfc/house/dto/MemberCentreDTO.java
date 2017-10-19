package com.shfc.house.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.house.dto.MemberCentreDTO
 * @Description: 经纪人会员中心实体类
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/10 15:48
 * version V1.0.0
 */
public class MemberCentreDTO implements Serializable {
    private Integer realtorStatus;//经纪人状态
    private String realName ="";//真实姓名
    private String headPortrait = "";//头像
    private String realtorNumber ="";//经纪人编号
    private String deadline = "";//会员截止日期
    private Integer status =2;//会员状态(0正常1过期2未开通）

    private List<ComboDTO> comboList = new ArrayList<>();//套餐列表

    public Integer getRealtorStatus() {
        return realtorStatus;
    }

    public void setRealtorStatus(Integer realtorStatus) {
        this.realtorStatus = realtorStatus;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getRealtorNumber() {
        return realtorNumber;
    }

    public void setRealtorNumber(String realtorNumber) {
        this.realtorNumber = realtorNumber;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ComboDTO> getComboList() {
        return comboList;
    }

    public void setComboList(List<ComboDTO> comboList) {
        this.comboList = comboList;
    }
}
