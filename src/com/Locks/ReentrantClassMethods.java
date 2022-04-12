package com.Locks;
import java.util.concurrent.locks.ReentrantLock;

//some methods of Reentrant(C) which is child implementation class of LOCK(I).
public class ReentrantClassMethods {
    public static void main(String[] args) {

        ReentrantLock l = new ReentrantLock();

        l.lock();
        l.lock();
        l.lock();

        System.out.println(l.isLocked()); //true
        System.out.println(l.getHoldCount()); //3
        System.out.println(l.isHeldByCurrentThread()); //true
        System.out.println(l.getQueueLength()); //0

        l.unlock();
        l.unlock();

        System.out.println(l.isLocked()); //true
        System.out.println(l.getHoldCount()); //1

        l.unlock();

        System.out.println(l.isLocked()); //false
        System.out.println(l.getHoldCount()); //0
        System.out.println(l.isFair()); //false

    }
}
