package com.example.myapplication.thread;

public class PrintThread extends Thread {

    String mMessage = "";
    int length = 0;

    PrintThread(String mMessage, int length) {
        this.mMessage = mMessage;
        this.length = length;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.length; i++) {
            if (i == 2000) {
                new PrintThread("哈哈", 100).start();
                continue;
            }
            System.out.print(mMessage + " " + (i + 1) + " ");
        }
    }
}
