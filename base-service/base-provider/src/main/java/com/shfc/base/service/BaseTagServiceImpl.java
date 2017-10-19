package com.shfc.base.service;

import com.shfc.base.dto.BaseTagDTO;
import com.shfc.base.manager.BaseTagManager;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @File com.shfc.base.service.BaseTagServiceImpl.java
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 
 * @author wuky
 * @date 2016年12月28日 下午10:57:55
 * @version V1.0
 */
@Service
public class BaseTagServiceImpl implements BaseTagService {

	@Autowired(required = false)
	private BaseTagManager baseTagManager;

	@Override
	public ResultDO<List<BaseTagDTO>> getFeatureList(String tagType) {
		ResultDO<List<BaseTagDTO>> resultDO = new ResultDO<List<BaseTagDTO>>();
		// 请求参数不能为空
		if (ValidateHelper.isEmpty(tagType)){
			resultDO.setErrMsg("请求参数tagType不能为空");
			return resultDO;
		}

		List<BaseTagDTO> baseTags = baseTagManager.selectByType(Integer.parseInt(tagType));

		if (baseTags.size() == 0) {
			resultDO.setErrMsg("请求参数错误或者请求对象不存在");
			return resultDO;
		}

		resultDO.setData(baseTags);
		resultDO.setSuccess(true);

		return resultDO;
	}

	/*
	@Override
	public ResultDO<String> addCustomTags(AddTagBean addTagBean) {

		ResultDO<String> resultDO = new ResultDO<String>();

		long userId = Long.parseLong(addTagBean.getUserId());
		int type = Integer.parseInt(addTagBean.getType());
		String name = addTagBean.getName();
		String color = addTagBean.getColor();

		//标签类型必须是存在的
		BaseTagType baseTagType=baseTagManager.queryTagTypeById(Long.parseLong(addTagBean.getType()));

		if(baseTagType==null){
			resultDO.setErrMsg("标签类型不存在");
			return resultDO;
		}

        HashMap<String, Object> params = new HashMap<String, Object>();

        // 1:新房标签、2:二手房标签、4:经纪人客户、5:经纪人评价标签、6:房源纠错标签
		if (type == TagType.HOUSE_TAG.getValue()) {
			// 用户自定义标签规避“学区房、地铁房、唯一”等敏感词；
			List<HashMap<String, Object>> sensitives = baseTagManager.querySensitiviWords((long)type);

			if (sensitives != null && sensitives.size() != 0) {

				for (HashMap<String, Object> map : sensitives) {
					String sensitiveWord = map.get("sensitive_word").toString();
					if (name.contains(sensitiveWord)) {
						resultDO.setErrMsg("用户自定义标签需规避" + sensitiveWord + "等敏感词");
						return resultDO;
					}
				}
			}



		}
		params.put("tagType", type);
		params.put("creater", userId);

		int sum = baseTagManager.queryTagByUserId(params);

		if (sum >= 2) {
			resultDO.setErrMsg("自定义标签不超过两个");
			return resultDO;
		}

		ResultDO<Long> result=baseTagManager.addTag(addTagBean);

		if(!result.isSuccess()){
			resultDO.setErrMsg("添加自定义标签失败");
			return resultDO;
		}

		resultDO.setData(String.valueOf(result.getData()));
        resultDO.setSuccess(true);


        return resultDO;

	}*/
}


