package com.shfc.adviser.ao;

import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-04-11 14:30
 **/
@Service
public class MemberAO {
    @Autowired
    private MemberService memberService;

    public ResultDO<MemberStatusDTO> queyStatus(){
        CurrentRealtorDTO currentRealtorDTO = HttpSessionUtils.getCurrentRealtor();
        ResultDO<MemberStatusDTO> resultDO=new ResultDO<MemberStatusDTO>();
        if(currentRealtorDTO==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        return  memberService.queyStatus(currentRealtorDTO.getRealtorId());
    }

    public ResultDO<MemberCentreDTO> showMemberCenter(){
        ResultDO<MemberCentreDTO> resultDO = new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        resultDO = memberService.showMemberCenter(realtorId);
        return resultDO;
    }

    public ResultDO<Boolean> checkPhoneInterest(InterestQueryDTO queryDTO){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        Long leadsHouserId = queryDTO.getLeadsHouseId();
        if(leadsHouserId == null){
            resultDO.setErrMsg("房源ID不能为空！");
            return resultDO;
        }
        queryDTO.setRealtorId(realtorId);
        queryDTO.setLeadsHouseId(leadsHouserId);
        resultDO = memberService.checkPhoneInterest(queryDTO);
        return resultDO;
    }

    public ResultDO<BuyMemberResultDTO> buyMember(BuyMemberDTO object){
        ResultDO<BuyMemberResultDTO> resultDO = new ResultDO<>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        //验证经纪人是否是会员，会员状态有效就不用再购买了
        ResultDO<MemberStatusDTO> memberStatus =  memberService.queyStatus(realtorId);
        if(!memberStatus.isSuccess()){
            resultDO.setErrMsg(memberStatus.getErrMsg());
            return resultDO;
        }
        String status  = memberStatus.getData().getStatus();//会员状态  0:正常,1:过期，2：未开通
        if(status.equals("0")){
            resultDO.setErrMsg("已经是会员不需要购买！");
            return resultDO;
        }
        resultDO = memberService.buyMember(object);
        return resultDO;
    }
}
