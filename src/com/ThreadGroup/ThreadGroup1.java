package com.ThreadGroup;

//Every JAVA thread belongs to a ThreadGroup,
//ThreadGroup of main thread -> main
//ParentGroup for all ThreadGroups in JAVA -> system
public class ThreadGroup1 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getThreadGroup().getName()); //main
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); //system


    }
}
