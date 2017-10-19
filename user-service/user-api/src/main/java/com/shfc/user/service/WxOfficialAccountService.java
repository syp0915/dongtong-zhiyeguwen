package com.shfc.user.service;

import com.shfc.common.result.ResultDO;
import com.shfc.user.dto.WxMessageDTO;
import com.shfc.user.httpbean.req.ReqBean60107;
import com.shfc.user.httpbean.req.ReqBean60108;
import com.shfc.user.httpbean.req.ReqBean60113;
import com.shfc.user.httpbean.resp.RespBean60107;
import com.shfc.user.httpbean.resp.RespBean60108;
import com.shfc.user.httpbean.resp.RespBean60113;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageReqBean;
import com.shfc.user.httpbean.wxBean.WxVerifyReqBean;
import com.shfc.user.httpbean.wxBean.WxVerifyRespBean;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午10:25.
 */
public interface WxOfficialAccountService {

    /**
     * 微信公众号&上海房产帐号绑定
     * @param reqBean60107
     * @return
     */
    public ResultDO<RespBean60107> bindShfcAccount(ReqBean60107 reqBean60107);

    /**
     * 根据微信code获取账户信息
     * @param reqBean60108
     * @return
     */
    public ResultDO<RespBean60108> getAccountInfoByWxCode(ReqBean60108 reqBean60108);

    /**
     * 微信通道验证
     * @param wxVerifyReqBean
     * @return
     */
    public WxVerifyRespBean wxPassageVerify(WxVerifyReqBean wxVerifyReqBean);

    /**
     * 获取微信js参数信息
     * @param reqBean60113
     * @return
     */
    public ResultDO<RespBean60113> getWxJsInfo(ReqBean60113 reqBean60113);

    /**
     * 发送微信模板消息
     * @param wxAccountType
     * @param wxTemplateMessageReqBean
     * @return
     */
    public ResultDO<WxMessageDTO> sendWxTempleteMessage(String wxAccountType, WxTemplateMessageReqBean wxTemplateMessageReqBean);

    /**
     * 微信取消关注通知事件
     * @param wxOpenId
     * @return
     */
    public ResultDO<Boolean> unsubscribeWx(String wxOpenId);

}
