package com.soft.moto.config;

import com.soft.moto.config.interceptor.MyBaitsInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sucx
 * @projectName moto
 * @description: 拦截器配置
 * @date 2020/4/2114:27
 */
@Configuration
public class InterceptorConfiguration {

    @Bean
    public Interceptor getMyBaitsInterceptor(){
        return new MyBaitsInterceptor();
    }
}
