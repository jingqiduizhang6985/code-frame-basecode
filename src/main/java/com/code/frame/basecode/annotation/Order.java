package com.code.frame.basecode.annotation;

public class Order {
    @MyField(description = "id", length = 12,value = "1")
    private long id;
    @MyField(description = "编号", length = 20,value = "2021lskf12")
    private String code;
    @MyField(description = "金额", length = 20,value = "1000")
    private long money;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", money=" + money +
                '}';
    }
}
