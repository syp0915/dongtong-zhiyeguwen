package com.shfc.house.manager;

import com.shfc.common.base.ValidateHelper;
import com.shfc.common.exception.AppException;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.*;
import com.shfc.house.domain.*;
import com.shfc.house.dto.RealtorHouseDTO;
import com.shfc.house.dto.RealtorHouseDetailDTO;
import com.shfc.house.dto.RealtorHouseInfoDTO;
import com.shfc.house.utils.HouseCodeUtils;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wuky
 * @version V1.0
 * @create 2017-08-22 14:49
 **/
@Service
public class RealtorHouseManager {

    @Autowired
    private RealtorHouseMapper realtorHouseMapper;

    @Autowired
    private RealtorUnitiveAccountMapper realtorUnitiveAccountMapper;
    @Autowired
    private RealtorHouseTagRelMapper realtorHouseTagRelMapper;
    @Autowired
    private RealtorHouseEntrustProtocolMapper realtorHouseEntrustProtocolMapper;
    @Autowired
    private RealtorHouseStatusFlowMapper realtorHouseStatusFlowMapper;


    /**
     * 经纪人发布房源,保存到数据库
     * @param dto
     * @return
     */
    @Transactional
    public ResultDO<Long> saveRealtorHouse(RealtorHouseDTO dto,Long realtorId)  throws AppException{
        ResultDO<Long> resultDO=new ResultDO<>();
         //step 1
        // 根据小区地址,楼栋号,室号,经纪人Id判断是否已经发过
        RealtorHouse result=realtorHouseMapper.queryHousebyCondition(dto.getImportPlotName(),dto.getUnitNo(),dto.getHouseNo(),realtorId);
        if(result!=null){
            resultDO.setErrMsg("已发布过此房源");
            return resultDO;
        }
        RealtorHouse realtorHouse=new RealtorHouse();
        //step 2 保存房源
        BeanUtils.copyProperties(dto,realtorHouse);
        if(!ValidateHelper.isEmpty(dto.getLongitude())){
            realtorHouse.setLongitude(new BigDecimal(dto.getLongitude()));
        }
        if(!ValidateHelper.isEmpty(dto.getLatitude())){
            realtorHouse.setLatitude(new BigDecimal(dto.getLatitude()));
        }

        if(dto.getPlotId()!=null){
            realtorHouse.setPlotName(dto.getImportPlotName());
        }

        if(dto.getTotalPrice()!=null){
            realtorHouse.setTotalPrice(dto.getTotalPrice().multiply(new BigDecimal(10000)));
        }
        realtorHouse.setAuditStatus(1);//待审核
        realtorHouse.setStatus(3);//下架
        realtorHouse.setIsDelete(1);//未删除
        // 生成房源编号--
        String houseCode = HouseCodeUtils.HouseCode() ;
        while(realtorHouseMapper.findHouseByCode(houseCode) != null){
            houseCode = HouseCodeUtils.HouseCode() ;
        }
        realtorHouse.setHouseCode(houseCode);
        realtorHouse.setRealtorId(realtorId);
        realtorHouse.setModifyTime(new Date());
        realtorHouseMapper.insert(realtorHouse);

        //step 3:保存标签关系
        if(!ValidateHelper.isEmpty(dto.getTags())){
            // 标签id不为空
            for(Long tagId: dto.getTags()){
                addTags(realtorHouse.getId(),tagId,realtorId);
            }
        }
        //step 4 :协议
        if(!ValidateHelper.isEmpty(dto.getEntrustUrl())){
            for(String url:dto.getEntrustUrl()){
              addEntrustUrl(realtorHouse.getId(),url,realtorId);
            }
        }
        //step 5:保存发布记录
        RealtorHouseStatusFlow realtorHouseStatusFlow=new RealtorHouseStatusFlow();
        realtorHouseStatusFlow.setHouseId(realtorHouse.getId());
        realtorHouseStatusFlow.setStatus(1);
        realtorHouseStatusFlowMapper.insert(realtorHouseStatusFlow);

        resultDO.setData(realtorHouse.getId());
        resultDO.setSuccess(true);

        return resultDO;
    }

    /**
     * 修改房源
     * @param dto
     * @return
     */
    @Transactional(rollbackFor = AppException.class)
    public ResultDO modifyRealtorHouse(RealtorHouse realtorHouse,RealtorHouseDTO dto,Long realtorId)  throws AppException{
        ResultDO resultDO=new ResultDO();
//        if(dto.getPlotId()!=null){
//            realtorHouse.setPlotId(dto.getPlotId());
//            realtorHouse.setPlotName(dto.getImportPlotName());
//            realtorHouse.setImportPlotName(dto.getImportPlotName());
//            realtorHouse.setDistrictId(dto.getDistrictId());
//            realtorHouse.setBlockId(dto.getBlockId());
//            realtorHouse.setLongitude(new BigDecimal(dto.getLongitude()));
//            realtorHouse.setLatitude(new BigDecimal(dto.getLatitude()));
//            realtorHouse.setAddress(dto.getAddress());
//        }else {
//            realtorHouse.setPlotId(null);
//            realtorHouse.setPlotName(null);
//            realtorHouse.setDistrictId(null);
//            realtorHouse.setBlockId(null);
//            realtorHouse.setLongitude(null);
//            realtorHouse.setLatitude(null);
//        }
        if(!ValidateHelper.isEmpty(dto.getAddress())){
            realtorHouse.setAddress(dto.getAddress());
        }
        if(!ValidateHelper.isEmpty(dto.getImportPlotName())){
            realtorHouse.setImportPlotName(dto.getImportPlotName());
        }
        if(!ValidateHelper.isEmpty(dto.getUnitNo())){
            realtorHouse.setUnitNo(dto.getUnitNo());
        }
        if(!ValidateHelper.isEmpty(dto.getHouseNo())){
            realtorHouse.setHouseNo(dto.getHouseNo());
        }
        if(!ValidateHelper.isEmpty(dto.getRoom())){
            realtorHouse.setRoom(dto.getRoom());
        }
        if(!ValidateHelper.isEmpty(dto.getHall())){
            realtorHouse.setHall(dto.getHall());
        }
        if(!ValidateHelper.isEmpty(dto.getBathroom())){
            realtorHouse.setBathroom(dto.getBathroom());
        }
        if(!ValidateHelper.isEmpty(dto.getOrientation())){
            realtorHouse.setOrientation(dto.getOrientation());
        }
        if(!ValidateHelper.isEmpty(dto.getFloor())){
            realtorHouse.setFloor(dto.getFloor());
        }
        if(!ValidateHelper.isEmpty(dto.getTotalFloor())){
            realtorHouse.setTotalFloor(dto.getTotalFloor());
        }
        if(!ValidateHelper.isEmpty(dto.getArea())){
            realtorHouse.setArea(dto.getArea());
        }
        if(!ValidateHelper.isEmpty(dto.getTotalPrice())){
            realtorHouse.setTotalPrice(dto.getTotalPrice().multiply(new BigDecimal(10000)));
        }
        realtorHouse.setAuditStatus(1);//审核状态修改为待审核
        realtorHouse.setStatus(3);//下架

        realtorHouseMapper.updateByPrimaryKey(realtorHouse);

        //标签
        if(!ValidateHelper.isEmpty(dto.getTags())){
            realtorHouseTagRelMapper.deleteTagsByHouseId(dto.getHouseId());
            for(Long tagId:dto.getTags()){
                addTags(dto.getHouseId(),tagId,realtorId);
            }
        }else {
            realtorHouseTagRelMapper.deleteTagsByHouseId(dto.getHouseId());

        }
        //协议
        if(!ValidateHelper.isEmpty(dto.getEntrustUrl())){
            realtorHouseEntrustProtocolMapper.deleteEntrustUrlByHouseId(dto.getHouseId());
            for(String url:dto.getEntrustUrl()){
                addEntrustUrl(dto.getHouseId(),url,realtorId);
            }
        }else {
            realtorHouseEntrustProtocolMapper.deleteEntrustUrlByHouseId(dto.getHouseId());
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 保存标签
     * @param houseId,tagId,realTorId
     * @return
     */
    public void addTags(Long houseId,Long tagId,Long realtorId){
        RealtorHouseTagRel realtorHouseTagRel = new RealtorHouseTagRel();
        realtorHouseTagRel.setHouseId(houseId);
        realtorHouseTagRel.setTagId(tagId);
        realtorHouseTagRel.setCreater(realtorId);
        realtorHouseTagRelMapper.insert(realtorHouseTagRel);
    }


    /**
     * 保存协议
     * @param houseId,url,realTorId
     * @return
     */
    public void addEntrustUrl(Long houseId,String url,Long realtorId){
        RealtorHouseEntrustProtocol realtorHouseEntrustProtocol=new RealtorHouseEntrustProtocol();
        realtorHouseEntrustProtocol.setHouseId(houseId);
        realtorHouseEntrustProtocol.setProtocolUrl(url);
        realtorHouseEntrustProtocol.setSource(1);
        realtorHouseEntrustProtocol.setIsDelete(1);
        realtorHouseEntrustProtocol.setCreater(realtorId);
        realtorHouseEntrustProtocolMapper.insert(realtorHouseEntrustProtocol);

    }

    /**
     * 查询经纪人账号是否存在
     * @param realtorId
     * @return
     */
    public RealtorUnitiveAccount findRealtorById(Long realtorId){
        return realtorUnitiveAccountMapper.selectByPrimaryKey(realtorId);
    }

    /**
     * 查询房源是否存在
     * @param houseId
     * @return
     */
    public RealtorHouse findRealtorHouseById(Long houseId){
        return realtorHouseMapper.selectByPrimaryKey(houseId);
    }

    /**
     * 查询二手房列表
     * @param page
     * @return
     */
    public  Page<RealtorHouseInfoDTO> queryHouseList(Page<RealtorHouseInfoDTO> page,Long realtorId){
       realtorHouseMapper.queryHouseList(page,realtorId);
       return page;
    }

    /**
     * 二手房详情
     * @param houseId
     * @return
     */
    public RealtorHouseDetailDTO queryHouseDatail(Long houseId,Long realtorId){
        return realtorHouseMapper.queryHouseDatail(houseId,realtorId);
    }

    /**
     * 二手房上下架、删除操作
     * @param realtorHouse
     * @return
     */
    public int updOperation(RealtorHouse realtorHouse){
        return realtorHouseMapper.updOperation(realtorHouse);
    }
}
