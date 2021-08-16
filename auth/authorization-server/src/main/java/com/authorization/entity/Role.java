package com.authorization.entity;

import com.springcloud.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName Role
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午12:44.
 */
@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
