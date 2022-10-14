package Ques3;


class SyncTable{
    void printTable(int n){//synchronized method
        synchronized(this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }
}

class MySyncThread1 extends Thread{
    SyncTable t;
    MySyncThread1(SyncTable t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MySyncThread2 extends Thread{
    SyncTable t;
    MySyncThread2(SyncTable t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

public class SyncBlock{
    public static void main(String args[]){
        SyncTable obj = new SyncTable();//only one object
        MySyncThread1 t1=new MySyncThread1(obj);
        MySyncThread2 t2=new MySyncThread2(obj);
        t1.start();
        t2.start();
    }
}
