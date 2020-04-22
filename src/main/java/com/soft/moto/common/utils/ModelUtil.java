package com.soft.moto.common.utils;

import com.soft.moto.model.BaseModel;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;


/**
 * @author sucx
 * @title: ModelUtil
 * @projectName springboot_demo
 * @description: 模型数据封装类
 * @date 2020/1/2210:22
 */
@Slf4j
public final class ModelUtil {

    /**
     * 创建基础数据
     */
    public static void setCreateBaseInfo(Optional<Object> model){
        model.ifPresent((data) -> {
           if (data instanceof BaseModel){
               BaseModel baseMode = (BaseModel)data;
               baseMode.setId(CommonUtil.getUuid());
               baseMode.setCreateTime(DateUtil.getCurrentDate());
               baseMode.setCreateUser(null);
               //默认状态
               if (null == baseMode.getStatus()){
                   baseMode.setStatus(Constants.MODEL_STATUS_NORMAL);
               }
           }
        });
    }

    /**
     * 更新基础数据
     */
    public static void setUpdateBaseInfo(Object obj){
        if (obj instanceof BaseModel){
            BaseModel model = (BaseModel) obj;
            model.setUpdateTime(DateUtil.getCurrentDate());
            model.setUpdateUser(null);
            //默认状态
            if (null == model.getStatus()){
                model.setStatus(Constants.MODEL_STATUS_NORMAL);
            }
        }
    }


}
