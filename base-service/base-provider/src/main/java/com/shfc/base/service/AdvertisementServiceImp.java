package com.shfc.base.service;

import com.shfc.base.dto.AdvRespDTO;
import com.shfc.base.dto.AdvertisementListDTO;
import com.shfc.base.manager.AdvertisementManager;
import com.shfc.base.query.AdvertisementsQuery;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 广告
 *
 * @author wky
 * @version V1.0
 * @create 2017-01-04 10:07
 **/
@Service
public class AdvertisementServiceImp implements AdvertisementService{
    @Autowired
    private AdvertisementManager advertisementManager;

    public static final Logger LOGGER = Logger.getLogger(AdvertisementServiceImp.class);


    @Override
    public ResultDO<List<AdvertisementListDTO>> queryAdvertisements(AdvertisementsQuery query) {
        ResultDO<List<AdvertisementListDTO>> resultDO=new ResultDO<>();


        String source=query.getSource();
        String position=query.getPosition();

        if(ValidateHelper.isEmpty(source)){
            resultDO.setErrMsg("请求参数来源不能为空");
            return resultDO;
        }
        if(ValidateHelper.isEmpty(position)){
            resultDO.setErrMsg("请求参数位置不能为空");
            return resultDO;
        }
        try {
            resultDO.setData(advertisementManager.queryAdvertisementsByCondition(source,position));
            resultDO.setSuccess(true);


        }catch (Exception e){
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }

    @Override
    public ResultDO<AdvRespDTO> queryAdvertisement(AdvertisementsQuery query) {
        ResultDO<AdvRespDTO> resultDO=new ResultDO<>();


        String source=query.getSource();
        String position=query.getPosition();

        if(ValidateHelper.isEmpty(source)){
            resultDO.setErrMsg("请求参数来源不能为空");
            return resultDO;
        }
//        if(ValidateHelper.isEmpty(position)){
//            resultDO.setErrMsg("请求参数位置不能为空");
//            return resultDO;
//        }
        try {
            AdvRespDTO dto=new AdvRespDTO();
            List<AdvertisementListDTO> bannerList=advertisementManager.queryAdvertisementsByCondition(source,"1");
            List<AdvertisementListDTO> list=advertisementManager.queryAdvertisementsByCondition(source,"2");
            dto.setList(list);
            dto.setBannerlist(bannerList);

            resultDO.setData(dto);
            resultDO.setSuccess(true);


        }catch (Exception e){
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }
}
