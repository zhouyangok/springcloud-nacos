package com.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName Oauth2AuthenticationApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午4:48.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableCreateCacheAnnotation
public class Oauth2AuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthenticationApplication.class, args);
    }
}
