package com.shfc.house.service;

import com.alibaba.fastjson.JSON;
import com.shfc.base.dto.SysMessageDTO;
import com.shfc.base.enums.SysMessageFrom;
import com.shfc.base.enums.SysMessageType;
import com.shfc.base.enums.SysMessageUserType;
import com.shfc.base.service.SmsRemoteService;
import com.shfc.base.service.SysMessageService;
import com.shfc.common.base.Logger;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.base.BaseServiceImpl;
import com.shfc.house.dao.NnsEntrustProtocolMapper;
import com.shfc.house.dao.RealtorInfoMapper;
import com.shfc.house.domain.*;
import com.shfc.house.dto.CurrentUserDTO;
import com.shfc.house.dto.NnsHouseDetailDTO;
import com.shfc.house.dto.RealtorInfoDTO;
import com.shfc.house.enums.NnsHouseStatus;
import com.shfc.house.httpbean.req.ReqBean60101;
import com.shfc.house.httpbean.req.ReqBean60102;
import com.shfc.house.httpbean.req.ReqBean60103;
import com.shfc.house.httpbean.req.ReqBean60106;
import com.shfc.house.httpbean.resp.*;
import com.shfc.house.manager.EntrustManager;
import com.shfc.house.manager.NnsHouseManager;
import com.shfc.house.query.UserShortcutQuery;
import com.shfc.house.utils.StringUtils;
import com.shfc.mybatis.pagination.Page;
import com.shfc.sign.query.SignatureQuery;
import com.shfc.sign.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午11:21.
 */
@Service
public class EntrustServiceImpl extends BaseServiceImpl implements EntrustService {

    @Value("${nns.entrust.protocol}")
    private String ENTRUSTPROTOCOL; // 协议富文本
    @Autowired(required = false)
    private EntrustManager entrustManager;
    @Autowired
    private NnsHouseManager nnsHouseManager;
    @Autowired(required = false)
    private NnsEntrustProtocolMapper nnsEntrustProtocolMapper;

    @Autowired(required = false)
    private RealtorInfoMapper realtorInfoMapper;

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private SmsRemoteService smsRemoteService;

    @Autowired
    private SysMessageService sysMessageService;

    @Autowired
    private SignService signService;

    @Autowired
    private RealtorService realtorService;

    @Autowired
    private RealtorCompanyService realtorCompanyService;

    @Override
    public ResultDO<RespBean60101> getEntrustListByUserId(ReqBean60101 reqBean60101) {
        ResultDO<RespBean60101> resultDO = new ResultDO<RespBean60101>();
        RespBean60101 respBean60101 = new RespBean60101();
        String userId = reqBean60101.getUserId();
        if (isNullOrEmpty(userId)){
            resultDO.setSuccess(false);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            resultDO.setErrCode(1);
            return resultDO;
        }
        if (reqBean60101.getPageSize() == null || reqBean60101.getPageNumber() == null){
            resultDO.setSuccess(false);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            resultDO.setErrCode(1);
            return resultDO;
        }
        User user = userService.selectById(Long.parseLong(userId));
        if (user == null){
            resultDO.setSuccess(false);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
            resultDO.setErrCode(1);
            return resultDO;
        }
        Page<HashMap<String, Object>> query = null;
        try {
            query = entrustManager.getEntrustListByUserId(Long.parseLong(userId), reqBean60101.getPageSize(), reqBean60101.getPageNumber());
        } catch (Exception e) {
            e.printStackTrace();
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_DB_OPERATE_EXCEPTION);
            return resultDO;
        }
        List<HashMap<String, Object>> list = query.getData();
        if (list != null && list.size() > 0){
            List<RespBean60101Detail> entrustList = new ArrayList<RespBean60101Detail>();
            for (HashMap<String, Object> map : list) {
                RespBean60101Detail respBean60101Detail = new RespBean60101Detail();
                respBean60101Detail.setPlotName(checkStringMapObject(map.get("plot_name")));
                respBean60101Detail.setBuildingUnitNo(checkStringMapObject(map.get("unit_no")));
                respBean60101Detail.setFloorCount(checkIntMapObject(map.get("floor")));
                respBean60101Detail.setRoomNo(checkStringMapObject(map.get("house_no")));
                respBean60101Detail.setRealtorCmpName(checkStringMapObject(map.get("com_abbr")));
                respBean60101Detail.setShopName(checkStringMapObject(map.get("store_name")));
                respBean60101Detail.setRealtorName(checkStringMapObject(map.get("real_name")));
                respBean60101Detail.setAgreementStatus(Integer.parseInt(checkIntMapObject(map.get("status"))));
                respBean60101Detail.setAgreementId(checkStringMapObject(map.get("id")));
                respBean60101Detail.setAgreementPrice(new BigDecimal(checkDecimalMapObject(map.get("total_price"))));
                try {
                    respBean60101Detail.setContractTime(checkDateTimeMapObject(map.get("success_time")));
                } catch (ParseException e) {
                    e.printStackTrace();
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(1);
                    resultDO.setErrMsg(ERROR_DATA_FORMAT_EXCEPTION);
                    return resultDO;
                }
                entrustList.add(respBean60101Detail);
            }
            respBean60101.setEntrustList(entrustList);
            respBean60101.setPageSize(query.getPageSize());
            respBean60101.setPageNumber(query.getPageNumber());
            respBean60101.setTotalCount(query.getTotalSize());
        }else {
            respBean60101.setPageSize(query.getPageSize());
            respBean60101.setPageNumber(query.getPageNumber());
            respBean60101.setTotalCount(0L);
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60101);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60102> getEntrustInfoById(ReqBean60102 reqBean60102) {
        ResultDO<RespBean60102> resultDO = new ResultDO<RespBean60102>();
        RespBean60102 respBean60102 = new RespBean60102();
        String agreementId = reqBean60102.getAgreementId();
        if (isNullOrEmpty(agreementId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        HashMap<String, Object> map = entrustManager.getEntrustInfoById(Long.parseLong(agreementId));
        if (map == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
            return resultDO;
        }
        respBean60102.setAgreementId(checkStringMapObject(map.get("id")));
        respBean60102.setAgreementNo(checkStringMapObject(map.get("protocol_number")));
        respBean60102.setAgreementContent(checkStringMapObject(map.get("protocol_content")));
        respBean60102.setRealtorCmpName(checkStringMapObject(map.get("com_name")));
        respBean60102.setRealtorCmpSimpleName(checkStringMapObject(map.get("com_abbr")));
        respBean60102.setRealtorShopName(checkStringMapObject(map.get("store_name")));
        respBean60102.setRealtorName(checkStringMapObject(map.get("real_name")));
        respBean60102.setPicUrl(checkStringMapObject(map.get("head_portrait")));
        respBean60102.setAgreementStatus(Integer.parseInt(checkIntMapObject(map.get("status"))));
        try {
            respBean60102.setContractTime(checkDateTimeMapObjectAviableNull(map.get("success_time")));
            respBean60102.setExpirationDate(checkDateMapObjectAviableNull(map.get("overdue_time")));
        } catch (ParseException e) {
            e.printStackTrace();
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_PARSE_DATA_EXCEPTION);
            return resultDO;
        }
        respBean60102.setProvince("上海");
        respBean60102.setCity("上海市");
        respBean60102.setDistrict(checkStringMapObject(map.get("district_name")));
        respBean60102.setBlock(checkStringMapObject(map.get("block_name")));
        respBean60102.setAddress(checkStringMapObject(map.get("address")));
        respBean60102.setRealtorPhone(checkStringMapObject(map.get("telphone")));
        respBean60102.setPlotName(checkStringMapObject(map.get("plot_name")));
        respBean60102.setBuildingUnitNo(checkStringMapObject(map.get("unit_no")));
        respBean60102.setRoomNo(checkStringMapObject(map.get("house_no")));
        respBean60102.setRoomCount(Integer.parseInt(checkIntMapObject(map.get("room"))));
        respBean60102.setHallCount(Integer.parseInt(checkIntMapObject(map.get("hall"))));
        respBean60102.setBathroomCount(Integer.parseInt(checkIntMapObject(map.get("bathroom"))));
        respBean60102.setKitchRoomCount(Integer.parseInt(checkIntMapObject(map.get("kitchen"))));
        respBean60102.setStructureArea(new BigDecimal(checkDecimalMapObject(map.get("area"))));
        respBean60102.setTotalFloor(Integer.parseInt(checkIntMapObject(map.get("total_floor"))));
        respBean60102.setCurrentFloor(Integer.parseInt(checkIntMapObject(map.get("floor"))));
        respBean60102.setHousePropertyNo(checkStringMapObject("house_code"));
        respBean60102.setAgreementPrice(new BigDecimal(checkDecimalMapObject(map.get("total_price"))));
        respBean60102.setPriceType(Integer.parseInt(checkIntMapObject(map.get("price_type"))));
        respBean60102.setPhone(checkStringMapObject(map.get("phone")));
        respBean60102.setTagList(entrustManager.getTagListByHouseId(Long.parseLong(checkStringMapObject(map.get("nns_house_id")))));
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60102);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60103> revokeEntrustById(ReqBean60103 reqBean60103) {
        ResultDO<RespBean60103> resultDO = new ResultDO<RespBean60103>();
        RespBean60103 respBean60103 = new RespBean60103();
        String agreementId = reqBean60103.getAgreementId();
        String revokeReason = reqBean60103.getRevokeReason();
        if (isNullOrEmpty(agreementId) || isNullOrEmpty(revokeReason)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        NnsEntrustProtocol nnsEntrustProtocol = entrustManager.selectNnsEntrustProtocolByPrimaryKey(Long.parseLong(agreementId));
        if (nnsEntrustProtocol == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
            return resultDO;
        }
        if (nnsEntrustProtocol.getStatus() != 1){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("只有成功签约的委托协议才能进行此操作");
            return resultDO;
        }
        nnsEntrustProtocol.setStatus(3);
        int count  = entrustManager.updateNnsEntrustProtocolByPrimaryKeySelective(nnsEntrustProtocol);

        NnsEntrustProtocolWorkflow nnsEntrustProtocolWorkflow = new NnsEntrustProtocolWorkflow();
        nnsEntrustProtocolWorkflow.setProtocolId(Long.parseLong(agreementId));
        nnsEntrustProtocolWorkflow.setProtocolStatus(3);
        nnsEntrustProtocolWorkflow.setCauseText(revokeReason);
        nnsEntrustProtocolWorkflow.setCreateTime(new Date());
        nnsEntrustProtocolWorkflow.setCreater(nnsEntrustProtocol.getUserId());
        nnsEntrustProtocolWorkflow.setCreaterType(1);
        entrustManager.insertNnsEntrustProtocolWorkflowSelective(nnsEntrustProtocolWorkflow);

        //查询该房源是否需要下架
        int entrustCount = nnsEntrustProtocolMapper.getEffectiveEntrustCountByHouseId(nnsEntrustProtocol.getNnsHouseId());
        if (entrustCount == 0){
            NnsHouse nnsHouse = nnsHouseManager.findHouseById(nnsEntrustProtocol.getNnsHouseId());
            if (nnsHouse == null){
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
                return resultDO;
            }
            nnsHouse.setStatus(NnsHouseStatus.SOLD_OUT.getValue());
            nnsHouse.setModifier(nnsEntrustProtocol.getUserId());
            nnsHouseManager.updateNnsHouseSelective(nnsHouse);
        }

        //添加通知
        if(count>0){
            SysMessageDTO sysMessageDTO = new SysMessageDTO();
            sysMessageDTO.setMesFrom(SysMessageFrom.TV_997.getValue());
            sysMessageDTO.setMesType(SysMessageType.ENTRUST_COWRY.getValue());
            sysMessageDTO.setBizId(nnsEntrustProtocol.getId());
            sysMessageDTO.setUserId(nnsEntrustProtocol.getRealtorId());
            sysMessageDTO.setUserType(SysMessageUserType.REALTOR.getValue());
            sysMessageDTO.setMesDigest("业主已撤销协议");
            sysMessageDTO.setMesContent("业主主动撤销了对你公司的该房源委托，如有问题请联系该业主。");
            try {
                sysMessageService.addMessage(sysMessageDTO);
            } catch (AppException e) {
                e.printStackTrace();
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg("远程调用异常");
                return resultDO;
            }
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60103);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60104> getEntrustStatusListById(ReqBean60102 reqBean60102) {
        ResultDO<RespBean60104> resultDO = new ResultDO<RespBean60104>();
        RespBean60104 respBean60104 = new RespBean60104();
        String agreementId = reqBean60102.getAgreementId();
        if (isNullOrEmpty(agreementId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        NnsEntrustProtocol nnsEntrustProtocol = nnsEntrustProtocolMapper.selectByPrimaryKey(Long.parseLong(agreementId));
        if (nnsEntrustProtocol == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
            return resultDO;
        }
        RealtorInfo realtorInfo = realtorInfoMapper.selectByRealtorId(nnsEntrustProtocol.getRealtorId());
        if (realtorInfo == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
            return resultDO;
        }
        String realtorName = realtorInfo.getRealName();
        String realtorPhone = realtorInfo.getTelphone();
        List<NnsEntrustProtocolWorkflow> list =entrustManager.getEntrustStatusListById(Long.parseLong(agreementId));
        if (list != null && list.size() > 0){
            List<RespBean60104Detail> statusList = new ArrayList<RespBean60104Detail>();
            for (NnsEntrustProtocolWorkflow nepw: list) {
                RespBean60104Detail respBean60104Detail = new RespBean60104Detail();
                int status = nepw.getProtocolStatus();
                respBean60104Detail.setStatus(status);
                respBean60104Detail.setHappenedTime(DateUtils.formatDate(nepw.getCreateTime(), DATE_TIME_FORMAT));
                switch (status){
                    case 0:
                    {
                        respBean60104Detail.setStatusTitle("经纪人已发起签约");
                        respBean60104Detail.setStatusDesc("【"+realtorName+"】【"+realtorPhone+"】已经发起了协议签订，请确认协议内容真实无误后，进行委托协议签约");
                        break;
                    }
                    case 1:
                    {
                        respBean60104Detail.setStatusTitle("签约成功");
                        respBean60104Detail.setStatusDesc("委托协议已达成，【"+realtorName+"】【"+realtorPhone+"】将在协议期内为您提供卖房服务");
                        break;
                    }
                    case 3:
                    {
                        respBean60104Detail.setStatusTitle("您已经撤销了委托协议");
                        respBean60104Detail.setStatusDesc("协议已经失效，如需签订请联系经纪人重新发起");
                        break;
                    }
                    case 4:
                    {
                        respBean60104Detail.setStatusTitle("委托协议已过期");
                        respBean60104Detail.setStatusDesc("协议已经失效，如需签订请联系经纪人重新发起");
                        break;
                    }
                    default:break;
                }
                statusList.add(respBean60104Detail);
            }
            respBean60104.setStatusList(statusList);
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60104);
        return resultDO;
    }

    @Override
    public ResultDO<RespBean60106> submitEntrust(ReqBean60106 reqBean60106) {
        ResultDO<RespBean60106> resultDO = new ResultDO<RespBean60106>();
        RespBean60106 respBean60106 = new RespBean60106();
        String agreementId = reqBean60106.getAgreementId();
        String name = reqBean60106.getName();
        String identityId = reqBean60106.getIdentityId();
        String phone = reqBean60106.getPhone();
        String verifyCodeId = reqBean60106.getVerifyCodeId();
        String verifyCode = reqBean60106.getVerifyCode();
        String operateType = reqBean60106.getOperateType();//0-第一步提交，仅做要素验证，不做协议提交，1-协议最终提交，要素验证和提交都要做
        if (isNullOrEmpty(agreementId) || isNullOrEmpty(name) || isNullOrEmpty(identityId)
                || isNullOrEmpty(phone) || isNullOrEmpty(operateType) || reqBean60106.getEntrustPeriod() == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        if ("0".equals(operateType) && (isNullOrEmpty(verifyCode) || isNullOrEmpty(verifyCodeId))){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_EXCEPTION);
            return resultDO;
        }
        int entrustPeriod = reqBean60106.getEntrustPeriod();
        if (entrustPeriod != 1 && entrustPeriod != 2 && entrustPeriod != 3 && entrustPeriod != 6){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("协议期限参数异常");
            return resultDO;
        }
        if (!StringUtils.isChinaPhoneLegal(phone)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("请输入合法手机号");
            return resultDO;
        }
        NnsEntrustProtocol nnsEntrustProtocol = nnsEntrustProtocolMapper.selectByPrimaryKey(Long.parseLong(agreementId));
        if (nnsEntrustProtocol == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
            return resultDO;
        }
        if (nnsEntrustProtocol.getStatus() != 0){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("该协议不是待签约状态，你无法完成协议签署");
            return resultDO;
        }
        if (!entrustManager.checkIdentityNoAndName(identityId, name)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(1);
            resultDO.setErrMsg("姓名和身份证信息不匹配，请重新输入");
            return resultDO;
        }
        //姓名和身份证号两要素验证通过后，以身份证号为主体验证手机号
        Long userId = null;
        HashMap<String, Object> identityMap = userService.isAuthIdentityNoExist(identityId);
        Logger.info(this, "identityMap--------->" + JSON.toJSONString(identityMap));
        if (identityMap != null){
            String actualPhone = checkStringMapObject(identityMap.get("phone"));
            if (isNullOrEmpty(actualPhone)){
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(ERROR_DB_DATA_EXCEPTION);
                return resultDO;
            }else {
                if (!actualPhone.equals(phone)){
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(1);
                    resultDO.setErrMsg("您已存在" + StringUtils.phoneNumberAddasterisk(actualPhone) + "的实名认证帐号，请用以上手机号验证并继续");
                    return resultDO;
                }else {
                    userId = Long.parseLong(checkIntMapObject(identityMap.get("id")));
                }
            }
        }
        //到这里userId还是为null，说明身份证信息在数据库中不存在，继续往下以手机号作为主体判断判断
        if (userId == null){
            HashMap<String, Object> phoneMap = userService.isPhoneExist(phone);
            Logger.info(this, "phoneMap--------->" + JSON.toJSONString(phoneMap));
            if (phoneMap != null){
                String actualIdentityNo = checkStringMapObject(phoneMap.get("identity_no"));
                if (isNullOrEmpty(actualIdentityNo)){
                    //绑定身份证号，完成实名认证
                    userId = Long.parseLong(checkIntMapObject(phoneMap.get("id")));
                    User user = userService.selectById(userId);
                    user.setIdentityNo(identityId);
                    user.setRealName(name);
                    user.setIsAuth(true);
                    userService.updateBySelective(user);
                }else {
                    if (!actualIdentityNo.equals(identityId)){
                        resultDO.setSuccess(false);
                        resultDO.setErrCode(1);
                        resultDO.setErrMsg("您" + phone + "的手机号已经被他人实名占用，请更换手机号后重试");
                        return resultDO;
                    }else {
                        userId = Long.parseLong(checkIntMapObject(phoneMap.get("id")));
                    }
                }
            }
        }
        //身份证和手机号都不存在，则注册用户，绑定身份证号，完成实名验证
        if (userId == null){
            UserShortcutQuery userShortcutQuery = new UserShortcutQuery();
            userShortcutQuery.setPhone(phone);
            userShortcutQuery.setMsgId(verifyCodeId);
            userShortcutQuery.setCheckCode(verifyCode);
            ResultDO<CurrentUserDTO> userResult = null;
            try {
                //注册用户
                userResult = userService.shortcutUser(userShortcutQuery);
            } catch (AppException e) {
                e.printStackTrace();
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(ERROR_INNER_SYSTEM_ERROR);
                return resultDO;
            }
            if (userResult == null){
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(ERROR_INNER_SYSTEM_ERROR);
                return resultDO;
            }
            Logger.info(this, "注册用户返回结果是----------->" + JSON.toJSONString(userResult));
            if (!userResult.isSuccess()){
                resultDO.setSuccess(false);
                resultDO.setErrCode(userResult.getErrCode());
                resultDO.setErrMsg(userResult.getErrMsg());
                return resultDO;
            }
            Long tmpUserId = userResult.getData().getUserId();
            if (tmpUserId == null){
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(ERROR_DB_OPERATE_EXCEPTION);
                return resultDO;
            }
            //绑定身份证号，完成实名验证
            userId = tmpUserId;
            User user = userService.selectById(userId);
            user.setIdentityNo(identityId);
            user.setRealName(name);
            user.setUserName(name);
            user.setIsAuth(true);
            userService.updateBySelective(user);
        }else {
            //用户已经存在，需要验证验证码
            if ("0".equals(operateType)){
                ResultDO<String> smsResult = smsRemoteService.checkCaptcha(phone, verifyCode, verifyCodeId);
                if (!smsResult.isSuccess()){
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(1);
                    resultDO.setErrMsg(smsResult.getErrMsg());
                    return resultDO;
                }
            }
        }
        //最后一步最终提交，更新协议，发送通知
        if ("1".equals(operateType)){
            //调用下载签章图片接口获取签章图片
            Date overdueTime  = com.shfc.house.utils.DateFormatUtils.addMonth(new Date(), entrustPeriod);
            Logger.info(this,"调用电子签章接口获取签章图片路径");
            RealtorInfoDTO realtorInfo = realtorService.myInfo(nnsEntrustProtocol.getRealtorId());
            RealtorCompany realtorCompany = realtorCompanyService.selectRealtorCompanyById(realtorInfo.getComId());
            NnsHouseDetailDTO nnsHouse = nnsHouseManager.findDetailHouseById(nnsEntrustProtocol.getNnsHouseId());
            User user = userService.selectById(userId);
            if(realtorCompany == null || realtorCompany.getId() == null){
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg("经纪公司未找到");
                Logger.info(this,"经纪公司未找到");
                return resultDO;
            }
            if(realtorCompany.getAccountId() == null){
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg("经纪公司未注册E签宝");
                Logger.info(this,"经纪公司未注册E签宝");
                return resultDO;
            }
            SignatureQuery signatureQuery = new SignatureQuery();
            signatureQuery.setName(name);
            signatureQuery.setEmail(user.getUserEmail());
            signatureQuery.setMobile(user.getMobile());
            signatureQuery.setIdno(user.getIdentityNo());
            signatureQuery.setProtocolNumber(nnsEntrustProtocol.getProtocolNumber());
            signatureQuery.setSealDataToOrg(realtorCompany.getSealData());
            signatureQuery.setAccountIdToCompany(realtorCompany.getAccountId());
            signatureQuery.setNnsEntrustProtocolid(nnsEntrustProtocol.getId());
            signatureQuery.setTotalPrice(nnsEntrustProtocol.getTotalPrice());
            signatureQuery.setDistrictName(nnsHouse.getDistrictName());
            signatureQuery.setBlockName(nnsHouse.getBlockName());
            signatureQuery.setAddress(nnsHouse.getAddress());
            signatureQuery.setPlotName(nnsHouse.getPlotName());
            signatureQuery.setUnitNo(nnsHouse.getUnitNo());
            signatureQuery.setHouseNo(nnsHouse.getHouseNo());
            signatureQuery.setOverdueTime(overdueTime);
            Logger.error(this,"overdueTime:"+overdueTime+" agreementId:"+agreementId+"userId:"+userId.toString()+"Reloterid:"+realtorInfo.getComId());
            ResultDO<String> result = signService.signature(signatureQuery);
            String fileImgUrl = result.getData();
            String picUrl = null;
            if(result.isSuccess()){
                picUrl = fileImgUrl;
            }else{
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(result.getErrMsg());
                Logger.info(this,result.getErrMsg());
                return resultDO;
            }
            Logger.info(this,"调用电子签章接口获取签章图片路径"+fileImgUrl+"-----------"+result.getErrMsg()+"cccccc"+result.getErrCode()+"dddddddddddd"+result.isSuccess());
            Logger.info(this,"picUrl="+picUrl);
            nnsEntrustProtocol.setUserId(userId);
            nnsEntrustProtocol.setStatus(1);
            nnsEntrustProtocol.setSuccessTime(new Date());
            nnsEntrustProtocol.setDealUrl(picUrl);
            nnsEntrustProtocol.setOverdueTime(overdueTime);
            Long nnsHouseId = nnsEntrustProtocol.getNnsHouseId();
            NnsHouse house = nnsHouseManager.findHouseById(nnsHouseId);
            BigDecimal totalPrice = house.getTotalPrice();
            String address = new StringBuilder(house.getAddress()).append(house.getUnitNo()).append("楼").append(house.getHouseNo()).append("室").toString();
            String protocol = ENTRUSTPROTOCOL.replace("!{totalPrice}", String.valueOf(totalPrice)).replace("!{address}", address).replace("!{effictiveDate}",DateUtils.formatDate(overdueTime,"yyyy-MM-dd"));
            protocol = HtmlUtils.htmlEscape(protocol);//生成协议文本
            nnsEntrustProtocol.setProtocolContent(protocol);
            int count = nnsEntrustProtocolMapper.updateByPrimaryKeySelective(nnsEntrustProtocol);

            NnsEntrustProtocolWorkflow nnsEntrustProtocolWorkflow = new NnsEntrustProtocolWorkflow();
            nnsEntrustProtocolWorkflow.setProtocolId(Long.parseLong(agreementId));
            nnsEntrustProtocolWorkflow.setProtocolStatus(1);
            nnsEntrustProtocolWorkflow.setCreateTime(new Date());
            nnsEntrustProtocolWorkflow.setCreater(nnsEntrustProtocol.getUserId());
            nnsEntrustProtocolWorkflow.setCreaterType(1);
            entrustManager.insertNnsEntrustProtocolWorkflowSelective(nnsEntrustProtocolWorkflow);

            if(nnsHouse == null){
                resultDO.setSuccess(false);
                resultDO.setErrCode(1);
                resultDO.setErrMsg(ERROR_REQUEST_PARAMS_ERROR_OR_OBJECT_NOT_EXIST);
                return resultDO;
            }
            nnsHouse.setStatus(NnsHouseStatus.PUTAWAY.getValue());
            nnsHouse.setModifier(nnsEntrustProtocol.getUserId());
            nnsHouseManager.updateNnsHouseSelective(nnsHouse);
            if(count>0){
                SysMessageDTO sysMessageDTO = new SysMessageDTO();
                sysMessageDTO.setMesFrom(SysMessageFrom.TV_997.getValue());
                sysMessageDTO.setMesType(SysMessageType.ENTRUST_COWRY.getValue());
                sysMessageDTO.setBizId(nnsEntrustProtocol.getId());
                sysMessageDTO.setUserId(nnsEntrustProtocol.getRealtorId());
                sysMessageDTO.setUserType(SysMessageUserType.REALTOR.getValue());
                sysMessageDTO.setMesDigest("业主已签署协议");
                sysMessageDTO.setMesContent("业主已经完成了协议签署，该委托协议已生效。");
                try {
                    sysMessageService.addMessage(sysMessageDTO);
                } catch (AppException e) {
                    e.printStackTrace();
                    resultDO.setSuccess(false);
                    resultDO.setErrCode(1);
                    resultDO.setErrMsg("远程调用异常");
                    return resultDO;
                }
            }
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(0);
        resultDO.setErrMsg(SUCCESS);
        resultDO.setData(respBean60106);
        return resultDO;
    }
}
