package com.code.frame.basecode.lock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock 对单例模式的对象加锁。
 */
public class SingleObject {
    private static SingleObject instant = new SingleObject();
    private ReentrantLock lock = new ReentrantLock();
    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(5000);	//线程池和线程池队列
    protected ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 1, TimeUnit.MINUTES, workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());
    private SingleObject(){
    }
    public static SingleObject getInstant(){
        return instant;
    }

    private void action(String workName){
        try {
            //手动加锁
            lock.lock();
            System.out.println(workName+ " "+ getDate()+" 我被锁住了....");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //无论是否异常 都需要取消枷锁
            lock.unlock();
        }
    }

    public void work1(String workName){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(this.getClass().getName() + workName);
                action(workName);
            }

        });
    }

    public static void main(String[] args) {
        //单例模式获取的对象 是同一个对象
        SingleObject test1 = SingleObject.getInstant();
        System.out.println(test1);
        test1.work1("test1_work1");
        test1.work1("test1_work2");

        SingleObject test2 = SingleObject.getInstant();
        System.out.println(test2);
        test2.work1("test2_work3");
        test2.work1("test2_work4");
    }

    private static String getDate(){
        DateFormat dateFo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //毫秒转为日期
        long currentTime = System.currentTimeMillis();//获得现在的时间的毫秒数
        long anyTime = new Long(currentTime);//将任意字符型的毫秒数转换成long型
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(anyTime);
        return dateFo.format(calendar.getTime());
    }
}
