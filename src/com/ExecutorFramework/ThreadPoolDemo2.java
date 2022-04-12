package com.ExecutorFramework;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//with ExecutorFramework
class PrintJob1 implements Runnable {

    String name;

    PrintJob1(String name) {
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

public class ThreadPoolDemo2 {
    public static void main(String[] args) {

        //Creating an array of jobs for PrintJob1
        PrintJob1[] jobs = {new PrintJob1("Steve"),
                new PrintJob1("Bruce"),
                new PrintJob1("Clarke"),
                new PrintJob1("Natasha"),
                new PrintJob1("Diana"),
                new PrintJob1("Tony")
        };

        //creating a ThreadPool containing 3 threads
        ExecutorService service = Executors.newFixedThreadPool(3);

        //Starting threads & assigning jobs to each thread in ThreadPool & finally,
        //Shutting down the ThreadPool, all these are implicitly done by ExecutorFramework
        for (PrintJob1 job : jobs) {
            service.submit(job);
        }

        service.shutdown();

    }
}
