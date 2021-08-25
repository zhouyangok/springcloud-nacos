package com.auth.cloud.entity;

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
 * @ClassName Menu
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/18 上午9:04.
 */
@Data
@TableName(value = "t_menu")//如果表名和实体类名不一致，需要单独说明
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String path;
    private Integer parentId;
    private int status;
    /**
     * 时间格式化，将数据库时间格式化后传给前端
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "create_date")
    private Date createDate;
    private Integer createUserId;
}
