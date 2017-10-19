package com.shfc.house.manager;

import com.shfc.common.base.ValidateHelper;
import com.shfc.house.dao.LeadsHouseCorrectMapper;
import com.shfc.house.dao.LeadsHouseCorrectTagMapper;
import com.shfc.house.domain.LeadsHouseCorrect;
import com.shfc.house.domain.LeadsHouseCorrectTag;
import com.shfc.house.dto.LeadsHouseCorrectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.shfc.house.manager.LeadsHouseCorrectManager
 * @Description: LeadsHouseCorrectManager
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/4/10 15:46
 * version V1.0.0
 */
@Service
public class LeadsHouseCorrectManager {
    @Autowired
    private LeadsHouseCorrectMapper leadsHouseCorrectMapper;
    @Autowired
    private LeadsHouseCorrectTagMapper leadsHouseCorrectTagMapper;

    @Transactional
    public void correctLeadsHouse(LeadsHouseCorrectDTO dto, Long realtorId){
        LeadsHouseCorrect correct = new LeadsHouseCorrect();
        correct.setLeadsHouseId(dto.getLeadsHouseId());
        correct.setCreater(realtorId);
        leadsHouseCorrectMapper.insert(correct);
        if(!ValidateHelper.isEmpty(dto.getTagIds())){
            List<LeadsHouseCorrectTag> tagList = new ArrayList<>(dto.getTagIds().size());
            for(Long tagId: dto.getTagIds()){
                LeadsHouseCorrectTag tag = new LeadsHouseCorrectTag();
                tag.setLeadsCorrectId(correct.getId());
                tag.setTagId(tagId);
                tag.setCreater(realtorId);
                tagList.add(tag);
            }

            leadsHouseCorrectTagMapper.batchInsert(tagList);
        }
    }
}
