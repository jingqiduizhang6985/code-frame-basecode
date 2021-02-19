package com.code.frame.basecode.thread;

public class ThreadImplAction {
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadImpl());
        t.start();
        System.out.println("End ");
    }
}
