package com.cloud.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName EasyExcelService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/30 下午9:34.
 */

public interface EasyExcelService {
    void readExcel(MultipartFile file,EasyExcelService easyExcelService);
}
