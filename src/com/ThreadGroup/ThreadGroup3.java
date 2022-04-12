package com.ThreadGroup;

//By default, Max-Priority of a ThreadGroup -> 10
//If we have added few threads in a particular ThreadGroup and change the Max-Priority of that
//ThreadGroup in between, then it won't affect the priority of previously already added threads,
//However newly added threads hereafter will get affected.
//------------------------------------------------------------------------------------------------
public class ThreadGroup3 {
    public static void main(String[] args) {

        //creating a ThreadGroup
        ThreadGroup g1 = new ThreadGroup("tg");

        //adding few Threads
        Thread t1 = new Thread(g1, "First Thread");
        Thread t2 = new Thread(g1, "Second Thread");

        //changing max-priority of ThreadGroup from 10 to 3
        g1.setMaxPriority(3);

        //adding another thread with its default priority 5,
        //which will gets changed to 3 as per newly set MaxPriority of ThreadGroup
        Thread t3 = new Thread(g1, "Third Group");

        System.out.println(t1.getPriority()); // 5 -> which was default
        System.out.println(t2.getPriority()); // 5 -> which was default
        System.out.println(t3.getPriority()); // 3 -> because added after setting new MaxPriority

    }
}
