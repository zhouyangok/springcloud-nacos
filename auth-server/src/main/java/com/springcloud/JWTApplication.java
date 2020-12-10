package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName JWTApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/12/9 下午9:11.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class JWTApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWTApplication.class, args);
    }
}
