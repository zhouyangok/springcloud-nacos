package com.order.controller;

import cn.hutool.core.convert.Convert;
import com.springcloud.entity.Order;
import com.springcloud.entity.Stock;
import com.springcloud.result.CommonResult;
import com.order.util.RedisUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisTestController
 * @Description: redis测试接口
 * @Author zhouyang
 * @Date 2020/9/17 下午8:27.
 */
@RestController
@RequestMapping("/redisTest")
@Api(tags = "redis测试接口")
public class RedisTestController {

    @Resource
    RedisUtil redisUtil;


    /**
     * 设置缓存过期时间
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    @GetMapping("/testExpire")
    public String testExpire(String key, String value) throws Exception {
        redisUtil.set(key, value);
        redisUtil.expire(key, 5);
        String d1 = Convert.toStr(redisUtil.get(key));
        TimeUnit.SECONDS.sleep(10);
        String d2 = Convert.toStr(redisUtil.get(key));
        return "d1:" + d1 + ",d2:" + d2;
    }

    /**
     * 设置值
     *
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/setRedis")
    public CommonResult setRedis(String key, String value) {
        redisUtil.set(key, value);
        return CommonResult.success(redisUtil.get(key));
    }

    /**
     * 获取值
     *
     * @param key
     * @return
     */
    @GetMapping("/getRedis")
    public CommonResult getRedis(String key) {
        Object o = redisUtil.get(key);
        return CommonResult.success(o);
    }


    /**
     * 测试redis存储对象
     *
     * @return
     */
    @GetMapping("/testSetObject")
    public CommonResult testSetObject() {
        // 测试对象
        Order testModel = new Order();
        testModel.setId((int) Math.random());
        testModel.setName("测试");
        redisUtil.set("testModel", testModel);
        Order testModel2 = (Order) redisUtil.get("testModel");
        System.err.println(testModel2);
        System.err.println(testModel2.getName());
        System.err.println(testModel2.getId());
        return CommonResult.success(testModel2);
    }

    /**
     * 递增操作
     *
     * @param key
     * @return
     * @throws Exception
     */
    @GetMapping("/testIncr")
    public CommonResult testIncr(String key) throws Exception {
        System.out.println(redisUtil.get(key));
        redisUtil.incr(key, 1);
        redisUtil.expire(key, 10); // 缓存失效10s
        return CommonResult.success(redisUtil.get(key));
    }


    /**
     * 高并发下 递增 测试
     *
     * @throws Exception
     */

    @GetMapping("/testIncr2")
    public void testIncr2() throws Exception {
        // 模拟发送短信的并发
        // 首先开启一个线程池，创建一个专门消费短信的线程
        // 一次性放入多个线程实例 ，实例 都是2秒请求一次 ，而10s内的只能允许一条。 也就是说我测试100个线程，只能10s一条
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //
                    String key = "testIncr2_17353620612";
                    long count = redisUtil.incr(key, 1);
                    if (count == 1L) {
                        redisUtil.expire(key, 10); // 缓存失效10s
                        System.err.println("短信发送成功===" + new Date());

                    } else {
                        System.err.println("访问次数快===" + new Date());
                    }
                }
            });
            threadPoolExecutor.submit(threads[i]);
        }

        while (threadPoolExecutor.getQueue().isEmpty()) {
            threadPoolExecutor.shutdown();
            System.err.println("所有线程执行完毕");
        }

        System.in.read();// 加入该代码，让主线程不挂掉

//        // 启动线程
//        for (int i = 0; i < 100; i++) {
//            threads[i].start();
//        }
    }


    @GetMapping("/testDecr")
    public CommonResult testDecr() throws Exception {
        String key = "Decr_17353620612";
        redisUtil.decr(key, 1);
        redisUtil.expire(key, 10); // 缓存失效10s
        return CommonResult.success(redisUtil.get(key));
    }


    /**
     * 测试放在hash 里面的对象
     */
    @GetMapping("/testHsetObject")
    public void testHsetObject() {
        // 测试对象
        Stock testModel = new Stock();
        testModel.setId(Convert.toInt(Math.random()));
        testModel.setProductId(234);
        redisUtil.hset("hash", "testModel", testModel);
        Stock testModel2 = (Stock) redisUtil.hget("hash", "testModel");
        System.err.println(testModel2);
        System.err.println(testModel2.getProductId());
        System.err.println(testModel2.getId());
    }

    /**
     * 太奇妙了 放进去Long 取出来会根据大小变为相应的数据类型
     *
     * @throws Exception
     */
    @GetMapping("/testHsetStringStringObjectLong")
    public void testHsetStringStringObjectLong() throws Exception {
        redisUtil.hset("testHsetStringStringObjectLong", "int", 100); // java.lang.Integer 读取来是inter
        System.err.println(redisUtil.hget("testHsetStringStringObjectLong", "int").getClass().getTypeName());
//        Assert.assertEquals(redisUtil.hget("map", "testHsetStringStringObject"), 100L);
        redisUtil.hset("testHsetStringStringObjectLong", "long", System.currentTimeMillis()); // java.lang.Integer 读取来是inter
        System.err.println(redisUtil.hget("testHsetStringStringObjectLong", "long").getClass().getTypeName());

    }

    @GetMapping("/testLGetListSize")
    public void testLGetListSize() throws Exception {
        // 看看重复元素会怎么处理
        long size = 0;
        redisUtil.lSet("testLGetListSize", "testLGetListSize0", 10); // 10秒过期
        size = redisUtil.lGetListSize("testLGetListSize");
        System.err.println(size);
        redisUtil.lSet("testLGetListSize", "testLGetListSize0", 10);
        size = redisUtil.lGetListSize("testLGetListSize");
        System.err.println(size);
    }


}
