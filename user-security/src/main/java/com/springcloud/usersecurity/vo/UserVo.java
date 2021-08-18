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
    private Integer userId;
    private String username;
    private String password;
    private Integer roleId;
    private Integer createUserId;
}
