package com.springcloud.stock.service;

import com.springcloud.entities.Stock;
import com.springcloud.result.CommonResult;

/**
 * @ClassName StockServic
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午9:38.
 */

public interface StockService {

    public CommonResult insertStock(Stock stock);

    public CommonResult getStock(Integer id);

    public CommonResult delStock(Integer id);
}
