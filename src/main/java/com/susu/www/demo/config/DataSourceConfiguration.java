package com.susu.www.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.susu.www.demo.config.properties.DruidProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sucx
 * @title: DataSourceConfig
 * @projectName springboot_demo
 * @description: db配置
 * @date 2020/1/1314:38
 */
@Configuration
public class DataSourceConfiguration {
    @Autowired
    private DruidProperties properties;
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
    /**
     * 配置Druid的监控
     * 配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername",properties.getLoginUsername());    //登录名
        initParams.put("loginPassword",properties.getLoginPassword());    //登录密码
        initParams.put("allow",properties.getAllow());//默认就是允许所有访问
        initParams.put("deny",properties.getDeny());       //拒接访问
        registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

    /**
     * 配置一个web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions",properties.getExclusions());
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(properties.getUrlPatterns());
        return  bean;
    }
}
