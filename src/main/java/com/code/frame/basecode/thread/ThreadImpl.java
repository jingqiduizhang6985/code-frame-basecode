package com.code.frame.basecode.thread;

/**
 * 线程方式2 实现Runnable接口
 */
public class ThreadImpl implements Runnable{

    @Override
    public void run(){
//		currentThread() 方法返回正在被执行的线程的信息。
        System.out.println(Thread.currentThread().getName());
        System.out.println("工作中...");
    }
}
