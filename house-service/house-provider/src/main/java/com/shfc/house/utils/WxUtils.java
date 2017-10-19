package com.shfc.house.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/2/20 下午4:08.
 */
public class WxUtils {
    public static Map<String, Object> parseXml(String xmlString) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(xmlString.getBytes("utf-8")));
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static String map2XmlString(Map<String, Object> map) {
        String xmlResult = "";
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        for (String key : map.keySet()) {
            String value = "<![CDATA[" + map.get(key).toString() + "]]>";
            sb.append("<" + key + ">" + value + "</" + key + ">");
        }
        sb.append("</xml>");
        xmlResult = sb.toString();
        return xmlResult;
    }
}
