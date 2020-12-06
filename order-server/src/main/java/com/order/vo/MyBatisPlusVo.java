package com.order.vo;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "实体名称，模糊查询")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "创建时间，示例：2020-01-10 13：23：12")
    private String start;
    @ApiModelProperty(value = "修改时间，示例：2020-01-10 13：23：12")
    private String  end;
}
