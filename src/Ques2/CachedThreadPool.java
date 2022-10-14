package Ques2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ThreadPoolExecutor mypool = (ThreadPoolExecutor) executor;
//print statement will print the pool size.
        System.out.println("size of mypool: " + mypool.getPoolSize());
        executor.submit(new Threadimplementain());
        executor.submit(new Threadimplementain());
        System.out.println("Total number threads scheduled): "+ mypool.getTaskCount());
        executor.shutdown();
    }

    static class Threadimplementain implements Runnable {

        public void run() {

            try {
                Long num = (long) (Math.random() / 30);
                System.out.println("Thread Name: " +Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(num);
                System.out.println("after sleep Thread Name: " +Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
