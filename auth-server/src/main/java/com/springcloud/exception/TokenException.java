package com.springcloud.exception;

/**
 * @ClassName TokenException
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/9/16 下午10:37.
 */

public class TokenException extends BaseException {

    private static final long serialVersionUID = 1L;

    public TokenException(String message) {
        super(message);
    }
}
