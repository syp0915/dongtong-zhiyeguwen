package com.shfc.house.service;

import com.shfc.common.base.Logger;
import com.shfc.common.base.RegexUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.RealtorCompanyMapper;
import com.shfc.house.dao.RealtorStoreMapper;
import com.shfc.house.domain.RealtorCompany;
import com.shfc.house.domain.RealtorStore;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Package com.shfc.house.service.ImportDataServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/6/7 13:12
 * version V1.0.0
 */
@Service
public class ImportDataServiceImpl implements ImportDataService {
    @Autowired
    private RealtorCompanyMapper realtorCompanyMapper;
    @Autowired
    private RealtorStoreMapper realtorStoreMapper;
    @Async
    public ResultDO inportRealtorData(String filePath)  {
        ResultDO resultDO = new ResultDO();
        try {
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNumber = sheet.getLastRowNum();
            Integer codeNum = 10000;
            String maxCode = realtorStoreMapper.selectMaxCode();
            if(maxCode!=null){
                maxCode = maxCode.substring(2,maxCode.length());
                if(RegexUtils.isInteger(maxCode)){
                    codeNum = Integer.valueOf(maxCode);
                }
            }
            for (int i = 1; i < rowNumber; i++) {
                String companyName = sheet.getRow(i).getCell(0).getStringCellValue();
                String shopName = sheet.getRow(i).getCell(1).getStringCellValue();
                RealtorCompany realtorCompany = null;
                if (!ValidateHelper.isEmpty(companyName)){
                    realtorCompany = realtorCompanyMapper.findCompanyByName(companyName);
                    if (realtorCompany == null){
                        realtorCompany = new RealtorCompany();
                        realtorCompany.setComName(companyName);
                        realtorCompany.setComAbbr(companyName);
                        realtorCompany.setComStatus(0);
                        realtorCompany.setIsDel(0);
                        realtorCompanyMapper.insert(realtorCompany);
                    }
                }
                RealtorStore realtorStore = null;
                if (!ValidateHelper.isEmpty(shopName)){
                    //shopName = companyName;
                    realtorStore = realtorStoreMapper.findStoreByName(shopName);
                    if (realtorStore == null){
                        realtorStore = new RealtorStore();
                        realtorStore.setStoreName(shopName);
                        realtorStore.setRealtorCompanyId(realtorCompany.getId());
                        realtorStore.setStoreStatus(0);
                        realtorStore.setIsDel(0);
                        realtorStore.setStoreCode("SH" + ++codeNum);
                        realtorStoreMapper.insert(realtorStore);
                    }
                }
            }
            resultDO.setSuccess(true);
            return resultDO;
        } catch (IOException e) {
            Logger.error(ImportDataServiceImpl.class,e.getMessage(),e);
            resultDO.setErrMsg("文件service层导入异常！");
            return resultDO;
        }
    }
}
