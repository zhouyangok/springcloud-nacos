package com.cloud.oss.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cloud.oss.entity.SubjectExcel;
import com.cloud.oss.service.EasyExcelService;
import com.springcloud.exception.GlobalExceptionHandler;
import com.springcloud.exception.MyExceptionHandler;

/**
 * @ClassName SubjectListener
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/30 下午9:37.
 */

public class SubjectListener extends AnalysisEventListener<SubjectExcel> {

    private EasyExcelService easyExcelService;

    //    因为该类不是spring管理，所以不能注入其他属性方法，需要通过构造方法将对象传入
    public SubjectListener() {
    }

    public SubjectListener(EasyExcelService easyExcelService) {
        this.easyExcelService = easyExcelService;
    }

    //读取excel中数据
    @Override
    public void invoke(SubjectExcel data, AnalysisContext analysisContext) {
        if (data == null) {
            throw new MyExceptionHandler(20001, "文件数据为空");
        }
        //        一行一行读取
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
