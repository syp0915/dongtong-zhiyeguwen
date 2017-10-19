package com.shfc.adviser.errorCode;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @Package com.shfc.adviser.errorCode.ErrorCodeProperties
 * @Description: 错误代码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/20 10:33
 * version V1.0.0
 */
public class ErrorCodeProperties {

    private static Properties properties = null;
    private static final Logger LOGGER = Logger.getLogger(ErrorCodeProperties.class);

    static {
        try {
            Resource resource = new ClassPathResource("errorcode.properties");
            EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
            properties = PropertiesLoaderUtils.loadProperties(encodedResource);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("错误代码加载失败", e);
        }
    }

    /**
     * 获取属性
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getProperties(Object key) {
        return (T) properties.getProperty(String.valueOf(key));
    }


    public static void main(String[] args) {
        System.out.println(ErrorCodeProperties.getProperties(-98));
    }
}
