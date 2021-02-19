package com.code.frame.basecode.thread;

/**
 * 线程方式一 继承Thread 实现run方法
 */
public class ThreadExtend extends Thread{
    @Override
    public void run() {
//		currentThread() 方法返回正在被执行的线程的信息。
        System.out.println(Thread.currentThread().getName());
        System.out.println("活跃状态0： "+ isAlive());
        System.out.println("我是一个线程，正在工作中....");
    }

}
