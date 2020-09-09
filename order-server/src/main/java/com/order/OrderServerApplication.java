package com.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName NacosServerApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/7/1 下午1:29.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.order.service")
@MapperScan("com.order.mapper")
public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class,args);
    }
}