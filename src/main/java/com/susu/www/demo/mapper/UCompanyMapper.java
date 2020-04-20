package com.susu.www.demo.mapper;

import com.susu.www.demo.model.UCompany;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UCompanyMapper {
    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(UCompany record);

    /**
     * 动态插入数据
     * @param record
     * @return
     */
    int insertSelective(UCompany record);

    UCompany selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UCompany record);

    int updateByPrimaryKey(UCompany record);

    List<UCompany> selectCompanyList(UCompany company);
}