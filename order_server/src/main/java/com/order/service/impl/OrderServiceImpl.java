package com.order.service.impl;

import cn.hutool.core.date.DateUtil;
import com.order.mapper.OrderMapper;
import com.order.service.OrderService;
import com.order.service.ScoreServiceFeign;
import com.springcloud.entities.Order;
import com.springcloud.entities.Score;
import com.springcloud.result.CommonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName OrderService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/6 下午9:50.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ScoreServiceFeign scoreService;

    @Override
    public CommonResult createOrder(Order order) {
        //1、创建积分
        Score score = new Score();
        score.setScore(10);
        score.setUserId(1);
        scoreService.createScore(score);
        //2、创建订单
        order.setCreateDate(DateUtil.date());
        orderMapper.insert(order);
        return CommonResult.success();
    }

    @Override
    public CommonResult getOrderById(Integer id) {
        Order order = orderMapper.selectById(id);
        return CommonResult.success(order);
    }
}
