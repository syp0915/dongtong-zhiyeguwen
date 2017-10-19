package com.shfc.house.service;

import com.shfc.base.dto.SysMessageDTO;
import com.shfc.base.enums.SysMessageFrom;
import com.shfc.base.enums.SysMessageType;
import com.shfc.base.enums.SysMessageUserType;
import com.shfc.base.service.SmsRemoteService;
import com.shfc.base.service.SysMessageService;
import com.shfc.common.base.Logger;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.constant.ConstantService;
import com.shfc.house.domain.*;
import com.shfc.house.dto.*;
import com.shfc.house.enums.LeadsOrderStatus;
import com.shfc.house.enums.MemberStatus;
import com.shfc.house.enums.PayType;
import com.shfc.house.enums.YesNo;
import com.shfc.house.manager.*;
import com.shfc.pay.dto.PayDataDTO;
import com.shfc.pay.dto.PayOrderDTO;
import com.shfc.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 会员服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-04-10 16:16
 **/
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberManager memberManager;
    @Autowired
    private LeadsHouseCallManager leadsHouseCallManager;
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private LeadsComboManager leadsComboManager;
    @Autowired
    private LeadsHouseManager leadsHouseManager;
    @Autowired
    private PayService payService;
    @Autowired
    private SmsRemoteService smsRemoteService;
    @Autowired
    private SysMessageService sysMessageService;


    @Value("${three.dayPast.remind.business.id}")
    private String threeDayPastRemindTemId;
    @Value("${member.past.remind.business.id}")
    private String memberPastRemindTemId;
    @Value("${mc.house.appId}")
    private String houseAppId;

    @Override
    public ResultDO<MemberStatusDTO> queyStatus(Long realtorId) {
        ResultDO<MemberStatusDTO> resultDO=new ResultDO<MemberStatusDTO>();
        if(realtorId==null){
            resultDO.setErrMsg("经纪人Id不能为空");
            return resultDO;
        }
        MemberStatusDTO dto=new MemberStatusDTO();
        LeadsRealtorMember member=memberManager.queryStatusByRealtorId(realtorId);
        if(member==null){
            dto.setStatus(String.valueOf(MemberStatus.NOT_OPEN.getValue()));
            dto.setDescribe("开通会员");
        }else{
            dto.setStatus(String.valueOf(member.getStatus()));
            if(dto.getStatus().equals(String.valueOf(MemberStatus.EXPIRE.getValue()))){//会员过期
                dto.setDescribe("会员已过期");
            }else {
                dto.setDescribe(DateUtils.formatDate(member.getDeadline(),"yyyy年MM月dd日")+"到期");
            }
        }

        resultDO.setData(dto);
        resultDO.setSuccess(true);
        return resultDO;
    }


    //public MemberCentreDTO
    /**
     * 1. 查询realtor_unitive_account，realtor_info,leads_realtor_member 返回经纪人审核状态和会员状态
     * 1.1 审核不通过不能开通会员
     * 返回：会员状态，全部套餐列表
     *  1.2 判断会员状态——有效
     * 返回：到期时间，已购买的套餐，会员状态
     *  1.3 判断会员状态——过期
     *返回：会员状态，全部套餐列表
     * @param realtorId
     * @return
     */
    @Override
    public ResultDO<MemberCentreDTO> showMemberCenter(Long realtorId) {
        ResultDO<MemberCentreDTO> resultDO = new ResultDO<>();
        MemberCentreDTO memberCentreDTO = memberManager.selectByRealtorId(realtorId);
        if(memberCentreDTO==null){
            resultDO.setErrMsg("经纪人信息不存在！");
            return resultDO;
        }
        Integer memberStatus  = memberCentreDTO.getStatus();
        if (memberStatus!=null && memberStatus.intValue()== MemberStatus.OPEN.getValue()){  //1.2 判断会员状态——有效
            List<ComboDTO> comboDTOList =  memberManager.validComboList(realtorId);
            memberCentreDTO.setComboList(comboDTOList);
            resultDO.setData(memberCentreDTO);
            resultDO.setSuccess(true);
            return resultDO;
        }else {
            List<ComboDTO> comboDTOList =  memberManager.allComboList();
            memberCentreDTO.setComboList(comboDTOList);
            resultDO.setData(memberCentreDTO);
            resultDO.setSuccess(true);
            return resultDO;
        }
    }
    @Override
    public ResultDO<BuyMemberResultDTO> buyMember(BuyMemberDTO buyMemberDTO) {
        ResultDO<BuyMemberResultDTO> resultDO = new ResultDO<>();
        BuyMemberResultDTO buySucessDto = new BuyMemberResultDTO();
        Long orderId = buyMemberDTO.getOrderId();
        Integer payType = buyMemberDTO.getPayType();
        String invitationCode = buyMemberDTO.getInvitationCode();
        if(orderId==null){
            resultDO.setErrMsg("订单ID不能为空！");
            return resultDO;
        }
        if(payType==null){
            resultDO.setErrMsg("支付类型不能为空！");
            return resultDO;
        }
        //根据订单ID验证订单
        LeadsOrder leadsOrder = orderManager.selectByPrimaryKey(orderId);
        if(leadsOrder==null){
            resultDO.setErrMsg("订单信息不正确！");
            return resultDO;
        }else if (leadsOrder.getStatus().intValue()!= LeadsOrderStatus.NO_PAYMENT.getValue()){
            resultDO.setErrMsg("订单状态不正确！");
            return resultDO;
        }
        Long comboId = leadsOrder.getComboId();//套餐ID
        LeadsCombo leadsCombo  = leadsComboManager.select(comboId);
        if(leadsCombo==null){
            resultDO.setErrMsg("套餐信息不正确！");
            return resultDO;
        }else if(leadsCombo.getStatus().intValue() != 0){
            resultDO.setErrMsg("套餐状态不正确！");
            return resultDO;
        }
        //远程调用支付接口，拼装参数 begin
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setMerchantNo(ConstantService.MERCHANT_NO);//商户号
        payOrderDTO.setMerOrderNo(leadsOrder.getOrderNum());//订单编号
        payOrderDTO.setSubject(leadsCombo.getComboName());//商品名称
        payOrderDTO.setTotalAmount(leadsCombo.getComboPrice().toPlainString());//总金额
        payOrderDTO.setReceiptAmount(leadsCombo.getComboPrice().toPlainString());//实收金额
        payOrderDTO.setTransactionType("APP");//默认值APP
        if(payType.intValue()==PayType.ALIPAY.getValue()){  //支付宝
            payOrderDTO.setPayType(PayType.getNameByValue(payType));
        }else if(payType.intValue()==PayType.WXPAY.getValue()){ //微信
            payOrderDTO.setPayType(PayType.getNameByValue(payType));
        }
        //payOrderDTO.setOrderTime(DateUtils.date2String(leadsOrder.getCreateTime(), DateFormatUtils.TIME_NOFUll_FORMAT));
        payOrderDTO.setOrderTime(DateUtils.getCurrentTime());//支付订单时间
        //远程调用支付接口，拼装参数 end
        ResultDO<PayDataDTO> payResult = payService.getOrderInfo(payOrderDTO);
        if(!payResult.isSuccess()){
            resultDO.setErrMsg(payResult.getErrMsg());
            resultDO.setErrCode(payResult.getErrCode());
            return resultDO;
        }
        //更新订单的邀请码和支付类型
        leadsOrder.setInvitationCode(invitationCode);
        leadsOrder.setPayType(payType);
        leadsOrder.setOrderPaySerialNum(payResult.getData().getOrderNo());
        Logger.info(MemberServiceImpl.class,leadsOrder.getOrderPaySerialNum());
        try {
            orderManager.updateInvitationCodeOrStatus(leadsOrder);
        } catch (AppException e) {
            e.printStackTrace();
        }
        buySucessDto.setOrderInfo(payResult.getData().getOrderInfo());
        resultDO.setSuccess(true);
        resultDO.setData(buySucessDto);
        return resultDO;
    }

    @Override
    public ResultDO<Boolean> checkPhoneInterest(InterestQueryDTO interestQueryDTO){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        Long leadsHouseId  = interestQueryDTO.getLeadsHouseId();
        Long realtorId = interestQueryDTO.getRealtorId();
        LeadsHouseCall record =  leadsHouseCallManager.findCallByHouseAndRealtorId(leadsHouseId,realtorId);
        if(record==null){
            LeadsHouse leadsHouse =leadsHouseManager.findLeadsHouseById(leadsHouseId);
            if(leadsHouse==null){
                resultDO.setErrMsg("该房源信息不存在！");
                return resultDO;
            }
            resultDO = memberManager.checkPhoneInterest(realtorId);
            if(resultDO.isSuccess()){
                //数据库插入一条电话拨打记录
                LeadsHouseCall callRecord = new LeadsHouseCall();
                callRecord.setLeadsHouseId(interestQueryDTO.getLeadsHouseId());
                callRecord.setRealtorId(interestQueryDTO.getRealtorId());
                callRecord.setCreater(interestQueryDTO.getRealtorId());
                callRecord.setStatus(YesNo.NO.getValue());
                leadsHouseCallManager.insert(callRecord);
            }
            return resultDO;
        }
        resultDO.setSuccess(true);
        return resultDO;
    }
    @Override
    public ResultDO<Boolean> memberPastRemind(){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        List<RealtorMemberDTO> list = memberManager.pastMemberList();
        if(list!=null && list.size()>0){
            Iterator<RealtorMemberDTO> iterator = list.iterator();
            while (iterator.hasNext()){
                RealtorMemberDTO realtorMemberDTO = iterator.next();
                String phone  = realtorMemberDTO.getPhone();
                String businessId =memberPastRemindTemId;
                HashMap<String,Object> paramMap = new HashMap<>();
                paramMap.put("appId",houseAppId);
                paramMap.put("phone",phone);
                paramMap.put("businessId", businessId);
                paramMap.put("osType", realtorMemberDTO.getOsType());
                paramMap.put("deviceId", realtorMemberDTO.getDeviceId());
                smsRemoteService.pushSendNoticeMessage(paramMap,null,null,null);
               // smsRemoteService.sendSMSMessage(phone,tempId,"");//发送短信
                SysMessageDTO messageDTO = new SysMessageDTO();
                messageDTO.setMesFrom(SysMessageFrom.TV_997.getValue());
                messageDTO.setMesType(SysMessageType.SYSTEM_INFORM.getValue());
                messageDTO.setUserId(realtorMemberDTO.getRealtorId());//消息发给经纪人
                messageDTO.setUserType(SysMessageUserType.REALTOR.getValue());
                messageDTO.setMesDigest("会员到期");
                messageDTO.setMesContent("您的置业顾问会员已经到期，请及时续约，以免影响您的日常权益和工作！");
                try {
                    sysMessageService.addMessage(messageDTO);//添加本地消息
                } catch (AppException e) {
                    e.printStackTrace();
                }
            }
        }
        memberManager.updateRealtorMemberList();
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<Boolean> threeDayPastRemind(){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        List<RealtorMemberDTO> list =  memberManager.threeDayPastMemberList();
        if(list!=null && list.size()>0){
            Iterator<RealtorMemberDTO> iterator = list.iterator();
            while (iterator.hasNext()){
                RealtorMemberDTO realtorMemberDTO = iterator.next();
                String phone  = realtorMemberDTO.getPhone();
                String businessId =threeDayPastRemindTemId;
                HashMap<String,Object> paramMap = new HashMap<>();
                paramMap.put("appId",houseAppId);
                paramMap.put("phone",phone);
                paramMap.put("businessId", businessId);
                paramMap.put("osType", realtorMemberDTO.getOsType());
                paramMap.put("deviceId", realtorMemberDTO.getDeviceId());
                List<String> contentParamList = new ArrayList<>();
                contentParamList.add("3天");
                ResultDO<String> pushResult =  smsRemoteService.pushSendNoticeMessage(paramMap,contentParamList,null,null);
                Logger.info("threeDayPastRemind:"+this,pushResult.toString());
                //smsRemoteService.sendSMSMessage(phone,tempId,"");//发送短信
                SysMessageDTO messageDTO = new SysMessageDTO();
                messageDTO.setMesFrom(SysMessageFrom.TV_997.getValue());
                messageDTO.setMesType(SysMessageType.SYSTEM_INFORM.getValue());
                messageDTO.setUserId(realtorMemberDTO.getRealtorId());//消息发给经纪人
                messageDTO.setUserType(SysMessageUserType.REALTOR.getValue());
                messageDTO.setMesDigest("会员即将到期");
                messageDTO.setMesContent("您购买的置业顾问会员还有三天就要到期了，请密切关注会员有效期变动情况！");
                try {
                    sysMessageService.addMessage(messageDTO);
                } catch (AppException e) {
                    e.printStackTrace();
                }
            }
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 1.判断是否已经执行
     * 2.查询是否有今天待生效的套餐
     * 3.更新待生效为生效，更新以前的套餐失效
     * @return
     */
    @Override
    public ResultDO<String> makeComboDisplay() {
        ResultDO<String> resultDO = new ResultDO<>();
        Boolean alreadyResult =  memberManager.todayAlreadyEffectCombo();
        if(!alreadyResult){
            //查询今天待生效的套餐
            Boolean todayResult  = memberManager.todayEffectCombo();
            if(todayResult){
                //更新待生效为生效，更新以前的套餐失效
                try {
                    memberManager.updateEffectCombo();
                    Logger.info(MemberServiceImpl.class,"今天待生效的套餐已经生效！");
                    resultDO.setSuccess(true);
                    return resultDO;
                } catch (Exception e) {
                    Logger.error(MemberServiceImpl.class,"更新今天待生效的套餐数据库执行失败！");
                    resultDO.setErrMsg("更新今天待生效的套餐数据库执行失败！");
                    return resultDO;
                }
            }else {
                Logger.info(MemberServiceImpl.class,"今天没有待生效的套餐！");
                resultDO.setSuccess(true);
                return resultDO;
            }
        }else {
            Logger.info(MemberServiceImpl.class,"今天待生效的套餐已经执行过了！");
            resultDO.setErrMsg("今天待生效的套餐已经执行过了！");
            return resultDO;
        }
    }
    /**
     * 1.判断是否已经执行
     * 2.查询是否有今天待生效的套餐
     * 3.更新待生效为生效，更新以前的套餐失效
     * @return
     */
    @Override
    public ResultDO<String> makeComboDetailDisplay() {
        ResultDO<String> resultDO = new ResultDO<>();
        Boolean alreadyResult =  memberManager.todayAlreadyEffectComboDetail();
        if(!alreadyResult){
            //查询今天待生效的套餐
            Boolean todayResult  = memberManager.todayEffectComboDetail();
            if(todayResult){
                //更新待生效为生效，更新以前的套餐失效
                try {
                    memberManager.updateEffectComboDetail();
                    Logger.info(MemberServiceImpl.class,"今天待生效的套餐权益已经生效！");
                    resultDO.setSuccess(true);
                    return resultDO;
                } catch (Exception e) {
                    Logger.error(MemberServiceImpl.class,"更新今天待生效的套餐权益数据库执行失败！");
                    resultDO.setErrMsg("更新今天待生效的套餐权益数据库执行失败！");
                    return resultDO;
                }
            }else {
                Logger.info(MemberServiceImpl.class,"今天没有待生效的套餐权益！");
                resultDO.setSuccess(true);
                return resultDO;
            }
        }else {
            Logger.info(MemberServiceImpl.class,"今天待生效的套餐权益已经执行过了！");
            resultDO.setErrMsg("今天待生效的套餐权益已经执行过了！");
            return resultDO;
        }
    }
    /**
     * 1.判断是否已经执行
     * 2.查询是否有今天待生效的非会员权益
     * 3.更新待生效为生效，更新以前的非会员权益失效
     * @return
     */
    @Override
    public ResultDO<String> makeNonmemberDetailDisplay() {
        ResultDO<String> resultDO = new ResultDO<>();
        Boolean alreadyResult =  memberManager.todayAlreadyEffectNonmemberDetail();
        if(!alreadyResult){
            //查询今天待生效的非会员权益
            Boolean todayResult  = memberManager.todayEffectNonmemberDetail();
            if(todayResult){
                //更新待生效为生效，更新以前的非会员权益失效
                try {
                    memberManager.updateEffectNonmemberDetail();
                    Logger.info(MemberServiceImpl.class,"今天待生效的非会员权益已经生效！");
                    resultDO.setSuccess(true);
                    return resultDO;
                } catch (Exception e) {
                    Logger.error(MemberServiceImpl.class,"更新今天待生效的非会员权益数据库执行失败！");
                    resultDO.setErrMsg("更新今天待生效的非会员权益数据库执行失败！");
                    return resultDO;
                }
            }else {
                Logger.info(MemberServiceImpl.class,"今天没有待生效的非会员权益！");
                resultDO.setSuccess(true);
                return resultDO;
            }
        }else {
            Logger.info(MemberServiceImpl.class,"今天待生效的非会员权益已经执行过了！");
            resultDO.setErrMsg("今天待生效的非会员权益已经执行过了！");
            return resultDO;
        }
    }
}
