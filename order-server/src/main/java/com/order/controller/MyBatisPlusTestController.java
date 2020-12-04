package com.order.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyBatisPlusTestController
 * @Description: todo
 * @Author zhouyang
 * @Date 2020/12/4 下午9:35.
 */
@Api("mybatisPlus接口学习")
@RestController
@RequestMapping("/mybatisPlus")
public class MyBatisPlusTestController {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        String ab = Convert.toStr(list);
        String join1 = StrUtil.join(",", list);
        System.out.println(join1);
        System.out.println(ab);//[a1, a2, a3]
        //        =============
        String join = StringUtils.join(list.toArray(), ",");
        System.out.println(join);

    }
}
