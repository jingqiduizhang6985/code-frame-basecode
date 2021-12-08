package com.code.frame.basecode.lock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过 synchronized 锁非静态方法
 *  实际锁的是 当前对象
 */
public class SynchronizedMethod {

    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(5000);	//线程池和线程池队列
    protected ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 1, TimeUnit.MINUTES, workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());

    public void work1(String workName){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(this.getClass().getName() + workName);
                        action(workName);
            }

        });
    }

    /**
     * 创建两个不同的对象 test1 test2  每个对象开启两个线程
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedMethod test1 = new SynchronizedMethod();
        test1.work1("test1_work1");
        test1.work1("test1_work2");

        SynchronizedMethod test2 = new SynchronizedMethod();
        test2.work1("test2_work3");
        test2.work1("test2_work4");
    }

    /**
     * 在方法上加 synchronized 锁的是当前对象
     * @param workName
     */
    private synchronized void action(String workName){
        try {
            System.out.println(workName+ " "+getDate()+" 我被锁住了....");
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
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
