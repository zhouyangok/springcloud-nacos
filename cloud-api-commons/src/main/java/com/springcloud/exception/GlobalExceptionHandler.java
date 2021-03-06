package com.springcloud.exception;

import com.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GlobleException
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/11/26 下午8:23.
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

//springcloud的全局异常一直无效，因为springapplication启动的时候，
// 没有扫描到这个包文件，没有办法注册到springbean容器中，需要手动扫描

    /**
     * 全局异常处理
     *
     * @param e
     * @return
     */

    @ExceptionHandler(Exception.class)
    public CommonResult error(Exception e) {
        e.printStackTrace();
        log.info("执行了全部异常");
        return CommonResult.fail("程序异常");
    }


    /**
     * 特定异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public CommonResult error(NullPointerException e) {
        e.printStackTrace();
        return CommonResult.fail("空指针异常");
    }


    /**
     * 自定义异常-需要主动try-catch抛出
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyExceptionHandler.class)
    public CommonResult myException(MyExceptionHandler e) {
        e.printStackTrace();
        log.info("执行了自定义异常");
        return CommonResult.fail(e.getMsg());
    }
}
