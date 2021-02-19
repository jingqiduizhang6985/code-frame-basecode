package com.code.frame.basecode.thread;

public class ThreadStop1 {

	static class Work extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 50000; i++) {
                    if (isInterrupted()) {
                        System.out.println("Interrupted！");
                        throw new InterruptedException("抛出异常！");
                    }
                    System.out.printf("i = %d\n", i);
                }
                System.out.println("for 循环结束!");
            } catch (InterruptedException e) {
            	 System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Throwable {
        Work work = new Work();
        work.start();
        Thread.sleep(200);
        work.interrupt();// 这句的作用是 isInterrupted() = true
        System.out.println("Call interrupt!");
    }
}
