package com.shfc.house.domain;

import com.shfc.common.httpbean.BaseBean;
import java.math.BigDecimal;

/**
 * @Package: com.shfc.house.domain.RealtorStore.java
 * @Description: 经纪公司门店
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author liaozm
 * @date 2017/06/07 10:48
 * version v1.0.0
 */
public class RealtorStore extends BaseBean {
    /**
     * 经纪公司ID
     */
    private Long realtorCompanyId;

    /**
     * 门店代码
     */
    private String storeCode;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 门店地址
     */
    private String storeAddress;

    /**
     * 门店电话
     */
    private String storeTel;

    /**
     * 门店传真
     */
    private String storeFax;

    /**
     * 公司X坐标
     */
    private BigDecimal storex;

    /**
     * 公司Y坐标
     */
    private BigDecimal storey;

    /**
     * 公司经纬度
     */
    private String storeLonLat;

    /**
     * 备案证书编号
     */
    private String fillingCerNo;

    /**
     * 门店状态- 0- 正常 1停用 9-异常
     */
    private Integer storeStatus;

    /**
     * 门店头像
     */
    private String storeImg;

    /**
     * 店长名称
     */
    private String shopowner;

    /**
     * 店长电话
     */
    private String shopownerTel;

    /**
     * 店长头像
     */
    private String shopownerPic;

    /**
     * 是否删除 0：否，1：是
     */
    private Integer isDel;

    /**
     * 获取经纪公司ID
     *
     * @return realtor_company_id
     */
    public Long getRealtorCompanyId() {
        return realtorCompanyId;
    }

    /**
     * 设置经纪公司ID
     *
     * @param realtorCompanyId
     */
    public void setRealtorCompanyId(Long realtorCompanyId) {
        this.realtorCompanyId = realtorCompanyId;
    }

    /**
     * 获取门店代码
     *
     * @return store_code
     */
    public String getStoreCode() {
        return storeCode;
    }

    /**
     * 设置门店代码
     *
     * @param storeCode
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }

    /**
     * 获取门店名称
     *
     * @return store_name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置门店名称
     *
     * @param storeName
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * 获取门店地址
     *
     * @return store_address
     */
    public String getStoreAddress() {
        return storeAddress;
    }

    /**
     * 设置门店地址
     *
     * @param storeAddress
     */
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    /**
     * 获取门店电话
     *
     * @return store_tel
     */
    public String getStoreTel() {
        return storeTel;
    }

    /**
     * 设置门店电话
     *
     * @param storeTel
     */
    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel == null ? null : storeTel.trim();
    }

    /**
     * 获取门店传真
     *
     * @return store_fax
     */
    public String getStoreFax() {
        return storeFax;
    }

    /**
     * 设置门店传真
     *
     * @param storeFax
     */
    public void setStoreFax(String storeFax) {
        this.storeFax = storeFax == null ? null : storeFax.trim();
    }

    /**
     * 获取公司X坐标
     *
     * @return storeX
     */
    public BigDecimal getStorex() {
        return storex;
    }

    /**
     * 设置公司X坐标
     *
     * @param storex
     */
    public void setStorex(BigDecimal storex) {
        this.storex = storex;
    }

    /**
     * 获取公司Y坐标
     *
     * @return storeY
     */
    public BigDecimal getStorey() {
        return storey;
    }

    /**
     * 设置公司Y坐标
     *
     * @param storey
     */
    public void setStorey(BigDecimal storey) {
        this.storey = storey;
    }

    /**
     * 获取公司经纬度
     *
     * @return store_lon_lat
     */
    public String getStoreLonLat() {
        return storeLonLat;
    }

    /**
     * 设置公司经纬度
     *
     * @param storeLonLat
     */
    public void setStoreLonLat(String storeLonLat) {
        this.storeLonLat = storeLonLat == null ? null : storeLonLat.trim();
    }

    /**
     * 获取备案证书编号
     *
     * @return filling_cer_no
     */
    public String getFillingCerNo() {
        return fillingCerNo;
    }

    /**
     * 设置备案证书编号
     *
     * @param fillingCerNo
     */
    public void setFillingCerNo(String fillingCerNo) {
        this.fillingCerNo = fillingCerNo == null ? null : fillingCerNo.trim();
    }

    /**
     * 获取门店状态- 0- 正常 1停用 9-异常
     *
     * @return store_status
     */
    public Integer getStoreStatus() {
        return storeStatus;
    }

    /**
     * 设置门店状态- 0- 正常 1停用 9-异常
     *
     * @param storeStatus
     */
    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    /**
     * 获取门店头像
     *
     * @return store_img
     */
    public String getStoreImg() {
        return storeImg;
    }

    /**
     * 设置门店头像
     *
     * @param storeImg
     */
    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg == null ? null : storeImg.trim();
    }

    /**
     * 获取店长名称
     *
     * @return shopowner
     */
    public String getShopowner() {
        return shopowner;
    }

    /**
     * 设置店长名称
     *
     * @param shopowner
     */
    public void setShopowner(String shopowner) {
        this.shopowner = shopowner == null ? null : shopowner.trim();
    }

    /**
     * 获取店长电话
     *
     * @return shopowner_tel
     */
    public String getShopownerTel() {
        return shopownerTel;
    }

    /**
     * 设置店长电话
     *
     * @param shopownerTel
     */
    public void setShopownerTel(String shopownerTel) {
        this.shopownerTel = shopownerTel == null ? null : shopownerTel.trim();
    }

    /**
     * 获取店长头像
     *
     * @return shopowner_pic
     */
    public String getShopownerPic() {
        return shopownerPic;
    }

    /**
     * 设置店长头像
     *
     * @param shopownerPic
     */
    public void setShopownerPic(String shopownerPic) {
        this.shopownerPic = shopownerPic == null ? null : shopownerPic.trim();
    }

    /**
     * 获取是否删除 0：否，1：是
     *
     * @return is_del
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除 0：否，1：是
     *
     * @param isDel
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}