package com.order.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName MyBatisPlusVo
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/12/5 下午9:00.
 */
@Data
public class MyBatisPlusVo {

    private String name;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
