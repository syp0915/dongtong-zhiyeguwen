package com.shfc.user.service;

import com.alibaba.fastjson.JSON;
import com.shfc.common.result.ResultDO;
import com.shfc.user.JunitBaseTest;
import com.shfc.user.dto.WxMessageDTO;
import com.shfc.user.httpbean.wxBean.WxMessageVCBean;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageDataBean;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageReqBean;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/14 下午5:54.
 */
public class WxOfficialAccountServiceTest extends JunitBaseTest {
    @Autowired
    private WxOfficialAccountService wxOfficialAccountService;

    @Test
    public void testSendWxTempleteMessage(){
        String wxAccountType = "ajsh";
        String templeteId = "Z9rtpSCTBdBLyU1XDfROLM5QD43pqCaM8ORnO-2u4wM";
        String wxOpenId = "ogJlJwrav0MVtTIRJRnDDnn-xwUo";
        String callBackUrl = "http://www.baidu.com";
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> kvMap = new HashMap<String, Object>();
        WxTemplateMessageReqBean wxTemplateMessageReqBean = new WxTemplateMessageReqBean();
        WxTemplateMessageDataBean dataBean = new WxTemplateMessageDataBean();

        WxMessageVCBean vcBean = new WxMessageVCBean();
        vcBean.setValue("尊敬的业主您好");
        dataBean.setFirst(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue("望京");
        dataBean.setKeyword1(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue("哈哈哈");
        dataBean.setKeyword2(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue("13999999999");
        dataBean.setKeyword3(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue("2016年9月30日");
        dataBean.setKeyword4(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue("请拨打咨询热线123323");
        dataBean.setRemark(vcBean);

        wxTemplateMessageReqBean.setTouser(wxOpenId);
        wxTemplateMessageReqBean.setUrl(callBackUrl);
        wxTemplateMessageReqBean.setTemplate_id(templeteId);
        wxTemplateMessageReqBean.setData(dataBean);

        JSONObject data = JSONObject.fromObject(map);
        System.out.println("请求参数data是---------------------->" + data);
        ResultDO<WxMessageDTO> resultDO = wxOfficialAccountService.sendWxTempleteMessage(wxAccountType, wxTemplateMessageReqBean);
        System.out.println(JSON.toJSONString(resultDO));
    }
}
