package com.soft.moto.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sucx
 * @title: DriudProperties
 * @projectName springboot_demo
 * @description: druid数据源配置
 * @date 2020/1/1314:49
 */
@Component
@ConfigurationProperties(prefix = "spring.druid")
@Data
public class DruidProperties {
    /**
     * druid监控登陆账号
     */
    private String loginUsername = "admin";
    /**
     * druid监控登陆密码
     */
    private String loginPassword = "123456";
    /**
     * 白名单
     */
    private String allow = "";

    /**
     * 黑名单
     */
    private String deny = "";

    /**
     * 拦截器配置
     */
    private String exclusions = "*.js,*.css,*.jsp,*.png,*.jpg,*.gif,/druid/*";

    /**
     * 请求过滤url配置
     */
    private List<String> urlPatterns;

}
