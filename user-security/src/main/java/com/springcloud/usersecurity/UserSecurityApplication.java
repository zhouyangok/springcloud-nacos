package com.springcloud.usersecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName UserSecurityApplication
 * @Description: 用户服务
 * @Author zhouyang
 * @Date 2020/6/9 下午2:39.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@MapperScan("com.springcloud.usersecurity.mapper")
public class UserSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSecurityApplication.class,args);
    }
}
