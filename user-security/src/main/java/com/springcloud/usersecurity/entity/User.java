package com.springcloud.usersecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @ClassName User
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 上午8:48.
 */

@Data
@TableName(value = "t_user")//如果表名和实体类名不一致，需要单独说明
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer userId;
    @TableField(value = "user_name")
    private String username;
    private String password;
    /**
     * 时间格式化，将数据库时间格式化后传给前端
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "create_date")
    private Date createDate;

    private int status;
}
