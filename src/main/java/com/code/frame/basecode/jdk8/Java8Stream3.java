package com.code.frame.basecode.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * map
 */
public class Java8Stream3 {
    public static void main(String[] args) {
//        Java8Stream3.squaresList();
//        Java8Stream3.filter();
//        Java8Stream3.limit();
//        Java8Stream3.sorted();
        Java8Stream3.parallel();
    }


    // map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
    public static void squaresList(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        //遍历流数据
        squaresList.forEach(System.out::println);
//        for(Integer value:squaresList){
//            System.out.println(value);
//        }
    }
    //filter 方法用于通过设置条件过滤出元素。以下代码片段使用filter 方法过滤出空字符串：
    public static void filter(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("获取空字符串的数量   "+count);
    }
//    limit 方法用于获取指定数量的流。以下代码片段使用 limit 方法打印出 10 条数据：
    public static void limit(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    //sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序：
    public static void sorted(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    //并行（parallel）程序
    //parallelStream 是流并行处理程序的代替方法。以下实例我们使用parallelStream 来输出空字符串的数量：
    public static void parallel(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }
}
