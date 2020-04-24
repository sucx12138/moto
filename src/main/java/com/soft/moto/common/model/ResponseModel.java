package com.soft.moto.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author sucx
 * @projectName moto
 * @description: 简单的响应体
 * @date 2020/4/2115:30
 */
@Data
@EqualsAndHashCode
public class ResponseModel {
    public ResponseModel(Object content, HttpStatus status, String message) {
        this.content = content;
        this.status = status;
        this.message = message;
    }
    public ResponseModel(Object content, HttpStatus status) {
        this.content = content;
        this.status = status;
    }
    public ResponseModel(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }
    public ResponseModel() {
    }
    static public ResponseModel ok(Object content){
        return new ResponseModel(content,HttpStatus.OK);
    }
    static public ResponseModel fail(Object content){
        return new ResponseModel(content,HttpStatus.BAD_REQUEST);
    }
    private Object content;
    private HttpStatus status;
    private String message;
}
