package com.order.service;

import com.springcloud.entities.Score;
import com.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ScoreService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/7 下午10:29.
 */
@FeignClient("score-server")
@RequestMapping("/score")
public interface ScoreService {

    @PostMapping("/createScore")
    CommonResult createScore(@RequestBody Score score);
}