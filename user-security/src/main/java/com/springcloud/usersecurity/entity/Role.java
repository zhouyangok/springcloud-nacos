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
 * @ClassName Role
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/17 下午9:31.
 */
@Data
@TableName(value = "t_role")//如果表名和实体类名不一致，需要单独说明
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    /**
     * 时间格式化，将数据库时间格式化后传给前端
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "create_date")
    private Date createDate;
    @TableField(value = "create_user_id")
    private Integer createUserId;
    private int status;
}
