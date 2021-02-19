package com.code.frame.basecode.thread;

public class ThreadExtendAction {

    public static void main(String[] args)throws Exception {
        //获取线程子类对象
        ThreadExtend work = new ThreadExtend();

        System.out.println("活跃状态1： "+ work.isAlive());
        //开启线程
        work.start();

        //睡眠1秒
        Thread.sleep(1000);

        System.out.println("活跃状态2： "+ work.isAlive());

//		//获取线程子类对象
//		ThreadWork1 work1 = new ThreadWork1();
//		//开启线程
//		work1.start();
        System.out.println("End");
    }
}
