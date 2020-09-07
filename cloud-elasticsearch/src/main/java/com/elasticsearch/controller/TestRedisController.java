package com.elasticsearch.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @ClassName TestRedisController
 * @Description: redis 测试
 * @Author zhouyang
 * @Date 2020/8/4 下午9:11.
 */
@RestController
@RequestMapping("/redis")
public class TestRedisController {

    @RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public int getUser() {
        int s =123456;
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return s;
    }


    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
