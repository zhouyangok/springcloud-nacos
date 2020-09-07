package com.order.controller;

import com.order.service.OrderService;
import com.order.service.ScoreService;
import com.springcloud.entities.Order;
import com.springcloud.entities.Score;
import com.springcloud.entities.User;
import com.springcloud.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TestNacosController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/7/1 下午1:32.
 */

@RestController
@RequestMapping("/order")
@Api(tags = "订单服务接口")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ScoreService scoreService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id " + id;
    }

    @ApiOperation("创建订单")
    @PostMapping("/createOrder")
    public CommonResult createOrder(@RequestBody Order order) {
        Score score = new Score();
        score.setScore(10);
        score.setUserId(1);
        scoreService.createScore(score);
        return orderService.createOrder(order);
    }

    @ApiOperation("根据id获取订单详情")
    @ApiImplicitParam(name = "id", value = "订单id", required = true)
    @GetMapping("/getOrder/{id}")
    public CommonResult getOrder(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

}
