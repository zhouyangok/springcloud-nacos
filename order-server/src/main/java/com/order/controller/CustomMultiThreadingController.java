package com.order.controller;

import com.order.service.impl.CustomMultiThreadingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CustomMultiThreadingController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/1/6 下午9:52.
 */
@Api(tags = "线程池学习")
@RestController
@RequestMapping("/multithreading")
public class CustomMultiThreadingController {
    @Autowired
    private CustomMultiThreadingService customMultiThreadingService;


    @GetMapping("/doTask")
    public String doTask() {

        try {
            for (int i = 0; i < 100000; i++) {
                customMultiThreadingService.executeAysncTask(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "success";
    }

}
