package com.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName MogodbApplication
 * @Description: mongodb集成
 * @Author zhouyang
 * @Date 2020/12/29 下午1:21.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }
}
