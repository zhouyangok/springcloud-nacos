package com.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Stock
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午9:33.
 */
@Data
@TableName(value = "t_stock")
public class Stock {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private Integer userId;
    /**
     * 时间格式化，将数据库时间格式化后传给前端
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    private Integer stockNumber;
}
