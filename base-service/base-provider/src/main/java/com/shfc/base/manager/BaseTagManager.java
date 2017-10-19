package com.shfc.base.manager;


import com.shfc.base.dao.BaseSensitiveWordMapper;
import com.shfc.base.dao.BaseTagCategoryMapper;
import com.shfc.base.dao.BaseTagMapper;
import com.shfc.base.dao.BaseTagTypeMapper;
import com.shfc.base.domain.BaseTagType;
import com.shfc.base.dto.BaseTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BaseTagManager {
    @Autowired(required = false)
    private BaseTagMapper baseTagMapper;
    @Autowired(required = false)
    private BaseTagTypeMapper baseTagTypeMapper;
    @Autowired(required = false)
    private BaseTagCategoryMapper baseTagCategoryMapper;
    @Autowired
    private BaseSensitiveWordMapper baseSensitiveWordMapper;


    /**
     * 按标签类型查找
     * Copyright: Copyright (c) 2016
     * Company:上海房产
     *
     * @return
     * @author wky
     * @date 2016年11月17日 下午4:40:11
     * @version V1.0
     */
    public List<BaseTagDTO> selectByType(Integer tagType) {

        return baseTagMapper.selectByType(tagType);
    }

    /**
     * 添加标签
     * Copyright: Copyright (c) 2016
     * Company:上海房产
     *
     * @return
     * @author wky
     * @date 2016年11月17日 下午4:40:11
     * @version V1.0
     */
//    @Transactional(rollbackFor = AppException.class)
//    public ResultDO<Long> addTag(TagQuery tagQuery) {
//        ResultDO<Long> resultDO = new ResultDO<Long>();
//		String userId = tagQuery.getUserId();
//		String type = tagQuery.getType();
//		String name = tagQuery.getName();
//		String color = tagQuery.getColor();
//
//        if (type==null||"".equals(type)) {
//            resultDO.setErrMsg("标签类型不能为空");
//            return resultDO;
//
//        }
//
//        if (name==null||"".equals(name)) {
//            resultDO.setErrMsg("标签属性不能为空");
//            return resultDO;
//
//        }
//        if (userId==null||"".equals(userId)) {
//            resultDO.setErrMsg("用户不能为空");
//            return resultDO;
//
//        }
//        BaseTag tag = new BaseTag();
//        tag.setTagName(name);
//        tag.setTagColor(color);
//        tag.setTagType(Integer.parseInt(type));
//        tag.setLevel(1);//自定义标签
//        tag.setCategory(0);//自定义标签
//        tag.setCreater(Long.parseLong(userId));
//        tag.setCreateTime(new Date());
//        baseTagMapper.insert(tag);
//        resultDO.setData(tag.getId());
//        resultDO.setSuccess(true);
//
//        return resultDO;
//
//
//    }

    public BaseTagType queryTagTypeById(Long id) {
        // TODO Auto-generated method stub
        return baseTagTypeMapper.selectByPrimaryKey(id);
    }

    public List<HashMap<String, Object>> querySensitiviWords(Long type) {

        return baseSensitiveWordMapper.querySensitiviWords(type);
    }

    public int queryTagByUserId(HashMap<String, Object> params) {
        // TODO Auto-generated method stub
        return baseTagMapper.queryTagByUserId(params);
    }

}
