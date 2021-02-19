package com.code.frame.basecode.annotation;

/**
 * 定义一个被加入注解的对象
 * @author duran
 * @date 2020.10.15
 */
public class Student {
    @MyField(description = "用户名", length = 12)
    private String username;
}
