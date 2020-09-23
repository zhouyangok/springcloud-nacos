package com.springcloud.stock.controller;

import com.springcloud.entity.Stock;
import com.springcloud.result.CommonResult;
import com.springcloud.stock.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName StockController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午9:35.
 */
@RestController
@Slf4j
@RequestMapping("/stock")
@Api(tags = "积分服务接口")
public class StockController {

    @Resource
    private StockService stockService;

    @ApiOperation("新增库存")
    @PostMapping("/insertStock")
    public CommonResult insertStock(@RequestBody Stock stock) {
        return stockService.insertStock(stock);
    }

    @ApiOperation("根据商品id获取商品库存")
    @ApiImplicitParam(name = "id", value = "商品id", required = true)
    @GetMapping("/getStock/{id}")
    public CommonResult getStock(@PathVariable Integer id) {
        return stockService.getStock(id);
    }

    @ApiOperation("根据商品id获取商品减库存")
    @ApiImplicitParam(name = "id", value = "商品id", required = true)
    @GetMapping("/delStock/{id}")
    public CommonResult delStock(@PathVariable Integer id) {
        return stockService.delStock(id);
    }
}
