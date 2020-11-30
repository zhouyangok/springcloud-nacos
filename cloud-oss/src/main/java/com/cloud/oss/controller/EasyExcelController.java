package com.cloud.oss.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.excel.EasyExcel;
import com.cloud.oss.entity.ExcelWriteDemo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EasyExcelController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/30 下午8:42.
 */
@Api(value = "excel上传下载")
@RequestMapping("/easyExcel")
public class EasyExcelController {

    public static void main(String[] args) {
//        实现easyexcel的写操作
//        1.设置文件写入位置以及文件名称
        String filename = "/Users/zhouyang/Desktop/tmpfile/easyExcel.xlsx";
//        2.调用easyexcel方法实现写操作
//        write方法中有两个参数，第一个是文件名称路径，第二个是文件对应实体类class
        EasyExcel.write(filename, ExcelWriteDemo.class).sheet("学生名称").doWrite(getData());
    }


    private static List<ExcelWriteDemo> getData() {
        List<ExcelWriteDemo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelWriteDemo excelDemo = new ExcelWriteDemo();
            excelDemo.setSno(i);
            excelDemo.setSname(UUID.randomUUID().toString().replace("-", ""));
            list.add(excelDemo);
        }
        return list;
    }
}
