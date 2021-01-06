package com.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ThreadTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/1/6 下午9:46.
 */
@Data
@TableName("t_thread_test")
public class ThreadTest {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;

    private String address;

    private Integer num;
}
