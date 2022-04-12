package com.ThreadGroup;

//Constructors of ThreadGroup(C) available in Java.lang package
public class ThreadGroup2 {
    public static void main(String[] args) {

        //creating a ThreadGroup by specifying its name
        ThreadGroup g1 = new ThreadGroup("First Group");
        System.out.println(g1.getParent().getName()); //main

        ThreadGroup g2 = new ThreadGroup(g1, "Second Group");
        System.out.println(g2.getParent().getName()); //First Group
    }
}
