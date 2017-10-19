package com.shfc.base.service;

import com.shfc.base.dto.AliyunSTSRespDTO;
import com.shfc.base.dto.AppUpdateRespDTO;
import com.shfc.common.result.ResultDO;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/13 下午4:09.
 */
public interface AppService {

    /**
     * 获取阿里云oss的token信息
     *
     * @param osType
     * @return
     */
    public ResultDO<AliyunSTSRespDTO> getAliyunTokenInfo(String osType);

    /**
     * 获取app版本更新信息
     *
     * @param osType
     * @param version
     * @return
     */
    public ResultDO<AppUpdateRespDTO> queryAppUpdate(Integer osType, String version);
}
