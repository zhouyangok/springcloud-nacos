package com.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description: 用户实体
 * @Author zhouyang
 * @Date 2020/6/9 下午2:48.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    private Long id;

    private String name;
}
