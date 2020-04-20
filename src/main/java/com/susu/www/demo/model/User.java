package com.susu.www.demo.model;

import lombok.Data;

/**
 * @author sucx
 * @title: User
 * @projectName springboot_demo
 * @description: 用户模型
 * @date 2020/1/2210:23
 */
@Data
public class User extends BaseModel{
    private String name;
    private String currentRemoteIp;
}
