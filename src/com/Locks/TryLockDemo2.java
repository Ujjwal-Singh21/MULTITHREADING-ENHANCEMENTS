package com.Locks;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//tryLock() method with Time-Period
class MyThread2 extends Thread {

    static ReentrantLock l = new ReentrantLock();

    MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {

        do {
            try {
                if (l.tryLock(5000, TimeUnit.MILLISECONDS)) {

                    System.out.println(Thread.currentThread().getName() + "..." + "got the LOCK");

                    Thread.sleep(30000);

                    l.unlock();

                    System.out.println(Thread.currentThread().getName() + "..." + "releases the LOCK");

                    break;

                } else {

                    System.out.println(Thread.currentThread().getName() + "..." + "unable to get the " +
                            "LOCK and will try again");
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}

public class TryLockDemo2 {
    public static void main(String[] args) {


        MyThread2 t1 = new MyThread2("First Thread");
        MyThread2 t2 = new MyThread2("Second Thread");

        t1.start();
        t2.start();

    }
}
