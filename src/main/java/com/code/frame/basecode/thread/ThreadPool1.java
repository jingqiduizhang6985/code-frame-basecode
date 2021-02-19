package com.code.frame.basecode.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool1 {
	private static int status = 0;
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
						System.out.println("status "+ status);
						status++;
						System.out.println("在线程池中开启了一个线程  "+Thread.currentThread().getName());
						if(status==5){//当status=5的时候 抛出异常 该线程中断退出while循环。
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
				 //线程未中断的时候执行
				 while (!Thread.currentThread().isInterrupted()) {
					try {
						Thread.sleep(1000);
						System.out.println("在线程池中开启了一个线程  "+Thread.currentThread().getName());
					} catch (Exception e) {
						//如果出现异常 设置为中断状态 跳出本次循环。
						Thread.currentThread().interrupt();
					}
				}
			}

		});
	}

	public void work3(){
		executor.execute(new Runnable() {
			@Override
			public void run() {
				Thread.currentThread().setName(this.getClass().getName() + " work3");
				 //线程未中断的时候执行
				while (!Thread.currentThread().isInterrupted()) {
					try {

						Thread.sleep(1000);
						System.out.println("在线程池中开启了一个线程  "+Thread.currentThread().getName());
						System.out.println("线程池活动线程数量 "+executor.getActiveCount());
						System.out.println("任务数量： "+ executor.getTaskCount());
					} catch (Exception e) {
						//如果出现异常 设置为中断状态 跳出本次循环。
						Thread.currentThread().interrupt();
					}
				}
			}

		});
	}


	public static void main(String[] args) throws Exception{
		ThreadPool1 t = new ThreadPool1();
		t.work1();
		t.work2();
		t.work3();
	}
}
