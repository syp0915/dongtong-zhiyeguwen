package com.shfc.house.manager;

import com.shfc.base.dto.SysMessageDTO;
import com.shfc.base.enums.SysMessageFrom;
import com.shfc.base.enums.SysMessageType;
import com.shfc.base.enums.SysMessageUserType;
import com.shfc.base.service.SysMessageService;
import com.shfc.common.exception.AppException;
import com.shfc.common.math.RandomUtils;
import com.shfc.house.dao.NnsEntrustProtocolMapper;
import com.shfc.house.dao.NnsEntrustProtocolWorkflowMapper;
import com.shfc.house.dao.NnsHouseMapper;
import com.shfc.house.domain.NnsEntrustProtocol;
import com.shfc.house.domain.NnsEntrustProtocolWorkflow;
import com.shfc.house.domain.NnsHouse;
import com.shfc.house.dto.NnsEntrustWorkflowDTO;
import com.shfc.house.dto.NnsHouseEntrustDetailDTO;
import com.shfc.house.dto.NnsHouseEntrustListDTO;
import com.shfc.house.dto.PastProtocolDTO;
import com.shfc.house.enums.NnsProtocolStatus;
import com.shfc.house.enums.YesNo;
import com.shfc.house.query.NnsProtocolQuery;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Package com.shfc.house.manager.NnsEntrustProtocolManager
 * @Description: 委托协议管理
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author xiehaibin
 * @date 2017/1/12 15:09
 * version V1.0.0
 */
@Service
public class NnsEntrustProtocolManager {

    @Value("${nns.entrust.protocol}")
    private String ENTRUSTPROTOCOL; // 协议富文本

    @Autowired
    private NnsEntrustProtocolMapper nnsEntrustProtocolMapper;
    @Autowired
    private NnsEntrustProtocolWorkflowMapper nnsEntrustProtocolWorkflowMapper;
    @Autowired
    private SysMessageService sysMessageService;
    @Autowired
    private NnsHouseMapper nnsHouseMapper;

    /**
     * @Description: 新增协议
     * @Title saveProtocol
     * @Author  lv bin
     * @Date 2017/1/13 15:10
     * @param  protocolUrl, houseId
     * @return java.lang.Long
     * @throws
     */
    public Long  saveProtocol(String protocolUrl, Long houseId){

        NnsHouse house = nnsHouseMapper.selectByPrimaryKey(houseId);

        BigDecimal totalPrice = house.getTotalPrice();

        String address = new StringBuilder(house.getAddress()).
                append(house.getUnitNo()).append("楼").
                append(house.getHouseNo()).append("室").toString();

        String protocol = ENTRUSTPROTOCOL.replace("!{totalPrice}", String.valueOf(totalPrice)).replace("!{address}", address);

        protocol = HtmlUtils.htmlEscape(protocol);

        System.out.println(protocol);

        return null;
    }

    /**
     * 新增协议
     * @param query
     * @return
     * @throws AppException
     */
    @Transactional(rollbackFor = AppException.class)
    public Long addEntrustProtocol(NnsProtocolQuery query) throws AppException{
        NnsHouse house = nnsHouseMapper.selectByPrimaryKey(query.getNnsHouseId());
        BigDecimal totalPrice = house.getTotalPrice();
        String address = new StringBuilder(house.getAddress()).
                append(house.getUnitNo()).append("楼").
                append(house.getHouseNo()).append("室").toString();
        String protocol = ENTRUSTPROTOCOL.replace("!{totalPrice}", String.valueOf(totalPrice)).replace("!{address}", address)
                .replace("!{effectiveDate}"," ");
        protocol = HtmlUtils.htmlEscape(protocol);//生成协议文本
        NnsEntrustProtocol record = new NnsEntrustProtocol();
        record.setRealtorId(query.getRealtorId());
        record.setNnsHouseId(query.getNnsHouseId());
        record.setPriceType(query.getPriceType());
        record.setTotalPrice(query.getTotalPrice());
        record.setProtocolNumber("CA".concat(RandomUtils.generateNumberString(8)));
        if(!StringUtils.isEmpty(query.getDealUrl())){
            //协议类型(0-在线签订，1-拍照上传)
            record.setType(YesNo.YES.getValue());
            record.setDealUrl(query.getDealUrl());
            record.setStatus(NnsProtocolStatus.OFFLINE_SIGN.getValue());
        }else {
            record.setType(YesNo.NO.getValue());
            record.setProtocolContent(protocol);
            record.setStatus(NnsProtocolStatus.WAIT_SIGN.getValue());
        }
        nnsEntrustProtocolMapper.insert(record);
        NnsEntrustProtocolWorkflow workflowRecord = new NnsEntrustProtocolWorkflow();
        workflowRecord.setProtocolId(record.getId());
        workflowRecord.setCreater(record.getRealtorId());
        workflowRecord.setCreaterType(YesNo.NO.getValue());
        if(!StringUtils.isEmpty(query.getDealUrl())){
            workflowRecord.setProtocolStatus(NnsProtocolStatus.OFFLINE_SIGN.getValue());
        }else {
            workflowRecord.setProtocolStatus(NnsProtocolStatus.WAIT_SIGN.getValue());
        }
        nnsEntrustProtocolWorkflowMapper.insert(workflowRecord);
        return record.getId();
    }

    public List<Long> selectExistProtocol(Long realtorId,Long nnsHouseId){
        return nnsEntrustProtocolMapper.selectExistProtocol(realtorId,nnsHouseId);
    }
    public Page<NnsHouseEntrustListDTO> houseEntrustList(Long realtorId, Page page){
        nnsEntrustProtocolMapper.houseEntrustList(realtorId,page);
       return page;
    }

    public NnsHouseEntrustDetailDTO houseEntrustDetail(Long protocolId){
        return nnsEntrustProtocolMapper.houseEntrustDetail(protocolId);
    }
    public List<NnsEntrustWorkflowDTO> entrustWorkflowList(Long protocolId){
        return nnsEntrustProtocolWorkflowMapper.entrustWorkflowList(protocolId);
    }

    //用户更新协议
    @Transactional(rollbackFor = AppException.class)
    public void userUpdateProtocol(NnsEntrustProtocol record) throws AppException{
        nnsEntrustProtocolMapper.updateByPrimaryKey(record);
    }

    public NnsEntrustProtocol selectProtocolById(Long protocolId){
        return nnsEntrustProtocolMapper.selectByPrimaryKey(protocolId);
    }

    /**
     * 定时任务更新协议最后有效期
     */
    @Transactional(rollbackFor = AppException.class)
    public List<PastProtocolDTO> updatePastProtocol() throws AppException{
        List<PastProtocolDTO> protocolList =  nnsEntrustProtocolMapper.selectPastProtocol();
        for (PastProtocolDTO protocol : protocolList){
            //协议状态置为过期
            nnsEntrustProtocolMapper.updatePastProtocol(protocol.getProtocolId());
            //新增一条协议流
            NnsEntrustProtocolWorkflow workflowRecord = new NnsEntrustProtocolWorkflow();
            workflowRecord.setProtocolId(protocol.getProtocolId());
            workflowRecord.setProtocolStatus(NnsProtocolStatus.OVERDUE_SIGN.getValue());
            workflowRecord.setCreater(-1L);
            workflowRecord.setCreaterType(2);
            nnsEntrustProtocolWorkflowMapper.insert(workflowRecord);
            //新增通知
            SysMessageDTO sysMessageDTO = new SysMessageDTO();
            sysMessageDTO.setMesFrom(SysMessageFrom.TV_997.getValue());
            sysMessageDTO.setMesType(SysMessageType.ENTRUST_COWRY.getValue());
            sysMessageDTO.setBizId(protocol.getProtocolId());
            sysMessageDTO.setUserId(protocol.getRealtorId());
            sysMessageDTO.setUserType(SysMessageUserType.REALTOR.getValue());
            sysMessageDTO.setMesDigest("协议已过期");
            StringBuffer sbf = new StringBuffer();
            sbf.append("该协议约定于").append(protocol.getOverdueTime()).append("过期，协议已经失效。");
            sysMessageDTO.setMesContent(sbf.toString());
            try {
                sysMessageService.addMessage(sysMessageDTO);
            } catch (AppException e) {
                throw  new AppException();
            }
        }
        return protocolList;
    }

    /**
     * 根据id查询委托协议
     * @param id
     * @return
     */
    public  NnsEntrustProtocol selectByPrimaryKey(Long id){
        return nnsEntrustProtocolMapper.selectByPrimaryKey(id);
    }

    /**
     * 发送签署短信-查询小区名称
     * @param protocolId
     * @return
     */
    public String findPlotNameByProtocolId(Long protocolId){
        return nnsEntrustProtocolMapper.findPlotNameByProtocolId(protocolId);
    }
}
