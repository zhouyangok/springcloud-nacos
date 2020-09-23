package com.email_sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName EmailSmsApplication
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/23 下午9:57.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class EmailSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSmsApplication.class, args);
    }
}
