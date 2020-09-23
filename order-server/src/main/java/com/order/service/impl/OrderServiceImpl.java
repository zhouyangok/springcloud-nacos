package com.order.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order.mapper.OrderMapper;
import com.order.service.OrderService;
import com.order.service.ScoreServiceFeign;
import com.order.service.StockServiceFeign;
import com.springcloud.entity.Order;
import com.springcloud.entity.Score;
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
    @Resource
    private StockServiceFeign stockServiceFeign;

    @Override
    public CommonResult createOrder(Order order) {
        //1、创建积分
        Score score = new Score();
        score.setScore(10);
        score.setUserId(1);
        CommonResult result = scoreService.createScore(score);
        if (result.getCode() != 200) {
            return result;
        }
        //2、创建订单
        order.setCreateDate(DateUtil.date());
        orderMapper.insert(order);
        //3、消减库存
        stockServiceFeign.delStock(1);
        return CommonResult.success();
    }

    @Override
    public CommonResult getOrderById(Integer id) {
        Order order = orderMapper.selectById(id);
        return CommonResult.success(order);
    }

    @Override
    public CommonResult updateOrder(Order order) {
        order.setCreateDate(DateUtil.date());
        int result = orderMapper.updateById(order);
        if (result > 0) {
            return CommonResult.success();
        }
        return CommonResult.fail();
    }

    @Override
    public CommonResult deleteOrder(Integer id) {
        Order order = orderMapper.selectById(id);
        if (order != null) {
            int result = orderMapper.deleteById(id);
            if (result > 0) {
                return CommonResult.success();
            }
            return CommonResult.fail("删除失败");
        }
        return CommonResult.fail("订单不存在");
    }

    @Override
    public CommonResult pageQuery(int pageNum, int pageSize) {
        Page<Order> page = new Page<>(pageNum, pageSize);
        IPage orderIPage = orderMapper.selectPage(page, null);
        return CommonResult.success(orderIPage);
    }
}
