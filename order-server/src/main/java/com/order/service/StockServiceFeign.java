package com.order.service;

import com.order.service.impl.StockFallbackFeign;
import com.springcloud.entity.Stock;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName stockServiceFeign
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午10:01.
 */

@FeignClient(value = "stock-server", path = "/stock", fallback = StockFallbackFeign.class)
public interface StockServiceFeign {
    //RequestParam或者PathVarible参数，都应该加name注解
    @PostMapping("/insertStock")
    CommonResult insertStock(@RequestBody Stock stock);

    @GetMapping("/delStock")
    CommonResult delStock(@RequestParam(name = "id") Integer id);
}
