package com.susu.www.demo.service;

import com.susu.www.demo.model.UCompany;

import java.util.List;

/**
 * @author sucx
 * @title: CompanyService
 * @projectName springboot_demo
 * @description: 企业服务
 * @date 2020/1/1616:41
 */
public interface CompanyService {
    UCompany findCompany(String id);

    List<UCompany> findCompanyList(UCompany company);

    int deleteCompany(String id);

    int saveCompany(UCompany company);

    int updateCompany(UCompany company);
}
