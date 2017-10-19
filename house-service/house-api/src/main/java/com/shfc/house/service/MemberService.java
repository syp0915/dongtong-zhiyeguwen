package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *会员服务
 * @author wky
 * @version V1.0
 * @create 2017-04-10 16:06
 **/
public interface MemberService {
    /**
     * @Description: 根据经纪人Id查询经纪人会员状态
     * @Title queyStatus
     * @Author  吴开阳
     * @param  realtorId
     * @return ResultDO<MemberStatusDTO>
     * @throws
     */

    ResultDO<MemberStatusDTO> queyStatus(Long realtorId);


    /**
     * 会员中心展示
     * @param realtorId
     * @Author  xhb
     * @return
     */
    ResultDO<MemberCentreDTO> showMemberCenter(Long realtorId);

    /**
     * 购买会员
     * @param buyMemberDTO
     * @Author  xhb
     * @return
     */
    ResultDO<BuyMemberResultDTO> buyMember(BuyMemberDTO buyMemberDTO);

    /**
     * 判断拨打电话权益
     * @Author  xhb
     * @return
     */
    ResultDO<Boolean> checkPhoneInterest(InterestQueryDTO interestQueryDTO);

    /**
     * 会员过期，修改状态并发送短信/push提醒
     * @return
     * @Author  xhb
     */
    ResultDO<Boolean> memberPastRemind();

    /**
     * 3天即将过期的会员，发短信/push提醒
     * @Author  xhb
     */
    ResultDO<Boolean> threeDayPastRemind();
    /**
     * 跑批使生效日期为今天的套餐生效
     * @Author  xhb
     */
    ResultDO<String> makeComboDisplay();

    /**
     * 跑批使生效日期为今天的权益生效
     * @Author  xhb
     */
    ResultDO<String> makeComboDetailDisplay();

    /**
     * 跑批使生效日期为今天的非会员权益生效
     * @Author  xhb
     */
    ResultDO<String> makeNonmemberDetailDisplay();
}
