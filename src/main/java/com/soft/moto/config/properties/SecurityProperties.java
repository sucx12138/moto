package com.soft.moto.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sucx
 * @projectName moto
 * @description: 安全管理配置
 * @date 2020/4/2115:37
 */
@Component
@ConfigurationProperties(prefix = "spring.security")
public class SecurityProperties {
    /**
     * 浏览器 属性类
     */
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
