package com.susu.www.demo.common;

import com.susu.www.demo.config.exception.BadRequestException;
import com.susu.www.demo.model.User;
import org.springframework.http.HttpStatus;

/**
 * @author sucx
 * @title: UserUtil
 * @projectName springboot_demo
 * @description:
 * @date 2020/1/2210:22
 */
public final class UserUtil {
    /**
     * 获取当前用户【模拟】
     * @return
     */
    public static User getCurrentUser(){
        User user = new User();
        user.setId(CommonUtil.getUUID());
        if (null == user){
            throw new BadRequestException(HttpStatus.FORBIDDEN,Constants.EXCEPTION_MESSAGE_USER_NOT_FOUND);
        }
        return user;
    }
}
