package com.Locks;
import java.util.concurrent.locks.ReentrantLock;

//using ReentrantLock(C) instead of synchronized keyword
//example is same as old synchronized example
//if we comment LINE-1 & LINE-2, then threads will get executed simultaneously -> Irregular output
//if we don't comment LINE-1 & LINE-2, then threads will get executed one after another by acquiring
//LOCK, Hence -> Regular output
//----------------------------------------------------------------------------------------------------
class Display {

    ReentrantLock l = new ReentrantLock();

    public void wish(String name) {

        l.lock(); //LINE-1

        System.out.println(Thread.currentThread().getName());

        for (int i = 1; i <= 5; i++) {
            System.out.print("Good Morning: ");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(name);
        }

        l.unlock(); //LINE-2
    }
}

class MyThread extends Thread {

    Display d;
    String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {

        d.wish(name);
    }
}

public class ReentrantLockDemo1 {
    public static void main(String[] args) {

        Display d = new Display();

        MyThread t1 = new MyThread(d, "Dhoni");
        t1.setName("Dhoni Thread");
        MyThread t2 = new MyThread(d, "Yuvaraj");
        t2.setName("Yuvaraj Thread");
        MyThread t3 = new MyThread(d, "Kohli");
        t3.setName("Kohli Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
