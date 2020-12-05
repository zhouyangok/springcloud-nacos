package com.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName NacosServerApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/7/1 下午1:29.
 */
@SpringBootApplication(scanBasePackages={"com.order","com.springcloud"})//需要扫描到common包中的exception
@EnableDiscoveryClient
@EnableFeignClients("com.order.service")
@MapperScan("com.order.mapper")
public class OrderServerApplication {



    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class,args);
    }

}
