package com.code.frame.basecode.lock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * 参考地址
 * https://blog.csdn.net/canot/article/details/50879963
 */

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        public void run() {
            //加锁
            synchronized (lock) {
                //当条件不满足的时候，进入WAITTING状态，同时释放lock锁
                while (flag) {
                    System.out.println("flag is true ");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足
                System.out.println("doSomething");
            }
        }
    }

    static class Notify implements Runnable {
        public void run() {
            //加锁
            synchronized (lock) {
                //获取lock的锁，然后进行通知，通知不会释放lock锁
                //直到发出通知的线程执行完毕释放了lock锁，WaitThread线程才能从wait方法返回
                lock.notifyAll();
                System.out.println("flag is false now");
                flag = false;
            }
        }
    }

}
