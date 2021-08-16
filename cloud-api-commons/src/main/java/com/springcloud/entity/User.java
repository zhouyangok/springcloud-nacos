package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description: 用户实体
 * @Author zhouyang
 * @Date 2020/6/9 下午2:48.
 */
@Data
@NoArgsConstructor
public class User implements Serializable{

    private Long id;

    private String username;
    private String password;
    private String role;

    public User(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
