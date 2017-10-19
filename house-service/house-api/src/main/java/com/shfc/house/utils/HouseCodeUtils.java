package com.shfc.house.utils;

import com.shfc.common.math.RandomUtils;

/**
 * @Package com.shfc.house.utils.HouseCodeUtils
 * @Description: 房源编码生产规则
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 11:18
 * version V1.0.0
 */
public class HouseCodeUtils {

    /** 
      * @Description: 获取上海房源编码---置业顾问
      * @Title shHouseCode
      * @Author  lv bin
      * @Date 2017/1/8 11:19
      * @param  
      * @return 
      * @throws 
      */
    public static synchronized String zshHouseCode(){
        return "ZSH0".concat(RandomUtils.generateNumberString(7));
    }


    /**
     * @Description: 获取上海房源编码---997发房
     * @Title HouseCode
     * @Author  wuky
     * @Date 2017/8/22 14:19
     * @param
     * @return
     * @throws
     */
    public static synchronized String HouseCode(){
        return "SR".concat(RandomUtils.generateNumberString(8));
    }
}
