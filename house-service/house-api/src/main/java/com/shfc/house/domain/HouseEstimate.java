package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.house.domain.HouseEstimate.java
 * @Description: 房源估价
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author lv bin
 * @date 2017/01/03 16:52
 * version v1.0.0
 */
public class HouseEstimate extends BaseBean {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 房屋详细地址
     */
    private String detailAddress;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 所属城市
     */
    private Long cityId;

    /**
     * 小区Id
     */
    private Long plotId;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 楼号
     */
    private String unitNo;

    /**
     * 门牌号
     */
    private String roomNo;

    /**
     * 建筑面积
     */
    private Float area;

    /**
     * 房
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
     * 厨房
     */
    private Integer kitchen;

    /**
     * 装修
     */
    private Integer decorate;

    /**
     * 所在楼层
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 房屋类型 1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅  8：叠加别墅 14：新里洋房
     */
    private Integer houseType;

    /**
     * 估算单价
     */
    private BigDecimal price;

    /**
     * 估算总价
     */
    private BigDecimal totalPrice;

    /**
     * 物业类型  1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅  8：叠加别墅 14：新里洋房
     */
    private Integer serveType;

    /**
     * 物业公司
     */
    private String serveCompany;

    /**
     * 物业费
     */
    private Float serveCost;

    /**
     * 产权类型
     */
    private Integer ownerType;

    /**
     * 产权年限
     */
    private Integer ownerYears;

    /**
     * 获取用户id
     *
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取房屋详细地址
     *
     * @return detail_address
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 设置房屋详细地址
     *
     * @param detailAddress
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    /**
     * 获取纬度
     *
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 获取经度
     *
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 获取所属城市
     *
     * @return city_id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置所属城市
     *
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取小区Id
     *
     * @return plot_id
     */
    public Long getPlotId() {
        return plotId;
    }

    /**
     * 设置小区Id
     *
     * @param plotId
     */
    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    /**
     * 获取小区名称
     *
     * @return plot_name
     */
    public String getPlotName() {
        return plotName;
    }

    /**
     * 设置小区名称
     *
     * @param plotName
     */
    public void setPlotName(String plotName) {
        this.plotName = plotName == null ? null : plotName.trim();
    }

    /**
     * 获取楼号
     *
     * @return unit_no
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * 设置楼号
     *
     * @param unitNo
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    /**
     * 获取门牌号
     *
     * @return room_no
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 设置门牌号
     *
     * @param roomNo
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    /**
     * 获取建筑面积
     *
     * @return area
     */
    public Float getArea() {
        return area;
    }

    /**
     * 设置建筑面积
     *
     * @param area
     */
    public void setArea(Float area) {
        this.area = area;
    }

    /**
     * 获取房
     *
     * @return room
     */
    public Integer getRoom() {
        return room;
    }

    /**
     * 设置房
     *
     * @param room
     */
    public void setRoom(Integer room) {
        this.room = room;
    }

    /**
     * 获取厅
     *
     * @return hall
     */
    public Integer getHall() {
        return hall;
    }

    /**
     * 设置厅
     *
     * @param hall
     */
    public void setHall(Integer hall) {
        this.hall = hall;
    }

    /**
     * 获取卫
     *
     * @return bathroom
     */
    public Integer getBathroom() {
        return bathroom;
    }

    /**
     * 设置卫
     *
     * @param bathroom
     */
    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    /**
     * 获取厨房
     *
     * @return kitchen
     */
    public Integer getKitchen() {
        return kitchen;
    }

    /**
     * 设置厨房
     *
     * @param kitchen
     */
    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    /**
     * 获取装修
     *
     * @return decorate
     */
    public Integer getDecorate() {
        return decorate;
    }

    /**
     * 设置装修
     *
     * @param decorate
     */
    public void setDecorate(Integer decorate) {
        this.decorate = decorate;
    }

    /**
     * 获取所在楼层
     *
     * @return floor
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * 设置所在楼层
     *
     * @param floor
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * 获取总楼层
     *
     * @return total_floor
     */
    public Integer getTotalFloor() {
        return totalFloor;
    }

    /**
     * 设置总楼层
     *
     * @param totalFloor
     */
    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    /**
     * 获取房屋类型 1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅  8：叠加别墅 14：新里洋房
     *
     * @return house_type
     */
    public Integer getHouseType() {
        return houseType;
    }

    /**
     * 设置房屋类型 1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅  8：叠加别墅 14：新里洋房
     *
     * @param houseType
     */
    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    /**
     * 获取估算单价
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置估算单价
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取估算总价
     *
     * @return total_price
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置估算总价
     *
     * @param totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取物业类型  1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅  8：叠加别墅 14：新里洋房
     *
     * @return serve_type
     */
    public Integer getServeType() {
        return serveType;
    }

    /**
     * 设置物业类型  1：里弄房 2：新工房 3：公寓  5：独栋别墅 6：双拼别墅 7：联排别墅  8：叠加别墅 14：新里洋房
     *
     * @param serveType
     */
    public void setServeType(Integer serveType) {
        this.serveType = serveType;
    }

    /**
     * 获取物业公司
     *
     * @return serve_company
     */
    public String getServeCompany() {
        return serveCompany;
    }

    /**
     * 设置物业公司
     *
     * @param serveCompany
     */
    public void setServeCompany(String serveCompany) {
        this.serveCompany = serveCompany == null ? null : serveCompany.trim();
    }

    /**
     * 获取物业费
     *
     * @return serve_cost
     */
    public Float getServeCost() {
        return serveCost;
    }

    /**
     * 设置物业费
     *
     * @param serveCost
     */
    public void setServeCost(Float serveCost) {
        this.serveCost = serveCost;
    }

    /**
     * 获取产权类型
     *
     * @return owner_type
     */
    public Integer getOwnerType() {
        return ownerType;
    }

    /**
     * 设置产权类型
     *
     * @param ownerType
     */
    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * 获取产权年限
     *
     * @return owner_years
     */
    public Integer getOwnerYears() {
        return ownerYears;
    }

    /**
     * 设置产权年限
     *
     * @param ownerYears
     */
    public void setOwnerYears(Integer ownerYears) {
        this.ownerYears = ownerYears;
    }

    /**
     * @Title toString
     * @Author lv bin
     * @Date 2017/01/03 16:52
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", cityId=").append(cityId);
        sb.append(", plotId=").append(plotId);
        sb.append(", plotName=").append(plotName);
        sb.append(", unitNo=").append(unitNo);
        sb.append(", roomNo=").append(roomNo);
        sb.append(", area=").append(area);
        sb.append(", room=").append(room);
        sb.append(", hall=").append(hall);
        sb.append(", bathroom=").append(bathroom);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", decorate=").append(decorate);
        sb.append(", floor=").append(floor);
        sb.append(", totalFloor=").append(totalFloor);
        sb.append(", houseType=").append(houseType);
        sb.append(", price=").append(price);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", serveType=").append(serveType);
        sb.append(", serveCompany=").append(serveCompany);
        sb.append(", serveCost=").append(serveCost);
        sb.append(", ownerType=").append(ownerType);
        sb.append(", ownerYears=").append(ownerYears);
        sb.append("]");
        return sb.toString();
    }
}