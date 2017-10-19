package com.shfc.house.manager;

import com.shfc.house.dao.NnsEntrustProtocolMapper;
import com.shfc.house.dao.NnsEntrustProtocolWorkflowMapper;
import com.shfc.house.dao.NnsHouseTagRelMapper;
import com.shfc.house.domain.NnsEntrustProtocol;
import com.shfc.house.domain.NnsEntrustProtocolWorkflow;
import com.shfc.mybatis.pagination.Page;
import com.shfc.house.base.BaseManager;
import com.shfc.house.httpbean.resp.TagBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 下午1:57.
 */
@Service
public class EntrustManager extends BaseManager{

    @Autowired(required = false)
    private NnsEntrustProtocolMapper nnsEntrustProtocolMapper;

    @Autowired(required = false)
    private NnsHouseTagRelMapper nnsHouseTagRelMapper;

    @Autowired(required = false)
    private NnsEntrustProtocolWorkflowMapper nnsEntrustProtocolWorkflowMapper;

    public Page<HashMap<String, Object>> getEntrustListByUserId(Long userId, int pageSize, int pageNumber) throws Exception{
        Page<HashMap<String, Object>> query = new Page<HashMap<String, Object>>(pageNumber, pageSize);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        query.setQuery(params);
        nnsEntrustProtocolMapper.getEntrustListByUserId(query);
        return query;
    }

    public HashMap<String, Object> getEntrustInfoById(Long agreementId){
        return nnsEntrustProtocolMapper.getEntrustInfoById(agreementId);
    }

    /**
     * 根据房源id获取标签列表
     * @Author: Jianguo_li
     * @Date 2017/1/10 下午5:49
     * @Param [houseId]
     * @Return java.util.List<TagBean>
     */
    public List<TagBean> getTagListByHouseId(Long houseId){
        List<TagBean> tagList = new ArrayList<TagBean>();
        List<HashMap<String, Object>> list = nnsHouseTagRelMapper.getTagListByHouseId(houseId);
        if (list != null && list.size() > 0){
            for (HashMap<String, Object> map : list) {
                TagBean tagBean = new TagBean();
                tagBean.setTagId(checkStringMapObject(map.get("tag_id")));
                tagBean.setTagName(checkStringMapObject(map.get("tag_name")));
                tagBean.setTagColor(checkStringMapObject(map.get("tag_color")));
                tagList.add(tagBean);
            }
        }
        return tagList;
    }

    public NnsEntrustProtocol selectNnsEntrustProtocolByPrimaryKey(Long agreementId){
        return nnsEntrustProtocolMapper.selectByPrimaryKey(agreementId);
    }

    public int insertNnsEntrustProtocolWorkflowSelective(NnsEntrustProtocolWorkflow nnsEntrustProtocolWorkflow){
        return nnsEntrustProtocolWorkflowMapper.insertSelective(nnsEntrustProtocolWorkflow);
    }

    public int updateNnsEntrustProtocolByPrimaryKeySelective(NnsEntrustProtocol nnsEntrustProtocol){
        return nnsEntrustProtocolMapper.updateByPrimaryKeySelective(nnsEntrustProtocol);
    }


    /**
     * @Author: Jianguo_li
     * @Date 2017/1/10 下午8:10
     * @Param [reqBean60104]
     * @Return RespBean60104
     */
    public List<NnsEntrustProtocolWorkflow> getEntrustStatusListById(Long agreementId){
        return nnsEntrustProtocolWorkflowMapper.getEntrustListById(agreementId);
    }


    /**
     * 身份证和真实姓名两要素验证
     * @Author: Jianguo_li
     * @Date 2017/1/11 下午2:46
     * @Param [identityNo, name]
     * @Return boolean
     */
    public boolean checkIdentityNoAndName(String identityNo, String name){
        // TODO: 2017/1/11 两要素验证，调用外部接口
        return true;
    }
}
