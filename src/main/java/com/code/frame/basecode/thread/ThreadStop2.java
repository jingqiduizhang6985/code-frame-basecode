package com.code.frame.basecode.thread;

/**
 * 停止线程
 *
 * 静态内部类
 * @author asus
 * interrupt() 方法调用后，线程仍在运行。
 * 要使用 interrupt() 方法停止线程，需要在线程中判断中断状态，有两个方法：
 * interrupted()：测试当前线程是否是中断状态，执行后将状态清除，设置为 false；
 * isInterrupted()：作用同上，但是不清除状态。
 */
public class ThreadStop2 {

	static class Work extends Thread{
		@Override
		public void run(){
			 for (int i = 1; i <= 50000; i++) {
				 	if (isInterrupted()) {
	                    System.out.println("跳出循环!");
	                    break;
				 	}
				 	System.out.print("i = %d\n"+ i);
	            }
		}
	}

	public static void main(String[] args) throws Exception{
		Work t = new Work();
		t.start();
	    Thread.sleep(200);
//	    停止线程
//	    interrupt() 方法
//	    interrupt() 方法并不能立刻停止线程，只是在在线程中打了一个停止的标记
	    t.interrupt();// 这句的作用是 isInterrupted() = true
	    System.out.println("Call interrupt!");
	}
}
