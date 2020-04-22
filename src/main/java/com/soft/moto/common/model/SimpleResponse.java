package com.soft.moto.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sucx
 * @projectName moto
 * @description: 简单的响应体
 * @date 2020/4/2115:30
 */
@Data
@EqualsAndHashCode
public class SimpleResponse {
    public SimpleResponse(){}
    public SimpleResponse(Object content){
        this.content = content;
    }
    private Object content;
}
