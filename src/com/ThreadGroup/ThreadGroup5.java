package com.ThreadGroup;

//Java Program to display all active thread names and whether they are daemon in nature that
//belongs to Parent systemGroup and its child Groups.
//-----------------------------------------------------------------------------------------------
public class ThreadGroup5 {
    public static void main(String[] args) {

        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();

        //creating a Thread array for enumerate method
        Thread[] threadsArray = new Thread[system.activeCount()];

        //calling enumerate() method on system group reference
        system.enumerate(threadsArray);

        //printing name & isDaemon..?
        for (Thread t : threadsArray) {
            System.out.println(t.getName() + "...." + t.isDaemon());
        }

    }
}
