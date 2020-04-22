package com.soft.moto.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sucx
 * @title: NetworkUtil
 * @projectName springboot_demo
 * @description: 网络工具
 * @date 2020/1/2211:26
 */
public final class NetworkUtil {
    /**
     * 获取客户端IP地址
     * @return
     */
    public static String getRemoteIp(){
        final ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        final HttpServletRequest request = attributes.getRequest();
        return request.getRemoteAddr();
    }
}
