package com.code.frame.basecode.jdk8;

/**
 * 静态默认方法
 */
public interface InterfaceStatic {
    default void print() {
        System.out.println("我是一辆车!");
    }
    // 静态方法
    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }
}
