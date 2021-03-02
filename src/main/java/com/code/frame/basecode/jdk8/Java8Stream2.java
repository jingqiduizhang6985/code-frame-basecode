package com.code.frame.basecode.jdk8;

import java.util.Random;

public class Java8Stream2 {
    public static void main(String[] args) {
        Random random = new Random();
        //遍历10个随机数
        random.ints().limit(10).forEach(System.out::println);
    }
}
