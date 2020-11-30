package com.cloud.oss.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cloud.oss.entity.ExcelReadDemo;

import java.util.Map;

/**
 * @ClassName ExcelListener
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/30 下午9:14.
 */

public class ExcelListener extends AnalysisEventListener<ExcelReadDemo> {

    //    一行一行的读取excel中内容
    @Override
    public void invoke(ExcelReadDemo data, AnalysisContext analysisContext) {
        System.out.println("****" + data);
    }

    //读取表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头***" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
