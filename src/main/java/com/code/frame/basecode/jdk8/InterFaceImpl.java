package com.code.frame.basecode.jdk8;

public class InterFaceImpl implements InterfaceCar,InterfaceDoor {
 //这种方式 覆盖父类的方法
//    @Override
//    public void print() {
//        System.out.println("我是一个实现类");
//    }
    //这种方式 使用指定的父类接口的方法。
     @Override
     public void print() {
         InterfaceCar.super.print();
     }
    public static void main(String[] args) {
        InterFaceImpl data = new InterFaceImpl();
        data.print();
    }

}
