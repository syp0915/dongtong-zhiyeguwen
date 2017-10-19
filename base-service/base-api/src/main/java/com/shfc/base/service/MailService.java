package com.shfc.base.service;

import com.shfc.base.dto.MailDTO;
import com.shfc.common.result.ResultDO;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 邮件服务
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-12 09:47
 **/
public interface MailService {

    ResultDO<Boolean> sendMail(MailDTO mailDTO);
}
