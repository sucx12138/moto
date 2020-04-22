package com.soft.moto.config;

import com.soft.moto.config.security.UserDetailsServiceImpl;
import com.soft.moto.config.properties.SecurityProperties;
import com.soft.moto.config.security.handler.MyAuthenticationFailureHandler;
import com.soft.moto.config.security.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author sucx
 * @projectName moto
 * @description: Security权限控制配置
 * @date 2020/4/2115:11
 */
@Configuration
public class BrowserSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 重写PasswordEncoder  接口中的方法，实例化加密策略
     *
     * @return 返回 BCrypt 加密策略
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 注入 自定义的  登录成功处理类
     */
    @Autowired
    private MyAuthenticationSuccessHandler successHandler;
    /**
     * 注入 自定义的 登陆失败处理类
     */
    @Autowired
    private MyAuthenticationFailureHandler errorHandler;
    /**
     * 注入 认证授权框架自定义配置
     */
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final String loginPage = securityProperties.getBrowser().getLoginPage();
        //表单登录 方式
        http.formLogin()
                .loginPage(loginPage)
                .usernameParameter("username")
                .passwordParameter("password")
                //登录需要经过的url请求
                .loginProcessingUrl("/auth/login")
                .successHandler(successHandler)
                .failureHandler(errorHandler)
                .and()
                //请求授权
                .authorizeRequests()
                //不需要权限认证的url
                .antMatchers("/authentication/require", loginPage).permitAll()
                //任何请求
                .anyRequest()
                //需要身份认证
                .authenticated()
                .and()
                //关闭跨站请求防护
                .csrf().disable();
    }

    /**
     * 设置userDetailsService
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
