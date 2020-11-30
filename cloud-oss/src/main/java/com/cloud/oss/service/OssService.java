package com.cloud.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName OssService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/29 下午1:46.
 */

public interface OssService {
    String uploadAvatar(MultipartFile file);
}
