package com.code.frame.basecode.jdk8;

public class Java8Tester7Car implements Vehicle, FourWheeler {
        public void print() {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("我是一辆汽车!");
        }
}
