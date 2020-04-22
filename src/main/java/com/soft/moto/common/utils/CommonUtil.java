package com.soft.moto.common.utils;

import com.soft.moto.config.exception.BadRequestException;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author sucx
 * @title: CommonUtil
 * @projectName springboot_demo
 * @description: 公用工具类
 * @date 2020/1/2117:05
 */
public class CommonUtil {

    /**
     * 检查主键不为空
     * @param id
     */
    public static void checkPrimaryKeyNotNull(String id){
        if (StringUtils.isEmpty(id)){
            throw new BadRequestException(Constants.CONTROLLER_MESSAGE_ID_IS_NULL);
        }
    }

    /**
     * 生成UUID
     * @return
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
