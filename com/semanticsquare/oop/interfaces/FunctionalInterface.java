package com.semanticsquare.oop.interfaces;

public interface FunctionalInterface {
    void test();
    default void test2(){
        System.out.println("functional interface test2");
    }
}
