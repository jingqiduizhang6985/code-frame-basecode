package com.code.frame.basecode.base;

public class Person {

    Person(){
        System.out.println("父类的构造方法");
    }

    static {
        System.out.println("父类的静态方法");
    }

    public void eat(){
        System.out.println("父类的公有方法");
    }

}
