package com.shfc.adviser.ao;

import com.fc.common.redis.RedisUtil;
import com.shfc.adviser.errorCode.ErrorCode;
import com.shfc.adviser.utils.AuthSessionUtils;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.adviser.wnl.Util.JdwxProperties;
import com.shfc.authentication.dto.AuthenticationNameDTO;
import com.shfc.authentication.service.AuthenticationService;
import com.shfc.base.dto.SmsDTO;
import com.shfc.base.dto.SysMessageDTO;
import com.shfc.base.service.SmsRemoteService;
import com.shfc.base.service.SysMessageService;
import com.shfc.common.base.RegexUtils;
import com.shfc.common.base.UUIDUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.idCard.IdcardInfoExtractor;
import com.shfc.common.idCard.IdcardValidator;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.*;
import com.shfc.house.enums.GenderType;
import com.shfc.house.enums.RealtorStatus;
import com.shfc.house.query.CustomerStoreQuery;
import com.shfc.house.query.RealtorMessageQuery;
import com.shfc.house.query.RealtorShortcutQuery;
import com.shfc.house.service.RealtorCompanyService;
import com.shfc.house.service.RealtorService;
import com.shfc.house.service.WxRealtorAccountService;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Package com.shfc.adviser.ao.RealtorLoginAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/8 11:52
 * version V1.0.0
 */
@Service
public class RealtorAO {
    @Autowired
    private RealtorService realtorService;
    @Autowired
    private SmsRemoteService smsRemoteService;
    @Autowired
    private SysMessageService sysMessageService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private WxRealtorAccountService wxRealtorAccountService;
    @Autowired
    private RealtorCompanyService realtorCompanyService;

    private final String NOTE_TITLE ="NOTE";//短信开头

    private final String isAuth = JdwxProperties.getProperties("jdwx.auth");

    @Value("${send.checkcode.temId}")
    private String sendCheckcodeTemId;//登录验证码的模板ID

    @Value("${send.voice.temId}")
    private String sendVoiceTemId;//发送语音验证码的模板ID

    @Value("${app.param}")
    private String appParam;//app参数


    public ResultDO<CurrentRealtorDTO> shortcut(RealtorShortcutQuery query){
        ResultDO<CurrentRealtorDTO> resultDO = new ResultDO<CurrentRealtorDTO> ();
        String phone =query.getPhone();
        String checkCode = query.getCheckCode();
        if(StringUtils.isEmpty(phone)){
            resultDO.setErrMsg("手机号不能为空！");
            return resultDO;
        }else {
            if(!RegexUtils.find(phone, "^1\\d{10}$")){
                resultDO.setErrMsg("手机号格式不正确！");
                return resultDO;
            }
        }
        if(StringUtils.isEmpty(checkCode)){
            resultDO.setErrMsg("验证码不能为空！");
            return resultDO;
        }

        resultDO = realtorService.shortcut(query);
        if(!resultDO.isSuccess()){
            resultDO.setErrMsg(resultDO.getErrMsg());
            return resultDO;
        }
        CurrentRealtorDTO currentRealtorDTO =  resultDO.getData();
        if(currentRealtorDTO!=null){
            if(currentRealtorDTO.getStatus()!=null && currentRealtorDTO.getStatus().intValue()== RealtorStatus.CANCEL.getValue()){
                resultDO.setSuccess(false);
                resultDO.setErrCode(ErrorCode.ACCOUNT_TERMINATION);
                return resultDO;
            }
        }
        String tokenKey = "HOUSE_ADVISER_APP_" + UUIDUtils.getUUID();
        currentRealtorDTO.setTokenKey(tokenKey);
        HttpSessionUtils.putObject(AuthSessionUtils.CURRENT_REALTOR_INFO, currentRealtorDTO);
        RedisUtil.set(tokenKey, currentRealtorDTO.getRealtorId(), 2592000L);
        resultDO.setSuccess(true);
        return resultDO;
    }

    public ResultDO<CheckCodeResp> sendCheckCode(String phone){
        ResultDO<CheckCodeResp> resultDO = new ResultDO<CheckCodeResp>();
        CheckCodeResp bean = new CheckCodeResp();
        if(StringUtils.isEmpty(phone)){
            resultDO.setErrMsg("手机号不能为空！");
            return resultDO;
        }else {
            if(!RegexUtils.find(phone, "^1\\d{10}$")){
                resultDO.setErrMsg("手机号格式不正确！");
                return resultDO;
            }
        }
        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setPhone(phone);
        ResultDO<String> sendResult  = smsRemoteService.sendCheckCode(smsDTO);
        if(!sendResult.isSuccess()){
            resultDO.setErrMsg(sendResult.getErrMsg());
            return resultDO;
        }
        bean.setMsgId(sendResult.getData());
        resultDO.setSuccess(true);
        resultDO.setData(bean);
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
    public ResultDO<CheckCodeResp> sendVoiceCode(String phone){
        ResultDO<CheckCodeResp> resultDO = new ResultDO<CheckCodeResp>();
        CheckCodeResp bean = new CheckCodeResp();
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
        //String templateId = "CAPTCHA024053";//职业顾问1.0 正式环境配置
        ResultDO<String> sendResult  = new ResultDO<>();//smsRemoteService.sendVoiceCode(phone,sendVoiceTemId);
        if(!sendResult.isSuccess()){
            resultDO.setErrMsg(sendResult.getErrMsg());
            return resultDO;
        }
        bean.setMsgId(sendResult.getData());
        resultDO.setSuccess(true);
        resultDO.setData(bean);
        return resultDO;
    }

    public ResultDO<String> basicInfo(RealtorInfoDTO realtorInfoDTO,String version){
        CurrentRealtorDTO currentRealtorDTO = HttpSessionUtils.getCurrentRealtor();
        ResultDO<String> resultDO = new ResultDO<String>();
        String idCard = realtorInfoDTO.getIdentityNo();
        if(currentRealtorDTO==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }

        if(StringUtils.isEmpty(realtorInfoDTO.getRealName())){
            resultDO.setErrMsg("姓名不能为空！");
            return resultDO;
        }
        if(realtorInfoDTO.getDistrictId()==null){
            resultDO.setErrMsg("主营区域不能为空！");
            return resultDO;
        }
        if(realtorInfoDTO.getBlockId()==null){
            resultDO.setErrMsg("主营板块不能为空！");
            return resultDO;
        }
        if(ValidateHelper.isEmpty(realtorInfoDTO.getCardImg())){
            resultDO.setErrMsg("名片不能为空！");
            return resultDO;
        }else{
            String reg="(?i).+?\\.(jpg|gif|bmp|png)";
            if(!realtorInfoDTO.getCardImg().startsWith("http://")||!realtorInfoDTO.getCardImg().matches(reg)){
                resultDO.setErrMsg("名片上传后地址格式异常！");
                return resultDO;
            }
        }

        if (ValidateHelper.isEmpty(realtorInfoDTO.getHeadPortrait())) {
            resultDO.setErrMsg("头像不能为空！");
            return resultDO;
        } else {
            String reg = "(?i).+?\\.(jpg|gif|bmp|png)";
            if (!realtorInfoDTO.getCardImg().startsWith("http://") || !realtorInfoDTO.getCardImg().matches(reg)) {
                resultDO.setErrMsg("头像上传后地址格式异常！");
                return resultDO;
            }
        }
        if (ValidateHelper.isEmpty(realtorInfoDTO.getStoreCode()) || realtorInfoDTO.getComId() == null || realtorInfoDTO.getStoreId() == null) {
            resultDO.setErrMsg("门店相关信息不能为空！");
            return resultDO;
        }
        if(StringUtils.isEmpty(idCard)){
            resultDO.setErrMsg("身份证不能为空！");
            return resultDO;
        }else {
            if(!IdcardValidator.isValidatedAllIdcard(idCard)){
                resultDO.setErrMsg("用户身份证输入不正确");
                return resultDO;
            }else {
                idCard =  idCard.toUpperCase();
                realtorInfoDTO.setIdentityNo(idCard);
            }
        }

        if(StringUtils.isEmpty(realtorInfoDTO.getBuildingNameList())){
            resultDO.setErrMsg("主营楼盘不能为空！");
            return resultDO;
        }
        IdcardInfoExtractor idcardExtractor = new IdcardInfoExtractor(idCard);
        String gender  = idcardExtractor.getGender();
        if(!StringUtils.isEmpty(gender)){
            if(gender.equals(GenderType.MAN.getName())){
                realtorInfoDTO.setGender(GenderType.MAN.getValue());
            }else if(gender.equals(GenderType.WOMAN.getName())){
                realtorInfoDTO.setGender(GenderType.WOMAN.getValue());//女 转换成 1
            }
        }
        if(Boolean.valueOf(isAuth).booleanValue()) {
            AuthenticationNameDTO dto = new AuthenticationNameDTO();
            dto.setName(realtorInfoDTO.getRealName());
            dto.setId(realtorInfoDTO.getIdentityNo());
            dto.setMerchantId(1L);
            dto.setChannelNo("997");//置业顾问频道
            //验证姓名,身份证号码是否一致
            ResultDO<Boolean> result = authenticationService.identityId(dto);
            if (!result.isSuccess()) {
                resultDO.setErrMsg(result.getErrMsg());
                return resultDO;
            } else {
                if (!result.getData()) {//验证失败
                    resultDO.setErrMsg(result.getErrMsg());
                    return resultDO;
                }
            }
        }


        realtorInfoDTO.setRealtorId(currentRealtorDTO.getRealtorId());
        realtorInfoDTO.setTelphone(currentRealtorDTO.getPhone());
        resultDO = realtorService.basicInfo(realtorInfoDTO);
        return resultDO;
    }

    public ResultDO<CompanyStoreDTO> queryStoreCode(String storeCode){
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        ResultDO<CompanyStoreDTO> resultDO = new ResultDO<CompanyStoreDTO>();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(StringUtils.isEmpty(storeCode)){
            resultDO.setErrMsg("门店代码不能为空！");
            return resultDO;
        }
        CompanyStoreDTO companyStoreDTO = realtorService.findCompanyStoreByStoreCode(storeCode);
        if(companyStoreDTO==null){
            resultDO.setErrMsg("门店代码不正确！");
            return resultDO;
        }
        resultDO.setData(companyStoreDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }

    public ResultDO<CurrentRealtorDTO> identityAuth(RealtorInfoDTO realtorInfoDTO){
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        ResultDO<CurrentRealtorDTO> resultDO = new ResultDO<CurrentRealtorDTO>();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(StringUtils.isEmpty(realtorInfoDTO.getHeadPortrait())){
            resultDO.setErrMsg("经纪人头像不能为空！");
            return resultDO;
        }
        if(StringUtils.isEmpty(realtorInfoDTO.getCardImg())){
            resultDO.setErrMsg("经纪人名片不能为空！");
            return resultDO;
        }
        realtorInfoDTO.setRealtorId(realtorId);
        return realtorService.identityAuth(realtorInfoDTO);
    }
    public ResultDO<RealtorInfoDTO> showCompleteInfo(RealtorInfoDTO realtorInfoDTO){
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        ResultDO<RealtorInfoDTO> resultDO = new ResultDO<RealtorInfoDTO>();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        RealtorInfoDTO infoDTO = realtorService.showCompleteInfo(realtorId);
        if(infoDTO!=null){
            String idCard  = infoDTO.getIdentityNo();
            if(!StringUtils.isEmpty(idCard) && idCard.length()==18){
                idCard = idCard.replaceAll("(\\d{4})\\d{10}(\\w{4})","$1**********$2");
            }else if(!StringUtils.isEmpty(idCard) && idCard.length()==15){
                idCard = idCard.replaceAll("(\\d{4})\\d{8}(\\w{3})","$1********$2");
            }
            infoDTO.setIdentityNo(idCard);
        }
        resultDO.setSuccess(true);
        resultDO.setData(infoDTO);
        return resultDO;
    }

    public ResultDO<RealtorInfoDTO> myInfo(){
        ResultDO<RealtorInfoDTO> resultDO = new ResultDO<RealtorInfoDTO>();
        Long realtorId = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        RealtorInfoDTO infoDTO = realtorService.myInfo(realtorId);
        resultDO.setSuccess(true);
        resultDO.setData(infoDTO);
        return resultDO;
    }
   public ResultDO<List<SysMessageDTO>> messageList(){
       ResultDO<List<SysMessageDTO>> resultDO = new ResultDO<List<SysMessageDTO>>();
       Long realtorId  = HttpSessionUtils.getCurrentRealtorId();
       if(realtorId==null){
           resultDO.setErrMsg("请先登录");
           return resultDO;
       }
       List<SysMessageDTO> list = sysMessageService.nnsMessageList(realtorId,1);
       resultDO.setSuccess(true);
       resultDO.setData(list);
       return resultDO;
   }

    public  ResultDO<List<SysMessageDTO>> nnsMessageClassifyList(RealtorMessageQuery messageQuery){
        ResultDO<List<SysMessageDTO>> resultDO = new ResultDO<List<SysMessageDTO>>();
        Long realtorId  = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(messageQuery.getMesType()==null){
            resultDO.setErrMsg("消息类型不能为空！");
            return resultDO;
        }
        List<SysMessageDTO> list = sysMessageService.nnsMessageClassifyList(realtorId,1,messageQuery.getMesType());
        resultDO.setSuccess(true);
        resultDO.setData(list);
        return resultDO;
    }

    public ResultDO<CurrentRealtorDTO> realtorIfAuth(){
        ResultDO<CurrentRealtorDTO> resultDO = new ResultDO<CurrentRealtorDTO>();
        Long realtorId  = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        CurrentRealtorDTO currentRealtor = realtorService.findCurrentRealtorById(realtorId);
        if(currentRealtor!=null){
            resultDO.setSuccess(true);
            resultDO.setData(currentRealtor);
            return resultDO;
        }
        return resultDO;
    }

    public ResultDO<String> updateUserAutograph(String userAutograph){
        ResultDO<String> resultDO = new ResultDO<String>();
        Long realtorId  = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
       return realtorService.updateUserAutograph(realtorId,userAutograph);
    }


    public ResultDO<Integer> nnsUnReadMsg(){
        ResultDO<Integer> resultDO = new ResultDO<Integer>();
        Long realtorId  = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
       Integer num = sysMessageService.nnsUnReadMsg(realtorId,1);
        resultDO.setSuccess(true);
        resultDO.setData(num);
        return resultDO;
    }

    /**
     * 拷贝了周敏 红包项目经纪人审核发送短信的代码
     * @param realtorId
     * @param status
     * @param reason
     * @return
     */
    public ResultDO<String> smsPush(Long realtorId , Integer status , String reason){
        ResultDO<String> resultDO = new ResultDO<>();
        if(realtorId==null){
            resultDO.setErrMsg("经纪人ID不能为空！");
            return resultDO;
        }
        if(status==null){
            resultDO.setErrMsg("状态不能为空！");
            return resultDO;
        }
        return wxRealtorAccountService.smsPush(realtorId, status, reason);
    }

    public ResultDO<String> getParam(String version){
        ResultDO<String> resultDO = new ResultDO<>();
        resultDO.setSuccess(true);
        if(ValidateHelper.isEmptyString(version)){
            resultDO.setData("true");
            return resultDO;
        }else {
            if(version.equals(appParam)){
                resultDO.setData("false");
                return resultDO;
            }else {
                resultDO.setData("true");
                return resultDO;
            }
        }
    }

    public ResultDO<String> updateInfo(RealtorInfoDTO realtorInfoDTO,String version){
        CurrentRealtorDTO currentRealtorDTO = HttpSessionUtils.getCurrentRealtor();
        ResultDO<String> resultDO = new ResultDO<String>();
        if(currentRealtorDTO==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        realtorInfoDTO.setRealtorId(currentRealtorDTO.getRealtorId());
        //区域不为空时,
        if(!ValidateHelper.isEmpty(realtorInfoDTO.getDistrictId())){
            //板块也不能为空
            if(ValidateHelper.isEmpty(realtorInfoDTO.getBlockId())|| ValidateHelper.isEmpty(realtorInfoDTO.getBlockName())){
                resultDO.setErrMsg("区域、板块、小区不能为空，请选择.");
                return resultDO;
            }
            //主营楼盘也不能为空
            if(ValidateHelper.isEmpty(realtorInfoDTO.getBuildingNameList())){
                resultDO.setErrMsg("区域、板块、小区不能为空，请选择.");
                return resultDO;
            }
        }


        if(!ValidateHelper.isEmpty(realtorInfoDTO.getHeadPortrait())){
            String reg="(?i).+?\\.(jpg|gif|bmp|png)";
            if(!realtorInfoDTO.getHeadPortrait().startsWith("http://")||!realtorInfoDTO.getHeadPortrait().matches(reg)){
                resultDO.setErrMsg("头像格式异常！");
                return resultDO;
            }

        }


        realtorService.updateInfo(realtorInfoDTO);

        resultDO.setSuccess(true);
        return resultDO;

    }

    public ResultDO<List<RealtorCompanyDTO>> queryCompanyByKeyword(String keyword){
        ResultDO<List<RealtorCompanyDTO>> resultDO=new ResultDO<>();
        //关键词为空时直接返回
        if(ValidateHelper.isEmpty(keyword)){
            resultDO.setSuccess(true);
            return resultDO;
        }
        return realtorCompanyService.queryCompanyByKeyword(keyword);
    }

    public ResultDO<Page<RealtorStoreDTO>> queryStoreByKeyword(CustomerStoreQuery query){
        ResultDO<Page<RealtorStoreDTO>> resultDO=new ResultDO<>();
        if(query.getRealtorCompanyId()==null){
            resultDO.setErrMsg("经纪人公司不能为空");
            return resultDO;
        }

        return realtorCompanyService.queryStoreByKeyword(query);
    }

    public ResultDO<List<RealtorStoreDTO>> queryStoreByKeyword(String keyword,Long realtorCompanyId){
        ResultDO<List<RealtorStoreDTO>> resultDO=new ResultDO<>();
        if(realtorCompanyId==null){
            resultDO.setErrMsg("经纪人公司不能为空");
        }
        //关键词为空时直接返回
        if(ValidateHelper.isEmpty(keyword)){
            resultDO.setSuccess(true);
            return resultDO;
        }
        return realtorCompanyService.queryStoreByKeyword(keyword,realtorCompanyId);
    }

    public ResultDO<Boolean> updateDeviceId(String deviceId,Integer osType){
        ResultDO<Boolean> resultDO = new ResultDO<>();
        Long realtorId  = HttpSessionUtils.getCurrentRealtorId();
        if(realtorId==null){
            resultDO.setErrMsg("请先登录");
            return resultDO;
        }
        if(ValidateHelper.isEmptyString(deviceId)){
            resultDO.setErrMsg("设备ID不能为空!");
            return resultDO;
        }
        if(osType==null){
            resultDO.setErrMsg("设备类型不能为空!");
            return resultDO;
        }else if(osType.intValue()<0|| osType.intValue()>1){
            resultDO.setErrMsg("设备类型输入不正确!");
            return resultDO;
        }
        return realtorService.updateDeviceId(realtorId,deviceId,osType);
    }
}
