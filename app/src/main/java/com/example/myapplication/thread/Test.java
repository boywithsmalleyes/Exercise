package com.example.myapplication.thread;

public class Test {


    public static void main(String[] args) {
        Thread t  = new PrintThread("Nice", 2000);
        t.setDaemon(true);
        t.start();
//        new PrintThread("Good", 2000).start();
        System.out.println("主线程结束");
    }
}
