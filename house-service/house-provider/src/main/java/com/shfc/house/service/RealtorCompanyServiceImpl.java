package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.dao.RealtorCompanyMapper;
import com.shfc.house.dao.RealtorStoreMapper;
import com.shfc.house.domain.RealtorCompany;
import com.shfc.house.domain.RealtorStore;
import com.shfc.house.dto.RealtorCompanyDTO;
import com.shfc.house.dto.RealtorStoreDTO;
import com.shfc.house.query.CustomerStoreQuery;
import com.shfc.mybatis.pagination.Page;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Package com.shfc.house.service.RealtorCompanyServiceImpl
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/1/17 15:43
 * version V1.0.0
 */
@Service
public class RealtorCompanyServiceImpl implements  RealtorCompanyService{

    @Autowired
    private RealtorCompanyMapper realtorCompanyMapper;

    @Autowired
    private RealtorStoreMapper realtorStoreMapper;

    public static final Logger LOGGER = Logger.getLogger(PlotServiceImpl.class);

    @Override
    public RealtorCompany selectRealtorCompanyById(Long id) {
        return realtorCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultDO<Long> updateByPrimaryKeySelective(RealtorCompany realtorCompany) {
        ResultDO<Long> resultDO = new ResultDO<Long>();
        try {
            realtorCompanyMapper.updateByPrimaryKeySelective(realtorCompany);
            resultDO.setSuccess(true);
        } catch (Exception e) {
            LOGGER.error("修改经纪公司异常", e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }

    /**
     * 模糊查询经纪人公司
     * @param key
     * @param page
     * @return
     */
    @Override
    public ResultDO<List<RealtorCompany>> selectRealtorCompanyByKey(String key, Page page) {
        ResultDO<List<RealtorCompany>> resultDO = new ResultDO<>();
        try {
            Map<String,Object> map = new HashedMap();
            map.put("comName",key);
            map.put("page",page);
            resultDO.setData(realtorCompanyMapper.selectRealtorCompanyByKey(map));
            resultDO.setSuccess(true);
        } catch (Exception e) {
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }

    @Override
    public ResultDO<List<RealtorStore>> selectRealtorStoreByCompanyId(int realtorCompanyId, Page page) {
        ResultDO<List<RealtorStore>> resultDO = new ResultDO<>();
        try {
            Map<String,Object> map = new HashedMap();
            map.put("realtorCompanyId",realtorCompanyId);
            map.put("page",page);
            resultDO.setData(realtorStoreMapper.selectRealtorStoreByCompanyId(map));
            resultDO.setSuccess(true);
        } catch (Exception e) {
            LOGGER.error(e);
            resultDO.setErrMsg("系统异常，请联系管理员");
        }
        return resultDO;
    }

    @Override
    public ResultDO<List<RealtorCompanyDTO>> queryCompanyByKeyword(String keyword) {
        ResultDO<List<RealtorCompanyDTO>> resultDO=new ResultDO<>();
        resultDO.setData(realtorCompanyMapper.queryCompanyByKey(keyword));
        resultDO.setSuccess(true);
        return resultDO;
    }

    @Override
    public ResultDO<Page<RealtorStoreDTO>> queryStoreByKeyword(CustomerStoreQuery query) {
        ResultDO<Page<RealtorStoreDTO>> resultDO=new ResultDO<>();
        if(query.getRealtorCompanyId()==null){
            resultDO.setErrMsg("经纪人公司不能为空");
            return resultDO;
        }

        Page<RealtorStoreDTO> page=new Page<>(query.getPageNumber(),query.getPageSize());

        try {
            page.setQuery(query);
            realtorStoreMapper.queryStoreByKeyword(page);
            resultDO.setData(page);
            resultDO.setSuccess(true);
            return resultDO;

        }catch ( Exception e ){
            com.shfc.common.base.Logger.error(e, "查询门店列表异常");
            resultDO.setErrMsg("系统异常，请联系管理员");
            return resultDO;
        }
    }

    @Override
    public ResultDO<List<RealtorStoreDTO>> queryStoreByKeyword(String keyword, Long realtorCompanyId) {
        ResultDO<List<RealtorStoreDTO>> resultDO=new ResultDO<>();
        if(realtorCompanyId==null){
            resultDO.setErrMsg("经纪人公司不能为空");
            return resultDO;
        }

        resultDO.setData(realtorStoreMapper.queryStore(keyword,realtorCompanyId));
        resultDO.setSuccess(true);
        return resultDO;
    }
}
