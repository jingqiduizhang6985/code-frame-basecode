package com.code.frame.basecode.jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Collectors
 */
public class Java8Stream4 {
    public static void main(String[] args) {
//        Java8Stream4.filtered();
        Java8Stream4.count();
    }

    /**
     * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors可用于返回列表或字符串
     */
    public static void filtered(){
        //创建一个数组
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //过滤掉 空字符串
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        //过滤得到 字符串abc
        List<String> towList = filtered.stream().filter(string -> !"abc".equals(string)).collect(Collectors.toList());
        System.out.println("筛选列表: " + towList);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }

    /**
     * 另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果
     */
    public static void count(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("个数 : " + stats.getCount());
    }

}
