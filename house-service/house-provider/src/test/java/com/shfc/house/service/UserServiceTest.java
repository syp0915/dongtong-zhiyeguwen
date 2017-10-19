package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import com.shfc.house.domain.User;
import com.shfc.house.dto.CurrentUserDTO;
import com.shfc.house.query.UserShortcutQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author sunyaping
 * @Package com.shfc.house.service
 * @Description
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * @date 2017-04-07 10:08
 * version V1.0.0
 **/
public class UserServiceTest extends JunitBaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testShortcutUser(){
        UserShortcutQuery query=new UserShortcutQuery();
        ResultDO<CurrentUserDTO> resp = new ResultDO<CurrentUserDTO>();
        query.setPhone("13891021211");
        query.setCheckCode("160929");
        query.setDeviceId("");
        query.setMsgId("");
        try{
            resp= userService.shortcutUser(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(resp.getData());
    }

    @Test
    public void testIsAuthIdentityNoExist(){
        String identityNo="1212";
        HashMap<String, Object> hashMap= userService.isAuthIdentityNoExist(identityNo);
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(hashMap!=null){
            System.out.println(hashMap.get("id"));
            System.out.print(hashMap.get("phone"));
        }
    }

    @Test
    public void testIsPhoneExist(){
        String phone="13891021211";
        HashMap<String, Object> hashMap= userService.isPhoneExist(phone);
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(hashMap!=null){
            System.out.println(hashMap.get("id"));
            System.out.print(hashMap.get("identity_no"));
        }
    }

    @Test
    public void testSelectById(){
        String userId="1";
        User user= userService.selectById(Long.parseLong(userId));
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(user!=null){
            System.out.print(user.getIdentityNo());
        }
    }

    @Test
    public void testUpdateWxOpenId(){
        String userId="1";
        String wxOpenId="67";
        Integer result=null;
        try{
            result= userService.updateWxOpenId(Long.parseLong(userId),wxOpenId);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(result);
    }

    @Test
    public void testUpdateBySelective(){
       User user=new User();
       user.setId((long)1);
       user.setVersion((long)0);
       Integer result= userService.updateBySelective(user);
       System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.print(result);
    }



}
