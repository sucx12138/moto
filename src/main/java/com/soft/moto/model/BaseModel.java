package com.soft.moto.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sucx
 * @title: BaseModel
 * @projectName springboot_demo
 * @description: 表模型基础字段
 * @date 2020/1/2210:18
 */
@Data
public class BaseModel implements Serializable {
    /**
     * 主键id
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建ip
     */
    private String createIp;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户
     */
    private String updateUser;
    /**
     * 更新ip
     */
    private String updateIp;
    /**
     * 状态码[0-删除 1-正常]
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
}
