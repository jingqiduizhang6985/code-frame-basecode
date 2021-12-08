package com.code.frame.basecode.jdk8;

/**
 * lambda 表达式的局部变量可以不用声明为 final，
 * 但是必须不可被后面的代码修改（即隐性的具有final 的语义）
 */
public class Java8Tester4 {
    public static void main(String[] args) {
        int num = 1;
        Converter<Integer, String> s = (param) ->
                System.out.println((param + num));
        s.convert(2);
//        num = 5;
    }
    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
