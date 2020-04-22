package com.soft.moto.controller;

import com.soft.moto.common.model.SimpleResponse;
import com.soft.moto.common.utils.Constants;
import com.soft.moto.config.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sucx
 * @projectName moto
 * @description: 安全访问控制器
 * @date 2020/4/2115:27
 */
@Slf4j
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
@RestController
public class BrowserSecurityController {

    /**
     * 重定向 策略
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 把当前的请求缓存到 session 里去
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * 注入 Security 属性类配置
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证时 跳转到这里
     */
    @RequestMapping("/authentication/require")
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //拿到请求对象
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null){
            final String loginPage = securityProperties.getBrowser().getLoginPage();
            //获取 跳转url
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是:"+targetUrl);
            //判断 targetUrl 是不是 .html　结尾, 如果是：跳转到登录页(返回view)
            if (StringUtils.endsWithIgnoreCase(targetUrl, Constants.HTML_SUFFIX)){
                redirectStrategy.sendRedirect(request,response,loginPage);
            }
        }
        //如果不是，返回一个json 字符串
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }
}
