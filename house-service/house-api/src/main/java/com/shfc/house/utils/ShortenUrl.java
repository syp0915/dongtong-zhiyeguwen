package com.shfc.house.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * @Package com.shfc.house.utils.ShortenUrl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/6 15:59
 * version V1.0.0
 */
public class ShortenUrl {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        String httpArg = "url_long="+"http://www.baidu.com";
        String jsonResult = request(httpArg);
        System.out.println(jsonResult);

    }

    /**
     * @param
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String request( String httpArg) {
        String httpUrl = "http://apis.baidu.com/3023/shorturl/shorten";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "e69072f9fd15626b6bd5c54a28ff51f1");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            HashMap<String,Object> resultMap  = JSON.parseObject(result,HashMap.class);
            List<Map<String,Object>> urls  = (List<Map<String,Object>>)resultMap.get("urls");
            if(urls==null){
                System.out.println("解析错误！");
            }else {
                Map<String,Object> mapStr = urls.get(0);
                result = (String) mapStr.get("url_short");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
