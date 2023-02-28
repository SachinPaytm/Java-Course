package com.semanticsquare.oop.interfaces;
/**
 * @author XYZ Inc.
 */
public class X extends AbstractA implements A, B, C, Cloneable {
    public void foo() {
        System.out.println("X: foo");
        System.out.println("VAL: " + B.VAL);
    }
    public void foobar() {
        System.out.println("X: foobar");
    }

    public C clone() {
        try {
            return (C) super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void inheritanceTest() {
        go();
        //staticMethod();
    }

}