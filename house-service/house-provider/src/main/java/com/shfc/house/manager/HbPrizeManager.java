package com.shfc.house.manager;

import com.alibaba.fastjson.JSON;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.HbPrizeMapper;
import com.shfc.house.dao.HbPrizeRecordMapper;
import com.shfc.house.domain.HbPrize;
import com.shfc.house.domain.HbPrizeRecord;
import com.shfc.house.dto.HbPrizeDTO;
import com.shfc.house.dto.HbRunPrizeDTO;
import com.shfc.house.dto.WxSendRedPapperReqDTO;
import com.shfc.house.dto.WxSendRedPapperRespDTO;
import com.shfc.house.enums.YesNo;
import com.shfc.house.service.WxRealtorAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Package com.shfc.house.manager.HbPrizeManager
 * @Description: 奖品管理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/15 17:37
 * version V1.0.0
 */
@Service
public class HbPrizeManager {
    private static final Logger logger = Logger.getLogger(HbPrizeManager.class);
    @Autowired
    private HbPrizeMapper hbPrizeMapper;

    @Autowired
    private HbPrizeRecordMapper hbPrizeRecordMapper;

    @Autowired
    private WxRealtorAccountService wxRealtorAccountService;

    public List<HbPrizeDTO> prizeList(){
        return hbPrizeMapper.prizeList();
    }

    /**
     * 更新奖品数量-1，添加抽奖记录
     * @param prize
     * @return
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public void updatePrizeAmount(HbPrizeDTO prize, HbRunPrizeDTO accountDto) throws AppException{
        HbPrize record = hbPrizeMapper.selectByPrimaryKey(prize.getPrizeId());
        record.setPrizeAmount(prize.getPrizeAmount());
        hbPrizeMapper.updateByPrimaryKey(record);
        HbPrizeRecord hbPrizeRecord = new HbPrizeRecord();
        BeanUtils.copyProperties(prize,hbPrizeRecord);
        hbPrizeRecord.setAccountId(accountDto.getRealtorId());
        hbPrizeRecord.setType(YesNo.NO.getValue());//账号类型(0经纪人,1用户)
        hbPrizeRecord.setPhone(accountDto.getPhone());
        hbPrizeRecordMapper.insert(hbPrizeRecord);
        //调用微信接口发送红包
        BigDecimal hongbaoMoney = record.getPrizeMoney().multiply(new BigDecimal("100"));
        WxSendRedPapperReqDTO wxSendRedPapperReqDTO = new WxSendRedPapperReqDTO();
        wxSendRedPapperReqDTO.setOrderNo(hbPrizeRecord.getId().toString());
        wxSendRedPapperReqDTO.setSendAmount(hongbaoMoney.longValue());
        wxSendRedPapperReqDTO.setWxOpenId(accountDto.getWxOpenId());
        logger.info("hongbaoMoney="+hongbaoMoney+" wxOpenId="+accountDto.getWxOpenId());
        ResultDO<WxSendRedPapperRespDTO> resultDO = wxRealtorAccountService.sendWxRedPapper("sfjjr", wxSendRedPapperReqDTO);
        if(!resultDO.isSuccess()){
            throw  new AppException();
        }
    }
}
