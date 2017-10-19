package com.shfc.user.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/15 上午10:59.
 */
public class ApacheHttpUtils {
    private final static String ENCODING = "UTF-8";

    /**
     * 发送请求json参数
     * @param url
     * @param jsonParam
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String doPost(String url, JSONObject jsonParam) throws ClientProtocolException, IOException {

        //实例化一个Httpclient的
        //HttpClient client = new DefaultHttpClient();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //实例化一个post请求
        HttpPost post = new HttpPost(url);

        StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
        entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(entity);
        //实行请求并返回
        HttpResponse response = client.execute(post);

        return new String(EntityUtils.toByteArray(response.getEntity()), ENCODING);
    }

}
