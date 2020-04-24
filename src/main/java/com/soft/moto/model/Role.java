package com.soft.moto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author sucx
 */
@Data
@EqualsAndHashCode
@ToString
public class Role extends BaseModel{
    private String code;

    private String name;
}