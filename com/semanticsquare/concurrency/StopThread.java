package com.semanticsquare.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                while(!stop) { System.out.println("In while ..."); }
            }
        }).start();

        TimeUnit.MICROSECONDS.sleep(1);
        stop = true;
        System.out.println("In main...");
    }
}
