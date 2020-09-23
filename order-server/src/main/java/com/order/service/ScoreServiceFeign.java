package com.order.service;

import com.springcloud.entity.Score;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName ScoreService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/7 下午10:29.
 */
@FeignClient(value = "score-server",path = "/score",fallback = ScoreFallbackFeign.class)
public interface ScoreServiceFeign {

    @PostMapping("/createScore")
    CommonResult createScore(@RequestBody Score score);
}
