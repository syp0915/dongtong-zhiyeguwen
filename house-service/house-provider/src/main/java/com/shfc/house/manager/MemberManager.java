package com.shfc.house.manager;

import com.fc.common.redis.RedisUtil;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.constant.ConstantService;
import com.shfc.house.dao.*;
import com.shfc.house.domain.LeadsRealtorMember;
import com.shfc.house.dto.ComboDTO;
import com.shfc.house.dto.InterestDTO;
import com.shfc.house.dto.MemberCentreDTO;
import com.shfc.house.dto.RealtorMemberDTO;
import com.shfc.house.enums.MemberStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-04-10 16:20
 **/
@Service
public class MemberManager {

    @Autowired
    private LeadsRealtorMemberMapper leadsRealtorMemberMapper;
    @Autowired
    private LeadsHouseCallMapper leadsHouseCallMapper;
    @Autowired
    private LeadsComboMapper leadsComboMapper;
    @Autowired
    private LeadsComboDetailMapper leadsComboDetailMapper;
    @Autowired
    private LeadsNonmemberDetailMapper leadsNonmemberDetailMapper;

    public LeadsRealtorMember queryStatusByRealtorId(Long realtorId){
        return leadsRealtorMemberMapper.queryStatusByRealtorId(realtorId);
    }

    /**
     * 根据经纪人ID查询经纪人是否开通会员
     * @param realtorId
     * @return
     */
    public MemberCentreDTO selectByRealtorId(Long realtorId){
        return leadsRealtorMemberMapper.selectByRealtorId(realtorId);
    }
    /**
     * 查询经纪人已经开通的套餐
     */
    public List<ComboDTO> validComboList(Long realtorId){
        return leadsRealtorMemberMapper.validComboList(realtorId);
    }

    /**
     * 查询全部的有效套餐
     */
    public List<ComboDTO> allComboList(){
        return leadsRealtorMemberMapper.allComboList();
    }

    /**
     * 每天查询有效的权益
     * @return
     */
    public List<InterestDTO> queryInterestByDay(){
        return leadsRealtorMemberMapper.queryInterestByDay();
    }

    /**
     * 1.先查询经纪人的状态（是否会员）
     * 2.根据经纪人的状态判断权益
     * 3.判断拨打电话权限
     * @param realtorId
     * @return
     */
    public ResultDO<Boolean> checkPhoneInterest(Long realtorId){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        //redis取经纪人的的权益
        InterestDTO interestDTO  = (InterestDTO) RedisUtil.get(ConstantService.MEMBER_PHONE_INTERES_TASK+realtorId);
        if(interestDTO==null){
            List<InterestDTO> list  = (List<InterestDTO>) RedisUtil.get(ConstantService.MEMBER_PHONE_INTERES_TASK);
            if(list==null || list.size()==0){
                list  = queryInterestByDay();
                if(list.isEmpty()){
                    resultDO.setErrMsg("获取经纪人权益数据异常！");
                    return resultDO;
                }
                RedisUtil.set(ConstantService.MEMBER_PHONE_INTERES_TASK,list,calculateSecond());
            }
            interestDTO = list.get(0);
        }
        int noMemberPhoneNum  = interestDTO.getNoMemberPhoneNum().intValue();
        int phoneNum = interestDTO.getPhoneNum().intValue();
        LeadsRealtorMember record  = leadsRealtorMemberMapper.queryStatusByRealtorId(realtorId);
        if(record==null  || (record.getStatus().intValue()!= MemberStatus.OPEN.getValue())){
            //未开通会员--或者
            if(noMemberPhoneNum<=0){
                resultDO.setErrCode(43);
                resultDO.setErrMsg("非会员拨打电话次数超限！");
                return resultDO;
            }else {
                //次数减少一次
                --noMemberPhoneNum;
                interestDTO.setNoMemberPhoneNum(noMemberPhoneNum);
                RedisUtil.set(ConstantService.MEMBER_PHONE_INTERES_TASK+realtorId,interestDTO,calculateSecond());
            }
        }else {
            //会员权限
            if(phoneNum<=0){
                resultDO.setErrCode(44);
                resultDO.setErrMsg("会员拨打电话次数超限！");
                return resultDO;
            }else {
                //次数减少一次
                --phoneNum;
                interestDTO.setPhoneNum(phoneNum);
                RedisUtil.set(ConstantService.MEMBER_PHONE_INTERES_TASK+realtorId,interestDTO,calculateSecond());
            }
        }
        resultDO.setSuccess(true);
        return resultDO;
    }
    /**
     * 1.先查询经纪人的状态（是否会员）
     * 2.根据经纪人的状态判断权益
     * 3.判断查询房源权限
     * @param realtorId
     * @return
     */
    public ResultDO<Boolean> checkHouseInterest(Long realtorId){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        //redis取经纪人的的权益
        InterestDTO interestDTO  = (InterestDTO) RedisUtil.get(ConstantService.MEMBER_HOUSE_INTERES_TASK+realtorId);
        if(interestDTO==null){
            List<InterestDTO> list  = (List<InterestDTO>) RedisUtil.get(ConstantService.MEMBER_HOUSE_INTERES_TASK);
            if(list==null || list.size()==0){
                list  = queryInterestByDay();
                RedisUtil.set(ConstantService.MEMBER_HOUSE_INTERES_TASK,list,calculateSecond());
            }
            interestDTO = list.get(0);
        }
        int noMemberHouseNum  = interestDTO.getNoMemberHouseNum().intValue();
        int houseNum = interestDTO.getHouseNum().intValue();
        LeadsRealtorMember record  = leadsRealtorMemberMapper.queryStatusByRealtorId(realtorId);
        if(record==null || (record.getStatus().intValue() != MemberStatus.OPEN.getValue())){
            //未开通会员--以及会员过期
            if(noMemberHouseNum<=0){
                resultDO.setErrCode(41);
                resultDO.setErrMsg("非会员查看房源次数超限！");
                return resultDO;
            }else {
                //次数减少一次
                --noMemberHouseNum;
                interestDTO.setNoMemberHouseNum(noMemberHouseNum);
                RedisUtil.set(ConstantService.MEMBER_HOUSE_INTERES_TASK+realtorId,interestDTO,calculateSecond());
            }
        }else {
            //会员权限
            if(houseNum<=0){
                resultDO.setErrCode(42);
                resultDO.setErrMsg("会员查看房源次数超限！");
                return resultDO;
            }else {
                --houseNum;
                interestDTO.setHouseNum(houseNum);
                RedisUtil.set(ConstantService.MEMBER_HOUSE_INTERES_TASK+realtorId,interestDTO,calculateSecond());
            }
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 计算两个时间相差的秒数
     * @return
     */
    public int calculateSecond(){
        String nowDate = DateUtils.getCurrentTime();
        String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ") + "23:59:59";
        int secondCount = DateUtils.compareTime(nowDate, nextTime, 3);
        return secondCount;
    }

    /**
     * 过期会员列表
     * @return
     */
    public List<RealtorMemberDTO> pastMemberList(){
        return leadsRealtorMemberMapper.pastMemberList();
    }
    /**
     * 查询失效的会员记录,并更新状态
     */
    public void updateRealtorMemberList(){
        leadsRealtorMemberMapper.updateRealtorMemberList();
    }

    /**
     * 3天即将过期的会员列表
     */
    public List<RealtorMemberDTO> threeDayPastMemberList(){
         return leadsRealtorMemberMapper.threeDayPastMemberList();
    }

    /**
     * 先判断今天待生效的套餐是否已经生效
     * add by xiehb
     * effective_date 等于今天，status=0
     * @return
     */
    public Boolean todayAlreadyEffectCombo(){
        Integer count =  leadsComboMapper.selectTodayAlreadyEffectCombo();
        if(count!=null && count.intValue()>0){
            return true;
        }
        return false;
    }
    /**
     * 查询今天待生效的套餐,取最新的一条记录
     * add by xiehb
     * @return
     */
    public Boolean todayEffectCombo(){
        Integer count = leadsComboMapper.todayEffectCombo();
        if(count!=null && count.intValue()>0){
            return true;
        }
        return false;
    }

    /**
     * 更新待生效套餐状态，以前生效套餐置为无效
     */
    @Transactional(rollbackFor = AppException.class)
    public void updateEffectCombo() throws AppException{
        leadsComboMapper.updateTodayEffectCombo();
        leadsComboMapper.updateLoseEffectCombo();
    }

    /**
     * 先判断今天待生效的套餐权益是否已经生效
     * add by xiehb
     * effective_date 等于今天，status=0
     * @return
     */
    public Boolean todayAlreadyEffectComboDetail(){
        Integer count =  leadsComboDetailMapper.selectTodayAlreadyEffectComboDetail();
        if(count!=null && count.intValue()>0){
            return true;
        }
        return false;
    }
    /**
     * 查询今天待生效的套餐权益,取最新的一条记录
     * add by xiehb
     * @return
     */
    public Boolean todayEffectComboDetail(){
        Integer count = leadsComboDetailMapper.todayEffectComboDetail();
        if(count!=null && count.intValue()>0){
            return true;
        }
        return false;
    }

    /**
     * 更新待生效套餐状态，以前生效套餐置为无效
     */
    @Transactional(rollbackFor = AppException.class)
    public void updateEffectComboDetail() throws AppException{
        leadsComboDetailMapper.updateTodayEffectComboDetail();
        leadsComboDetailMapper.updateLoseEffectComboDetail();
    }

    /**
     * 先判断今天待生效的非会员权益是否已经生效
     * add by xiehb
     * effective_date 等于今天，status=0
     * @return
     */
    public Boolean todayAlreadyEffectNonmemberDetail(){
        Integer count =  leadsNonmemberDetailMapper.todayAlreadyEffectNonmemberDetail();
        if(count!=null && count.intValue()>0){
            return true;
        }
        return false;
    }
    /**
     * 查询今天待生效的套餐权益,取最新的一条记录
     * add by xiehb
     * @return
     */
    public Boolean todayEffectNonmemberDetail(){
        Integer count = leadsNonmemberDetailMapper.todayEffectNonmemberDetail();
        if(count!=null && count.intValue()>0){
            return true;
        }
        return false;
    }

    /**
     * 更新待生效套餐状态，以前生效套餐置为无效
     */
    @Transactional(rollbackFor = AppException.class)
    public void updateEffectNonmemberDetail() throws AppException{
        leadsNonmemberDetailMapper.updateTodayEffectNonmemberDetail();
        leadsNonmemberDetailMapper.updateLoseEffectNonmemberDetail();
    }
}
