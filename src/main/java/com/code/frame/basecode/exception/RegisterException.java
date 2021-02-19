package com.code.frame.basecode.exception;

/**
 * 自定义注册异常，继承RuntimeException
 */
public class RegisterException extends RuntimeException {
    //定义无参构造方法
    public RegisterException() {
        super();
    }

    //定义有参构造方法
    public RegisterException(String message) {
        super(message);
    }
}
