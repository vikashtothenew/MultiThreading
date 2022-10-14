package Ques1;

class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Hi,the thread has been created from extending thread class!");
        for(int i=11;i<15;i++){
            System.out.println(Thread.currentThread().getName()+"-prints- "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class RunnableThread implements Runnable{
    public void run(){
        System.out.println("This thread belongs to Runnable interface");
        for(int i=15;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"-prints-"+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadCreation01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        RunnableThread  runnableObjectThread= new RunnableThread();
        Thread thread2 = new Thread(runnableObjectThread);
        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();
        Thread.sleep(2000);
        System.out.println("After Thread 1 and 2 execution");
    }
}

