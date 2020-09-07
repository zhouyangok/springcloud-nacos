package com.springcloud.score.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/6/9 下午3:10.
 */
@Configuration
public class ApplicationContextConfig {

    @Bean //相当于Spring中applicationContext.xml中<bean id="" class="">
    @LoadBalanced
//    使用此注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
