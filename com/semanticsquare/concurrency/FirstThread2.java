package com.semanticsquare.concurrency;

public class FirstThread2 extends Thread {

    public void run() {
        System.out.println("Inside run2 ...");
        go();
    }
    private void go() {
        System.out.println("Inside go2 ...");
        more();
    }
    private void more() {
        System.out.println("Inside more2 ...");
    }

    public static void main(String[] args) {

        System.out.println("Inside main2 ...");
        Thread myThread = new FirstThread2();
        myThread.start();

    }

}