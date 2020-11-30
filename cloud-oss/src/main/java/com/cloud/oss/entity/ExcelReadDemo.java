package com.cloud.oss.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName ExcelReadDemo
 * @Description: excel读操作实体类
 * @Author zhouyang
 * @Date 2020/11/30 下午9:08.
 */
@Data
public class ExcelReadDemo {

    //    设置列对应的属性
    @ExcelProperty(index = 0)
    private int sid;
    //    设置列对应的属性
    @ExcelProperty(index = 1)
    private String sname;
}
