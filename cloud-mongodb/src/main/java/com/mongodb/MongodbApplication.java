package com.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName MogodbApplication
 * @Description: mongodb集成
 * @Author zhouyang
 * @Date 2020/12/29 下午1:21.
 */
@SpringBootApplication
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }
}
