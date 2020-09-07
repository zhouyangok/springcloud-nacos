package com.order.service;

import cn.hutool.core.date.DateUtil;
import com.order.mapper.OrderMapper;
import com.springcloud.entities.Order;
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
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    public CommonResult createOrder(Order order){
        order.setCreateDate(DateUtil.date());
        orderMapper.insert(order);
        return CommonResult.success();
    }

    public CommonResult getOrderById(Integer id){
        Order order = orderMapper.selectById(id);
        return CommonResult.success(order);
    }
}
