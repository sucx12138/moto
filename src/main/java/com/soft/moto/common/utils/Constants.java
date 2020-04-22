package com.soft.moto.common.utils;

/**
 * @author sucx
 * @title: Constants
 * @projectName springboot_demo
 * @description: 常量池
 * @date 2020/1/2117:06
 */
public final class Constants {

    /**控制层提示信息-START**/
    public static final String CONTROLLER_MESSAGE_ID_IS_NULL = "主键id不能为空";
    /**控制层提示信息-END**/

    /**异常信息-START**/
    public static final String EXCEPTION_MESSAGE_USER_NOT_FOUND = "用户不存在,请先登陆...";
    /**异常信息-END**/

    /**数据模型状态-START STATUS: 0-删除状态 1-可用状态**/
    public static final Integer MODEL_STATUS_NORMAL = 1;
    public static final Integer MODEL_STATUS_DELETE = 0;
    /**数据模型状态-END**/

    /**请求后缀-START**/
    public static final String HTML_SUFFIX = ".html";
    /**请求后缀-END**/
}
