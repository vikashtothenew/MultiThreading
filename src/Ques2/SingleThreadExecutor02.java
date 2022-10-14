package Ques2;

//A single thread pool can be obtainted by calling the static newSingleThreadExecutor() method of Executors class.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor02 {
    //SingleThreadExecutor
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            executor.submit(new Task());
            System.out.println("Shutdown the executor");
            executor.shutdown();
        } finally {
            if(!executor.isTerminated()){
                System.err.println("Task not finished!");
            }
            executor.shutdownNow();
            System.out.println("Shutdown finished!");
        }
    }
    public static class Task implements Runnable{
        @Override
        public void run() {
            Long duration = (long)(Math.random()*12);
            System.out.println("Task Running"+duration);
        }
    }
}

