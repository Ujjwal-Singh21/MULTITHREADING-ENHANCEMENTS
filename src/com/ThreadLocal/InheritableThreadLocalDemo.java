package com.ThreadLocal;

class ParentThread extends Thread {

//    static ThreadLocal tl = new ThreadLocal();

    static InheritableThreadLocal tl = new InheritableThreadLocal() {

        @Override
        public Object childValue(Object p) {
            return "CC";
        }
    };

    @Override
    public void run() {
        tl.set("PP");
        System.out.println("Parent Value: " + tl.get()); //PP

        ChildThread ct = new ChildThread();
        ct.start();
    }

}

class ChildThread extends Thread {

    @Override
    public void run() {
        System.out.println("Child Value: " + ParentThread.tl.get());
    }

}

public class InheritableThreadLocalDemo {
    public static void main(String[] args) {

        ParentThread pt = new ParentThread();
        pt.start();

    }
}
