package com.soft.moto.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.soft.moto.config.properties.SecurityProperties;
import com.soft.moto.enums.LoginType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sucx
 * @projectName moto
 * @description: 登陆成功处理
 * @date 2020/4/2115:15
 */
@Slf4j
@Component
public class MyAuthenticationSuccessHandler extends  SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        //判断是json 格式返回 还是 view 格式返回
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            //将 authention 信息打包成json格式返回
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(authentication));
        }else {
            //返回view
            super.onAuthenticationSuccess(request,response,authentication);
        }

    }
}
