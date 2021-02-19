package com.code.frame.basecode.base;

/**
 * 父子之间 执行顺序
 *
 * 父类的静态方法
 * 子类的静态块
 * 父类的构造方法
 * 子类的构造方法
 * 子类的公有方法
 */
public class Test {

    public static void main(String[] args) {

        Student student = new Student();
        student.study();

    }
}
