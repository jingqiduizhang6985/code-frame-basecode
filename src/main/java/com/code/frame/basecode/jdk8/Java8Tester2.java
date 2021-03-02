package com.code.frame.basecode.jdk8;

/**
 * 变量作用域
 * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在lambda
 * 内部修改定义在域外的局部变量，否则会编译错误。
 */
public class Java8Tester2 {
    final static String salutation = "Hello! ";

    public static void main(String[] args) {
        GreetingService greetingService = message ->
                System.out.println(salutation + " " + message);
        greetingService.sendMessage("Runoob");

    //====================相当于下面==============================
    GreetingService g = new GreetingService() {
        @Override
        public void sendMessage(String message) {
            System.out.println(salutation + message);
        }
    };
    g.sendMessage("jack");
    }
    interface GreetingService{
        void sendMessage(String message);
    }
}
