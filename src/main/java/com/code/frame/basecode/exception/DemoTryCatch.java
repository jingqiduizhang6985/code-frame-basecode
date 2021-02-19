package com.code.frame.basecode.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DemoTryCatch {
    public static void main(String[] args) {
        //捕获异常
        try {
            //可能产生异常的代码
            readFile();
        } catch (FileNotFoundException e) {
            //异常的处理逻辑，将异常记录日志，异常封装后显示
            System.out.println("系统找不到指定的路径");
        } finally {
            System.out.println("我被执行了...");
        }
        System.out.println("后续代码....");

    }

    public static void readFile() throws FileNotFoundException {
        InputStream is = new FileInputStream("E:/iodemo/ch01.txt");
    }

}
