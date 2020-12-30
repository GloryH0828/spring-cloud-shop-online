package com.gloryh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 促销 微服务 启动类
 *
 * @author 黄光辉
 * @since 2020/11/16
 **/
@SpringBootApplication
@MapperScan("com.gloryh.repository")
public class PromotionApplication {
    public static void main(String[] args) {
        SpringApplication.run(PromotionApplication.class,args);
    }
}
