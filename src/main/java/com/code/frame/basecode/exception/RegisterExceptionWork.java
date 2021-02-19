package com.code.frame.basecode.exception;

import java.util.Scanner;

/**
 * 对自定义异常 RegisterException 的使用
 */

public class RegisterExceptionWork {

    //数据库用户名
    static String[] userNames = {"张三", "李四", "王五"};

    public static void main(String[] args) {
        //输入注册的用户名
        System.out.println("请输入用户名：");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        //循环遍历userNames数组，查询用户名是否已经存在
        for (String name : userNames) {
            //如果存在，抛出异常，中断程序
            if (name.equals(username)) {
                throw new RegisterException("用户名已经存在");
            }
        }
        //如果不存在，输出注册成功
        System.out.println("注册成功");
    }
}
