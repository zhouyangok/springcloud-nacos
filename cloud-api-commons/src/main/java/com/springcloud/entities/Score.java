package com.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Score
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/7 下午9:59.
 */
@Data
@TableName(value = "t_score")
public class Score {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer score;
    private Integer userId;
    /**
     * 时间格式化，将数据库时间格式化后传给前端
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
}
