package com.soft.moto.model;

import lombok.Data;

/**
 * @author sucx
 */
@Data
public class Menu extends BaseModel{

    private String code;

    private String name;

    private Integer type;

    private String url;

    private String icon;

}