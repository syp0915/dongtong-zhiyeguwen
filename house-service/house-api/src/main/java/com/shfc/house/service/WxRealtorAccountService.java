package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.query.WxJsQuery;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 微信经纪人账户
 *
 * @author wky
 * @version V1.0
 * @create 2017-02-15 10:01
 **/
public interface WxRealtorAccountService {

    /**
     * 根据微信code获取账户信息
     * @param
     * @return
     */
    public ResultDO<RealtorAccountInfoDTO> getAccountInfoByWxCode(String wxCode);

    /**
     * 微信通道验证
     * @param wxVerifyDTO
     * @return
     */
    public ResultDO<String> wxPassageVerify(WxVerifyDTO wxVerifyDTO);

    /**
     * 微信绑定经纪人账户
     * @param realtorAccountBindDTO
     * @return
     */
    public ResultDO<RealtorAccoutStatusDTO> bindRealtorAccount(RealtorAccountBindDTO realtorAccountBindDTO);

    /**
     *身份审核－微信推送
     * @param realtorId
     * @param status
     * @param reason
     * @return
     */
    public ResultDO<Object> wxPush(Long realtorId , int status , String reason , String auditTime);

    /**
     * 身份审核－短信推送
     * @param realtorId
     * @param status
     * @param reason
     * @return
     */
    public ResultDO<String> smsPush(Long realtorId , int status , String reason);

    /**
     * 获取微信js参数信息
     * @param query
     * @return
     */
    public ResultDO<WxJsDTO> getWxJsInfo(WxJsQuery query);

    /**
     * 发送微信模板消息
     * @param wxAccountType
     * @param dto
     * @return
     */
    public ResultDO<WxMessageDTO> sendWxTempleteMessage(String wxAccountType, WxTemplateMessageDTO dto);

    /**
     * 发送微信红包
     * @param wxAccountType
     * @param wxSendRedPapperReqDTO
     * @return
     */
    public ResultDO sendWxRedPapper(String wxAccountType, WxSendRedPapperReqDTO wxSendRedPapperReqDTO);

}
