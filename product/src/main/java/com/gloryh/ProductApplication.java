package com.gloryh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 商品启动类
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@SpringBootApplication
@MapperScan("com.gloryh.repository")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
