package com.shfc.house.service;

import com.alibaba.fastjson.JSONObject;
import com.shfc.base.dto.SysMessageDTO;
import com.shfc.base.enums.SysMessageFrom;
import com.shfc.base.enums.SysMessageType;
import com.shfc.base.enums.SysMessageUserType;
import com.shfc.base.service.SmsRemoteService;
import com.shfc.base.service.SysMessageService;
import com.shfc.common.base.Logger;
import com.shfc.common.exception.AppException;
import com.shfc.house.domain.LeadsOrder;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.enums.LeadsOrderStatus;
import com.shfc.house.manager.OrderManager;
import com.shfc.house.manager.RealtorInfoManager;
import com.shfc.kafka.comsumer.BaseKafkaConsumerService;
import com.shfc.kafka.exception.BreakRepeatException;
import com.shfc.kafka.exception.NeedRepeatException;
import com.shfc.kafka.exception.NoNeedRepeatException;
import com.shfc.pay.dto.PayBackDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Package com.shfc.house.service.ConsumeService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/16 13:11
 * version V1.0.0
 */
@Service
public class OrderConsumeServiceImpl implements BaseKafkaConsumerService {
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private RealtorInfoManager realtorInfoManager;
    @Autowired
    private SmsRemoteService smsRemoteService;//短信服务
    @Autowired
    private SysMessageService sysMessageService;

    @Value("${order.pay.sucess.business.id}")
    private String orderPaySucessTemId;

    @Value("${mc.house.appId}")
    private String houseAppId;


    @Override
    public String consumeMessage(String message) throws NeedRepeatException, NoNeedRepeatException, BreakRepeatException {
        Logger.info(this.getClass(),"kafka接收到的参数= "+message);
        PayBackDataDTO object = null;
        try {
            object = JSONObject.parseObject(message,PayBackDataDTO.class);
        }catch (Exception e){
            Logger.error(this.getClass(),"json解析message错误= ",e);
            //return "false";
            throw new NoNeedRepeatException();
        }

        String merOrderNo = object.getMerOrderNo();//商户订单号
        //String orderNo  = object.getOrderNo();//支付订单号
        LeadsOrder leadsOrder = orderManager.selectByOrderNum(merOrderNo);
        if(leadsOrder!=null && leadsOrder.getStatus().intValue() == LeadsOrderStatus.HAVE_PAID.getValue()){
            return "true";
        }
        //leadsOrder.setOrderPaySerialNum(orderNo);
        leadsOrder.setStatus(LeadsOrderStatus.HAVE_PAID.getValue());
        try {
            orderManager.updateNoPaymentOrder(leadsOrder);
        } catch (AppException e) {
            e.printStackTrace();
            Logger.error(OrderConsumeServiceImpl.class,e.getMessage(),e);
            throw new NoNeedRepeatException();
        }
        try {
            RealtorUnitiveAccount account =  realtorInfoManager.findById(leadsOrder.getRealtorId());
            Integer osType = account.getOsType();
            String businessId =orderPaySucessTemId;
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("appId",houseAppId);
            paramMap.put("phone",account.getPhone());
            paramMap.put("businessId", businessId);
            paramMap.put("osType", osType);
            paramMap.put("deviceId", account.getDeviceId());
            smsRemoteService.pushSendNoticeMessage(paramMap,null,null,null);
            //smsRemoteService.sendSMSMessage(account.getPhone(),tempId,"");//购买成功发送短信提醒
            SysMessageDTO messageDTO = new SysMessageDTO();
            messageDTO.setMesFrom(SysMessageFrom.TV_997.getValue());
            messageDTO.setMesType(SysMessageType.SYSTEM_INFORM.getValue());
            messageDTO.setBizId(leadsOrder.getId());//订单ID
            messageDTO.setUserId(leadsOrder.getRealtorId());//消息发给经纪人
            messageDTO.setUserType(SysMessageUserType.REALTOR.getValue());
            messageDTO.setMesDigest("购买会员成功");
            messageDTO.setMesContent("您已经成功购买置业顾问会员，您的满意是我们最大的动力！");
            sysMessageService.addMessage(messageDTO);//添加本地消息
        } catch (AppException e) {
            e.printStackTrace();
            Logger.error(OrderConsumeServiceImpl.class,e.getMessage(),e);
        }
        return "true";
    }

}