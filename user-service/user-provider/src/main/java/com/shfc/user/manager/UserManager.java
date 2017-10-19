package com.shfc.user.manager;

import com.shfc.common.exception.AppException;
import com.shfc.user.base.BaseManager;
import com.shfc.user.dao.UserMapper;
import com.shfc.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.user.manager.UserManager
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/13 16:31
 * version V1.0.0
 */
@Service
public class UserManager extends BaseManager{
    @Autowired(required = false)
    private UserMapper userMapper;

    public List<User> findUserByPhone(String phone){
       return userMapper.findUserByPhone(phone);
    }

    public User selectById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
    @Transactional(rollbackFor = AppException.class)
    public Integer updateUser(User user) throws AppException{
       return userMapper.updateByPrimaryKey(user);
    }
    @Transactional(rollbackFor = AppException.class)
    public Integer insertUser(User user) throws AppException{
        return userMapper.insert(user);
    }

    public boolean bindShfcAccount(User user, String wxOpenId) throws Exception {
        user.setWxOpenId(wxOpenId);
        user.setBindingTime(new Date());
        try {
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(ERROR_DB_OPERATE_EXCEPTION);
        }
        return true;
    }
}
