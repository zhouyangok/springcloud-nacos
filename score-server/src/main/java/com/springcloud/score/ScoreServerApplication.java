package com.springcloud.score;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName UIConsumerApplication
 * @Description: 平台调用接口
 * @Author zhouyang
 * @Date 2020/6/9 下午3:04.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.springcloud.score.mapper")
public class ScoreServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreServerApplication.class,args);
    }
}
