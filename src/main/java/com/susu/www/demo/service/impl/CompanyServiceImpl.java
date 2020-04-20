package com.susu.www.demo.service.impl;

import com.susu.www.demo.mapper.UCompanyMapper;
import com.susu.www.demo.model.UCompany;
import com.susu.www.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sucx
 * @title: CompanyServiceImpl
 * @projectName springboot_demo
 * @description: 服务层
 * @date 2020/1/1616:42
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private UCompanyMapper companyMapper;

    @Override
    public UCompany findCompany(String id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UCompany> findCompanyList(UCompany company) {
        return companyMapper.selectCompanyList(company);
    }

    @Override
    public int deleteCompany(String id) {
        return companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveCompany(UCompany company) {
        return companyMapper.insertSelective(company);
    }

    @Override
    public int updateCompany(UCompany company) {
        return companyMapper.updateByPrimaryKeySelective(company);
    }

}
