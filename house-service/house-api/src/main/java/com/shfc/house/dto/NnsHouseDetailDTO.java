package com.shfc.house.dto;

import com.shfc.house.domain.NnsHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.house.dto.NnsHouseDetailDTO
 * @Description: 二手房详情
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 11:26
 * version V1.0.0
 */
public class NnsHouseDetailDTO extends NnsHouse{
    private String districtName; // 区域名称
    private String blockName; // 板块名称
    private List<BaseTagDTO> tagList; // 房源特色

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public List<BaseTagDTO> getTagList() {
        return tagList;
    }

    public void setTagList(List<BaseTagDTO> tagList) {
        this.tagList = tagList;
    }
}
