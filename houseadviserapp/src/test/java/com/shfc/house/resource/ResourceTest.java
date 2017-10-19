package com.shfc.house.resource;

import com.alibaba.fastjson.JSONObject;
import com.fc.common.redis.RedisUtil;
import com.shfc.adviser.ao.PerpetualAO;
import com.shfc.adviser.wnl.Util.JdwxProperties;
import com.shfc.common.date.DateUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.JunitBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ResourceTest extends JunitBaseTest {

    @Autowired
    private PerpetualAO perpetualAO;


    @Test
    public void testRedis(){
        System.out.println("============================");
        String key ="NOTE".concat("13816513175");
       // RedisUtil.set(key, 3);
        System.out.println(RedisUtil.get("13816513175"));
        String nowDate  = DateUtils.getCurrentTime();
        System.out.println(nowDate);
        String nextTime = DateUtils.getCurrentTime("yyy-MM-dd ")+"11:10:59";
        System.out.println("nextTime=="+nextTime);
        int secondCount  = DateUtils.compareTime(nowDate,nextTime,3);
        if(secondCount>0){
            RedisUtil.set(key, 4,secondCount);
        }

        System.out.println(secondCount);
    }
    @Test
    public void testRedis1(){
        String key ="NOTE".concat("13816513175");
        RedisUtil.get(key);
        System.out.println("============================");
        System.out.println(RedisUtil.get(key));
    }

    @Test
    public void testStar(){
        String currentDate = DateUtils.getCurrentTime("yyyy-MM-dd");
        String astroid = "1";
        ResultDO<JSONObject> result =  perpetualAO.selectStarJsonStr(currentDate,astroid);
        System.out.println(result.getData().toJSONString());
    }

    @Test
    public void testJDWXURL(){
        System.out.println(JdwxProperties.getProperties("jdwx.url")+"*******************");
    }
}
