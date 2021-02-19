package com.code.frame.basecode.extendimpl;

public class MyType extends AbstractType{
    @Override
    void doBroadcast(String message) throws Exception {
        System.out.println("我是MyType doBroadcast");
    }

    public static void main(String[] args) throws Exception{
        MyType myType = new MyType();
    }


}
