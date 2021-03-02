package com.code.frame.basecode.jdk8;

public interface InterfaceCar {
    default void print(){
        System.out.println("我是一个car");
    }
}
