package com.code.frame.basecode.jdk8;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

/**
   *
   * @ClassName:JDK8_features
   * @Description:JDK8新特性
   * @author duran
   * @date 2020年12月15日上午9:13:24
   */
public class JDK8_features {
    public List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
    /**
     * 1.Lambda表达式
     *
     * 原来的方法：
     * new Thread(new Runnable() {
     *      @Override
     *      public void run() {
     *          System.out.println("Hello World!");
     *      }
     *  });
     *
     * 可替换为：
     * new Thread(() -> System.out.println("Hello World!"));
     */
    @Test
    public void testLambda(){
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("方式二："+e));
    }

    /**
     * 2 Stream函数式操作流元素集合
     */
    @Test
    public void testStream(){
        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("求和："+nums
                       .stream()//转成Stream
                       .filter(team -> team!=null)//过滤
                       .distinct()//去重
                       .mapToInt(num->num*2)//map操作
                       .skip(2)//跳过前2个元素
                       .limit(4)//限制取前4个元素
                       .peek(System.out::println)//流式处理对象函数
                       .sum());
    }
}
