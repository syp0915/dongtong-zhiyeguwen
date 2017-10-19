package com.shfc.user.service;

import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.user.domain.User;
import com.shfc.user.dto.CurrentUserDTO;
import com.shfc.user.query.UserShortcutQuery;

import java.util.HashMap;

/**
 * @Package com.shfc.user.service.UserService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/13 15:15
 * version V1.0.0
 */
public interface UserService {
    /**
     * 用户快捷登录
     * @return
     */
    public ResultDO<CurrentUserDTO> shortcutUser(UserShortcutQuery query) throws AppException;

    /**
     * 检查指定的身份证号是否已经存在实名认证
     * @param identityNo
     * @return
     */
    HashMap<String, Object> isAuthIdentityNoExist(String identityNo);

    /**
     * 检查指定的手机号是否已经注册用户
     * @param phone
     * @return
     */
    HashMap<String, Object> isPhoneExist(String phone);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public User selectById(Long userId);

    /**
     * 绑定微信账号
     * @param userId
     * @return
     */
    public Integer updateWxOpenId(Long userId,String wxOpenId) throws AppException;

    /**
     * 有选择性的更新user信息
     * @param user
     * @return
     */
    public Integer updateBySelective(User user);
}
