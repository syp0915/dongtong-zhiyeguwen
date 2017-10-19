package com.shfc.house.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

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

    public static String doPost(String url, String paramString) throws ClientProtocolException, IOException {

        //实例化一个Httpclient的
        //HttpClient client = new DefaultHttpClient();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //实例化一个post请求
        HttpPost post = new HttpPost(url);

        StringEntity entity = new StringEntity(paramString, "utf-8");
        entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(entity);
        //实行请求并返回
        HttpResponse response = client.execute(post);

        return new String(EntityUtils.toByteArray(response.getEntity()), ENCODING);
    }

    public static String doPostForCertificate(String url, String paramString, String filePath) throws ClientProtocolException, IOException, Exception {

//        System.getProperties().setProperty("https.proxyHost", "121.43.164.229");
//        System.getProperties().setProperty("https.proxyPort", "3128");
//        Authenticator authenticator = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("shfc_proxys", "cewnvsSFXC89534FH".toCharArray());
//            }
//        };
//        Authenticator.setDefault(authenticator);

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream inputStream = new FileInputStream(filePath);
        try{
            keyStore.load(inputStream, "1436028202".toCharArray());
        }finally {
            inputStream.close();
        }
        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, "1436028202".toCharArray()).build();
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

        HttpHost target = new HttpHost("api.mch.weixin.qq.com", 443, "https");
        HttpHost proxy = new HttpHost("121.43.164.229", 3128, "http");

        CredentialsProvider provider = new BasicCredentialsProvider();
        AuthScope authScope = new AuthScope(proxy.getHostName(), proxy.getPort());
        Credentials credentials = new UsernamePasswordCredentials("shfc_proxys", "cewnvsSFXC89534FH");
        provider.setCredentials(authScope, credentials);

        CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(factory).setDefaultCredentialsProvider(provider).build();

        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

        HttpPost post = new HttpPost(url);
        post.setConfig(config);

        StringEntity entity = new StringEntity(paramString, "utf-8");
        entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(entity);
        //实行请求并返回
        CloseableHttpResponse response = client.execute(target, post);

        return new String(EntityUtils.toByteArray(response.getEntity()), ENCODING);
    }

    /**
     * 模拟GET请求
     * @param url
     * @throws IOException
     * @throws ClientProtocolException
     */

    public static InputStream doGet(String url) throws IOException, ClientProtocolException
    {
        InputStream inputStream=null;
        //实例化一个Httpclient的
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            inputStream=entity.getContent();
        }

        return inputStream;
    }
}
