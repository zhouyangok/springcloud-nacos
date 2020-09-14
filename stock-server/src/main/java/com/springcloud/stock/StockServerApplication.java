package com.springcloud.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName UIOpenfeignConsumerApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/23 下午5:08.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@MapperScan("com.springcloud.stock.mapper")
public class StockServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockServerApplication.class,args);
    }
}
