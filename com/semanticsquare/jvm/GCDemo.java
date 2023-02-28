package com.semanticsquare.jvm;

public class GCDemo {
    static int[] arr = new int[2*1024*1024];

    public static void main(String[] args) {
        System.out.println(arr[0]);
    }
}
