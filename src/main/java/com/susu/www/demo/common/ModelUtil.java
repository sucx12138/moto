package com.susu.www.demo.common;

import com.susu.www.demo.model.BaseModel;
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
               baseMode.setId(CommonUtil.getUUID());
               baseMode.setCreateTime(DateUtil.getCurrentDate());
               baseMode.setCreateUser(UserUtil.getCurrentUser().getId());
               //默认状态
               if (null == baseMode.getStats()){
                   baseMode.setStats(Constants.MODEL_STATUS_NOT_DELETE);
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
            model.setUpdateUser(UserUtil.getCurrentUser().getId());
            //默认状态
            if (null == model.getStats()){
                model.setStats(Constants.MODEL_STATUS_NOT_DELETE);
            }
        }
    }


}
