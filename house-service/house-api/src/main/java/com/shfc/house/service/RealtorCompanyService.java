package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.domain.RealtorCompany;
import com.shfc.house.domain.RealtorStore;
import com.shfc.house.dto.RealtorCompanyDTO;
import com.shfc.house.dto.RealtorStoreDTO;
import com.shfc.house.query.CustomerStoreQuery;
import com.shfc.mybatis.pagination.Page;

import java.util.List;

/**
 * @Package com.shfc.house.service.RealtorCompanyService
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/1/17 15:41
 * version V1.0.0
 */
public interface RealtorCompanyService {
    /**
     * 根据ID查询公司
     * @param id
     * @return
     */
    RealtorCompany selectRealtorCompanyById(Long id);

    ResultDO<Long> updateByPrimaryKeySelective(RealtorCompany realtorCompany);

    /**
     * 模糊查询公司
     * @param key
     * @param page
     * @return
     */
    ResultDO<List<RealtorCompany>> selectRealtorCompanyByKey(String key , Page page);

    /**
     * 根据公司ID查询门店
     * @param companyId
     * @param page
     * @return
     */
    ResultDO<List<RealtorStore>> selectRealtorStoreByCompanyId(int companyId, Page page);


    /**
     * 模糊查询公司
     * @param keyword
     * @return
     */
    ResultDO<List<RealtorCompanyDTO>> queryCompanyByKeyword(String keyword);


    /**
     * 模糊查询经纪人门店
     * @param query
     * @return
     */
    ResultDO<Page<RealtorStoreDTO>> queryStoreByKeyword(CustomerStoreQuery query);

    /**
     * 模糊查询经纪人门店
     * @param keyword
     * @return
     */
    ResultDO<List<RealtorStoreDTO>> queryStoreByKeyword(String keyword,Long realtorCompanyId);
}
