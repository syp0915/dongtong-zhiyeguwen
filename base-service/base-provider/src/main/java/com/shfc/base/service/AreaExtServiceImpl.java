package com.shfc.base.service;

import com.fc.common.redis.RedisUtil;
import com.shfc.base.domain.BaseBlock;
import com.shfc.base.domain.BaseDistrict;
import com.shfc.base.dto.BlockInfoDTO;
import com.shfc.base.dto.RegionInfoDTO;
import com.shfc.base.manager.AreaExtManager;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2016-12-30 09:30
 **/
@Service
public class AreaExtServiceImpl implements AreaExtService {
    public static final Logger LOGGER = Logger.getLogger(AreaExtServiceImpl.class);

    @Autowired
    private AreaExtManager areaExtManager;
    @Override
    public ResultDO<List<RegionInfoDTO>> getRegionBlockInfo(String cityId) {
        ResultDO<List<RegionInfoDTO>> resultDO=new ResultDO<List<RegionInfoDTO>>();
        try {

            if (cityId == null || "".equals(cityId)) {
                resultDO.setErrMsg("请求参数不能为空");
                return resultDO;
            }

            Object object= RedisUtil.get("BASE_AREA"+cityId);
            if(object!=null){
                List<RegionInfoDTO> list=(List<RegionInfoDTO>)object;
                resultDO.setData(list);
                resultDO.setSuccess(true);
                return resultDO;
            }

            //查询区域
            List<BaseDistrict> districts = areaExtManager.selectByCityId(cityId);
            if (districts.size() == 0) {
                resultDO.setErrMsg("请求参数错误或者请求对象不存在");
                return resultDO;
            }



            List<RegionInfoDTO> list = new ArrayList<RegionInfoDTO>();

            for (BaseDistrict baseDistrict : districts) {
                RegionInfoDTO regionInfoDTO = new RegionInfoDTO();
                regionInfoDTO.setRegionId(String.valueOf(baseDistrict.getId()));
                regionInfoDTO.setRegionName(baseDistrict.getDistrictName());

                List<BlockInfoDTO> blockList = new ArrayList<BlockInfoDTO>();
                // 查询区县下的街道、镇
                List<BaseBlock> blocks = areaExtManager.selectByDistrictId(baseDistrict.getId());

                for (BaseBlock baseBlock : blocks) {
                    BlockInfoDTO blockInfoDTO = new BlockInfoDTO();
                    blockInfoDTO.setBlockId(String.valueOf(baseBlock.getId()));
                    blockInfoDTO.setBlockName(baseBlock.getBlockName());
                    blockList.add(blockInfoDTO);
                }
                regionInfoDTO.setBlockList(blockList);
                list.add(regionInfoDTO);

            }
            resultDO.setData(list);

            if(!ValidateHelper.isEmpty(resultDO.getData())){
                RedisUtil.set("BASE_AREA"+cityId, resultDO.getData(), 3600);
            }

            resultDO.setSuccess(true);
        }catch (Exception e){
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }

    @Override
    public ResultDO<List<BlockInfoDTO>> queryBlock(String districtId) {
        ResultDO<List<BlockInfoDTO>> resultDO=new ResultDO<List<BlockInfoDTO>>();
        if(ValidateHelper.isEmpty(districtId)){

            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }
        Object object= RedisUtil.get("BASE_SERVICE_BLOCKINFO"+districtId);
        if(object!=null){
            List<BlockInfoDTO> list=(List<BlockInfoDTO>)object;
            resultDO.setData(list);
            resultDO.setSuccess(true);
            return resultDO;
        }
        List<BaseBlock> blocks = areaExtManager.selectByDistrictId(Long.parseLong(districtId));
        List<BlockInfoDTO> list=new ArrayList<BlockInfoDTO>();
        for(BaseBlock baseBlock:blocks){
            BlockInfoDTO dto=new BlockInfoDTO();
            dto.setBlockId(String.valueOf(baseBlock.getId()));
            dto.setBlockName(baseBlock.getBlockName());
            list.add(dto);
        }
        resultDO.setData(list);
        if(!ValidateHelper.isEmpty(resultDO.getData())){
            RedisUtil.set("BASE_SERVICE_BLOCKINFO"+districtId, resultDO.getData(), 3600);
        }
        resultDO.setSuccess(true);

        return resultDO;
    }

    @Override
    public ResultDO<List<RegionInfoDTO>> queryRegion(String cityId) {
        ResultDO<List<RegionInfoDTO>> resultDO=new ResultDO<List<RegionInfoDTO>>();
        if(ValidateHelper.isEmpty(cityId)){
            resultDO.setErrMsg("请求参数不能为空");
            return resultDO;
        }

        Object object= RedisUtil.get("BASE_SERVICE_REGIONINFO"+cityId);
        if(object!=null){
            List<RegionInfoDTO> list=(List<RegionInfoDTO>)object;
            resultDO.setData(list);
            resultDO.setSuccess(true);
            return resultDO;
        }

        List<BaseDistrict> districts = areaExtManager.selectByCityId(cityId);
        List<RegionInfoDTO> list=new ArrayList<RegionInfoDTO>();
        for(BaseDistrict baseDistrict:districts){
            RegionInfoDTO dto=new RegionInfoDTO();
            dto.setRegionId(String.valueOf(baseDistrict.getId()));
            dto.setRegionName(baseDistrict.getDistrictName());
            list.add(dto);
        }
        resultDO.setData(list);
        if(!ValidateHelper.isEmpty(resultDO.getData())) {
            RedisUtil.set("BASE_SERVICE_REGIONINFO" + cityId, resultDO.getData(), 3600);
        }
        resultDO.setSuccess(true);

        return resultDO;
    }
}
