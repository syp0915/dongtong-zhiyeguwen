package com.shfc.base.dao;

import com.shfc.base.domain.BaseTag;
import com.shfc.base.dto.BaseTagDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.shfc.base.dao.BaseTagMapper.java
 * @Description: 标签
 * @Company: 上海房产
 * @Copyright: Copyright (c) 2016 
 * All right reserved.
 * Author wuky
 * @date 2016/12/28 11:26
 * version v1.0.0
 */
@Repository
public interface BaseTagMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int insert(BaseTag record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(BaseTag record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param id
     * @return com.shfc.base.domain.BaseTag
     * @throws []
     */
    BaseTag selectByPrimaryKey(Long id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(BaseTag record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author wuky
     * @Date 2016/12/28 11:26
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(BaseTag record);

    /**
     * 按标签类型查找
     * Copyright: Copyright (c) 2016
     * Company:上海房产
     *
     * @author wky
     * @date 2016年11月17日 下午4:40:11
     * @version V1.0
     * @return
     */
    List<BaseTagDTO> selectByType(@Param("tagType") Integer tagType);


    /**
     * 按条件统计标签
     * Copyright: Copyright (c) 2016
     * Company:上海房产
     *
     * @author wky
     * @date 2016年11月17日 下午4:40:11
     * @version V1.0
     * @return
     */
    int queryTagByUserId(HashMap<String, Object> params);

}