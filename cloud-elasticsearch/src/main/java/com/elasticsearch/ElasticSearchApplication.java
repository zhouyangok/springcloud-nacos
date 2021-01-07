package com.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName ElasticSearchApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/7/12 下午5:06.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除自动配置
public class ElasticSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class,args);
    }
}
