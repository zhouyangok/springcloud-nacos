package com.authorization.exception;

import com.springcloud.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandlerAdvice
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午1:11.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends GlobalExceptionHandler {
}
