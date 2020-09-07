package com.springcloud.cloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName CloudEurekaApplication
 * @Description: 服务注册中心
 * @Author zhouyang
 * @Date 2020/6/9 下午2:25.
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class,args);
    }
}
