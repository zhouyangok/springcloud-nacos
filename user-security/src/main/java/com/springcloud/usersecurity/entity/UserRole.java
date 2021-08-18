package com.springcloud.usersecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName UserRole
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 下午9:35.
 */
@Data
@TableName(value = "t_user_role")//如果表名和实体类名不一致，需要单独说明
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Integer createUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "create_date")
    private Date createDate;
    private int status;
}
