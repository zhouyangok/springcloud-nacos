package com.springcloud.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.entity.Stock;
import org.springframework.stereotype.Component;

/**
 * @ClassName StockMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/14 下午9:43.
 */
@Component
public interface StockMapper extends BaseMapper<Stock> {
}
