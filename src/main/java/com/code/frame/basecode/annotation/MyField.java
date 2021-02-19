package com.code.frame.basecode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个注解
 * Target：描述了注解修饰的对象范围，取值在java.lang.annotation.ElementType定义，常用的包括：
 * METHOD：用于描述方法
 * PACKAGE：用于描述包
 * PARAMETER：用于描述方法变量
 * TYPE：用于描述类、接口或enum类型
 * FIELD: 注解用于字段上
 *
 * Retention: 表示注解保留时间长短。取值在java.lang.annotation.RetentionPolicy中，取值为：
 * SOURCE：在源文件中有效，编译过程中会被忽略
 * CLASS：随源文件一起编译在class文件中，运行时忽略
 * RUNTIME：在运行时有效
 *
 * @author duran
 * @date 2020.10.15
 */
@Target(ElementType.FIELD)//  注解用于字段上
//@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)// 保留到运行时，可通过注解获取
public @interface MyField {
    String description();
    int length();
}
