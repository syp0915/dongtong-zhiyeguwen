package com.shfc.house.manager;

import com.shfc.common.exception.AppException;
import com.shfc.house.dao.RealtorInfoMapper;
import com.shfc.house.dao.RealtorStoreStaffRelMapper;
import com.shfc.house.dao.RealtorUnitiveAccountMapper;
import com.shfc.house.dao.WxAccountRelationMapper;
import com.shfc.house.domain.RealtorInfo;
import com.shfc.house.domain.RealtorStoreStaffRel;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.dto.CompanyStoreDTO;
import com.shfc.house.dto.RealtorAccoutStatusDTO;
import com.shfc.house.dto.RealtorInfoDTO;
import com.shfc.house.enums.RealtorStatus;
import com.shfc.house.enums.YesNo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package com.shfc.house.manager.RealtorInfoManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 14:25
 * version V1.0.0
 */
@Service
public class RealtorInfoManager {
    @Autowired
    private RealtorUnitiveAccountMapper realtorUnitiveAccountMapper;

    @Autowired
    private RealtorInfoMapper realtorInfoMapper;

    @Autowired
    private RealtorStoreStaffRelMapper realtorStoreStaffRelMapper;

    @Autowired
    private WxAccountRelationMapper wxOpenBindingRecordMapper;

    public RealtorUnitiveAccount findById(Long realtorId){
        return realtorUnitiveAccountMapper.selectByPrimaryKey(realtorId);
    }

    /**
     * 根据手机号查询经纪人账户信息
     * @param phone
     * @return
     */
    public List<RealtorUnitiveAccount> findByPhone(String phone){
       return realtorUnitiveAccountMapper.findByPhone(phone);
    }

    public void updateRealtorAccount(RealtorUnitiveAccount record){
        realtorUnitiveAccountMapper.updateByPrimaryKey(record);
    }

    public Integer addRealtorAccount(RealtorUnitiveAccount record){
        return realtorUnitiveAccountMapper.insert(record);
    }

    /**
     * 根据门店代码查询公司和门店
     * @param storeCode
     * @return
     */
    public CompanyStoreDTO findCompanyStoreByStoreCode(String storeCode){
       return realtorInfoMapper.findCompanyStoreByStoreCode(storeCode);
    }
    /**
     *  门店代码查询公司和门店详细信息
     * @param storeCode
     * @return
     */
    public List<CompanyStoreDTO> companyStoreInfo(String storeCode){
        return realtorInfoMapper.companyStoreInfo(storeCode);
    }

    /**
     * 根据手机号校验该账户是否被解约过（disable='1'）,并返回comId
     */
    public List <Long> findComIdByPhone(String phone){
        return realtorInfoMapper.findComIdByPhone(phone);
    }

    //根据账户ID查询基本信息
    public RealtorInfo selectByAccountId(Long accountId){
        return realtorInfoMapper.selectByAccountId(accountId);
    }

    /**
     *  经纪人-我的
      */
   public RealtorInfoDTO myInfo(Long realtorId){
       return realtorInfoMapper.myInfo(realtorId);
   }
    /**
     * 经纪人完善基本信息
     * @param realtorInfoDTO
     */
    @Transactional(rollbackFor = AppException.class)
    public void basicInfo(RealtorInfoDTO realtorInfoDTO)throws AppException{
        RealtorInfo realtorInfo = realtorInfoMapper.selectByAccountId(realtorInfoDTO.getRealtorId());
        if(realtorInfo==null){
            realtorInfo = new RealtorInfo();
            BeanUtils.copyProperties(realtorInfoDTO,realtorInfo);
            realtorInfo.setIsAuth(true);//只有经过实名认证(姓名身份证一致)的才会保存
            realtorInfoMapper.insert(realtorInfo);
            Long id = realtorInfo.getId();
//            //添加经纪人和门店的关联关系
//            RealtorStoreStaffRel record = new RealtorStoreStaffRel();
//            record.setRealtorId(id);
//            record.setStoreId(realtorInfo.getStoreId());
//            realtorStoreStaffRelMapper.insert(record);
        }else {
            BeanUtils.copyProperties(realtorInfoDTO,realtorInfo);
            realtorInfoMapper.updateByPrimaryKeySelective(realtorInfo);
        }
        //修改审核状态
        updateRealtorStatus(realtorInfoDTO);

        //门店经纪人管理关系
        updateRealtorStoreRel(realtorInfoDTO.getRealtorId(),realtorInfoDTO.getStoreId());

    }

    @Transactional(rollbackFor = AppException.class)
    public int updateRealtorInfo(RealtorInfo realtorInfo) throws AppException{
        realtorInfoMapper.updateByPrimaryKey(realtorInfo);
        RealtorUnitiveAccount unitiveAccount = realtorUnitiveAccountMapper.selectByPrimaryKey(realtorInfo.getRealtorId());
        unitiveAccount.setStatus(RealtorStatus.UNDER_WAY.getValue());//审核中
        return realtorUnitiveAccountMapper.updateByPrimaryKey(unitiveAccount);
    }

    /**
     * 修改个性签名
     * @param realtorInfo
     * @return
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public int updateUserAutograph(RealtorInfo realtorInfo) throws AppException{

        return realtorInfoMapper.updateByPrimaryKey(realtorInfo);
    }

    public RealtorInfoDTO showCompleteInfo(Long realtorId){
        return realtorInfoMapper.showCompleteInfo(realtorId);
    }

    public RealtorInfo selectByRealtorId(Long realtorId){
        return realtorInfoMapper.selectByRealtorId(realtorId);
    }

    /**
     *  经纪人-完善信息后修改状态为4-审核中
     */
    @Transactional(rollbackFor = AppException.class)
    public int updateRealtorStatus(RealtorInfoDTO realtorInfoDTO){
        RealtorUnitiveAccount unitiveAccount = realtorUnitiveAccountMapper.selectByPrimaryKey(realtorInfoDTO.getRealtorId());
        unitiveAccount.setStatus(RealtorStatus.UNDER_WAY.getValue());//审核中
        return realtorUnitiveAccountMapper.updateByPrimaryKeySelective(unitiveAccount);
    }

    /**
     *  门店代码查询公司和门店详细信息
     * @param storeCode
     * @return
     */
    public List<CompanyStoreDTO> queryStoreById(Long storeCode){
        return realtorInfoMapper.queryStoreById(storeCode);
    }

    /**
     *  经纪人Id查询经纪人
     * @param realtorId
     * @return
     */
    public RealtorUnitiveAccount queryRealtorById(Long realtorId){
        return realtorUnitiveAccountMapper.queryRealtorById(realtorId);
    }

    /**
     *  经纪人Id查询审核状态
     * @param realtorId
     * @return
     */
    public List<RealtorAccoutStatusDTO> queryStatusById(Long realtorId){
        return realtorUnitiveAccountMapper.queryStatusById(realtorId);
    }

    /**
     * 抽奖前判断经纪人是否登录，根据wxOpenId查找绑定记录，有记录则登录
     * @param wxOpenId
     * @return
     */
    public List<RealtorAccoutStatusDTO> loginStatusByOpenId(String wxOpenId){
        return wxOpenBindingRecordMapper.loginStatusByOpenId(wxOpenId);
    }

    /**
     * 根据名片链接查看是否已使用该名片
     * @param cardImg
     * @return
     */
    public Integer queryCardByUrl(String cardImg){
        return realtorInfoMapper.queryCardByUrl(cardImg);
    }

    /**
     * 根据经纪人id查询经纪人状态和头像
     * @param realtorId
     * @return
     */
    public RealtorInfoDTO queryStatusByRealtorId(Long realtorId){
        return realtorInfoMapper.queryStatusByRealtorId(realtorId);
    }


    /**
     * 修改经纪人个人信息(头像,区域板块主营小区)
     * @param dto
     * @return
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public void updateInfo(RealtorInfoDTO dto,RealtorInfo realtorInfo) throws AppException{
        BeanUtils.copyProperties(dto, realtorInfo);
        realtorInfoMapper.updateByPrimaryKeySelective(realtorInfo);
    }

    /**
     * 修改经纪人门店和经纪人关联关系
     * @param realtorId
     * @param StoreId
     * @return
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public void updateRealtorStoreRel(Long realtorId,Long StoreId){
        RealtorStoreStaffRel realtorStoreStaffRel=realtorStoreStaffRelMapper.queryRelByRealtorId(realtorId);
        if(realtorStoreStaffRel!=null){
            realtorStoreStaffRel.setStatus(YesNo.YES.getValue());
            realtorStoreStaffRelMapper.updateByPrimaryKey(realtorStoreStaffRel);
        }
        RealtorStoreStaffRel record=new RealtorStoreStaffRel();
        record.setRealtorId(realtorId);
        record.setStoreId(StoreId);
        record.setStatus(YesNo.NO.getValue());
        realtorStoreStaffRelMapper.insert(record);
    }


    /**
     * 根据经纪人id查找经纪人信息
     * @param realtorId
     * @return
     */
    public RealtorUnitiveAccount getRealtorById(Long realtorId) {
        return realtorUnitiveAccountMapper.selectByPrimaryKey(realtorId);
    }

    /**
     * 修改设备ID
     * @param deviceId
     * @return
     */
    public int updateDeviceId(Long realtorId,String deviceId,Integer osType){
        RealtorUnitiveAccount account = getRealtorById(realtorId);
        if(account!=null){
            account.setDeviceId(deviceId);
            account.setOsType(osType);
            return realtorUnitiveAccountMapper.updateByPrimaryKeySelective(account);
        }
        return 0;
    }

}
