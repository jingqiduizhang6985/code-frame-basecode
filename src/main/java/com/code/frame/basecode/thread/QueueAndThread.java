package com.code.frame.basecode.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用线程池 + 队列 模拟存和取
 */
public class QueueAndThread {

    private static int status = 0 ;
    //一个队列
    private static Queue<String> queue = new LinkedList<String>();
    //	初始化 线程等待队列
    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(5000);	//线程池和线程池队列
    //	初始化 线程池 初始化线程池10个 最大线程数50个 线程最大空闲时间1分钟 线程等待队列workQueue
    protected ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 1, TimeUnit.MINUTES, workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());

    public void work1(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(this.getClass().getName() + " work1");
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(2000);
                        System.out.println("在线程池中开启了一个线程  "+Thread.currentThread().getName());
                        //添加数据到队列中
                        queue.offer("data"+status);
                        status ++;
                        System.out.println("队列存储数量为："+queue.size());
                        //当status=5的时候 抛出异常 该线程中断退出while循环。
                        //主要目的是 让线程1 停止 不再向队列中添加
                        if(status==10){
                            throw new InterruptedException("抛出异常！");
                        }
                    } catch (Exception e) {
                        //如果出现异常 设置为中断状态 跳出本次循环。
                        Thread.currentThread().interrupt();
                    }
                }
            }

        });

    }

    public void work2(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(this.getClass().getName() + " work2");
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("在线程池中开启了一个线程  "+Thread.currentThread().getName());
                        System.out.println("队列存储数量为："+queue.size());
                        if(queue.size()>0){
                            //从队列中删除一个元素并返回元素
                            String str = queue.poll();
                            System.out.println("取出的元素为 "+str);
                        }
                    } catch (Exception e) {
                        //如果出现异常 设置为中断状态 跳出本次循环。
                        Thread.currentThread().interrupt();
                    }
                }
            }

        });

    }

    public static void main(String[] args) {

        QueueAndThread t = new QueueAndThread();
        t.work1();
        t.work2();

        for(int i=0;i<=10;i++){
            queue.offer("dataMain"+i);
        }

    }

}
