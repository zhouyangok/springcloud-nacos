package com.cloud.oss.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.cloud.oss.utils.ConstantPropertiesUtils;
import com.cloud.oss.service.OssService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @ClassName OssServiceImpl
 * @Description: 文件上传
 * @Author zhouyang
 * @Date 2020/11/29 下午1:46.
 */
@Service
public class OssServiceImpl implements OssService {
    /**
     * 上传文件到oss
     *
     * @param file
     * @return
     */
    @Override
    public String uploadAvatar(MultipartFile file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 上传文件流。
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            originalFilename = uuid + originalFilename.replace("-","");
            String datePath = new DateTime().toString("yyyy/MM/dd");
            originalFilename = datePath + "/" + originalFilename;
            //第一个参数 bucketName名称
            //第二个参数 上传到oss文件路径和文件名称
            //第三个参数 输入流
            ossClient.putObject(bucketName, originalFilename, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            //返回上传路径
            String url = "https://" + bucketName + "." + endpoint + "/" + originalFilename;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
