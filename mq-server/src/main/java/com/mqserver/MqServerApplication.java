package com.mqserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName MqServerApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/22 下午9:59.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class MqServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqServerApplication.class,args);
    }
}
