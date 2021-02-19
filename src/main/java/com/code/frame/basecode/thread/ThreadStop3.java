package com.code.frame.basecode.thread;

import static java.lang.System.out;

/**
 * wait()  暂停线程
 * notify()唤醒线程
 * @author asus
 *
 */
public class ThreadStop3 {

    static class Work extends Thread {
        // 暂停标记
        private boolean isSuspended = false;

        void pause() {
            isSuspended = true;
        }

        synchronized void wake() {
            isSuspended = false;
            // 唤醒
            this.notify();
            out.println("已唤醒!");
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    for (int i = 1; i <= 5000; i++) {
                    	//判断线程是否为中断状态
                        if (isInterrupted()) {
                            return;
                        }

                        if (isSuspended) {
                            out.println("已暂停!");
                            // 等待
                            this.wait();
                        }

                        out.printf("%s i = %d\n", getName(), i);
                    }
                    out.printf("%s end!\n", getName());
                } catch (InterruptedException e) {
                    out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws Throwable {
        Work work = new Work();
        work.start();
        Thread.sleep(100);
        // 暂停
        work.pause();
        Thread.sleep(100);
        // 唤醒
        work.wake();
    }
}
