package com.Locks;
import java.util.concurrent.locks.ReentrantLock;

//tryLock() method without Time-Period
class MyThread1 extends Thread {

    static ReentrantLock l = new ReentrantLock();

    MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {

        if (l.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "..." + "got the LOCK and " +
                    "performing safe operations");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            l.unlock();

        } else {
            System.out.println(Thread.currentThread().getName() + "..." + "unable to get the LOCK " +
                    "and hence performing alternative operations");
        }
    }
}

public class TryLockDemo1 {
    public static void main(String[] args) {

        MyThread1 t1 = new MyThread1("First Thread");
        MyThread1 t2 = new MyThread1("Second Thread");

        t1.start();
        t2.start();

    }
}
