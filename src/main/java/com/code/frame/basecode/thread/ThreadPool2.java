package com.code.frame.basecode.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {
//	初始化 线程等待队列
	protected BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(5000);	//线程池和线程池队列
//	初始化 线程池 初始化线程池10个 最大线程数50个 线程最大空闲时间1分钟 线程等待队列workQueue
	protected ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 1, TimeUnit.MINUTES, workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());

	public void work1(int i){
		executor.execute(new Runnable() {
			@Override
			public void run() {
				Thread.currentThread().setName(this.getClass().getName() + " work"+i);
				 while (!Thread.currentThread().isInterrupted()) {
					try {
						int k = i*1000;
						Thread.sleep(k);
						System.out.println("i "+ i);
//						status++;
						System.out.println("在线程池中开启了一个线程  "+Thread.currentThread().getName());
//						}
					} catch (Exception e) {
						//如果出现异常 设置为中断状态 跳出本次循环。
						Thread.currentThread().interrupt();
					}
				}
			}

		});
	}


	public static void main(String[] args) throws Exception{
		ThreadPool2 t = new ThreadPool2();
		for(int i=2;i<=10;i++){
			t.work1(i);
		}



	}
}
