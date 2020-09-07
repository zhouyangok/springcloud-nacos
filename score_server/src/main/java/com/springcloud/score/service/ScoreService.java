package com.springcloud.score.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springcloud.entities.Score;
import com.springcloud.result.CommonResult;
import com.springcloud.score.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ScoreService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/7 下午9:57.
 */
@Service
public class ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    public CommonResult createScore(Score score) {
        QueryWrapper<Score> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", score.getUserId());
        Score data = scoreMapper.selectOne(queryWrapper);
        if (data != null) {
            data.setScore(data.getScore() + score.getScore());
            scoreMapper.updateById(data);
            return CommonResult.success();
        }
        score.setCreateDate(DateUtil.date());
        scoreMapper.insert(score);
        return CommonResult.success();
    }

    public CommonResult getScore(Integer userId) {
        QueryWrapper<Score> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        Score data = scoreMapper.selectOne(queryWrapper);
        return CommonResult.success(data);
    }

}
