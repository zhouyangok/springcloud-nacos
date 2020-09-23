package com.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Order
 * @Description: 订单实体类
 * @Author zhouyang
 * @Date 2020/9/6 下午9:44.
 */
@Data
@TableName(value = "t_order")//如果表名和实体类名不一致，需要单独说明
public class Order implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer userId;
    /**
     * 时间格式化，将数据库时间格式化后传给前端
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
}
