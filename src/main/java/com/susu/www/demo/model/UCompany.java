package com.susu.www.demo.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UCompany extends BaseModel{
    /**
     * 企业名称
     */
    @NotBlank
    private String name;

    /**
     * 地址
     */
    private String address;
    /**
     * 地址
     */
    private String areaId;

}