package com.shfc.adviser.ao;

import com.shfc.adviser.constants.ErrorConstant;
import com.shfc.base.dto.AliyunSTSRespDTO;
import com.shfc.base.dto.AppUpdateRespDTO;
import com.shfc.base.query.AliyunTokenQuery;
import com.shfc.base.query.AppUpdateQuery;
import com.shfc.base.service.AppService;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/6/14 下午1:49.
 */
@Service
public class AppAO {

    @Autowired(required = false)
    private AppService appService;


    public ResultDO<AppUpdateRespDTO> queryAppUpdate(AppUpdateQuery query){
        ResultDO<AppUpdateRespDTO> resultDO = new ResultDO<>();
        Integer osType = query.getOsType();
        String version = query.getVersion();
        if (ValidateHelper.isEmpty(osType) || ValidateHelper.isEmpty(version)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        return appService.queryAppUpdate(osType, version);
    }

    public ResultDO<AliyunSTSRespDTO> getAliyunTokenInfo(AliyunTokenQuery query){
        ResultDO<AliyunSTSRespDTO> resultDO = new ResultDO<>();
        if (ValidateHelper.isEmpty(query.getOsType())){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        return appService.getAliyunTokenInfo(query.getOsType());
    }
}
