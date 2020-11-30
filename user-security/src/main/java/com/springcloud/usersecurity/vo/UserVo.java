package com.springcloud.usersecurity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserVo
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/29 上午10:27.
 */

@Data
public class UserVo implements Serializable {
    private Long userId;
    private String userName;
    private String avatar;
    private String password;
}
