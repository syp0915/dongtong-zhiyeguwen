package com.shfc.base.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 邮件
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-12 09:44
 **/
public class MailDTO implements Serializable {
    private static final long serialVersionUID = 7074518351793955092L;
    private String to;//收件人
    private String subject;//主题
    private String content;//邮件内容
    //private String affix;//邮件附件;
    private List<AffixDTO> list;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<AffixDTO> getList() {
        return list;
    }

    public void setList(List<AffixDTO> list) {
        this.list = list;
    }
}
