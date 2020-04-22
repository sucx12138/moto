package com.soft.moto.model;

import lombok.Data;

import java.util.Set;

/**
 * @author sucx
 */
@Data
public class User extends BaseModel{

    private String userCode;

    private String userName;

    private String password;

    private String phone;

    private String idCard;

    private Set<Role> roles;

    private Set<Authority> authorities;
}