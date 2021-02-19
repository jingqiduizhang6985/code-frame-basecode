package com.code.frame.basecode.extendimpl;

public abstract class AbstractType implements InterfaceType{
    @Override
    public void setMessage(String message) throws Exception{
        System.out.println("我是 AbstractType setMessage");
        this.doBroadcast(message);
    }

    @Override
    public String getMessage() {
        return null;
    }

    abstract void doBroadcast(String message) throws Exception;
}
