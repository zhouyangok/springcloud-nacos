package com.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName PasswordConfig
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/12/9 下午9:21.
 */

//说明这个一个配置类，类似spring中的xml文件
@Configuration
public class PasswordConfig {

    //手动将PasswordEncoder注入到ioc容器中
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
