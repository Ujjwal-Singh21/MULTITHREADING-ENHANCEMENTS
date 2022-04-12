package com.ExecutorFramework;

//without Executor Framework

class PrintJob implements Runnable {

    String name;

    PrintJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + "...job started by Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(name + "...job completed by Thread: " + Thread.currentThread().getName());
    }
}

public class ThreadPoolDemo1 {
    public static void main(String[] args) {

        //Explicitly creating Threads separately for each job & assigning job to each Thread
        PrintJob p1 = new PrintJob("Steve");
        Thread t1 = new Thread(p1);

        PrintJob p2 = new PrintJob("Bruce");
        Thread t2 = new Thread(p2);

        PrintJob p3 = new PrintJob("Clarke");
        Thread t3 = new Thread(p3);

        PrintJob p4 = new PrintJob("Diana");
        Thread t4 = new Thread(p4);

        PrintJob p5 = new PrintJob("Natasha");
        Thread t5 = new Thread(p5);

        PrintJob p6 = new PrintJob("Tony");
        Thread t6 = new Thread(p6);

        //Explicitly starting each Thread
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
