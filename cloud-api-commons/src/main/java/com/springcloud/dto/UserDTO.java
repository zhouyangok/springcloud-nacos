package com.springcloud.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserDTO
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/15 下午10:01.
 */
@Data
@TableName(value = "t_user")
public class UserDTO {
    private Integer id;
    private String name;
    private String password;
    private Date createDate;
}
