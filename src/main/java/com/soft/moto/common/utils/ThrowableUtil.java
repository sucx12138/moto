package com.soft.moto.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author sucx
 * @title: ThrowableUtil
 * @projectName springboot_demo
 * @date 2020/1/2116:54
 */
public class ThrowableUtil {
    /**
     * 获取堆栈信息
     * @param throwable
     * @return
     */
    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
