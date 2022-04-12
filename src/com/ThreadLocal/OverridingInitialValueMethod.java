package com.ThreadLocal;

//Overriding initialValue method to set our own initial value instead of null
public class OverridingInitialValueMethod {
    public static void main(String[] args) {

        ThreadLocal tl = new ThreadLocal() {

            @Override
            public Object initialValue() {
                return "abc";
            }
        };

        System.out.println(tl.get()); //abc

        tl.set("Steve");

        System.out.println(tl.get()); //Steve

        tl.remove();

        System.out.println(tl.get()); //abc


    }
}
