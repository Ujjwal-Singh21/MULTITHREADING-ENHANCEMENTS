package com.ExecutorFramework;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Callable(I) has call() method and this method returns Object,
//In call() method, threads returns some result after completing the job.
//Future Object is used to hold the result from call() method.
//------------------------------------------------------------------------------
class MyCallable implements Callable {

    int num;

    MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Object call() throws Exception {

        System.out.println(Thread.currentThread()
                .getName() + " ... is responsible to find sum of first " + num + " numbers");

        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }

        return sum;
    }

}

public class CallableFutureDemo {

    public static void main(String[] args) throws Exception {

        MyCallable[] jobs = {new MyCallable(10),
                new MyCallable(20),
                new MyCallable(30),
                new MyCallable(40),
                new MyCallable(50),
                new MyCallable(60),
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (MyCallable job : jobs) {
            Future future = service.submit(job);
            System.out.println("Result from call() method: " + future.get());
        }

        service.shutdown();

    }
}
