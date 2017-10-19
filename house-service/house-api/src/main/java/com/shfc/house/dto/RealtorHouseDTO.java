package com.shfc.house.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 经纪人发房
 *
 * @author wuky
 * @version V1.0
 * @create 2017-08-22 13:50
 **/
@Data
public class RealtorHouseDTO implements Serializable {
    /*
     *房源Id
     */

    private Long houseId;

    /**
     * 区域Id
     */
    private Long districtId;

    /**
     * 板块Id
     */
    private Long blockId;

    /**
     * 小区Id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private String importPlotName;

    /**
     * 地址
     */
    private String address;

    /**
     * 百度经度
     */
    private String longitude;

    /**
     * 百度纬度
     */
    private String latitude;

    /**
     * 楼栋编号
     */
    private String unitNo;

    /**
     * 室号
     */
    private String houseNo;

    /**
     * 室
     */
    private Integer room;

    /**
     * 厅
     */
    private Integer hall;

    /**
     * 卫
     */
    private Integer bathroom;

    /**
     * 朝向 1：东 2：南 3：西 4：北 5：东南 6：东北 7：西南 8：西北 9：东西 10：南北
     */
    private Integer orientation;

    /**
     * 面积
     */
    private Float area;

    /**
     * 所在楼层
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 总价：万元
     */
    private BigDecimal totalPrice;

//    /**
//     * 房源发布人id
//     */
//    private Long realtorId;
    /**
     * 标签
     */
    private List<Long> tags;
    /**
     *委托协议链接
     */
    private List<String> entrustUrl;
}
