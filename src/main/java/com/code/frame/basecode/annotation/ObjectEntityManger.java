package com.code.frame.basecode.annotation;

import java.lang.reflect.Field;

public class ObjectEntityManger {

    public static Object createEntity(Class<?> classObj) throws Exception{
        // 通过类 创建对象
        Object entity = classObj.getConstructor().newInstance();
        // 获取所有字段 包括私有字段
        Field[] fields =  classObj.getDeclaredFields();
        if(fields.length<1){
            return null;
        }
        //遍历所有的属性
        for(Field f : fields){
            // 判断这个字段/属性 是否有MyField注解
            if(f.isAnnotationPresent(MyField.class)){
                //获取注解对象
                MyField annotation = f.getAnnotation(MyField.class);
                //获取注解描述内容
//                String description = annotation.description();
                //获取注解限制长度大小
                int length = annotation.length();
                //获取注解设置属性的内容
                String value = annotation.value();
                if(value==null&&"".equals(value.trim())){
                    value = "";
                }
                int valueLength = value.length();
                //如果大于设置的最大长度 则把多余的内容截取掉。
                if(valueLength>length){
                  value =  value.substring(0,length);
                }
                //私有属性 通过暴力反射，解除私有限定
                f.setAccessible(true);

                String typeName = f.getType().getSimpleName();
//                System.out.println(typeName);
                if("String".equals(typeName)){
                    f.set(entity,value);  //给当前属性设置值
                }
                if("Integer".equals(typeName)||"int".equals(typeName)){
                    f.set(entity,Integer.valueOf(value));  //给当前属性设置值
                }
                if("Long".equals(typeName)||"long".equals(typeName)){
                    f.set(entity,Long.valueOf(value));  //给当前属性设置值
                }
                if("Double".equals(typeName)||"double".equals(typeName)){
                    f.set(entity,Double.valueOf(value));  //给当前属性设置值
                }
                if("Short".equals(typeName)||"short".equals(typeName)){
                    f.set(entity,Short.valueOf(value));
                }
                if("boolean".equals(typeName)||"Boolean".equals(typeName)){
                    f.set(entity,Boolean.valueOf(value));
                }
            }
        }
        return entity;
    }


}
