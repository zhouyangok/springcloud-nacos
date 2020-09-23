package com.order.service;

import com.springcloud.entity.Order;
import com.springcloud.result.CommonResult;

/**
 * @ClassName OrderService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/8 下午10:09.
 */

public interface OrderService {
    CommonResult createOrder(Order order);
    CommonResult getOrderById(Integer id);
    CommonResult updateOrder(Order order);
    CommonResult deleteOrder(Integer id);
    CommonResult pageQuery(int pageNum,int pageSize);
}
