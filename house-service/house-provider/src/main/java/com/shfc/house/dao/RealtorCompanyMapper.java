package com.shfc.house.dao;

import com.shfc.house.domain.RealtorCompany;
import com.shfc.house.dto.RealtorCompanyDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RealtorCompanyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RealtorCompany record);

    int insertSelective(RealtorCompany record);

    RealtorCompany selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RealtorCompany record);

    int updateByPrimaryKeyWithBLOBs(RealtorCompany record);

    int updateByPrimaryKey(RealtorCompany record);

    List<RealtorCompany> selectRealtorCompanyByKey(Map<String,Object> map);


    List<RealtorCompanyDTO> queryCompanyByKey(@Param("keyword") String keyword);
    /**
     * 根据公司名字查找公司
     * @param companyName
     * @return
     */
    RealtorCompany findCompanyByName(String companyName);
}