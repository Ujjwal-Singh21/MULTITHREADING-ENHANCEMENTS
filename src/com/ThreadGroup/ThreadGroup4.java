package com.ThreadGroup;

//using few methods of ThreadGroup class

class MyThread extends Thread {

    MyThread(ThreadGroup g, String name) {
        super(g, name);
    }

    @Override
    public void run() {
        System.out.println("Child Thread");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class ThreadGroup4 {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup pg = new ThreadGroup("Parent ThreadGroup");
        ThreadGroup cg = new ThreadGroup(pg, "Child ThreadGroup");

        MyThread t1 = new MyThread(pg, "ChildThread1");
        MyThread t2 = new MyThread(pg, "ChildThread2");

        t1.start();
        t2.start();

        System.out.println(pg.activeCount());
        System.out.println(pg.activeGroupCount());
        pg.list();

        Thread.sleep(10000);

        System.out.println(pg.activeCount());
        System.out.println(pg.activeGroupCount());
        pg.list();

    }
}
