package com.code.frame.basecode.annotation;

public class Test2 {
    public static void main(String[] args) throws Exception {

//        Student student = (Student)ObjectEntityManger.createEntity(Student.class);
//        System.out.println(student);
        Order order = (Order)ObjectEntityManger.createEntity(Order.class);
        System.out.println(order);
    }
}
