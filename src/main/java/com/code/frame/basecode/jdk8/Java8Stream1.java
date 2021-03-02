package com.code.frame.basecode.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream
 */
public class Java8Stream1 {
    public static void main(String[] args) {
       //创建集合并添加数据
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //过滤掉空字符串
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        //遍历流数据
        filtered.forEach(System.out::println);
//        遍历数据
//        for(int i=0;i<filtered.size();i++){
//            System.out.println(filtered.get(i));
//        }
    }
}
