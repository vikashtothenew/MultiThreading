package Ques5;



public class ReentrantLock {
    private static Integer integer = 0;
    private static Integer integer2 = 0;
    private static java.util.concurrent.locks.ReentrantLock lock1 = new java.util.concurrent.locks.ReentrantLock();
    private static java.util.concurrent.locks.ReentrantLock lock2 = new java.util.concurrent.locks.ReentrantLock();
    private static Object lock = new Object();

    private static void increment() {
        lock1.lock();
        integer++;
        lock1.unlock();
    }

    private static void decrement() {
        lock2.lock();
        integer2--;
        lock2.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                increment();
            }
        }, "Increment1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                decrement();
            }
        }, "Decrement1");
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                decrement();
            }
        }, "Decrement2");
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                increment();
            }
        }, "Increment2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Final Value of Integer: " + integer);
        System.out.println("Final Value of Integer: " + integer2);
    }
}
