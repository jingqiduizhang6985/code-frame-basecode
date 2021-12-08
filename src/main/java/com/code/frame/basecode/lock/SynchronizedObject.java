package com.code.frame.basecode.lock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过 synchronized 锁 对象内部的属性
 * 实际锁的是 当前对象
 */
public class SynchronizedObject {

    private Object object = new Object();
    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(5000);	//线程池和线程池队列
    protected ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 1, TimeUnit.MINUTES, workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());

    public void work1(String workName){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(this.getClass().getName() + workName);
                        actionStatic(workName);
            }
        });
    }

    /**
     * 创建两个不同的对象 test1 test2  每个对象开启两个线程
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedObject test1 = new SynchronizedObject();
        test1.work1("work1");
        test1.work1("work2");

        SynchronizedObject test2 = new SynchronizedObject();
        test2.work1("work3");
        test2.work1("work4");
    }

    //静态块中传入的object 锁的是当前对象下的方法
    private void actionStatic(String workName){
        //锁对象中的属性  实际上锁的是当前对象
        synchronized (object){
            try {
                System.out.println(workName+ " "+getDate()+" 我被锁住了....");
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private String getDate(){
        DateFormat dateFo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //毫秒转为日期
        long currentTime = System.currentTimeMillis();//获得现在的时间的毫秒数
        long anyTime = new Long(currentTime);//将任意字符型的毫秒数转换成long型
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(anyTime);
        return dateFo.format(calendar.getTime());
    }
}
