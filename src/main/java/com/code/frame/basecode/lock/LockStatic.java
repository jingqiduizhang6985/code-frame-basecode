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
 *Lock 锁 静态方法 则锁的是类。
 *
 * synchronized 和 Lock
 *
 * 更多对比 参考地址：
 * https://blog.csdn.net/u010842515/article/details/67634813/
 *
 *    1）获取锁的线程执行完了该代码块，然后线程释放对锁的占有；
 * 　 2）线程执行发生异常，此时JVM会让线程自动释放锁。
 * 那么如果这个获取锁的线程由于要等待IO或者其他原因（比如调用sleep方法）被阻塞了，
 * 但是又没有释放锁，其他线程便只能干巴巴地等待，试想一下，这多么影响程序执行效率。
 *
 *因此就需要有一种机制可以不让等待的线程一直无期限地等待下去
 * （比如只等待一定的时间或者能够响应中断），通过Lock就可以办到。
 *再举个例子：当有多个线程读写文件时，读操作和写操作会发生冲突现象，
 * 写操作和写操作会发生冲突现象，但是读操作和读操作不会发生冲突现象。
 *
 * 但是采用synchronized关键字来实现同步的话，就会导致一个问题：
 * 如果多个线程都只是进行读操作，所以当一个线程在进行读操作时，其他线程只能等待无法进行读操作。
 * 因此就需要一种机制来使得多个线程都只是进行读操作时，线程之间不会发生冲突，通过Lock就可以办到。
 * 另外，通过Lock可以知道线程有没有成功获取到锁。这个是synchronized无法办到的。
 * 对比：
 */
public class LockStatic {
    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(5000);	//线程池和线程池队列
    protected ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 1, TimeUnit.MINUTES, workQueue,new ThreadPoolExecutor.DiscardOldestPolicy());
    private static ReentrantLock lock = new ReentrantLock();
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
        LockStatic test1 = new LockStatic();
        test1.work1("test1_work1");
        test1.work1("test1_work2");

        LockStatic test2 = new LockStatic();
        test2.work1("test2_work3");
        test2.work1("test2_work4");
    }

    private static void action(String workName){
        try {
            //手动加锁
            lock.lock();
            System.out.println(workName+ " "+ LockStatic.getDate()+" 我被锁住了....");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //无论是否异常 都需要取消枷锁
            lock.unlock();
        }
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
