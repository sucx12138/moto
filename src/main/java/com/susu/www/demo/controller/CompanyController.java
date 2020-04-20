package com.susu.www.demo.controller;

import com.alibaba.druid.util.StringUtils;
import com.susu.www.demo.common.CommonUtil;
import com.susu.www.demo.model.UCompany;
import com.susu.www.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sucx
 * @title: CompanyController
 * @projectName springboot_demo
 * @description: 企业管理控制层
 * @date 2020/1/1616:39
 */
@RestController
@RequestMapping("user")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company/{id}")
    public ResponseEntity findCompany(@PathVariable("id") String id){
        final UCompany company = companyService.findCompany(id);
        return ResponseEntity.ok(company);
    }
    @GetMapping("/company")
    public ResponseEntity findCompanyList(UCompany company){
        final List<UCompany> companyList = companyService.findCompanyList(company);
        return ResponseEntity.ok(companyList);
    }
    @DeleteMapping("/company/{id}")
    public ResponseEntity deleteCompany(@PathVariable("id") String id){
        final int deleteCount = companyService.deleteCompany(id);
        return ResponseEntity.ok(deleteCount);
    }
    @PostMapping("/company")
    public ResponseEntity saveCompany(@Validated @RequestBody UCompany company){
        final int saveCount = companyService.saveCompany(company);
        return ResponseEntity.ok(saveCount);
    }
    @PutMapping("/company")
    public ResponseEntity updateCompany(@Validated @RequestBody UCompany company){
        if (StringUtils.isEmpty(company.getId())){
            CommonUtil.checkPrimaryKeyNotNull(company.getId());
        }
        final int updateCount = companyService.updateCompany(company);
        return ResponseEntity.ok(updateCount);
    }


}
