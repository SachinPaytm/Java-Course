package com.semanticsquare.concurrency;

import java.util.concurrent.TimeUnit;

public class FirstThread1 {

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task); // NEW
        thread.start();
        //thread.start();
        try {
            //Thread.sleep(3000);
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Inside main ...");
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Inside run ...");
        go();
    }

    private void go() {
        System.out.println("Inside go ...");
        more();
    }

    private void more() {
        System.out.println("Inside more ...");
    }
}