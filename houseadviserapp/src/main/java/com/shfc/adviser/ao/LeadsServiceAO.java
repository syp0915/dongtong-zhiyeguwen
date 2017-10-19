package com.shfc.adviser.ao;

import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.base.RegexUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.query.CommissionQuery;
import com.shfc.house.service.LeadsAddedService;
import com.shfc.house.service.PersonalCenterService;
import com.shfc.house.service.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-12 16:15
 **/
@Service
public class LeadsServiceAO {
    @Autowired(required = false)
    private LeadsAddedService leadsAddedService;

    @Autowired(required = false)
    private PersonalCenterService personalCenterService;

    @Autowired(required = false)
    private RealtorService realtorService;


    /**
     * 增值服务-服务详情
     * @param serviceId
     * @return
     */
    public ResultDO<ServiceDTO> serviceDetail(Long serviceId){
        ResultDO<ServiceDTO> resultDO=new ResultDO<>();
        if(serviceId==null){
            resultDO.setErrMsg("服务Id不能为空");
        }

        return leadsAddedService.serviceDetail(serviceId);
    }

    /**
     * 增值服务-客户报备
     * @param dto
     * @return
     */
    public ResultDO<String> addCustomer(LeadsCustomerDTO dto){
        ResultDO<String> resultDO=new ResultDO<>();

        Long realtorId= HttpSessionUtils.getCurrentRealtorId();

        RealtorInfoDTO realtorInfoDTO=realtorService.showCompleteInfo(realtorId);
        if(realtorInfoDTO==null){
            resultDO.setErrMsg("推荐人信息不存在");
            return resultDO;
        }

        dto.setReferrerName(realtorInfoDTO.getRealName());
        dto.setReferrerId(realtorId);

        String checkResult=checkParams(dto);
        if(!ValidateHelper.isEmpty(checkResult)){
            resultDO.setErrMsg(checkResult);
            return resultDO;
        }

        if(!realtorInfoDTO.getTelphone().equals(dto.getReferrerPhone())){
            resultDO.setErrMsg("推荐人手机号与登录用户手机号不一致");
            return resultDO;
        }



        return leadsAddedService.addCustomer(dto);
    }


    public ResultDO<BigDecimal> calculateCommission(){
        ResultDO<BigDecimal> resultDO=new ResultDO<>();
        CommissionQuery commissionQuery=new CommissionQuery();
        Long currentRealtorId=HttpSessionUtils.getCurrentRealtorId();
        if(currentRealtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        commissionQuery.setReferrerId(currentRealtorId);

        ResultDO<CommissionRespDTO> result=personalCenterService.commissionStatistics(commissionQuery);
        if(!result.isSuccess()){
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }

        resultDO.setData(result.getData().getTotalCommission());
        resultDO.setSuccess(true);
        return resultDO;

    }

    public String checkParams(LeadsCustomerDTO dto){
        if(dto.getServiceId()==null){
            return "服务Id为空";
        }
        if(ValidateHelper.isEmpty(dto.getServiceName())){
            return "服务名称为空";
        }
        if(ValidateHelper.isEmpty(dto.getCustomerName())){
            return "客户姓名为空";
        }
        if(dto.getGender()==null){
            return "性别为空";
        }
        if(ValidateHelper.isEmpty(dto.getCustomerPhone())){
            return "客户手机号为空";
        }

//        if(dto.getComId()==null){
//            return "公司Id为空";
//        }

        //手机号校验
        String regex="^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        if(!RegexUtils.find(dto.getCustomerPhone(), regex)){
            return "客户手机号格式错误";
        }

        if(dto.getReferrerId()==null||ValidateHelper.isEmpty(dto.getReferrerName())||ValidateHelper.isEmpty(dto.getReferrerPhone())){
            return "推荐人信息缺失";
        }
        return null;
    }
}
