package com.shfc.base.service;

import com.shfc.base.domain.BuildingPoster;
import com.shfc.base.domain.HousePoster;
import com.shfc.base.dto.BuildingPosterDTO;
import com.shfc.base.dto.HousePosterDTO;
import com.shfc.base.dto.TemplateDTO;
import com.shfc.base.manager.TemplateManager;
import com.shfc.common.base.EmojiFilter;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-08-01 16:30
 **/
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    public TemplateManager templateManager;
    @Override
    public ResultDO<List<TemplateDTO>> templateList(Integer type) {
        ResultDO<List<TemplateDTO>> resultDO=new ResultDO<>();

        if(type==null){
            resultDO.setErrMsg("必传参数不可为空");
            return resultDO;
        }

        List<TemplateDTO> list=templateManager.templateList(type);
        resultDO.setData(list);
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public TemplateDTO queryTemplate(Long templateId,Long type) {

        return templateManager.queryTemplateById(templateId,type);
    }

    @Override
    public ResultDO<Long> addHousePoster(HousePosterDTO housePosterDTO) {
        ResultDO<Long> resultDO=new ResultDO<>();

        String result=checkHouseParam(housePosterDTO);
        if(!ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg(result);
            return resultDO;
        }

        housePosterDTO.setHouseDetail(EmojiFilter.filterEmoji(housePosterDTO.getHouseDetail()));

        //新增二手房海报内容
        if(housePosterDTO.getId()==null){
            resultDO.setData(templateManager.addHousePoster(housePosterDTO));
        }else {
            HousePoster housePoster=templateManager.queryHousePoster(housePosterDTO.getId());
            if(housePoster==null){
                resultDO.setErrMsg("二手房id找不到对应的海报内容");
                return resultDO;
            }
            resultDO.setData(templateManager.updateHousePoster(housePosterDTO));
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    public String checkHouseParam(HousePosterDTO housePosterDTO){
        if(ValidateHelper.isEmpty(housePosterDTO.getHousePictureUrl())){
            return "房源图片不能为空";
        }
        if(ValidateHelper.isEmpty(housePosterDTO.getPosterTopic())){
            return "海报主题不能为空";
        }
        if(ValidateHelper.isEmpty(housePosterDTO.getRoom())||ValidateHelper.isEmpty(housePosterDTO.getHall())||ValidateHelper.isEmpty(housePosterDTO.getBathroom())){
            return "户型信息不能为空";
        }
//        if(ValidateHelper.isEmpty(housePosterDTO.getFloor())||ValidateHelper.isEmpty(housePosterDTO.getTotalFloor())){
//            return "楼层不能为空";
//        }
        if(ValidateHelper.isEmpty(housePosterDTO.getArea())){
            return "面积不能为空";
        }
        if(ValidateHelper.isEmpty(housePosterDTO.getPrice())){
            return "价格不能为空";
        }

//        if(ValidateHelper.isEmpty(housePosterDTO.getTags())){
//            return "标签不能为空";
//        }
        if(ValidateHelper.isEmpty(housePosterDTO.getHouseDetail())){
            return "房源描述不能为空";
        }
        if(ValidateHelper.isEmpty(housePosterDTO.getOrientation())){
            return "朝向不能为空";
        }
        return null;
    }

//    @Override
//    public ResultDO<TempLateDetailDTO> describeHousePoster(Long templateId, Long houseId) {
//        ResultDO<TempLateDetailDTO> resultDO=new ResultDO<>();
//        TempLateDetailDTO dto=new TempLateDetailDTO();
//        if(templateId==null||houseId==null){
//            resultDO.setErrMsg("请求参数不可为空");
//            return resultDO;
//        }
//        //根据模板Id取模板
//        TemplateDTO templateDTO=templateManager.queryTemplateById(templateId,2L);
//        if(templateDTO==null){
//            resultDO.setErrMsg("模板不存在");
//            return resultDO;
//        }
//        //根据houseId去房源
//        HousePoster housePoster=templateManager.queryHousePoster(houseId);
//        if(housePoster==null){
//            resultDO.setErrMsg("房源信息异常");
//            return resultDO;
//        }
//        List<String> list=templateManager.tempColorList(templateId);
//        dto.setBgColor(list);
//
//        //所在楼层：1：低、2：中、3：高
//        String floor;
//        if(housePoster.getFloor()!=null){
//            switch (housePoster.getFloor()){
//                case 1:floor= FloorType.LOW.getName();
//                    break;
//                case 2:floor=FloorType.MIDDLE.getName();
//                    break;
//                case 3:floor=FloorType.HIGN.getName();
//                    break;
//                default:floor="";
//                    break;
//            }
//        }
//        //1：东 2：南 3：西 4：北 5：东南 6：东北 7：西南 8：西北 9：东西 10：南北
//        String orientation;
//        if(housePoster.getOrientation()!=null){
//            switch (housePoster.getOrientation()){
//                case 1:orientation= Orientation.EAST.getName();
//                    break;
//                case 2:orientation=Orientation.SOUTH.getName();
//                    break;
//                case 4:orientation=Orientation.WEST.getName();
//                    break;
//                case 5:orientation=Orientation.NORTH.getName();
//                    break;
//                case 6:orientation=Orientation.NORTHEAST.getName();
//                    break;
//                case 7:orientation=Orientation.SOUTHWEST.getName();
//                    break;
//                case 8:orientation=Orientation.NORTHWEST.getName();
//                    break;
//                case 9:orientation=Orientation.WESTEAST.getName();
//                    break;
//                case 10:orientation=Orientation.NORTHSOUTH.getName();
//                    break;
//                default:orientation="";
//                    break;
//            }
//        }
//        //户型
//        StringBuffer houseType=new StringBuffer();
//        if(housePoster.getRoom()!=null){
//            houseType.append(housePoster.getRoom()).append("室");
//        }
//        if(housePoster.getHall()!=null){
//            houseType.append(housePoster.getHall()).append("厅");
//        }
//        if(housePoster.getBathroom()!=null) {
//            houseType.append(housePoster.getBathroom()).append("卫");
//        }
//
//        String template=templateDTO.getTemplate().replace("!{totalPrice}",housePoster.getPlotName()).replace("!{address}",housePoster.getPlotName()).replace("!{effectiveDate}",housePoster.getLatitude());
//        template= HtmlUtils.htmlEscape(template);
//        dto.setTemplate(template);
//        dto.setTemplateTitle(templateDTO.getTemplateTitle());
//        dto.setLongitude(housePoster.getLongitude());
//        dto.setLatitude(housePoster.getLatitude());
//        resultDO.setData(dto);
//        resultDO.setSuccess(true);
//        return resultDO;
//    }

    @Override
    public ResultDO<Long> addBuildingPoster(BuildingPosterDTO buildingPosterDTO) {
        ResultDO<Long> resultDO=new ResultDO<>();
        String result=checkBuildingParam(buildingPosterDTO);
        if(!ValidateHelper.isEmpty(result)){
            resultDO.setErrMsg(result);
            return resultDO;
        }
        buildingPosterDTO.setSellingPoints(EmojiFilter.filterEmoji(buildingPosterDTO.getSellingPoints()));

        if(buildingPosterDTO.getId()==null){//新增
            resultDO.setData(templateManager.addBuildingPoster(buildingPosterDTO));
        }else {//修改
            BuildingPoster buildingPoster=templateManager.queryBuildingPoster(buildingPosterDTO.getId());
            if(buildingPoster==null){
                resultDO.setErrMsg("找不到相应的自有楼盘");
                return resultDO;
            }
            resultDO.setData(templateManager.updateBuildingPoster(buildingPosterDTO));

        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    public String checkBuildingParam(BuildingPosterDTO buildingPosterDTO){
        if(ValidateHelper.isEmpty(buildingPosterDTO.getBuildingPictureUrl())){
            return "楼盘图片不能为空";
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getPosterTopic())){
            return "海报主题不能为空";
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getOpenTime())){
            return "开盘不能为空";
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getArea())){
            return "所在区域不能为空";
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getSalePrice())){
            return "销售价格不能为空";
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getSaleModel())){
            return "销售户型不能为空";
        }

        if(ValidateHelper.isEmpty(buildingPosterDTO.getSaleArea())){
            return "销售面积不能为空";
        }
        if(ValidateHelper.isEmpty(buildingPosterDTO.getSellingPoints())){
            return "楼盘卖点不能为空";
        }
        return null;
    }


//    @Override
//    public ResultDO<TempLateDetailDTO> describeBuildingPoster(Long templateId, Long buildingId) {
//        ResultDO<TempLateDetailDTO> resultDO=new ResultDO<>();
//        TempLateDetailDTO dto=new TempLateDetailDTO();
//        if(templateId==null||buildingId==null){
//            resultDO.setErrMsg("请求参数不可为空");
//            return resultDO;
//        }
//        //根据模板Id取模板
//        TemplateDTO templateDTO=templateManager.queryTemplateById(templateId,1L);
//        if(templateDTO==null){
//            resultDO.setErrMsg("模板不存在");
//            return resultDO;
//        }
//        //根据houseId去房源
//        BuildingPoster buildingPoster=templateManager.queryBuildingPoster(buildingId);
//        if(buildingPoster==null){
//            resultDO.setErrMsg("房源信息异常");
//            return resultDO;
//        }
//        List<String> list=templateManager.tempColorList(templateId);
//        dto.setBgColor(list);
//
//        String template=templateDTO.getTemplate().replace("!{totalPrice}",buildingPoster.getBuildingName()).replace("!{address}",buildingPoster.getBuildingAddress()).replace("!{effectiveDate}",buildingPoster.getLatitude());
//        template= HtmlUtils.htmlEscape(template);
//        dto.setTemplate(template);
//        dto.setTemplateTitle(templateDTO.getTemplateTitle());
//        dto.setLongitude(buildingPoster.getLongitude());
//        dto.setLatitude(buildingPoster.getLatitude());
//        resultDO.setData(dto);
//        resultDO.setSuccess(true);
//        return resultDO;
//    }


}
