package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.dto.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-04-10 16:34
 **/
public class MemberServiceTest extends JunitBaseTest{
    @Autowired
    private MemberService memberService;

    @Test
    public void testQueyStatus(){
        ResultDO<MemberStatusDTO> resultDO=memberService.queyStatus(123L);
        System.out.println(resultDO.toString());
    }
    @Test
    public void testShowMemberCenter(){
        ResultDO<MemberCentreDTO> resultDO = memberService.showMemberCenter(1L);
        if(resultDO.isSuccess()){
            MemberCentreDTO memberCentreDTO =  resultDO.getData();
            System.out.println(memberCentreDTO.toString());
        }else {
            System.out.println(resultDO.getErrMsg());
        }
    }
    @Test
    public void testBuyMember(){
        BuyMemberDTO buyMemberDTO = new BuyMemberDTO();
        buyMemberDTO.setOrderId(223L);
        buyMemberDTO.setPayType(0);
        buyMemberDTO.setInvitationCode("123456789");
        ResultDO<BuyMemberResultDTO> resultDO = memberService.buyMember(buyMemberDTO);
        System.out.println(resultDO.toString());
    }

    @Test
    public void testCheckPhoneInterest(){
//        InterestQueryDTO interestQueryDTO = new InterestQueryDTO();
//        interestQueryDTO.setLeadsHouseId(1L);
//        interestQueryDTO.setRealtorId(1L);
//        ResultDO<Boolean> resultDO = memberService.checkPhoneInterest(interestQueryDTO);
//        System.out.println(resultDO.toString());

        InterestQueryDTO interestQueryDTO = new InterestQueryDTO();
        interestQueryDTO.setLeadsHouseId(1L);
        interestQueryDTO.setRealtorId(2L);
        ResultDO<Boolean> resultDO = memberService.checkPhoneInterest(interestQueryDTO);
        System.out.println(resultDO.toString());
    }
}
