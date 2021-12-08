package com.code.frame.basecode.jdk8;

/**
 * 4.4 默认方法实例
 * 我们可以通过以下代码来了解关于默认方法的使用，可以将代码放入 Java8Tester.java 文件中：
 */
public class Java8Tester7 {
    public static void main(String[] args) {
        Vehicle vehicle = new Java8Tester7Car();
        vehicle.print();
    }
}

interface Vehicle {
    default void print() {
        System.out.println("我是一辆车!");
    }

    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("我是一辆四轮车!");
    }
}
