package com.code.frame.basecode.jvm.test;

public class Test01 {
    public Test01() {
    }

    public static void main(String[] args) {

//-Xmx20m -Xms5m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags

//-Xmx20m -Xms5m -XX:+PrintGCDetails
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
        System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
        System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
        byte[] b1 = new byte[1*1024*1024];
        System.out.println("分配了1M");
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
        System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
        System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
        byte[] b2 = new byte[4*1024*1024];
        System.out.println("分配了4M");
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
        System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
        System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
    }
}
