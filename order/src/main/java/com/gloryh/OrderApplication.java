package com.gloryh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 订单微服务启动类
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@SpringBootApplication
@MapperScan("com.gloryh.repository")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
