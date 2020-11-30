package com.cloud.oss.controller;

import com.cloud.oss.service.OssService;
import com.springcloud.result.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName OSSController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/29 下午1:45.
 */
@Api(value = "文件上传")
@RestController
@RequestMapping("/fileOss")
public class OSSController {

    @Autowired
    private OssService ossService;

    @PostMapping("/uploadAvatar")
    public CommonResult uploadAvatar(MultipartFile file) {
        //获取上传文件
        String url =ossService.uploadAvatar(file);
        return CommonResult.success(url);
    }
}
