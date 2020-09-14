package com.order.service;

import com.springcloud.entities.Stock;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName stockServiceFeign
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午10:01.
 */

@FeignClient(value = "stock-server",fallback = StockFallbackFeign.class)
public interface StockServiceFeign {

    @PostMapping("/stock/insertStock")
    CommonResult insertStock(@RequestBody Stock stock);

    @GetMapping("/stock/delStock/")
    CommonResult delStock(Integer id);
}
