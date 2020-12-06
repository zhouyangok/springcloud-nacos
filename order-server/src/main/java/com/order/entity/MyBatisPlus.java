package com.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName MyBatisPlus
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/12/5 下午8:41.
 */
@Data
@TableName("t_mybatis_plus")
public class MyBatisPlus {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    //逻辑删除
    @TableLogic
    private Integer delFlag;
    // 注意！这里需要标记为填充字段
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
    /**
     * 乐观锁实现
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
