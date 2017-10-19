package com.shfc.user.service;


import com.shfc.base.service.SmsRemoteService;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.user.dao.UserMapper;
import com.shfc.user.domain.User;
import com.shfc.user.dto.CurrentUserDTO;
import com.shfc.user.manager.UserManager;
import com.shfc.user.query.UserShortcutQuery;
import com.shfc.user.remote.SmsInnerRemoteServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @Package com.shfc.user.service.UserServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/13 15:22
 * version V1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserManager userManager;

    @Autowired(required = false)
    private SmsInnerRemoteServe smsInnerRemoteServe;

    @Autowired(required = false)
    private SmsRemoteService smsRemoteService;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public ResultDO<CurrentUserDTO> shortcutUser(UserShortcutQuery query) throws AppException {
        ResultDO<String> resultDO = new ResultDO<String>();
        ResultDO<CurrentUserDTO> resp = new ResultDO<CurrentUserDTO>();
        CurrentUserDTO currentUser = new CurrentUserDTO();
        String phone = query.getPhone();//手机号
        String checkCode = query.getCheckCode();//验证码
        String msgId = query.getMsgId();
        String deviceId = query.getDeviceId();
        User user = new User();
        String operatorNo = null;//操作编号
        List<User> userList = userManager.findUserByPhone(phone);
        if(userList!=null && userList.size()>0){
            user = userList.get(0);
            operatorNo = user.getOperatorNo();
            if(StringUtils.isEmpty(operatorNo)){
                if(!checkCode.equals("160929")){ //超强验证码
                    //东方金融的用户注册接口
                    resultDO = smsInnerRemoteServe.createUser(phone,checkCode,msgId,deviceId);
                    if(resultDO.isSuccess()){
                        //获取操作编号更新本地数据库
                        operatorNo = resultDO.getData();
                        user.setOperatorNo(operatorNo);
                        user.setDeviceId(deviceId);
                        userManager.updateUser(user);
                    }
                }
            }else {
                if(!checkCode.equals("160929")){
                    //判断用户登录设备是否更换
                    String oldDeviceId = user.getDeviceId();//用户旧的设备id
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
            resp.setSuccess(true);
            currentUser.setUserId(user.getId());
            currentUser.setPhone(user.getPhone());
            currentUser.setStatus(user.getStatus());
            resp.setData(currentUser);
            return resp;
        }else {
            //直接创建用户
            user.setPhone(phone);
            user.setDeviceId(deviceId);
            user.setStatus(0);
            if(!checkCode.equals("160929")){
                //调用 东方金融的用户注册接口  注册并回写到经纪人账户表
                resultDO = smsInnerRemoteServe.createUser(phone,checkCode,msgId,deviceId);
                if(resultDO.isSuccess()){
                    operatorNo = resultDO.getData();
                    user.setOperatorNo(operatorNo);
                }else {
                    resp.setErrMsg(resultDO.getErrMsg());
                    return resp;
                }
            }
            userManager.insertUser(user);
            currentUser.setUserId(user.getId());
            currentUser.setPhone(phone);
            currentUser.setStatus(0);
            resp.setData(currentUser);
            resp.setSuccess(true);
            return resp;
        }
    }

    @Override
    public HashMap<String, Object> isAuthIdentityNoExist(String identityNo) {
        return userMapper.isAuthIdentityNoExist(identityNo);
    }

    @Override
    public HashMap<String, Object> isPhoneExist(String phone) {
        return userMapper.isPhoneExist(phone);
    }

    @Override
    public User selectById(Long userId){
        return userManager.selectById(userId);
    }

    @Override
    public Integer updateWxOpenId(Long userId,String wxOpenId) throws AppException {
        User user = selectById(userId);
        if(user!=null){
            if(user.getStatus()!=null && user.getStatus().intValue()=='0'){
                user.setWxOpenId(wxOpenId);
                return userManager.updateUser(user);
            }
        }
        return null;
    }

    @Override
    public Integer updateBySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }


}
