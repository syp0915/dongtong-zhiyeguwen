package com.shfc.user.service;

import com.shfc.common.result.ResultDO;
import com.shfc.user.httpbean.req.ReqBean60105;
import com.shfc.user.httpbean.req.ReqBean60109;
import com.shfc.user.httpbean.req.ReqBean60110;
import com.shfc.user.httpbean.req.ReqBean60111;
import com.shfc.user.httpbean.resp.RespBean60105;
import com.shfc.user.httpbean.resp.RespBean60109;
import com.shfc.user.httpbean.resp.RespBean60110;
import com.shfc.user.httpbean.resp.RespBean60111;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午10:23.
 */
public interface AssistantService {

    /**
     * 邮件分享委托协议
     * @param reqBean60105
     * @return
     */
    public ResultDO<RespBean60105> shareEntrustViaEmail(ReqBean60105 reqBean60105);

    /**
     * 获取短信验证码
     * @param reqBean60109
     * @return
     */
    public ResultDO<RespBean60109> sendVerifyCode(ReqBean60109 reqBean60109);

    /**
     * 验证短信验证码
     * @param reqBean60110
     * @return
     */
    public ResultDO<RespBean60110> checkVerifyCode(ReqBean60110 reqBean60110);

    /**
     * 获取上海房产公众号二维码url
     * @param reqBean60111
     * @return
     */
    public ResultDO<RespBean60111> getShfcOfficialAccountQrCode(ReqBean60111 reqBean60111);

}
