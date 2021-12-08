package com.code.frame.basecode.lock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过 Synchronized 锁静态方法 锁的是类
 */
public class SynchronizedStaticMethod {

    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(5000);	//线程池和线程池队列
    protected ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 1, TimeUnit.MINUTES, workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());

    public void work1(String workName){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(this.getClass().getName() + workName);
                SynchronizedStaticMethod.actionClass(workName);
            }

        });
    }

    public static void main(String[] args) {
        SynchronizedStaticMethod test1 = new SynchronizedStaticMethod();
        test1.work1("test1_work1");
        test1.work1("test1_work2");

        SynchronizedStaticMethod test2 = new SynchronizedStaticMethod();
        test2.work1("test2_work3");
        test2.work1("test2_work4");
    }

    //方法
    private static synchronized void actionClass(String workName){
//        synchronized (SynchronizedStaticMethod.class){
            try {
                System.out.println(workName+ " "+SynchronizedStaticMethod.getDate()+" 我被锁住了....");
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
//        }
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
