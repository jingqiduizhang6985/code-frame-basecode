package com.code.frame.basecode.annotation;

/**
 * 定义一个被加入注解的对象
 * @author duran
 * @date 2020.10.15
 */
public class Student {
    @MyField(description = "用户名", length = 12,value = "李四")
    private String username;
    @MyField(description = "年龄", length = 12,value = "1")
    private Integer age;
    @MyField(description = "电话", length = 12,value = "18765822821")
    private String phone;
    @MyField(description = "状态", length = 12,value = "1")
    private int status;
    @MyField(description = "时间", length = 5,value = "18765822821")
    private long time;
    @MyField(description = "开关", length = 12,value = "true")
    private boolean isTrue;
    @MyField(description = "short", length = 12,value = "1")
    private short shortOne;
    @MyField(description = "shortTow", length = 12,value = "2")
    private Short shortTow;

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", time=" + time +
                ", isTrue=" + isTrue +
                ", shortOne=" + shortOne +
                ", shortTow=" + shortTow +
                '}';
    }
}
