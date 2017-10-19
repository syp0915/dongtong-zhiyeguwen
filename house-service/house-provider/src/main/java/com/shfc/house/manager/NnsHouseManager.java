package com.shfc.house.manager;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.NnsHouseMapper;
import com.shfc.house.dao.NnsHousePublisherMapper;
import com.shfc.house.dao.NnsHouseTagRelMapper;
import com.shfc.house.dao.PlotMapper;
import com.shfc.house.domain.NnsHouse;
import com.shfc.house.domain.NnsHousePublisher;
import com.shfc.house.domain.NnsHouseTagRel;
import com.shfc.house.domain.Plot;
import com.shfc.house.dto.NnsHouseDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustDTO;
import com.shfc.house.enums.NnsHouseAuditStatus;
import com.shfc.house.enums.NnsHouseStatus;
import com.shfc.house.enums.YesNo;
import com.shfc.house.query.NnsHousePublishQuery;
import com.shfc.house.query.NnsProtocolQuery;
import com.shfc.house.utils.HouseCodeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Package com.shfc.house.manager.NnsHouseManager
 * @Description: 997 房源
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/8 10:34
 * version V1.0.0
 */
@Service
public class NnsHouseManager {
    @Autowired
    private NnsHouseMapper nnsHouseMapper;
    @Autowired
    private PlotMapper plotMapper;
    @Autowired
    private NnsHouseTagRelMapper nnsHouseTagRelMapper;
    @Autowired
    private NnsHousePublisherMapper nnsHousePublisherMapper;
    @Autowired
    private NnsEntrustProtocolManager nnsEntrustProtocolManager;

    public Long queryNnsHousePublish(NnsHousePublishQuery query) {

        return nnsHouseMapper.queryNnsHousePublish(query);
    }

    public NnsHouse findHouseById(Long nnsHouseId) {
        return nnsHouseMapper.selectByPrimaryKey(nnsHouseId);
    }

    public NnsHouseDetailDTO findDetailHouseById(Long nnsHouseId) {
        return nnsHouseMapper.findDetailHouseById(nnsHouseId);
    }

    public void updateNnsHouseSelective(NnsHouse nnsHouse) {
        nnsHouseMapper.updateByPrimaryKeySelective(nnsHouse);
    }

    @Transactional
    public ResultDO<Long>  saveNnsHouseEntrust(NnsHouseEntrustDTO dto) throws AppException {
        ResultDO<Long> resultDO = new ResultDO<Long>();
        Plot plot = plotMapper.selectByPrimaryKey(dto.getPlotId());

        //判断房源是否已发布
        NnsHousePublishQuery query = new NnsHousePublishQuery();
        query.setPlotId(dto.getPlotId());
        query.setUnitNo(dto.getUnitNo());
        query.setRoomNo(dto.getRoomNo());
        Long historyHouseId = queryNnsHousePublish(query);

        if(historyHouseId == null){
            //step 1:保存房源
            NnsHouse nnsHouse = new NnsHouse();
            BeanUtils.copyProperties(dto, nnsHouse);

            // 生成房源编号--
            String houseCode = HouseCodeUtils.zshHouseCode() ;
            while(nnsHouseMapper.findHouseByCode(houseCode) != null){
                houseCode = HouseCodeUtils.zshHouseCode() ;
            }
            nnsHouse.setHouseCode(houseCode);
            nnsHouse.setHouseNo(dto.getRoomNo());
            nnsHouse.setPlotName(plot.getPlotName());
            nnsHouse.setLongitude(plot.getLongtitude());
            nnsHouse.setLatitude(plot.getLatitude());
            nnsHouse.setAddress(plot.getPlotAddress());
            nnsHouse.setDistrictId(plot.getDistrictId());
            nnsHouse.setBlockId(plot.getBlockId());
            nnsHouse.setCreater(dto.getRealtorId());
            nnsHouse.setIsDelete(YesNo.NO.getValue());
            nnsHouse.setAuditStatus(NnsHouseAuditStatus.STAY_AUDIT.getValue());
            nnsHouse.setStatus(NnsHouseStatus.STAY_PUTAWAY.getValue());
            nnsHouseMapper.insert(nnsHouse);

            //step 2:保存标签关系
            if(!ValidateHelper.isEmpty(dto.getTagIds())){
                // 标签id不为空
                for(Long tagId: dto.getTagIds()){
                    NnsHouseTagRel tagRel = new NnsHouseTagRel();
                    tagRel.setNnsHouseId(nnsHouse.getId());
                    tagRel.setTagId(tagId);
                    tagRel.setCreater(dto.getRealtorId());
                    nnsHouseTagRelMapper.insert(tagRel);
                }
            }

            //step 3:保存发布记录
            NnsHousePublisher publisher = new NnsHousePublisher();
            publisher.setCreater(dto.getRealtorId());
            publisher.setNnsHouseId(nnsHouse.getId());
            publisher.setPublishId(dto.getRealtorId());
            publisher.setPublishPrice(dto.getTotalPrice());
            publisher.setPublishTime(new Date());
            nnsHousePublisherMapper.insert(publisher);

            historyHouseId = nnsHouse.getId();
            //step 4:调用添加协议-返回协议id结束
            //创建协议入参：经纪人id，房屋id；房价类型；总价；协议url
            NnsProtocolQuery nnsProtocolQuery = new NnsProtocolQuery();
            nnsProtocolQuery.setRealtorId(dto.getRealtorId());
            nnsProtocolQuery.setNnsHouseId(historyHouseId);
            nnsProtocolQuery.setTotalPrice(dto.getTotalPrice());
            nnsProtocolQuery.setPriceType(dto.getPriceType());
            nnsProtocolQuery.setDealUrl(dto.getDealUrl());
            Long protocolId = nnsEntrustProtocolManager.addEntrustProtocol(nnsProtocolQuery);
            resultDO.setSuccess(true);
            resultDO.setData(protocolId);
        }else {
            //根据房源id和经纪人id查询，判断是否是当前经纪人，如果是当前经纪人就不能再创建协议
           List<Long> list =  nnsEntrustProtocolManager.selectExistProtocol(dto.getRealtorId(),historyHouseId);
            if(list!=null && list.size()>0){
                resultDO.setErrMsg("同一个房源同一个经纪人只能发布一次!");
                return resultDO;
            }

            NnsProtocolQuery nnsProtocolQuery = new NnsProtocolQuery();
            nnsProtocolQuery.setRealtorId(dto.getRealtorId());
            nnsProtocolQuery.setNnsHouseId(historyHouseId);
            nnsProtocolQuery.setTotalPrice(dto.getTotalPrice());
            nnsProtocolQuery.setPriceType(dto.getPriceType());
            nnsProtocolQuery.setDealUrl(dto.getDealUrl());
            Long protocolId = nnsEntrustProtocolManager.addEntrustProtocol(nnsProtocolQuery);
            resultDO.setSuccess(true);
            resultDO.setData(protocolId);
        }

        return resultDO;
    }
}
