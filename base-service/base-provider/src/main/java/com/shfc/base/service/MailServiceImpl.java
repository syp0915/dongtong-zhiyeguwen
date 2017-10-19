package com.shfc.base.service;

import com.shfc.base.dto.AffixDTO;
import com.shfc.base.dto.MailDTO;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.URLDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-12 15:39
 **/
@Service
public class MailServiceImpl implements MailService {
    @Value("${mail.host}")
    private String mail_host; // smtp服务器
    @Value("${mail.from}")
    private String mail_from; // 发件人地址
    @Value("${mail.user}")
    private String mail_user; // 用户名
    @Value("${mail.pwd}")
    private String mail_pwd; // 密码
    @Value("${mail.smtp.timeout}")
    private String mail_SMTP_TIMEOUT; // 超时时间
    @Value("${mail.smtp.auth}")
    private String MAIL_SMTP_AUTH;//是否进行服务器认证

    public static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);


    @Override
    public ResultDO<Boolean> sendMail(MailDTO mailDTO) {
        ResultDO<Boolean> resultDO = new ResultDO<Boolean>();
        //收件人不可为空
        if(ValidateHelper.isEmpty(mailDTO.getTo())){
            resultDO.setErrMsg("收件人邮箱不可为空");
            return resultDO;
        }
        try {
            JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

            //设定mail server
            senderImpl.setHost(mail_host);
            senderImpl.setUsername(mail_user); // 设置username
            senderImpl.setPassword(mail_pwd); // 设置password
            Properties prop = new Properties();
            prop.put("mail.smtp.auth",MAIL_SMTP_AUTH); // 设为true，服务器进行认证
            prop.put("mail.smtp.timeout", mail_SMTP_TIMEOUT);
            senderImpl.setJavaMailProperties(prop);

            //建立邮件消息,发送简单邮件和html邮件的区别
            MimeMessage mailMessage = senderImpl.createMimeMessage();
            //注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
            //multipart模式 为true时发送附件 可以设置html格式
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

            //设置收件人，寄件人
            messageHelper.setTo(mailDTO.getTo());
            messageHelper.setFrom(mail_from);
            messageHelper.setSubject(mailDTO.getSubject());

            //true 表示启动HTML格式的邮件
            messageHelper.setText(mailDTO.getContent(), true);

            //FileSystemResource file = new FileSystemResource(new File(mailDTO.getAffix()));

           // EmailAttachment attachment = new EmailAttachment();//创建附件

            //attachment.setURL(new URI(mailDTO.getAffix()));

            for(AffixDTO affixDTO:mailDTO.getList()){
                URLDataSource url=new URLDataSource(new URL(affixDTO.getFile()));
                //这里的方法调用和插入图片是不同的。
                messageHelper.addAttachment(affixDTO.getFileName(), url);
            }
            //发送邮件
            senderImpl.send(mailMessage);

        } catch (MessagingException e) {
            LOGGER.error("发送邮件失败", e);
            resultDO.setErrMsg("发送邮件失败");
            return resultDO;
        } catch (MalformedURLException e) {
            LOGGER.error("添加附件失败", e);
            resultDO.setErrMsg("添加附件失败");
            return resultDO;
        }

        resultDO.setSuccess(true);
        return resultDO;
    }
}
