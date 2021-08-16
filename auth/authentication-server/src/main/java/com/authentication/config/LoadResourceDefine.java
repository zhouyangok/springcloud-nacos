package com.authentication.config;

import com.authentication.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName LoadResourceDefine
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:14.
 */
@Component
public class LoadResourceDefine {

    @Autowired
    private IResourceService resourceService;

    /**
     *取消返回的bean防止外部出现线程安全问题
     * 2020/5/15
     * @return
     */
    @PostConstruct
    public void resourceConfigAttributes() {
        resourceService.loadResource();
    }
}
