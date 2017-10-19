package com.shfc.adviser.ao;

import com.shfc.common.base.Logger;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.ImportReqBean;
import com.shfc.house.service.ImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @Package com.shfc.adviser.ao.ImportAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/6/7 13:59
 * version V1.0.0
 */
@Service
public class ImportAO {
    @Autowired
    private ImportDataService importDataService;

    public ResultDO importAjkData(ImportReqBean importReqBean) {
        ResultDO resultDO = new ResultDO();
        String filePath = importReqBean.getFilePath();
        if (ValidateHelper.isEmpty(filePath)){
            resultDO.setErrMsg("文件路径不能为空！");
            return resultDO;
        }
        File file = new File(filePath);
        if (!file.exists()){
            resultDO.setErrMsg("文件不存在！");
            return resultDO;
        }
        try {
            importDataService.inportRealtorData(filePath);
            resultDO.setSuccess(true);
            return resultDO;
        } catch (Exception e) {
            Logger.error(ImportAO.class,e.getMessage(),e);
            resultDO.setErrMsg("文件导入异常");
            return resultDO;
        }
    }
}
