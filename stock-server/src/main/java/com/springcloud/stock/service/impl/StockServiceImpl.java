package com.springcloud.stock.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springcloud.entity.Stock;
import com.springcloud.result.CommonResult;
import com.springcloud.stock.mapper.StockMapper;
import com.springcloud.stock.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName StockServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午9:39.
 */
@Service
public class StockServiceImpl implements StockService {
    @Resource
    private StockMapper stockMapper;
    @Override
    public CommonResult insertStock(Stock stock) {
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", stock.getProductId());
        Stock data = stockMapper.selectOne(queryWrapper);
        if(null!=data){
            return CommonResult.fail("商品库存已存在");
        }
        stock.setCreateDate(DateUtil.date());
        stockMapper.insert(stock);
        return CommonResult.success();
    }

    @Override
    public CommonResult getStock(Integer id) {
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", id);
        Stock stock = stockMapper.selectOne(queryWrapper);
        if(null!=stock){
            return CommonResult.success(stock);
        }
        return CommonResult.fail();
    }

    @Override
    public CommonResult delStock(Integer id) {
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", id);
        Stock stock = stockMapper.selectOne(queryWrapper);
        if(null!=stock){
            if(stock.getStockNumber()>0){
                stock.setStockNumber(stock.getStockNumber()-1);
            }
            stockMapper.updateById(stock);
            return CommonResult.success();
        }
        return CommonResult.fail();
    }
}
