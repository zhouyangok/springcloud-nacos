package com.springcloud.exception;

/**
 * @ClassName BaseException
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/16 下午10:36.
 */

public class BaseException extends RuntimeException{

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
