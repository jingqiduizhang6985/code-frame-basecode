package com.code.frame.basecode.extendimpl;

/**
 * 接口内部类
 * 一个消息接口
 *
 */
public interface Message {

    String getMessage();
    void setMessage(String messge);
//    abstract void doBroadcast(String message) throws Exception;
    class MyMessage implements Message{

        @Override
        public String getMessage() {
            return null;
        }

        @Override
        public void setMessage(String messge) {

        }
    }

}
