package com.shfc.adviser.ao;

import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.enums.PayType;
import com.shfc.house.enums.RealtorStatus;
import com.shfc.house.service.OrderService;
import com.shfc.house.service.RealtorService;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.shfc.adviser.ao.OrderAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/4/12 15:37
 * version V1.0.0
 */
@Service
public class OrderAO {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RealtorService realtorService;

    public ResultDO<OrderInfoDTO> createOrder(OrderParamDTO orderParamDTO){
        ResultDO<OrderInfoDTO> resultDO = new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        Long comboId = orderParamDTO.getComboId();//套餐ID
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(comboId==null){
            resultDO.setErrMsg("套餐ID不能为空！");
            return resultDO;
        }
        CurrentRealtorDTO currentRealtorDTO = realtorService.findCurrentRealtorById(realtorId);
        Integer status = currentRealtorDTO.getStatus();
        if(status!=null && status.intValue()== RealtorStatus.PASS_AUDIT.getValue()){
            orderParamDTO.setRealtorId(realtorId);
            return orderService.createOrder(orderParamDTO);
        }else {
            resultDO.setErrMsg("经纪人状态不正确，不能购买会员!");
            return resultDO;
        }
    }

    public ResultDO<Page<OrderListDTO>> orderList(OrderParamDTO query){
        ResultDO<Page<OrderListDTO>> resultDO = new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        query.setRealtorId(realtorId);
        return orderService.orderList(query);
    }

    public ResultDO<OrderInfoDTO> orderDetail(OrderParamDTO query){
        ResultDO<OrderInfoDTO> resultDO = new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        return orderService.orderDetail(query);
    }

    public ResultDO<Boolean> orderAttestation(OrderAttestationDTO payCheckDTO){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        Integer payType = payCheckDTO.getPayType();//支付渠道类型    aliPay:支付宝 wxPay:微信支付
        String result = payCheckDTO.getResult();//处理结果
        String resultStatus = payCheckDTO.getResultStatus();//处理结果码

        if(payType==null){
            resultDO.setErrMsg("支付渠道类型不能为空！");
            return resultDO;
        }
        if(payType.intValue() != PayType.ALIPAY.getValue() && payType.intValue() != PayType.WXPAY.getValue()){
            resultDO.setErrMsg("支付渠道类型不正确！");
            return resultDO;
        }
        if(ValidateHelper.isEmptyString(result)){
            resultDO.setErrMsg("处理结果不能为空！");
            return resultDO;
        }
        if(ValidateHelper.isEmptyString(resultStatus)){
            resultDO.setErrMsg("处理结果码不能为空！");
            return resultDO;
        }
        return orderService.orderAttestation(payCheckDTO);
    }

    public ResultDO<PayOrderResultDTO> queryOrderStatus(Long orderId,Integer payType){
        ResultDO<PayOrderResultDTO> resultDO = new ResultDO<>();
        if(orderId==null){
            resultDO.setErrMsg("订单id不能为空!");
            return resultDO;
        }
        if(payType==null){
            resultDO.setErrMsg("支付类型不能为空!");
            return resultDO;
        }
        return orderService.queryOrderStatus(orderId,payType);
    }
}
