package com.order.controller;

import com.order.service.OrderService;
import com.order.service.ScoreServiceFeign;
import com.springcloud.entities.Order;
import com.springcloud.entities.Score;
import com.springcloud.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    private ScoreServiceFeign scoreService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id " + id;
    }

    @ApiOperation("创建订单")
    @PostMapping("/createOrder")
    public CommonResult createOrder(@RequestBody Order order) {

        return orderService.createOrder(order);
    }

    @ApiOperation("根据id获取订单详情")
    @ApiImplicitParam(name = "id", value = "订单id", required = true)
    @GetMapping("/getOrder/{id}")
    public CommonResult getOrder(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }


    @ApiOperation("分页查询获取订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true)
    })
    @GetMapping("/pageQuery")
    public CommonResult pageQuery(@RequestParam int pageNum, @RequestParam int pageSize) {
        return orderService.pageQuery(pageNum, pageSize);
    }
}
