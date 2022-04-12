package com.ThreadLocal;

//ThreadLocal(C) present in java.lang package -> introduced in 1.2 V -> enhancements in 1.5 V,
//ThreadLocal(C) is used as a container to maintain a copy of local variable for each thread.
//Some important methods of ThreadLocal(C).
//--------------------------------------------------------------------------------------------------
public class ThreadLocalMethods {
    public static void main(String[] args) {

        ThreadLocal tl = new ThreadLocal();

        System.out.println(tl.get()); //null

        tl.set("Steve");

        System.out.println(tl.get()); //Steve

        tl.remove();

        System.out.println(tl.get()); //null


    }
}
