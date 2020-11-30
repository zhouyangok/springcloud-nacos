package com.cloud.oss.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName ExcelDemo
 * @Description: excel写操作实体类
 * @Author zhouyang
 * @Date 2020/11/30 下午8:49.
 */
@Data
public class ExcelWriteDemo {

    //设置excel表头名称
    @ExcelProperty("学生编号")
    private Integer sno;

    @ExcelProperty("学生姓名")
    private String sname;
}
