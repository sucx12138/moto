package com.soft.moto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sucx
 *  @MapperScan 注解扫描mapper层
 */
@SpringBootApplication
@MapperScan({"com.soft.moto.mapper"})
public class Application {

    /**
     * 程序入口方法
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
