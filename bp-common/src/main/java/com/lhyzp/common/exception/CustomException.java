package com.lhyzp.common.exception;

/**
 * 自定义异常
 * Created by Administrator on 2017-12-22.
 */
public class CustomException extends RuntimeException{

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
