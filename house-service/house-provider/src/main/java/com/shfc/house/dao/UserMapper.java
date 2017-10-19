package com.shfc.house.dao;

import com.shfc.house.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.shfc.house.dao.UserMapper.java
 * @Description: 用户
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author Li Jianguo
 * @date 2017/01/09 17:36
 * version v1.0.0
 */
@Repository
public interface UserMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author Li Jianguo
     * @Date 2017/01/09 17:36
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author Li Jianguo
     * @Date 2017/01/09 17:36
     * @param record
     * @return int
     * @throws []
     */
    int insert(User record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author Li Jianguo
     * @Date 2017/01/09 17:36
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(User record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author Li Jianguo
     * @Date 2017/01/09 17:36
     * @param id
     * @return User
     * @throws []
     */
    User selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author Li Jianguo
     * @Date 2017/01/09 17:36
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author Li Jianguo
     * @Date 2017/01/09 17:36
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(User record);

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
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    List<User> findUserByPhone(String phone);

    /**
     * 根据微信openid获取用户信息
     * @Author: Jianguo_li
     * @Date 2017/1/16 下午3:54
     * @Param 
     * @Return 
     */
    List<User> findUserByWxOpenId(String wxOpenId);
}