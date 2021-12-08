package com.code.frame.basecode.jdk8;

/**
 * 我们也可以直接在lambda 表达式中访问外层的局部变量：
 */
public class Java8Tester3 {
    public static void main(String[] args) {
        final int num = 1;
        Converter<Integer, String> s = (param) ->
                System.out.println((param + num));
        s.convert(2);  // 输出结果为 3
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
