package com.shfc.house.service;

import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.HbPrize;
import com.shfc.house.dto.HbPrizeDTO;
import com.shfc.house.dto.HbRunPrizeDTO;
import com.shfc.house.dto.HbWinPrizeDTO;
import com.shfc.house.dto.RealtorAccoutStatusDTO;
import com.shfc.house.manager.HbPrizeManager;
import com.shfc.house.manager.RealtorInfoManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @Package com.shfc.house.service.ActivityServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/2/15 16:57
 * version V1.0.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    public static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);
    @Autowired
    private HbPrizeManager hbPrizeManager;
    @Autowired
    private RealtorInfoManager realtorInfoManager;

    /**
     *抽奖前判断经纪人是否登录，根据wxOpenId查找绑定记录，有记录则登录
     * @param wxOpenId
     * @return
     */
    public List<RealtorAccoutStatusDTO> loginStatusByOpenId(String wxOpenId){
        return realtorInfoManager.loginStatusByOpenId(wxOpenId);
    }
    @Override
    public synchronized ResultDO<HbWinPrizeDTO> runPrize(HbRunPrizeDTO query) {
        ResultDO<HbWinPrizeDTO> winPrizeResult = new ResultDO<HbWinPrizeDTO>();
        List<HbPrizeDTO> prizes = hbPrizeManager.prizeList();
        if(prizes!=null && prizes.size()>0){
            int selected= 0;
            int i = 0;//做为死循环跳出条件
            try {
                selected = getPrizeIndex(prizes,query);
                while (selected==-1){
                   if(i>50)
                       break;
                   logger.info("selected=="+selected);
                   selected = getPrizeIndex(prizes,query);
                   i++;
                }
                if(selected!=-1){
                    HbPrizeDTO prizeDTO = prizes.get(selected);
                    String prizeName = prizeDTO.getPrizeName();
                    int prizeAmount = prizeDTO.getPrizeAmount();
                    logger.info("抽中的奖品为："+prizeName+"   ,剩余数量="+prizeAmount);
                    HbWinPrizeDTO winPrizeDTO = new HbWinPrizeDTO();
                    winPrizeDTO.setPrizeId(prizeDTO.getPrizeId());
                    winPrizeDTO.setPrizeName(prizeDTO.getPrizeName());
                    winPrizeDTO.setPrizeMoney(prizeDTO.getPrizeMoney());
                    winPrizeResult.setData(winPrizeDTO);
                    winPrizeResult.setSuccess(true);
                    return winPrizeResult;
                }
            } catch (AppException e) {
                logger.error(e);
            }
        }else {
            winPrizeResult.setErrMsg("活动已经结束！");
            return winPrizeResult;
        }
        return winPrizeResult;
    }

    /**
     * 根据Math.random()产生一个double型的随机数，判断每个奖品出现的概率
     * @param prizes
     * @return random：奖品列表prizes中的序列（prizes中的第random个就是抽中的奖品）
     */
    public int getPrizeIndex(List<HbPrizeDTO> prizes,HbRunPrizeDTO query) throws AppException {
        DecimalFormat df = new DecimalFormat("######0.00");
        int random = -1;
        //计算总权重
        double sumWeight = 0;
        for(HbPrizeDTO p : prizes){
            sumWeight += p.getPrizeWeight();
        }
        //产生随机数
        double randomNumber;
        randomNumber = Math.random();
        //根据随机数在所有奖品分布的区域并确定所抽奖品
        double d1 = 0;
        double d2 = 0;
        for(int i=0;i<prizes.size();i++){
            HbPrizeDTO prize = prizes.get(i);
            int amount  = prize.getPrizeAmount();
            if(amount>0){
                d2 += Double.parseDouble(String.valueOf(prizes.get(i).getPrizeWeight()))/sumWeight;
                if(i==0){
                    d1 = 0;
                }else{
                    d1 +=Double.parseDouble(String.valueOf(prizes.get(i-1).getPrizeWeight()))/sumWeight;
                }
                if(randomNumber >= d1 && randomNumber <= d2){
                    random = i;
                    amount--;
                    prize.setPrizeAmount(amount);
                    //更新数据库
                    hbPrizeManager.updatePrizeAmount(prize,query);
                    break;
                }
            }
        }
        return random;
       /* if(random!=-1){
            return random;
        }else {
            return getPrizeIndex(prizes,query);
        }*/
    }
}
