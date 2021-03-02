package com.code.frame.basecode.jdk8;

/**
 * Java 8 新增了接口的默认方法。
 */
public interface Java8Interface {
    default void print() {
        System.out.println("我是一辆车!");
    }
}
