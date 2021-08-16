package com.authentication.po;

import com.springcloud.entity.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Resource
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:18.
 */
@Data
@NoArgsConstructor
public class Resource extends BasePo {
    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
}
