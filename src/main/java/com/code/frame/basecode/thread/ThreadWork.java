package com.code.frame.basecode.thread;

public class ThreadWork {

	private Thread thread;
	private static int status=0;

	public void work1(){
		System.out.println("进来了");
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				//如果是未中断状态
				while(!Thread.currentThread().isInterrupted()){
					try {
						//
						Thread.sleep(1000);
						System.out.println("执行任务中work1...");
					} catch (InterruptedException e) {
						//如果出现异常 设置为中断状态 跳出本次循环。
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				}

			}
		});
		thread.start();
	}

	public void work2(){
		System.out.println("进来了");
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				//如果是未中断状态
				while(!Thread.currentThread().isInterrupted()){
					try {
						//
						Thread.sleep(2000);
						System.out.println("执行任务中work2...");

						//当符合条件时 抛出异常退出while循环。
						status++;
						System.out.print("status "+status);
						if(status==10){
							 throw new InterruptedException("抛出异常！");
						}
					} catch (InterruptedException e) {
						//如果出现异常 设置为中断状态 跳出本次循环。
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				}

			}
		});
		thread.start();
	}

	public void work3(){
		System.out.println("进来了");
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				//如果是未中断状态
				while(!Thread.currentThread().isInterrupted()){
					try {
						//
						Thread.sleep(3000);
						System.out.println("执行任务中work3...");
					} catch (InterruptedException e) {
						//如果出现异常 设置为中断状态 跳出本次循环。
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				}

			}
		});
		thread.start();
	}


	public static void main(String[] args) throws Exception{
		ThreadWork t = new ThreadWork();
		t.work1();
		t.work2();
		t.work3();
	}
}
