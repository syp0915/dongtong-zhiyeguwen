package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.dto.*;
import com.shfc.house.query.CheckCodeQuery;
import com.shfc.house.query.RealtorShortcutQuery;

import java.util.List;

/**
 * @Package com.shfc.house.service.RealtorLoginService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 13:06
 * version V1.0.0
 */
public interface RealtorService {
    /**
     * 查询经纪人
     * @param realtorId
     * @return
     */
    public CurrentRealtorDTO findCurrentRealtorById(Long realtorId);
    /**
     * 经纪人快捷登录
     * @param query
     * @return
     */
    public ResultDO<CurrentRealtorDTO> shortcut(RealtorShortcutQuery query);

    /**
     * 经纪人完善基本信息
     * @param realtorInfoDTO
     * @return
     */
    public ResultDO<String> basicInfo(RealtorInfoDTO realtorInfoDTO);
    /**
     * 门店代码查询公司和门店
     * @param storeCode
     * @return
     */
    public CompanyStoreDTO findCompanyStoreByStoreCode(String storeCode);
    /**
     *  门店代码查询公司和门店详细信息
     * @param storeCode
     * @return
     */
    List<CompanyStoreDTO> companyStoreInfo(String storeCode);

    /**
     * 经纪人身份认证（两要素）
     * @param realtorInfoDTO
     * @return
     */
    public ResultDO<CurrentRealtorDTO> identityAuth(RealtorInfoDTO realtorInfoDTO);

    /**
     * 展示经纪人个人信息
     * @param realtorId
     * @return
     */
    public RealtorInfoDTO showCompleteInfo(Long realtorId);

    /**
     * 经纪人-我的
     * @param realtorId
     * @return
     */
    public  RealtorInfoDTO myInfo(Long realtorId);

    public ResultDO<String>  updateUserAutograph(Long realtorId,String userAutograph);

    /**
     * 展示经纪人个人信息
     * @param realtorId
     * @return
     */
   // public ResultDO<RealtorInfoDTO> showMyInfo(Long realtorId);


    /**
     * 经纪人完善基本信息
     * @param realtorInfoDTO
     * @return
     */
    public ResultDO<String> completeBasicInfo(RealtorInfoDTO realtorInfoDTO);

    /**
     * 经纪人审核状态查询
     * @param realtorId
     * @return
     */
    public ResultDO<RealtorAccoutStatusDTO> queryAccountStatus(Long realtorId);


    /**
     * 获取短信验证码
     * @param query
     * @return
     */
    public ResultDO<CheckCodeDTO> sendCheckCode(CheckCodeQuery query, Object picCheckCode);


    /**
     * 经纪人修改个人信息
     * @param dto
     * @return
     */

    public ResultDO<String> updateInfo(RealtorInfoDTO dto);


    /**
     * 根据经纪人id查找经纪人
     * @param realtorId
     * @return
     */
    public ResultDO<RealtorUnitiveAccount> getRealtorInfoById(Long realtorId);

    /**
     * 修改设备ID
     * @param deviceId
     * @return
     */
    public ResultDO<Boolean> updateDeviceId(Long realtorId,String deviceId,Integer osType);

}
