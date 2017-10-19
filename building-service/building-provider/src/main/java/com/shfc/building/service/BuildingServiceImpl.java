package com.shfc.building.service;

import com.shfc.base.service.TemplateService;
import com.shfc.building.base.BaseServiceImpl;
import com.shfc.building.constants.ErrorConstant;
import com.shfc.building.dto.BuildingBasicDetailDTO;
import com.shfc.building.dto.BuildingDTO;
import com.shfc.building.dto.BuildingListBeanDTO;
import com.shfc.building.dto.BuildingListRespDTO;
import com.shfc.building.manager.BuildingAttentionManager;
import com.shfc.building.manager.BuildingManager;
import com.shfc.building.query.BuildingListQuery;
import com.shfc.building.query.RealtorAttentionBuildingListQuery;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import com.shfc.mybatis.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @File com.shfc.building.service.implParkBuildingServiceImpl.java
 * @Description: TODO Copyright: Copyright (c) 2016 Company:上海房产
 * 
 * @author ljgllxyz
 * @date 上午11:02:33
 * @version V1.0
 */
@Service
public class BuildingServiceImpl extends BaseServiceImpl implements BuildingService {

    @Autowired(required = false)
    private BuildingManager buildingManager;

    @Autowired(required = false)
    private BuildingAttentionManager buildingAttentionManager;

    @Autowired(required = false)
    private TemplateService templateService;


    /**
     * 查询楼盘列表
     * @param keyword
     * @param districtId
     * @param blockId
     * @param maxPrice
     * @param minPrice
     * @param roomCount
     * @param ownerType
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @Override
    public ResultDO<BuildingListRespDTO> getBuildingList(String keyword, Long districtId, Long blockId, BigDecimal maxPrice, BigDecimal minPrice, Integer roomCount, Integer ownerType, Integer pageSize, Integer pageNumber) {
        ResultDO<BuildingListRespDTO> resultDO = new ResultDO<>();
        if (ValidateHelper.isEmpty(pageSize) || ValidateHelper.isEmpty(pageNumber)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        BuildingListQuery params = new BuildingListQuery();
        if (!ValidateHelper.isEmpty(keyword)){
            params.setKeyword(keyword);
        }else {
            params.setDistrictId(districtId);
            if (!ValidateHelper.isEmpty(blockId)){
                params.setBlockId(blockId);
                params.setDistrictId(districtId);
            }
            params.setMaxPrice(maxPrice);
            params.setMinPrice(minPrice);
            params.setRoomCount(roomCount);
            params.setOwnerType(ownerType);
        }
        Page<BuildingListBeanDTO> query = buildingManager.getBuildingListByCondition(params, pageSize, pageNumber);
        if (query == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.DB_OPR_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.DB_OPR_EXCEPTION.getMsg());
            return resultDO;
        }
        BuildingListRespDTO buildingListRespDTO = new BuildingListRespDTO();
        buildingListRespDTO.setPageNumber(query.getPageNumber());
        buildingListRespDTO.setPageSize(query.getPageSize());
        buildingListRespDTO.setTotalCount(query.getTotalSize().intValue());
        buildingListRespDTO.setBuildingList(query.getData());

        resultDO.setSuccess(true);
        resultDO.setErrCode(ErrorConstant.SUCCESS.getCode());
        resultDO.setErrMsg(ErrorConstant.SUCCESS.getMsg());
        resultDO.setData(buildingListRespDTO);
        return resultDO;
    }

    /**
     * 获取指定经纪人关注的楼盘列表
     *
     * @param realtorId
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @Override
    public ResultDO<BuildingListRespDTO> getBuildingAttentionList(Long realtorId, Integer pageSize, Integer pageNumber) {
        ResultDO<BuildingListRespDTO> resultDO = new ResultDO<>();
        if (ValidateHelper.isEmpty(realtorId) || ValidateHelper.isEmpty(pageNumber) || ValidateHelper.isEmpty(pageSize)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        RealtorAttentionBuildingListQuery params = new RealtorAttentionBuildingListQuery();
        params.setRealtorId(realtorId);
        Page<BuildingListBeanDTO> query = buildingManager.getRealtorAttentionBuildingList(params, pageSize, pageNumber);
        if (query == null){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.DB_OPR_EXCEPTION.getCode());
            resultDO.setErrMsg(ErrorConstant.DB_OPR_EXCEPTION.getMsg());
            return resultDO;
        }
        BuildingListRespDTO buildingListRespDTO = new BuildingListRespDTO();
        buildingListRespDTO.setPageNumber(query.getPageNumber());
        buildingListRespDTO.setPageSize(query.getPageSize());
        buildingListRespDTO.setTotalCount(query.getTotalSize().intValue());
        buildingListRespDTO.setBuildingList(query.getData());

        resultDO.setSuccess(true);
        resultDO.setErrCode(ErrorConstant.SUCCESS.getCode());
        resultDO.setErrMsg(ErrorConstant.SUCCESS.getMsg());
        resultDO.setData(buildingListRespDTO);
        return resultDO;
    }

    @Override
    public ResultDO<BuildingListRespDTO> recommendBuilding(Integer count,String longitude, String latitude) {
        ResultDO<BuildingListRespDTO> resultDO=new ResultDO<>();

        BuildingListRespDTO buildingListRespDTO=new BuildingListRespDTO();
        List<BuildingListBeanDTO> list=null;
        if(!ValidateHelper.isEmpty(longitude)&&!ValidateHelper.isEmpty(latitude)) {
            list = buildingManager.recommendBuilding(count, latitude, longitude,null);
//            if(list.size()!=0&&list.size()<count){//经纬度周边不足count时,拉取列表补充
//                List<Long> buildingIds=new ArrayList<>();
//                for(BuildingListBeanDTO dto:list){
//                    buildingIds.add(dto.getBuildingId());
//                }
//                List<BuildingListBeanDTO> adList=buildingManager.recommendBuilding(count-list.size(),"","",buildingIds);
//                if(adList!=null&&adList.size()>0){
//                    list.addAll(adList);
//                }
//            }
//            if(list==null||list.size()==0){//经纬度没有时,按照列表顺序推荐前三套
//                list=buildingManager.recommendBuilding(count,"","",null);
//            }

        }else {//按照列表顺序推荐前count套
            list=buildingManager.recommendBuilding(count,"","",null);
        }
        buildingListRespDTO.setBuildingList(list);
        resultDO.setData(buildingListRespDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<BuildingBasicDetailDTO> buildingBasicDetail(Long realtorId,Long buildingId) {
        ResultDO<BuildingBasicDetailDTO> resultDO=new ResultDO<>();
        if (buildingId==null){
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }

        BuildingBasicDetailDTO buildingBasicDetailDTO=buildingManager.queryBuildingDetail(buildingId);
        if(buildingBasicDetailDTO==null){
            resultDO.setErrCode(ErrorConstant.OBJECT_NOT_EXIST.getCode());
            resultDO.setErrMsg(ErrorConstant.OBJECT_NOT_EXIST.getMsg());
            return resultDO;
        }

        boolean result=buildingAttentionManager.checkIsAttentionExist(realtorId,buildingId);
        buildingBasicDetailDTO.setAttention(result);
        resultDO.setData(buildingBasicDetailDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 新房关注操作
     *
     * @param realtorId
     * @param buildingId
     * @param oprType
     * @return
     */
    @Override
    public ResultDO operateBuildingAttention(Long realtorId, Long buildingId, Integer oprType) {
        ResultDO resultDO = new ResultDO();
        if (ValidateHelper.isEmpty(buildingId) || ValidateHelper.isEmpty(oprType) || ValidateHelper.isEmpty(realtorId)){
            resultDO.setSuccess(false);
            resultDO.setErrCode(ErrorConstant.NULL_PARAMETER.getCode());
            resultDO.setErrMsg(ErrorConstant.NULL_PARAMETER.getMsg());
            return resultDO;
        }
        boolean attentionFlag = buildingAttentionManager.checkIsAttentionExist(realtorId, buildingId);
        if (oprType == 0){//执行关注操作
            if (attentionFlag){//已经关注了
                resultDO.setSuccess(false);
                resultDO.setErrCode(ErrorConstant.HAS_ATTENTEND.getCode());
                resultDO.setErrMsg(ErrorConstant.HAS_ATTENTEND.getMsg());
                return resultDO;
            }
            if (!buildingAttentionManager.setAttention(realtorId, buildingId)){
                resultDO.setSuccess(false);
                resultDO.setErrCode(ErrorConstant.DB_OPR_EXCEPTION.getCode());
                resultDO.setErrMsg(ErrorConstant.DB_OPR_EXCEPTION.getMsg());
                return resultDO;
            }
        }else {//执行取消关注
            if (!attentionFlag){//不存在关注关系
                resultDO.setSuccess(false);
                resultDO.setErrCode(ErrorConstant.ATTENTION_NOT_EXIST.getCode());
                resultDO.setErrMsg(ErrorConstant.ATTENTION_NOT_EXIST.getMsg());
                return resultDO;
            }
            if (!buildingAttentionManager.cancelAttention(realtorId, buildingId)){
                resultDO.setSuccess(false);
                resultDO.setErrCode(ErrorConstant.DB_OPR_EXCEPTION.getCode());
                resultDO.setErrMsg(ErrorConstant.DB_OPR_EXCEPTION.getMsg());
                return resultDO;
            }
        }
        resultDO.setSuccess(true);
        resultDO.setErrCode(ErrorConstant.SUCCESS.getCode());
        resultDO.setErrMsg(ErrorConstant.SUCCESS.getMsg());
        return resultDO;
    }

//    @Override
//    public ResultDO<PosterDTO> buildingPoster(Long buildingId,Long templateId,BuildingDTO buildingDTO) {
//        ResultDO<PosterDTO> resultDO=new ResultDO<>();
//        PosterDTO posterDTO=new PosterDTO();
//
//        TemplateDTO templateDTO=templateService.queryTemplate(templateId,1L);
//        if(templateDTO==null){
//            resultDO.setErrMsg("模板不存在");
//            return resultDO;
//        }
//
//        if(ValidateHelper.isEmpty(buildingDTO.getBuildingName())){//直接取新房详情数据
//            BuildingBasicDetailDTO detailDTO=buildingManager.queryBuildingDetail(buildingId);
//            if(detailDTO==null){
//                resultDO.setErrCode(ErrorConstant.OBJECT_NOT_EXIST.getCode());
//                resultDO.setErrMsg(ErrorConstant.OBJECT_NOT_EXIST.getMsg());
//                return resultDO;
//            }
//
//            //户型,面积查询
//            BuildingDTO dto=buildingManager.queryAreaAndModel(buildingId);
//            if(dto==null){
//                resultDO.setErrMsg("户型信息为空");
//                return resultDO;
//            }
//            BeanUtils.copyProperties(dto,buildingDTO);
//
//            buildingDTO.setBuildingName(detailDTO.getBuildingName());
//            buildingDTO.setBuildingAddress(detailDTO.getBuildingAddress());
//            List list=new ArrayList();
//            list.add(detailDTO.getPicList().get(0));
//            buildingDTO.setBuildingPicUrl(list);
//            buildingDTO.setPosterTopic(templateDTO.getTemplateTitle());
//            buildingDTO.setOpenTime(detailDTO.getOpenDate());
//            buildingDTO.setArea(detailDTO.getDistrictName()+"-"+detailDTO.getBlockName());
//            if(detailDTO.getAreaAveragePrice()!=null){
//                buildingDTO.setSalePrice(String.valueOf(detailDTO.getAreaAveragePrice()));
//            }else if(detailDTO.getHouseAveragePrice()!=null){
//                buildingDTO.setSalePrice(String.valueOf(detailDTO.getHouseAveragePrice()));
//            }
//        }
//        if(ValidateHelper.isEmpty(buildingDTO.getSellingPoints())){
//            buildingDTO.setSellingPoints("交通出行便利，教育、医疗、商场配套齐全!");
//        }
//
//        String template=templateDTO.getTemplate().replace("!{totalPrice}",buildingDTO.getBuildingName()).
//                replace("!{address}",buildingDTO.getBuildingAddress())
//                .replace("!{effectiveDate}",buildingDTO.getSaleModel());
//        template= HtmlUtils.htmlEscape(template);
//        posterDTO.setBuildingId(buildingId);
//        posterDTO.setTemplateTitle(templateDTO.getTemplateTitle());
//        posterDTO.setTemplate(template);
//        resultDO.setData(posterDTO);
//        resultDO.setSuccess(true);
//        return resultDO;
//
//    }

    @Override
    public ResultDO<BuildingDTO> queryBuildingPoster(Long buildingId) {
        ResultDO<BuildingDTO> resultDO=new ResultDO<>();
        if(buildingId==null){
            resultDO.setErrMsg("楼盘Id不能为空");
            return resultDO;
        }
        BuildingDTO buildingDTO=new BuildingDTO();
        BuildingBasicDetailDTO detailDTO=buildingManager.queryBuildingDetail(buildingId);
        if(detailDTO==null){
            resultDO.setErrCode(ErrorConstant.OBJECT_NOT_EXIST.getCode());
            resultDO.setErrMsg(ErrorConstant.OBJECT_NOT_EXIST.getMsg());
            return resultDO;
        }

        //户型,面积查询
        BuildingDTO dto=buildingManager.queryAreaAndModel(buildingId);
        if(dto!=null){
            BeanUtils.copyProperties(dto,buildingDTO);
        }


        buildingDTO.setBuildingName(detailDTO.getBuildingName());
        buildingDTO.setBuildingAddress(detailDTO.getBuildingAddress());
        buildingDTO.setBuildingPicUrl(detailDTO.getPicList());
        buildingDTO.setOpenTime(detailDTO.getOpenDate());
        StringBuilder saleArea=new StringBuilder();
        if(!ValidateHelper.isEmpty(detailDTO.getDistrictName())){
            saleArea.append(detailDTO.getDistrictName()).append("-");
        }
        if(!ValidateHelper.isEmpty(detailDTO.getBlockName())){
            saleArea.append(detailDTO.getBlockName());
        }
        buildingDTO.setArea(saleArea.toString());
        if(!ValidateHelper.isEmpty(detailDTO.getAreaAveragePrice().toString())&& !detailDTO.getAreaAveragePrice().toString().equals("0.00")){
            buildingDTO.setSalePrice(String.valueOf(detailDTO.getAreaAveragePrice()+"元/平"));
        }else if(!ValidateHelper.isEmpty(detailDTO.getHouseAveragePrice())&&!detailDTO.getHouseAveragePrice().toString().equals("0.00")){
            buildingDTO.setSalePrice(String.valueOf(detailDTO.getHouseAveragePrice()+"万元/套"));
        }else {
            buildingDTO.setSalePrice("售价待定");
        }


        resultDO.setData(buildingDTO);
        resultDO.setSuccess(true);
        return resultDO;
    }
}
