package com.shfc.house.service;

import com.shfc.base.service.SmsRemoteService;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.NnsEntrustProtocol;
import com.shfc.house.dto.*;
import com.shfc.house.enums.NnsProtocolStatus;
import com.shfc.house.enums.NnsProtocolStatusText;
import com.shfc.house.manager.NnsEntrustProtocolManager;
import com.shfc.house.utils.DateFormatUtils;
import com.shfc.house.utils.ShortenUrl;
import com.shfc.mybatis.pagination.Page;
import com.shfc.user.httpbean.wxBean.WxMessageVCBean;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageDataBean;
import com.shfc.user.httpbean.wxBean.WxTemplateMessageReqBean;
import com.shfc.user.service.WxOfficialAccountService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.house.service.NnsEntrustProtocolServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 17:29
 * version V1.0.0
 */
@Service
public class NnsEntrustProtocolServiceImpl implements NnsEntrustProtocolService {
    public static final Logger LOGGER =Logger.getLogger(NnsEntrustProtocolServiceImpl.class);
    @Autowired
    private SmsRemoteService smsRemoteService;
    @Autowired
    private WxOfficialAccountService wxOfficialAccountService;
    @Autowired
    private NnsEntrustProtocolManager nnsEntrustProtocolManager;

    @Value("${send.signNote.url}")
    private String sendSignNoteUrl;
    @Value("${send.signNote.temId}")
    private String signNoteTemId;//发起签署短信的模板ID
    @Value("${past.protocol.note}")
    private String pastProtocolNote;
    @Value("${setting.dns}")
    private String settingDns;
    @Override
    public Page<NnsHouseEntrustListDTO> houseEntrustList(Long realtorId, Page page) {
        Page<NnsHouseEntrustListDTO> pageList = nnsEntrustProtocolManager.houseEntrustList(realtorId,page);
        for (NnsHouseEntrustListDTO entrust : pageList.getData()){
            String createTime  = entrust.getCreateTime();
            createTime = DateFormatUtils.getTimesToNow(createTime);
            entrust.setCreateTime(createTime);
            Integer status = entrust.getStatus();
            Integer type = entrust.getType();
            if(status.intValue()== NnsProtocolStatus.WAIT_SIGN.getValue()){
                entrust.setStatusText(NnsProtocolStatusText.WAIT_SIGN.getName());
            }else if(status.intValue()== NnsProtocolStatus.SUCCESS_SIGN.getValue()){
                //签约成功的协议 计算协议有效截止日期
                Date overdueTime = entrust.getOverdueTime();//协议有效截止日期
                Date successTime = entrust.getSuccessTime();//签约成功时间
                long days  = DateUtils.getDays(overdueTime,successTime);
                String statusText = NnsProtocolStatusText.SUCCESS_SIGN.getName();
                statusText = statusText.replace("X",Long.toString(days));
                entrust.setStatusText(statusText);
            }else if(status.intValue()== NnsProtocolStatus.REJECT_SIGN.getValue()){
                entrust.setStatusText(NnsProtocolStatusText.REJECT_SIGN.getName());
            }else if(status.intValue()== NnsProtocolStatus.CANCEL_SIGN.getValue()){
                entrust.setStatusText(NnsProtocolStatusText.CANCEL_SIGN.getName());
            }else if(status.intValue()== NnsProtocolStatus.OVERDUE_SIGN.getValue()){
                entrust.setStatusText(NnsProtocolStatusText.OVERDUE_SIGN.getName());
            }
            if(type.intValue()==1){
                entrust.setStatusText(NnsProtocolStatusText.OFFLINE_SIGN.getName());
            }
        }
        return pageList;
    }

    @Override
    public ResultDO<NnsHouseEntrustDetailDTO> houseEntrustDetail(Long protocolId) {
        ResultDO<NnsHouseEntrustDetailDTO> resultDO = new ResultDO<NnsHouseEntrustDetailDTO>();
        NnsHouseEntrustDetailDTO entrustDetailDTO = nnsEntrustProtocolManager.houseEntrustDetail(protocolId);
        if(entrustDetailDTO==null){
            resultDO.setErrMsg("协议不存在！");
            return resultDO;
        }
        Integer status = entrustDetailDTO.getStatus();
        if(status==null){
            resultDO.setErrMsg("协议状态不正确！");
            return resultDO;
        }
        Integer type = entrustDetailDTO.getType();
        if(status.intValue()== NnsProtocolStatus.WAIT_SIGN.getValue()){
            entrustDetailDTO.setStatusText(NnsProtocolStatusText.WAIT_SIGN.getName());
        }else if(status.intValue()== NnsProtocolStatus.SUCCESS_SIGN.getValue()){
            //签约成功的协议 计算协议有效截止日期
            Date overdueTime = entrustDetailDTO.getOverdueTime();//协议有效截止日期
            Date successTime = entrustDetailDTO.getSuccessTime();//签约成功时间
            long days  = DateUtils.getDays(overdueTime,successTime);
            String statusText = NnsProtocolStatusText.SUCCESS_SIGN.getName();
            statusText = statusText.replace("X",Long.toString(days));
            entrustDetailDTO.setStatusText(statusText);
        }else if(status.intValue()== NnsProtocolStatus.REJECT_SIGN.getValue()){
            entrustDetailDTO.setStatusText(NnsProtocolStatusText.REJECT_SIGN.getName());
        }else if(status.intValue()== NnsProtocolStatus.CANCEL_SIGN.getValue()){
            entrustDetailDTO.setStatusText(NnsProtocolStatusText.CANCEL_SIGN.getName());
        }else if(status.intValue()== NnsProtocolStatus.OVERDUE_SIGN.getValue()){
            entrustDetailDTO.setStatusText(NnsProtocolStatusText.OVERDUE_SIGN.getName());
        }
        if(type.intValue()== 1){
            entrustDetailDTO.setStatusText(NnsProtocolStatusText.OFFLINE_SIGN.getName());
        }
        String protocolContent = HtmlUtils.htmlUnescape(entrustDetailDTO.getProtocolContent());//协议内容
        entrustDetailDTO.setProtocolContent(protocolContent);
        resultDO.setSuccess(true);
        resultDO.setData(entrustDetailDTO);
        return resultDO;
    }

    @Override
    public List<NnsEntrustWorkflowDTO> entrustWorkflowList(Long protocolId) {
        List<NnsEntrustWorkflowDTO> list = nnsEntrustProtocolManager.entrustWorkflowList(protocolId);
        for (NnsEntrustWorkflowDTO workflowDTO : list){
            Integer status = workflowDTO.getProtocolStatus();
            if(status.intValue()==NnsProtocolStatus.WAIT_SIGN.getValue()){
                workflowDTO.setStatusText(NnsProtocolStatusText.WAIT_SIGN.getName());
            }else if(status!=null && status.intValue()==NnsProtocolStatus.SUCCESS_SIGN.getValue()){
                //签约成功的协议 计算协议有效截止日期
                Date overdueTime = workflowDTO.getOverdueTime();//协议有效截止日期
                Date successTime = workflowDTO.getSuccessTime();//签约成功时间
                long days  = DateUtils.getDays(overdueTime,successTime);
                String statusText = NnsProtocolStatusText.SUCCESS_SIGN.getName();
                statusText = statusText.replace("X",Long.toString(days));
                workflowDTO.setStatusText(statusText);
            }
            else if(status.intValue()== NnsProtocolStatus.REJECT_SIGN.getValue()){
                workflowDTO.setStatusText(NnsProtocolStatusText.REJECT_SIGN.getName());
            }else if(status.intValue()== NnsProtocolStatus.CANCEL_SIGN.getValue()){
                workflowDTO.setStatusText(NnsProtocolStatusText.CANCEL_SIGN.getName());
            }else if(status.intValue()== NnsProtocolStatus.OVERDUE_SIGN.getValue()){
                workflowDTO.setStatusText(NnsProtocolStatusText.OVERDUE_SIGN.getName());
            }else if(status.intValue()== NnsProtocolStatus.OFFLINE_SIGN.getValue()){
                workflowDTO.setStatusText(NnsProtocolStatusText.OFFLINE_SIGN.getName());
            }
        }
        return  list;
    }

    @Override
    public NnsEntrustProtocol selectProtocolById(Long protocolId) {
        return nnsEntrustProtocolManager.selectProtocolById(protocolId);
    }

    @Override
    public ResultDO<String> sendSignNote(SendSignNoteDTO object) {
        ResultDO<String> resultDO = new ResultDO<String>();
        Long protocolId = object.getProtocolId();
        NnsEntrustProtocol record = nnsEntrustProtocolManager.selectByPrimaryKey(protocolId);
        if(record==null){
            resultDO.setErrMsg("协议不存在！");
            return resultDO;
        }
        String plotName = nnsEntrustProtocolManager.findPlotNameByProtocolId(protocolId);
        if(StringUtils.isEmpty(plotName)){
            resultDO.setErrMsg("房源信息不正确！");
            return resultDO;
        }
        StringBuffer sendUrl = new StringBuffer();
        sendUrl.append(sendSignNoteUrl).append(protocolId);
        LOGGER.info("sendUrl========="+sendUrl);
        StringBuffer httpArgBf = new StringBuffer();
        httpArgBf.append("url_long=").append(sendUrl);
        String jsonResult = ShortenUrl.request(httpArgBf.toString());
        //resultDO = smsRemoteService.sendSMSMessage(object.getPhone(),signNoteTemId,plotName,jsonResult);
        return resultDO;
    }

    public List<PastProtocolDTO> updatePastProtocol(){
        List<PastProtocolDTO> protocolList = new ArrayList<>();
        try {
            protocolList = nnsEntrustProtocolManager.updatePastProtocol();

            if(protocolList!=null&&protocolList.size()>0){
                LOGGER.info("过期协议集合size()="+protocolList.size());
                for (PastProtocolDTO protocol:protocolList){
                    LOGGER.info("协议id===="+protocol.getProtocolId()+" 协议编号==="+protocol.getProtocolNumber());
                    //smsRemoteService.sendSMSMessage(protocol.getUserPhone(),pastProtocolNote,protocol.getProtocolNumber());
                    if(!StringUtils.isEmpty(protocol.getWxOpenId())){
                        sendPastProtocolWeiXin(protocol);
                    }
                }
            }
            return protocolList;
        } catch (AppException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendPastProtocolWeiXin(PastProtocolDTO protocol){
        String wxAccountType = "ajsh";
        String templeteId = "Z9rtpSCTBdBLyU1XDfROLM5QD43pqCaM8ORnO-2u4wM";
        //String wxOpenId = "ogJlJwrav0MVtTIRJRnDDnn-xwUo";
        String wxOpenId =protocol.getWxOpenId();
        Long protocolId = protocol.getProtocolId();//协议id
        String callBackUrl = settingDns+"/dist/entrustDetail.html?agreementId="+Long.toString(protocolId);
        WxTemplateMessageReqBean wxTemplateMessageReqBean = new WxTemplateMessageReqBean();
        WxTemplateMessageDataBean dataBean = new WxTemplateMessageDataBean();

        WxMessageVCBean vcBean = new WxMessageVCBean();
        StringBuffer first = new StringBuffer();
        first.append("您编号").append(protocol.getProtocolNumber()).append("的委托协议已经过期,");
        vcBean.setValue(first.toString());
        dataBean.setFirst(vcBean);

        vcBean = new WxMessageVCBean();
        StringBuffer key1 = new StringBuffer();
        key1.append(protocol.getDistrictName()).append(protocol.getAddress()).append(protocol.getPlotName());
        vcBean.setValue(key1.toString());
        dataBean.setKeyword1(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue(protocol.getRealName());
        dataBean.setKeyword2(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue(protocol.getRealtorPhone());
        dataBean.setKeyword3(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue(protocol.getSuccessTime());
        dataBean.setKeyword4(vcBean);

        vcBean = new WxMessageVCBean();
        vcBean.setValue("如需继续委托请联系经纪人重新发起。");
        dataBean.setRemark(vcBean);

        wxTemplateMessageReqBean.setTouser(wxOpenId);
        wxTemplateMessageReqBean.setUrl(callBackUrl);
        wxTemplateMessageReqBean.setTemplate_id(templeteId);
        wxTemplateMessageReqBean.setData(dataBean);

        JSONObject data = JSONObject.fromObject(dataBean);
        LOGGER.info("请求参数data是---------------------->" + data);
        wxOfficialAccountService.sendWxTempleteMessage(wxAccountType, wxTemplateMessageReqBean);
    }
}
