package com.gloryh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 商品分类 微服务启动类
 *
 * @author 黄光辉
 * @since 2020/11/4
 **/
@SpringBootApplication
@MapperScan("com.gloryh.repository")
public class CategoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class,args);
    }
}
