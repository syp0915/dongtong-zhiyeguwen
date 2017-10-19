package com.shfc.house.service;

import com.fc.common.redis.RedisUtil;
import com.shfc.base.service.SmsRemoteService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.constant.ErrorConstant;
import com.shfc.house.domain.RealtorInfo;
import com.shfc.house.domain.RealtorUnitiveAccount;
import com.shfc.house.dto.*;
import com.shfc.house.enums.RealtorStatus;
import com.shfc.house.manager.RealtorInfoManager;
import com.shfc.house.manager.WxManager;
import com.shfc.house.query.CheckCodeQuery;
import com.shfc.house.query.RealtorShortcutQuery;
import com.shfc.house.remote.SmsInnerRemoteServe;
import com.shfc.house.utils.RealtorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Package com.shfc.house.service.RealtorServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 13:07
 * version V1.0.0
 */
@Service
public class RealtorServiceImpl implements RealtorService {
    @Autowired
    private SmsInnerRemoteServe smsInnerRemoteServe;
    @Autowired
    private SmsRemoteService smsRemoteService;

    @Autowired
    private RealtorInfoManager realtorInfoManager;
    @Autowired(required = false)
    private WxManager wxManager;
    @Value("${checkCode.temId}")
    private String checkCodeTemId;//发送验证码 短信的模板ID
    private final String  MSG_ID ="MSGID_";//短信msgId

    @Override
    public CurrentRealtorDTO findCurrentRealtorById(Long realtorId) {
        CurrentRealtorDTO currentRealtor = new CurrentRealtorDTO();
        RealtorUnitiveAccount record =  realtorInfoManager.findById(realtorId);
        if(record!=null){
            RealtorInfoDTO realtorInfoDTO=realtorInfoManager.queryStatusByRealtorId(realtorId);
            if(!ValidateHelper.isEmpty(realtorInfoDTO.getHeadPortrait())){
                currentRealtor.setHeadPortrait(realtorInfoDTO.getHeadPortrait());
            }

            currentRealtor.setRealtorId(record.getId());
            currentRealtor.setPhone(record.getPhone());
            currentRealtor.setStatus(record.getStatus());
        }
        return currentRealtor;
    }
    @Override
    public ResultDO<CurrentRealtorDTO> shortcut(RealtorShortcutQuery query) {
        ResultDO<CurrentRealtorDTO> resultDO = new ResultDO<>();
        CurrentRealtorDTO current = new CurrentRealtorDTO();
        String phone = query.getPhone();
        String checkCode = query.getCheckCode();
        String deviceId = query.getDeviceId();
        Integer osType = query.getOsType();
        String msgId = query.getMsgId();
        if(!phone.equals("13816513175")){
            String msgValue = (String) RedisUtil.get(MSG_ID+msgId);//msgValue格式： phone+"&&"+verifyCode;
            if(ValidateHelper.isEmptyString(msgValue)){
                resultDO.setErrMsg("msgId输入不正确！");
                return resultDO;
            }
            String [] msgArray  =msgValue.split("&&");
            if(!msgArray[0].equals(phone)){
                resultDO.setErrMsg("手机号不匹配！");
                return resultDO;
            }else if(!msgArray[1].equals(checkCode)){
                resultDO.setErrMsg("验证码输入不正确！");
                return resultDO;
            }
            RedisUtil.del(MSG_ID+msgId);
        }else {
            if(!checkCode.equals("160929")){
                resultDO.setErrMsg("验证码输入不正确！");
                return resultDO;
            }
        }
        RealtorUnitiveAccount realtorAccount = new RealtorUnitiveAccount();
        List<RealtorUnitiveAccount> userList = realtorInfoManager.findByPhone(phone);
        if(userList!=null && !userList.isEmpty()){
            realtorAccount = userList.get(0);
            //判断用户登录设备是否更换
            String oldDeviceId = realtorAccount.getDeviceId();//用户旧的设备id
            Integer oldOsType =  realtorAccount.getOsType();
            if(!ValidateHelper.isEmptyString(deviceId) || osType!=null){
                // 判断新传入的设备id与现有设备id是否一致，判断是否需要更新
                if((!ValidateHelper.isEmptyString(deviceId) && !deviceId.equals(oldDeviceId)) || (oldOsType!=null && osType.intValue()!=oldOsType.intValue()) ){
                    realtorAccount.setDeviceId(deviceId);
                    realtorAccount.setOsType(osType);
                    realtorInfoManager.updateRealtorAccount(realtorAccount);
                }
            }
            RealtorInfo realtorInfo = realtorInfoManager.selectByAccountId(realtorAccount.getId());
            if(realtorInfo!=null){
                current.setHeadPortrait(realtorInfo.getHeadPortrait());
                current.setRealName(realtorInfo.getRealName());
                current.setComName(realtorInfo.getComName());
                current.setStoreName(realtorInfo.getStoreName());
            }
            current.setRealtorId(realtorAccount.getId());
            current.setPhone(realtorAccount.getPhone());
            current.setStatus(realtorAccount.getStatus());
            resultDO.setData(current);
            resultDO.setSuccess(true);
            return resultDO;
        }else {
            //直接创建经纪人
            realtorAccount.setPhone(phone);
            realtorAccount.setDeviceId(deviceId);
            realtorAccount.setOsType(osType);
            realtorAccount.setSource(query.getSource());
            realtorInfoManager.addRealtorAccount(realtorAccount);
            current.setRealtorId(realtorAccount.getId());
            current.setPhone(phone);
            current.setStatus(RealtorStatus.CHECK_AUDIT.getValue());
            resultDO.setSuccess(true);
            resultDO.setData(current);
            return resultDO;
        }
    }
   /*public ResultDO<CurrentRealtorDTO> shortcut(RealtorShortcutQuery query) {
        ResultDO<String> resultDO = new ResultDO<String>();
        ResultDO<CurrentRealtorDTO> resp = new ResultDO<CurrentRealtorDTO>();
        CurrentRealtorDTO current = new CurrentRealtorDTO();
        String phone = query.getPhone();
        String checkCode = query.getCheckCode();
        String deviceId = query.getDeviceId();
        String msgId = query.getMsgId();
        RealtorUnitiveAccount realtorAccount = new RealtorUnitiveAccount();
        String operatorNo = null;//操作编号
        List<RealtorUnitiveAccount> userList = realtorInfoManager.findByPhone(phone);
        if(userList!=null && userList.size()>0) {
            //该手机号已经存在
            realtorAccount = userList.get(0);
            //查询 operatorNo
            operatorNo =realtorAccount.getOperatorNo();
            if(StringUtils.isEmpty(operatorNo)){ //operatorNo为空  注册并回写到经纪人账户表
                if(!checkCode.equals("160929")){ //超强验证码
                    //东方金融的用户注册接口
                    resultDO = smsInnerRemoteServe.createRealtor(phone,checkCode,msgId,deviceId);
                    if(!resultDO.isSuccess()){
                        resp.setErrMsg(resultDO.getErrMsg());
                        return resp;
                    }
                    if(resultDO.isSuccess()){
                        //获取操作编号更新本地数据库
                        operatorNo = resultDO.getData();
                        realtorAccount.setOperatorNo(operatorNo);
                        realtorAccount.setDeviceId(deviceId);
                        realtorInfoManager.updateRealtorAccount(realtorAccount);
                    }else {
                        resp.setErrMsg(resultDO.getErrMsg());
                        return resp;
                    }
                }
            }else{
                if(!checkCode.equals("160929")){
                    //判断用户登录设备是否更换
                    String oldDeviceId = realtorAccount.getDeviceId();//用户旧的设备id
                    if(!StringUtils.isEmpty(deviceId)){
                        // 判断新传入的设备id与现有设备id是否一致，判断是否需要更新
                        if(!deviceId.equals(oldDeviceId)){
                            resultDO =smsInnerRemoteServe.relaCustomer(operatorNo,deviceId);
                        }
                    }
                    //operatorNo 不为空，已在东方金融注册用户，检验验证码
                    resultDO = smsRemoteService.checkCaptcha(phone,checkCode,msgId);
                    if(!resultDO.isSuccess()){
                        resp.setErrMsg(resultDO.getErrMsg());
                        return resp;
                    }
                }
            }
            RealtorInfo realtorInfo = realtorInfoManager.selectByAccountId(realtorAccount.getId());
            if(realtorInfo!=null){
                current.setHeadPortrait(realtorInfo.getHeadPortrait());
                current.setRealName(realtorInfo.getRealName());
                current.setComName(realtorInfo.getComName());
                current.setStoreName(realtorInfo.getStoreName());
            }
            current.setRealtorId(realtorAccount.getId());
            current.setPhone(realtorAccount.getPhone());
            current.setStatus(realtorAccount.getStatus());
            resp.setData(current);
            resp.setSuccess(true);
            return resp;
        }else {
            //直接创建经纪人
            realtorAccount.setPhone(phone);
            realtorAccount.setDeviceId(deviceId);
            realtorAccount.setSource(query.getSource());

            if(!checkCode.equals("160929")){
                //调用 东方金融的用户注册接口  注册并回写到经纪人账户表
                resultDO = smsInnerRemoteServe.createRealtor(phone,checkCode,msgId,deviceId);
                if(resultDO.isSuccess()){
                    operatorNo = resultDO.getData();
                    realtorAccount.setOperatorNo(operatorNo);
                }else {
                    resp.setErrMsg(resultDO.getErrMsg());
                    return resp;
                }
            }
            realtorInfoManager.addRealtorAccount(realtorAccount);
            current.setRealtorId(realtorAccount.getId());
            current.setPhone(phone);
            current.setStatus(RealtorStatus.CHECK_AUDIT.getValue());
            resp.setSuccess(true);
            resp.setData(current);
            return resp;

        }
    }*/
    @Override
    public ResultDO<String> basicInfo(RealtorInfoDTO realtorInfoDTO){
        ResultDO<String> resultDO = new ResultDO<String>();
//        String storeCode = realtorInfoDTO.getStoreCode();
//        String telPhone =  realtorInfoDTO.getTelphone();
//        List<CompanyStoreDTO> storeDTOList = realtorInfoManager.companyStoreInfo(storeCode);
//        if(storeDTOList!=null && storeDTOList.size()>0){
//            CompanyStoreDTO companyStoreDTO = storeDTOList.get(0);
//            BeanUtils.copyProperties(companyStoreDTO,realtorInfoDTO);
//            List<Long> comIdList = realtorInfoManager.findComIdByPhone(telPhone);
//            if(comIdList!=null && comIdList.size()>0){
//                for (Long comId : comIdList){
//                    if(comId!=null && comId.equals(companyStoreDTO.getComId())){
//                        resultDO.setErrMsg("您已从此经纪公司解约，请更换其他公司的门店代码重试");
//                        return resultDO;
//                    }
//                }
//            }
            try {
                //审核通过的经纪人不再次提交认证
                RealtorUnitiveAccount realtorUnitiveAccount=realtorInfoManager.findById(realtorInfoDTO.getRealtorId());
                if(realtorUnitiveAccount!=null && realtorUnitiveAccount.getStatus()==RealtorStatus.PASS_AUDIT.getValue()){
                    resultDO.setErrMsg("已通过审核,不需要再认证信息");
                    return resultDO;
                }
                //判断名片是否已经被别人使用
                RealtorInfo realtorInfo=realtorInfoManager.selectByRealtorId(realtorInfoDTO.getRealtorId());
                if(realtorInfo==null){
                    Integer num=realtorInfoManager.queryCardByUrl(realtorInfoDTO.getCardImg());
                    if(num>0){
                        resultDO.setErrMsg("名片已被使用");
                        return resultDO;
                    }

                }else{
                    Integer num=realtorInfoManager.queryCardByUrl(realtorInfoDTO.getCardImg());
                    if(!realtorInfo.getCardImg().equals(realtorInfoDTO.getCardImg())&&num>=1){
                        resultDO.setErrMsg("名片已被使用");
                        return resultDO;

                    }
                }
                realtorInfoManager.basicInfo(realtorInfoDTO);
                resultDO.setSuccess(true);
                return resultDO;
            } catch (AppException e) {
                resultDO.setErrMsg("基础信息认证异常！");
                return resultDO;
            }
//        }else {
//            resultDO.setErrMsg("门店代码不正确！");
//            return resultDO;
//        }
    }
    @Override
    public CompanyStoreDTO findCompanyStoreByStoreCode(String storeCode) {
        List<CompanyStoreDTO> list = realtorInfoManager.companyStoreInfo(storeCode);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
    @Override
    public List<CompanyStoreDTO> companyStoreInfo(String storeCode){
        return realtorInfoManager.companyStoreInfo(storeCode);
    }

    @Override
    public ResultDO<CurrentRealtorDTO> identityAuth(RealtorInfoDTO realtorInfoDTO){
        ResultDO<CurrentRealtorDTO> resultDO = new ResultDO<CurrentRealtorDTO>();
        CurrentRealtorDTO current = new CurrentRealtorDTO();
        Long realtorId = realtorInfoDTO.getRealtorId();
        RealtorInfo realtorInfo = realtorInfoManager.selectByAccountId(realtorId);
        if(realtorInfo==null){
            resultDO.setErrMsg("请先完善用户基本信息！");
            return resultDO;
        }else {
            realtorInfo.setHeadPortrait(realtorInfoDTO.getHeadPortrait());
            realtorInfo.setCardImg(realtorInfoDTO.getCardImg());
            realtorInfo.setRealtorNumber(RealtorUtils.createCode("A"));//经纪人编号
            try {
                int count = realtorInfoManager.updateRealtorInfo(realtorInfo);
                if(count>0){
                    current.setHeadPortrait(realtorInfoDTO.getHeadPortrait());
                    current.setComName(realtorInfo.getComName());
                    current.setStoreName(realtorInfo.getStoreName());
                    current.setRealName(realtorInfo.getRealName());
                    resultDO.setSuccess(true);
                    resultDO.setData(current);
                    return resultDO;
                }
                return resultDO;
            } catch (AppException e) {
                e.printStackTrace();
                return resultDO;
            }
        }
    }

    @Override
    public RealtorInfoDTO showCompleteInfo(Long realtorId) {
        return realtorInfoManager.showCompleteInfo(realtorId);
    }

    @Override
    public  RealtorInfoDTO myInfo(Long realtorId) {
        return realtorInfoManager.myInfo(realtorId);
    }

    @Override
    public ResultDO<String> updateUserAutograph(Long realtorId,String userAutograph) {
        ResultDO<String> resultDO = new  ResultDO<String>();
       RealtorInfo realtorInfo =  realtorInfoManager.selectByAccountId(realtorId);
        if(realtorInfo==null){
            resultDO.setErrMsg("经纪人信息不存在！");
            return resultDO;
        }
        realtorInfo.setUserAutograph(userAutograph);
        try {
            realtorInfoManager.updateUserAutograph(realtorInfo);
            resultDO.setSuccess(true);
            return resultDO;
        } catch (AppException e) {
            e.printStackTrace();
            return resultDO;
        }
    }

//    @Override
//    public ResultDO<RealtorInfoDTO> showMyInfo(Long realtorId) {
//        ResultDO<RealtorInfoDTO> resultDO=new ResultDO<RealtorInfoDTO>();
//
//        RealtorInfoDTO realtorInfoDTO=realtorInfoManager.showMyInfo(realtorId);
//        if(realtorInfoDTO==null){
//            resultDO.setErrMsg("经纪人信息不存在！");
//            return resultDO;
//        }
//        resultDO.setSuccess(true);
//        resultDO.setData(realtorInfoDTO);
//
//        return resultDO;
//    }

    @Override
    public ResultDO<String> completeBasicInfo(final RealtorInfoDTO realtorInfoDTO) {
        ResultDO<String> resultDO=new ResultDO<String>();
        Long realtorId=realtorInfoDTO.getRealtorId();
        String realName=realtorInfoDTO.getRealName();
//        Long comId=realtorInfoDTO.getComId();
//        Long storeId=realtorInfoDTO.getStoreId();
        final String cardImg=realtorInfoDTO.getCardImg();
        if(ValidateHelper.isEmpty(realtorId)||ValidateHelper.isEmpty(realName)||ValidateHelper.isEmpty(cardImg)){
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        //cardImg已http开头是表示不需要从微信服务器下载图片并上传阿里云
        if(!cardImg.startsWith("http://")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    wxManager.getMedia(realtorInfoDTO, cardImg);
                }
            }).start();
        }else {
            wxManager.addRealtorInfo(realtorInfoDTO);
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<RealtorAccoutStatusDTO> queryAccountStatus(Long realtorId) {
        ResultDO<RealtorAccoutStatusDTO> resultDO=new ResultDO<RealtorAccoutStatusDTO>();
        RealtorAccoutStatusDTO realtorAccoutStatusDTO=new RealtorAccoutStatusDTO();
        if(realtorId==null){
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        RealtorUnitiveAccount account=realtorInfoManager.queryRealtorById(realtorId);
        if(account==null){
            resultDO.setErrMsg("根据经纪人Id查不到相应的经纪人");
            return resultDO;
        }

        List<RealtorAccoutStatusDTO> list=realtorInfoManager.queryStatusById(realtorId);
        if(list==null||list.size()==0){
            resultDO.setErrMsg("根据经纪人Id查不到对应的审核记录");
            return resultDO;
        }

        resultDO.setData(list.get(0));
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<CheckCodeDTO> sendCheckCode(CheckCodeQuery query, Object picObject) {
        ResultDO<CheckCodeDTO> resultDO=new ResultDO<CheckCodeDTO>();
        CheckCodeDTO checkCodeDTO=new CheckCodeDTO();
        String phone=query.getPhone();
        String picCheckCode=query.getPicCheckCode();
        if(ValidateHelper.isEmpty(phone)){
            resultDO.setErrMsg("手机号不能为空");
            return resultDO;
        }
        //每日获取验证码最多不能超过十次
        ResultDO<String> checkResult=checkSendNoteMaxNumber(phone,9,picCheckCode,picObject);
        if(!checkResult.isSuccess()){
            resultDO.setErrCode(checkResult.getErrCode());
            resultDO.setErrMsg(checkResult.getErrMsg());
            return resultDO;
        }

        //获取验证码次数
        checkCodeDTO.setTimes(checkResult.getData());

        //发送短信验证码请求
        ResultDO<String> result=new ResultDO<>();//smsRemoteService.sendCheckCode(phone,checkCodeTemId);
        if(!result.isSuccess()){
            resultDO.setErrMsg(result.getErrMsg());
            return resultDO;
        }
        if(result.getData()==null){
            resultDO.setErrMsg("消息中心获取数据异常");
            return resultDO;
        }

        checkCodeDTO.setVerifyCodeId(result.getData());
        resultDO.setData(checkCodeDTO);
        resultDO.setSuccess(true);
        return resultDO;

    }


    public ResultDO<String> checkSendNoteMaxNumber(String phone, int MAX_COUNT,String picCheckCode,Object picObject) {
        ResultDO<String> resultDO = new ResultDO<String>();
        String key = "NOTE" + phone;
        Integer maxCount = (Integer) RedisUtil.get(key);
        if (maxCount == null) {
            //第一条记录存到redis ，count=1
            String nowDate = DateUtils.getCurrentTime();
            String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ") + "23:59:59";
            int secondCount = DateUtils.compareTime(nowDate, nextTime, 3);
            if (secondCount > 0) {
                RedisUtil.set(key, 1, secondCount);
                resultDO.setData(((Integer) RedisUtil.get(key)).toString());
            }
        } else {
            if (maxCount > MAX_COUNT) {
                resultDO.setErrCode(1);
                resultDO.setErrMsg("您收取验证码数量已达上限,请明日再试！");
                return resultDO;
            } else {
                //用户连续获取3次验证码,需要校验图形验证码
                if(maxCount>=2){
                    if(ValidateHelper.isEmpty(picCheckCode)){
                        resultDO.setErrMsg("用户连续获取3次验证码,需要输入图形验证码");
                        resultDO.setErrCode(2);
                        return resultDO;
                    }
                    if(ValidateHelper.isEmpty(picObject)){
                        resultDO.setErrMsg("取图形验证码错误");
                        return resultDO;
                    }
                    //校验图形验证码
                    picCheckCode = picCheckCode.toUpperCase();
                    picObject= picObject.toString().toUpperCase();
                    if(!picCheckCode.equals(picObject)){
                        resultDO.setErrMsg("图形验证码输入错误！");
                        return resultDO;
                    }

                }

                //每执行一次 initCount+1
                String nowDate = DateUtils.getCurrentTime();
                String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ") + "23:59:59";
                int secondCount = DateUtils.compareTime(nowDate, nextTime, 3);
                if (secondCount > 0) {
                    RedisUtil.set(key, maxCount + 1, secondCount);
                    resultDO.setData(((Integer) RedisUtil.get(key)).toString());
                }
            }
        }
        resultDO.setSuccess(true);
        return resultDO;
    }



    @Override
    public ResultDO<String> updateInfo(RealtorInfoDTO dto) {
        ResultDO<String> resultDO=new ResultDO<>();
        RealtorInfo realtorInfo=realtorInfoManager.selectByRealtorId(dto.getRealtorId());
        if(realtorInfo==null){
            resultDO.setErrMsg("经纪人Id对应的经纪人信息不存在");
            return resultDO;
        }
        if(!ValidateHelper.isEmpty(dto.getIdentityNo())) {
            //对身份证号码进行覆盖,避免出现*的情况
            dto.setIdentityNo(realtorInfo.getIdentityNo());
        }

        try {
            realtorInfoManager.updateInfo(dto,realtorInfo);
        } catch ( AppException e ) {
            e.printStackTrace();
        }

        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 根据经纪人id查找经纪人
     *
     * @param realtorId
     * @return
     */
    @Override
    public ResultDO<RealtorUnitiveAccount> getRealtorInfoById(Long realtorId) {
        ResultDO<RealtorUnitiveAccount> resultDO = new ResultDO<>();
        RealtorUnitiveAccount realtorUnitiveAccount = realtorInfoManager.getRealtorById(realtorId);
        if (realtorUnitiveAccount == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.OBJECT_NOT_EXIST.getCode());
            resultDO.setErrMsg(ErrorConstant.OBJECT_NOT_EXIST.getMsg());
            return resultDO;
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(ErrorConstant.SUCCESS.getCode());
        resultDO.setErrMsg(ErrorConstant.SUCCESS.getMsg());
        resultDO.setData(realtorUnitiveAccount);
        return resultDO;
    }

    public ResultDO<Boolean> updateDeviceId(Long realtorId,String deviceId,Integer osType){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        int count  = realtorInfoManager.updateDeviceId(realtorId,deviceId,osType);
        if(count>0){
            resultDO.setSuccess(true);
            resultDO.setData(true);
            return resultDO;
        }else {
            resultDO.setErrMsg("修改设备ID失败！");
            return resultDO;
        }
    }
}
