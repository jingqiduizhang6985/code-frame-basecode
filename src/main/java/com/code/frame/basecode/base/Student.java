package com.code.frame.basecode.base;

public class Student extends Person{

    Student(){
        System.out.println("子类的构造方法");
    }

    static {
        System.out.println("子类的静态块");
    }

    public void study(){
        System.out.println("子类的公有方法");
    }
}
