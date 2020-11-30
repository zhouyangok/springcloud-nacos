package com.cloud.oss.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName SujectExcel
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/30 下午9:33.
 */
@Data
public class SubjectExcel {

    @ExcelProperty(index = 0)
    private String subjectOne;
    @ExcelProperty(index = 1)
    private String subjectTwo;
}
