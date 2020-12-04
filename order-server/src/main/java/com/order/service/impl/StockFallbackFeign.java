package com.order.service.impl;

import com.order.service.StockServiceFeign;
import com.springcloud.entity.Stock;
import com.springcloud.result.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @ClassName StockFallbackFeign
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午10:02.
 */
@Component
public class StockFallbackFeign implements StockServiceFeign {

    @Override
    public CommonResult insertStock(Stock stock) {
        return CommonResult.fail("创建库存失败--接口错误，请联系管理员");
    }

    @Override
    public CommonResult delStock(Integer id) {
        return CommonResult.fail("削减库存失败--接口错误，请联系管理员");
    }
}
