package com.code.frame.basecode.annotation;

import java.lang.reflect.Field;

/**
 * 通过反射获取注解
 *
 * 返回指定的注解
 * getAnnotation
 * 判断当前元素是否被指定注解修饰
 * isAnnotationPresent
 * 返回所有的注解
 * getAnnotations
 *
 * @author duran
 * @date 2020.10.15
 */
public class Test {

    public static void main(String[] args) {
        // 获取类模板
        Class c = Student.class;
        // 获取所有字段
        for(Field f : c.getDeclaredFields()){
            // 判断这个字段是否有MyField注解
            if(f.isAnnotationPresent(MyField.class)){
                MyField annotation = f.getAnnotation(MyField.class);
                System.out.println("字段:[" + f.getName() + "], 描述:[" + annotation.description() + "], 长度:[" + annotation.length() +"]");
            }
        }

    }
}
