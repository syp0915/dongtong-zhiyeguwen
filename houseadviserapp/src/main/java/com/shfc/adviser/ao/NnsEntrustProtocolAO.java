package com.shfc.adviser.ao;

import com.fc.common.redis.RedisUtil;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.base.service.SmsRemoteService;
import com.shfc.common.base.RegexUtils;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.NnsEntrustWorkflowDTO;
import com.shfc.house.dto.NnsHouseEntrustDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustListDTO;
import com.shfc.house.dto.SendSignNoteDTO;
import com.shfc.house.service.NnsEntrustProtocolService;
import com.shfc.mybatis.pagination.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Package com.shfc.adviser.ao.NnsEntrustProtocolAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 17:50
 * version V1.0.0
 */
@Service
public class NnsEntrustProtocolAO {
    private Logger logger = Logger.getLogger(NnsEntrustProtocolAO.class);
    @Autowired
    private NnsEntrustProtocolService nnsEntrustProtocolService;
    @Autowired
    private SmsRemoteService smsRemoteService;

    private final String NOTE_TITLE ="NOTE";//短信开头
    public ResultDO<Page<NnsHouseEntrustListDTO>> houseEntrustList(Page page){
        ResultDO<Page<NnsHouseEntrustListDTO>> resultDO = new ResultDO<Page<NnsHouseEntrustListDTO>>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        Page<NnsHouseEntrustListDTO> list =  nnsEntrustProtocolService.houseEntrustList(realtorId,page);
        resultDO.setSuccess(true);
        resultDO.setData(list);
        return resultDO;
    }

    public ResultDO<NnsHouseEntrustDetailDTO> houseEntrustDetail(Long protocolId){
        ResultDO<NnsHouseEntrustDetailDTO> resultDO = new ResultDO<NnsHouseEntrustDetailDTO>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(protocolId==null){
            resultDO.setErrMsg("协议id不能为空！");
            return resultDO;
        }
        resultDO = nnsEntrustProtocolService.houseEntrustDetail(protocolId);
        return resultDO;
    }

    public ResultDO<List<NnsEntrustWorkflowDTO>> entrustWorkflowList(Long protocolId){
        ResultDO<List<NnsEntrustWorkflowDTO>> resultDO = new ResultDO<List<NnsEntrustWorkflowDTO>>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(protocolId==null){
            resultDO.setErrMsg("协议id不能为空！");
            return resultDO;
        }
        List<NnsEntrustWorkflowDTO> list = nnsEntrustProtocolService.entrustWorkflowList(protocolId);
        resultDO.setSuccess(true);
        resultDO.setData(list);
        return resultDO;
    }
    public ResultDO<String> sendSignNote(SendSignNoteDTO object){
        ResultDO<String> resultDO = new ResultDO<String>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        Long protocolId = object.getProtocolId();
        String phone = object.getPhone();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(protocolId==null){
            resultDO.setErrMsg("协议id不能为空！");
            return resultDO;
        }
        if(StringUtils.isEmpty(phone)){
            resultDO.setErrMsg("手机号不能为空！");
            return resultDO;
        }else {
            if(!RegexUtils.find(phone, "^1\\d{10}$")){
                resultDO.setErrMsg("手机号格式不正确！");
                return resultDO;
            }
        }
        //短信上限数量控制 beging
        ResultDO<String> checkResult = checkSendNoteMaxNumber(phone);
        if(!checkResult.isSuccess()){
            resultDO.setErrMsg(checkResult.getErrMsg());
            return resultDO;
        }
        //短信上限数量控制 end
        resultDO = nnsEntrustProtocolService.sendSignNote(object);
        return resultDO;
    }

    public ResultDO<String> checkSendNoteMaxNumber(String phone){
        ResultDO<String> resultDO = new ResultDO<String>();
        String key  = NOTE_TITLE.concat(phone);
        //int initCount =1;
        Integer  maxCount = (Integer) RedisUtil.get(key);
        if(maxCount==null){
            //第一条记录存到redis ，count=1
            String nowDate  = DateUtils.getCurrentTime();
            String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ")+"23:59:59";
            int secondCount  = DateUtils.compareTime(nowDate,nextTime,3);
            if(secondCount>0){
                RedisUtil.set(key,1,secondCount);
            }
        }else {
            if(maxCount>9){
                resultDO.setErrMsg("您收取验证码数量已达上限,请明日再试！");
                return resultDO;
            }else {
                //没执行一次 initCount+1
                String nowDate  = DateUtils.getCurrentTime();
                String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ")+"23:59:59";
                int secondCount  = DateUtils.compareTime(nowDate,nextTime,3);
                if(secondCount>0){
                    RedisUtil.set(key,maxCount+1,secondCount);
                }
            }
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

}
